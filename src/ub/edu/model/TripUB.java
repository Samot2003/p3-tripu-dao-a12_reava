package ub.edu.model;

import ub.edu.controller.Controller;
import ub.edu.model.Facana.FacanaData;
import ub.edu.model.Facana.FacanaUser;
import ub.edu.model.Transport.Transport;
import ub.edu.model.ValoracioStrategy.ValorarEstrelles;
import ub.edu.model.ValoracioStrategy.ValorarStrategy;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripUB {
    private FacanaData data;
    private FacanaUser facanaUser;


    private static volatile  TripUB uniqueIstance;

    private TripUB() {
        data = new FacanaData();
        facanaUser = new FacanaUser();
    }

    public static TripUB getInstance(){
        if (uniqueIstance == null){
            synchronized (TripUB.class){
                if (uniqueIstance == null){
                    uniqueIstance = new TripUB();
                }
            }
        }
        return uniqueIstance;
    }

    public Iterable<String> llistarCatalegRutesPerNom() throws Exception {
        SortedSet<String> excursionsDisponibles = new TreeSet<>();
        if (data.getRutaList().isEmpty()) {
            throw new Exception("No hi ha excursions disponibles");
        } else {
            for (Ruta r : data.getRutaList()) {
                excursionsDisponibles.add(r.getNom());
            }
        }
        return excursionsDisponibles;
    }

    public Iterable<String> llistarCatalegRutesPerDurada(){
        List<Ruta> sortedList = data.getRutaList();
        sortedList.sort(new Comparator<Ruta>() {
            public int compare(Ruta a1, Ruta a2) {
                return (Integer.compare(a1.getDurada(), a2.getDurada()));
            }
        });

        List<String> excursionsDisponibles = new ArrayList<>();
        for (Ruta r : sortedList) {
            excursionsDisponibles.add(r.getNom());
        }

        return excursionsDisponibles;
    }

    public Iterable<String> cercaRutesPerComarca(String nomComarca) throws Exception {
        SortedSet<String> comarques = new TreeSet<>();

        if (data.getComarcaMap().size() == 0){
            throw new Exception("No hi han comarques enregistrades");
        }

        Comarca comarca = data.getComarcaMap().get(nomComarca);
        if (comarca == null)
            throw new Exception("Comarca no trobada en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : data.getRutaMap().values()){
                if (ruta.containsComarca(comarca)) {
                    comarques.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) throw new Exception("No hi han rutes en aquesta comarca");
        }

        return comarques;
    }


    public Comarca afegirComarca(String nomComarca){
        Comarca comarca;
        if(data.getComarcaMap().containsKey(nomComarca)){
            comarca = data.getComarcaMap().get(nomComarca);
        }else{
            comarca = new Comarca(nomComarca);
            data.getComarcaMap().put(nomComarca, comarca);
        }
        return comarca;
    }

    public Iterable<String> cercarRutesPerTempsDeDurada(int numDies) throws Exception {
        SortedSet<String> llista = new TreeSet<>();
        for(Ruta ruta: data.getRutaMap().values()){
            if (ruta.getDurada() == numDies){
                llista.add(ruta.getNom());
            }
        }

        if (llista.isEmpty()){
            throw new Exception("No hi ha rutes amb aquest temps de durada");
        }

        return llista;

    }

    public Ruta afegirRuta(String nomRuta,String dataText, int numDies){
        return data.afegirRuta(nomRuta, dataText, numDies);
    }

    public Localitat afegirLocalitat(String nomLocalitat) {
        return data.afegirLocalitat(nomLocalitat);
    }

    public Iterable<String>  cercaRutesPerLocalitat(String nomLocalitat) throws Exception {
        SortedSet<String> localitats = new TreeSet<>();

        if (data.getLocalitatMap().size() == 0){
            throw new Exception("No hi ha localitats enregistrades");
        }

        Localitat localitat = data.getLocalitatMap().get(nomLocalitat);
        if (localitat == null)
            throw new Exception("Localitat no trobada en el sistema");
        else {
            int ncount = 0;
            for (Ruta ruta : data.getRutaMap().values()){
                if (ruta.containsLocalitat(localitat)) {
                    localitats.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) throw new Exception("No hi ha rutes en aquesta localitat");
        }

        return localitats;
    }

    public boolean afegirTransport(String nom, String id, float velocitat) {
        return data.afegirTransport(nom,id,velocitat);
    }

    public Iterable<String>  cercaRutesPerTransport(String id) throws Exception {
        SortedSet<String> transports = new TreeSet<>();

        if (data.getTransportMap().size() == 0){
            throw new Exception("No hi ha transports enregistrats");
        }

        Transport transport = data.getTransportMap().get(id);
        if (transport == null)
            throw new Exception("Transport no trobat en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : data.getRutaMap().values()){
                if (ruta.containsTransport(transport)) {
                    transports.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) throw new Exception("No hi ha rutes amb aquest transport recomanat");
        }
        return transports;
    }

    public void iniciarRuta(String nomPersona, String nomRuta) throws Exception {
        Persona p = data.getXarxaPersones().find(nomPersona);
        if (p.getRutaActual() != null){
            if (p.getRutaActual() .getNom().equals(nomRuta)){
                throw new Exception("ERROR: La ruta ja està començada");
            }
            else if (p.getRutaActual().getEstatRuta().equals("EnProces")) {
                throw new Exception("Has de acabar la ruta actual per tal de començar-ne una nova");
            }
        }else {
            for (Ruta ruta: data.getRutaMap().values()) {
                if (ruta.getNom().equals(nomRuta)) {
                    p.setRutaActual(ruta);
                    boolean canvi = ruta.iniciarRuta();
                    if (!canvi){
                        throw new Exception("ERROR: La ruta ja està iniciada");
                    }
                }
            }
        }
    }
    public void acabarRuta(String nomPersona) throws Exception {
        Persona p = data.getXarxaPersones().find(nomPersona);
        Ruta r;
        if (p.getRutaActual()  != null) {
            r = p.getRutaActual();
            boolean canvi = r.acabarRuta();
            p.setRutaActual(null);
        }else{
            throw new Exception("ERROR: No hi ha cap ruta en procés");
        }

    }


    public void iniciarTrackRutaActual(String nomPersona, String tramID) throws Exception {
        Ruta r = data.getRutaActual(nomPersona);
        if (r  == null){
            throw new Exception("No hi ha cap ruta iniciada per iniciar un tram Track") ;
        }else{
            if (r.getTramActual() != null){
                throw new Exception("Ja hi ha un tram track en procés, acaba'l abans d'iniciar un altre.");
            }else{
                r.setTramActual(new TramTrack(tramID));
            }
        }
    }
    public void acabarTrackRutaActual(String nomPersona) throws Exception {
        if (data.getRutaActual(nomPersona)  == null){
            throw new Exception("No hi ha cap ruta iniciada per acabar un tram Track") ;
        }else{
            if (data.getRutaActual(nomPersona).getTramActual() != null){
                data.getRutaActual(nomPersona).acabarTramActual();
            }else{
                throw new Exception("ERROR: No hi ha cap Tram Track en procés") ;
            }
        }

    }

    public void afegirPuntDeControl(String nomPersona, PuntDeControl p) throws Exception {
        if (data.getRutaActual(nomPersona)  == null){
            throw new Exception("No hi ha cap ruta iniciada");
        }else if (data.getRutaActual(nomPersona).getTramActual() == null){
            throw new Exception("No hi ha cap track iniciat");
        }else{
            data.getRutaActual(nomPersona).getTramActual().addPuntDeControl(p);
        }
    }

    public void crearGrup (String nomGrup) throws Exception {
        for (Grup g: data.getLlistaGrups()) {
            if (g.getNomGrup().equals(nomGrup)) {
                throw new Exception("Ja existeix un grup amb aquest nom canvia'l siusplau");
            }
        }
        Grup g = new Grup(nomGrup);
        data.addGrupLlista(g);
    }

    public void addMembreGrup (String nomGrup, String nomPersona) throws Exception {
        Persona persona = null;
        for(Persona p : data.getXarxaPersones().getLlista()){
            if (p.getName().equals(nomPersona)){
                persona=p;
            }
        }
        boolean trobat = false;
        if(persona == null){

            throw new Exception("L' usuari no ha sigut trobat a la base de dades") ;
        }

        else if (data.getLlistaGrups().size() != 0) {
            for (Grup grup : data.getLlistaGrups()) {
                if (grup.getNomGrup().equals(nomGrup)) {
                    grup.addGrup(persona);
                    trobat = true;
                }
            }
        }
        if (!trobat){
            throw new Exception("No hi ha cap grup amb aquest nom");
        }
    }

    public String marxarGrup (String nomGrup, String nomPersona) throws Exception {
        Persona persona = null;
        for(Persona p : data.getXarxaPersones().getLlista()){
            if (p.getName().equals(nomPersona)){
                persona=p;
            }
        }
        boolean trobat = false;
        if(persona == null){
            throw new Exception("L' usuari no ha sigut trobat a la base de dades") ;
        }
        else if (data.getLlistaGrups().size() != 0) {
            for (Grup grup : data.getLlistaGrups()) {
                if (grup.getNomGrup().equals(nomGrup)) {
                    if (grup.getPersona(persona.getName()) != null) {
                        grup.marxarGrup(persona);
                        trobat = true;
                    }
                }
            }
            if(!trobat) {
                throw new Exception("L'usuari no pertany al grup");
            }
        }
        else{
            throw new Exception("No hi ha cap grup a la llista afegeix algun primer");
        }
        return null;
    }

    public Iterable<String> getRankingGrup( String nomGrup) throws Exception {
        List<String> ret;
        if (data.getLlistaGrups().size() != 0) {
            for (Grup g: data.getLlistaGrups()) {
                if (g.getNomGrup().equals(nomGrup)) {
                    ret = (List) g.getRanking();
                    if (ret.size() == 0) {
                        throw new Exception("No hi ha membres en aquest grup, afegeix algun per veure el ranking");
                    } else {
                        return ret;
                    }
                }
            }
        }
        else{
            throw new Exception("No hi ha cap grup amb aquest nom al sistema");
        }
        return null;
    }

    public void addPuntsToPersona(String nom, int punts) throws Exception {
        boolean sumats = false;
        for (Persona pers: data.getXarxaPersones().getLlista()){
            if (pers.getName().equals(nom)){
                sumats = pers.addPunts(punts);
                if (sumats){
                    actualitzarRankings();
                }else{
                    throw new Exception("Els punts no s'han sumat");
                }
            }

        }
        throw new Exception("Usuari no trobat");
    }

    public void actualitzarRankingGrup(String nomGrup) throws Exception {
        for( Grup g: data.getLlistaGrups()){
            if (g.getNomGrup().equals(nomGrup)){
                g.actualitzarRanking();
            }
        }
        throw new Exception("No s'ha trobat el grup");
    }

    public void actualitzarRankings(){
        for( Grup g: data.getLlistaGrups()){
            g.actualitzarRanking();
        }
    }

    public void valorarPuntsDePas(String ID, ValorarStrategy str, int valoracio, String nomPersona) throws Exception {
        TramTrack t = data.getRutaActual(nomPersona).getTramActual();
        PuntDeControl p = t.getPuntDeControlByID(ID);
        p.setValoracio(str,valoracio);
    }

    public ArrayList<TramTrack> getAllTramTracks(){
        ArrayList<TramTrack> tramTracks = new ArrayList<>();
        for (Ruta r: data.getRutaList()){
            for(TramTrack t: r.getLlistaTramTracks()){
                tramTracks.add(t);
            }
        }
        return tramTracks;
    }

    public Iterable<String> llistarPuntsDePasRutaActual(ValorarStrategy str) throws Exception {


        List<String> list = new ArrayList<>();
        List<PuntDeControl> llistaPunts = new ArrayList<>();
        for(TramTrack t:getAllTramTracks() ) {
            llistaPunts.addAll(t.getPuntsDeControlValorats(str));
        }
        if (llistaPunts.isEmpty()){
            throw new Exception("La llista de valoracions per " + str.toString() + " està buida");
        }
        List<PuntDeControl> sortedList = llistaPunts;
        sortedList.sort((a1, a2) -> (Float.compare(a2.getValoracio().getNumValoracioPerType(str), a1.getValoracio().getNumValoracioPerType(str))));
        for (PuntDeControl v: sortedList){
            if (list.size() < 10) {
                list.add("ID: " + v.getID() + " " + str.toString() + " : " + v.getValoracio().getNumValoracioPerType(str));
            }
        }
        return list;
    }
    public FacanaUser getLogicaUsuari(){
        return facanaUser;
    }


    public List<String> getGrups(){
        List<String> s = new ArrayList<>();
        List<Grup> grups= data.getLlistaGrups();
        for (Grup g: grups){
            s.add(g.getNomGrup());
        }
        return s;
    }
}
