package ub.edu.model;

import ub.edu.model.Facana.FacanaData;
import ub.edu.model.Facana.FacanaUser;
import ub.edu.model.Transport.Transport;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripUB {
    private FacanaData data;
    private FacanaUser user;

    public TripUB() {
        data = new FacanaData();
        user = new FacanaUser();
    }
    public FacanaUser getUserInfo(){return user;}

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

    public void iniciarRuta(String nomRuta) throws Exception {
        if (data.getRutaActual() != null){
            if (data.getRutaActual() .getNom().equals(nomRuta)){
                throw new Exception("ERROR: La ruta ja està començada");
            }
            else if (data.getRutaActual().getEstatRuta().equals("EnProces")) {
                throw new Exception("Has de acabar la ruta actual per tal de començar-ne una nova");
            }
        }else {
            for (Ruta ruta: data.getRutaMap().values()) {
                if (ruta.getNom().equals(nomRuta)) {
                    data.setRutaActual(ruta);
                    boolean canvi = ruta.iniciarRuta();
                    if (!canvi){
                        throw new Exception("ERROR: La ruta ja està iniciada");
                    }
                }
            }
        }
    }
    public void acabarRuta() throws Exception {
        Ruta rAux;
        if (data.getRutaActual()  != null) {
            rAux = data.getRutaActual();
            boolean canvi = rAux.acabarRuta();
            data.setRutaActual(null);
        }else{
            throw new Exception("ERROR: No hi ha cap ruta en procés");
        }

    }

    public void addTrackRutaActual(TramTrack tram) throws Exception {
        if (data.getRutaActual()  == null){
            throw new Exception("No hi ha cap ruta iniciada per afegir un tram Track") ;
        }else{
            data.getRutaActual().addTram(tram);
        }
    }
    public void addTrackRuta(String nomRuta,TramTrack tram) throws Exception {
        for (Ruta r: data.getRutaMap().values()){
            if (nomRuta.equals(r.getNom())){
                r.addTram(tram);
            }
        }
        throw new Exception("Ruta no trobada al sistema") ;
    }


    public String iniciarTrackRutaActual(String tramID) throws Exception {
        if (data.getRutaActual()  == null){
            throw new Exception("No hi ha cap ruta iniciada per iniciar un tram Track") ;
        }else{
            if (data.getRutaActual() .getEstatTramActual().equals("EnProces")){
                throw new Exception("Ja hi ha un tram track en procés, acaba'l abans d'iniciar un altre.");
            }
            for (TramTrack t: data.getRutaActual() .getTramTracks()){
                if(t.getID().equals(tramID)){
                    data.getRutaActual() .setTramActual(t);
                    return t.cambiarEstat("EnProces");
                }
            }
            throw new Exception("Tram no trobat a la ruta actual") ;
        }
    }
    public void acabarTrackRutaActual() throws Exception {
        if (data.getRutaActual()  == null){
            throw new Exception("No hi ha cap ruta iniciada per acabar un tram Track") ;
        }else{
            TramTrack tramActual = data.getRutaActual().getTramActual();
            if (data.getRutaActual().getEstatTramActual().equals("EnProces")){
                data.getRutaActual() .cambiarEstatTramActual("NoComencat");
                data.getRutaActual() .setTramActual(null);
            }else{
                throw new Exception("ERROR: No hi ha cap Tram Track en procés") ;
            }
        }

    }

    public void afegirPuntDeControlInicialToTrackActual(PuntDeControl puntDeControl) throws Exception {
        if (data.getRutaActual()  == null){
            throw new Exception("No hi ha cap ruta iniciada");
        }else if (data.getRutaActual() .getTramActual() == null){
            throw new Exception("No hi ha cap track iniciat");
        }else{
            data.getRutaActual().getTramActual().setPuntDeControlInicial(puntDeControl);
        }
    }

    public String afegirPuntDeControlFinalToTrackActual(PuntDeControl puntDeControl) throws Exception {
        if (data.getRutaActual()  == null){
            throw new Exception("No hi ha cap ruta iniciada");
        }else if (data.getRutaActual() .getTramActual() == null){
            throw new Exception("No hi ha cap tram iniciat") ;
        }else{
            return data.getRutaActual().getTramActual().setPuntDeControlFinal(puntDeControl);
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
        if(persona == null){

            throw new Exception("L' usuari no ha sigut trobat a la base de dades") ;
        }
        else if (data.getLlistaGrups().size() != 0) {
            for (Grup grup : data.getLlistaGrups()) {
                if (grup.getNomGrup().equals(nomGrup)) {
                    grup.addGrup(persona);
                } else {
                    throw new Exception("No s'ha trobat cap grup amb aquest nom") ;
                }
            }
        }
        else {
            throw new Exception("No hi ha cap grup a la llista afegeix algun primer");
        }
    }

    public String marxarGrup (String nomGrup, String nomPersona) throws Exception {
        Persona persona = null;
        for(Persona p : data.getXarxaPersones().getLlista()){
            if (p.getName().equals(nomPersona)){
                persona=p;
            }
        }
        if(persona == null){
            throw new Exception("L' usuari no ha sigut trobat a la base de dades") ;
        }
        else if (data.getLlistaGrups().size() != 0) {
            for (Grup grup : data.getLlistaGrups()) {
                if (grup.getNomGrup().equals(nomGrup)) {
                    if (grup.getPersona(persona.getName()) != null) {
                        grup.marxarGrup(persona);
                    } else {
                        throw new Exception("S'ha trobat el grup pero l'usuari no pertany al grup");
                    }
                } else {
                    throw new Exception("No s'ha trobat cap grup amb aquest nom");
                }
            }
        }
        else{
            throw new Exception("No hi ha cap grup a la llista afegeix algun primer");
        }
        return null;
    }

    public Iterable<String> getRankingGrup( String nomGrup) throws Exception {
        List<String> ret;
        System.out.println("a");
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

    public void valorarPuntsDePasRutaActual( int estrelles, boolean like) throws Exception {
        if (data.getRutaActual() == null){
            throw new Exception("No hi ha cap ruta en procés");
        }
        for (TramTrack t: data.getRutaActual().getTramTracks()) {
            t.getPuntDeControlInicial().setValoracio(estrelles, like);
            t.getPuntDeControlFinal().setValoracio(estrelles, like);
        }
    }
    public Iterable<String> llistarPuntsDePasRuta(String nomRuta) throws Exception {
        Ruta ruta = null;
        List<String> list = new ArrayList<>();
        List<Valoracio> llistaPunts = new ArrayList<>();
        for (Ruta r: data.getRutaMap().values()){
            if(r.getNom().equals(nomRuta)){
                ruta = r;
            }
        }if (ruta == null){
            throw new Exception("Ruta no trobada");
        }
        for(TramTrack t: ruta.getTramTracks()) {
            llistaPunts.add(t.getPuntDeControlInicial().getValoracio());
        }

        if (llistaPunts.isEmpty()){
            llistaPunts = null;
            throw new Exception("La llista de punts de pas se la ruta actual esta buida");
        }
        List<Valoracio> sortedList = llistaPunts;
        sortedList.sort(new Comparator<Valoracio>() {

            public int compare(Valoracio a1, Valoracio a2) {
                return (Integer.compare(a2.getEstrelles(), a1.getEstrelles()));
            }
        });
        for (Valoracio v: sortedList){
            String like = "";
            list.add("Estrelles: " + v.getEstrelles() + " Like: " + v.getLike());
        }
        return list;
    }
    public void validateRegisterPersona (String username, String password) throws Exception {
        if  (data.getDataService().getPersonaByUsername(username).isPresent()){
            throw new Exception("Soci Duplicat");
        }
        else if (isMail(username) && isPasswordSegur(password)) {
            throw new Exception("Format incorrecte");
        }
    }

    public boolean isPasswordSegur(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean isMail(String correu) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }

    public boolean findPersona(String username) {
        Persona persona = data.getXarxaPersones().find(username);
        if (persona!=null) return true;
        else return false;
    }


    public void validatePassword(String b) throws Exception {
        if (!isPasswordSegur(b)) {
            throw new Exception("Contrassenya no prou segura");
        }
    }


    public void validateUsername(String b) throws Exception {
        if (!isMail(b))
            throw new Exception("Correu en format incorrecte");
    }

    public void validateRegistrePersona(String username, String password) throws Exception {
        if (isMail(username) && isPasswordSegur(password)) {
            Persona persona = data.getXarxaPersones().find(username);
            if (persona != null) {
                throw new Exception("Persona duplicada") ;
            }
        } else throw new Exception("Format incorrecte");
    }

    public void loguejarPersona(String username, String password) throws Exception {
        Persona persona = data.getXarxaPersones().find(username);
        if(persona == null){
            throw new Exception("Correu inexistent");
        }
        if(!persona.getPwd().equals(password)){
            throw new Exception("Contrassenya incorrecta") ;
        }
    }

    public String recuperarContrassenya(String username) throws Exception {
        Persona persona = data.getXarxaPersones().find(username);
        if(persona == null){
            throw new Exception("Correu inexistent");
        }
        return persona.getPwd();
    }
}
