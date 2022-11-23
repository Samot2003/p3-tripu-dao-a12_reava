package ub.edu.controller;

import ub.edu.model.*;

import ub.edu.model.Transport.*;

import java.util.*;

public class Controller {

    //ControllerData es una classe que inicialitza i emagatzema les dades
    private FacanaData data;
    private FacanaUser user;

    public Controller() {
        
        data = new FacanaData();
        user = new FacanaUser();
    }
    public FacanaUser getUserInfo(){return user;}

    public Iterable<String> llistarCatalegRutesPerNom() {
        SortedSet<String> excursionsDisponibles = new TreeSet<>();
        if (data.getRutaList().isEmpty()) {
            excursionsDisponibles.add("No hi ha excursions disponibles");
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

    public Iterable<String> cercaRutesPerComarca(String nomComarca){
        SortedSet<String> comarques = new TreeSet<>();

        if (data.getComarcaMap().size() == 0){
            comarques.add("No hi han comarques enregistrades");
            return comarques;
        }

        Comarca comarca = data.getComarcaMap().get(nomComarca);
        if (comarca == null)
            comarques.add("Comarca no trobada en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : data.getRutaMap().values()){
                if (ruta.containsComarca(comarca)) {
                    comarques.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) comarques.add("No hi han rutes en aquesta comarca");
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

    public Iterable<String> cercarRutesPerTempsDeDurada(int numDies){
        SortedSet<String> llista = new TreeSet<>();
        for(Ruta ruta: data.getRutaMap().values()){
            if (ruta.getDurada() == numDies){
                llista.add(ruta.getNom());
            }
        }

        if (llista.isEmpty()){
            llista.add("No hi ha rutes amb aquest temps de durada");
        }

        return llista;

    }

    public Ruta afegirRuta(String nomRuta,String dataText, int numDies){
        return data.afegirRuta(nomRuta, dataText, numDies);
    }

    public Localitat afegirLocalitat(String nomLocalitat) {
        return data.afegirLocalitat(nomLocalitat);
    }

    public Iterable<String>  cercaRutesPerLocalitat(String nomLocalitat) {
        SortedSet<String> localitats = new TreeSet<>();

        if (data.getLocalitatMap().size() == 0){
            localitats.add("No hi ha localitats enregistrades");
            return localitats;
        }

        Localitat localitat = data.getLocalitatMap().get(nomLocalitat);
        if (localitat == null)
            localitats.add("Localitat no trobada en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : data.getRutaMap().values()){
                if (ruta.containsLocalitat(localitat)) {
                    localitats.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) localitats.add("No hi ha rutes en aquesta localitat");
        }

        return localitats;
    }

    public boolean afegirTransport(String nom, String id, float velocitat) {
        return data.afegirTransport(nom,id,velocitat);
    }

    public Iterable<String>  cercaRutesPerTransport(String id) {
        SortedSet<String> transports = new TreeSet<>();

        if (data.getTransportMap().size() == 0){
            transports.add("No hi ha transports enregistrats");
            return transports;
        }

        Transport transport = data.getTransportMap().get(id);
        if (transport == null)
            transports.add("Transport no trobat en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : data.getRutaMap().values()){
                if (ruta.containsTransport(transport)) {
                    transports.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) transports.add("No hi ha rutes amb aquest transport recomanat");
        }
        return transports;
    }

    public String iniciarRuta(String nomRuta){
        if (data.getRutaActual() != null){
            if (data.getRutaActual() .getNom().equals(nomRuta)){
                return "ERROR: La ruta ja està començada";
            }
            else if (data.getRutaActual().getEstatRuta().equals("EnProces")) {
                return "Has de acabar la ruta actual per tal de començar-ne una nova";
            }
        }else {
            for (Ruta ruta: data.getRutaMap().values()) {
                if (ruta.getNom().equals(nomRuta)) {
                    data.setRutaActual(ruta);
                    boolean canvi = ruta.iniciarRuta();
                    if (canvi){
                        return "Ruta inciada";
                    }else{
                        return "ERROR: La ruta ja està iniciada";
                    }
                }
            }
        }

        return "Ruta no trobada en el sistema";
    }
    public String acabarRuta(){
        Ruta rAux;
        if (data.getRutaActual()  != null) {
            rAux = data.getRutaActual();
            boolean canvi = rAux.acabarRuta();
            data.setRutaActual(null);
            return "Ruta actual finalitzada";
        }
        return "ERROR: No hi ha cap ruta en procés";
    }

    public String addTrackRutaActual(TramTrack tram){
        if (data.getRutaActual()  == null){
            return "No hi ha cap ruta iniciada per afegir un tram Track";
        }else{
            data.getRutaActual().addTram(tram);
            return "Tram afegit correctament";
        }
    }
    public String addTrackRuta(String nomRuta,TramTrack tram){
        for (Ruta r: data.getRutaMap().values()){
            if (nomRuta.equals(r.getNom())){
                r.addTram(tram);
                return "Tram afegit a la ruta correctament";
            }
        }
        return "Ruta no trobada al sistema";
    }


    public String iniciarTrackRutaActual(String tramID){
        if (data.getRutaActual()  == null){
            return "No hi ha cap ruta iniciada per iniciar un tram Track";
        }else{
            if (data.getRutaActual() .getEstatTramActual().equals("EnProces")){
                return "Ja hi ha un tram track en procés, acaba'l abans d'iniciar un altre.";
            }
            for (TramTrack t: data.getRutaActual() .getTramTracks()){
                if(t.getID().equals(tramID)){
                    data.getRutaActual() .setTramActual(t);
                    return "Tram: " + t.cambiarEstat("EnProces");
                }
            }
            return "Tram no trobat a la ruta actual";
        }
    }
    public String acabarTrackRutaActual(){
        if (data.getRutaActual()  == null){
            return "No hi ha cap ruta iniciada per acabar un tram Track";
        }else{
            if (data.getRutaActual() .getEstatTramActual().equals("EnProces")){
                data.getRutaActual() .cambiarEstatTramActual("NoComencat");
                data.getRutaActual() .setTramActual(null);;
                return "Tram Track finalitzat amb éxit";
            }else{
                return "ERROR: No hi ha cap Tram Track en procés";
            }
        }

    }

    public String afegirPuntDeControlInicialToTrackActual(PuntDeControl puntDeControl){
        if (data.getRutaActual()  == null){
            return "No hi ha cap ruta iniciada";
        }else if (data.getRutaActual() .getTramActual() == null){
            return "No hi ha cap track iniciat";
        }else{
            return data.getRutaActual() .getTramActual().setPuntDeControlInicial(puntDeControl);
        }
    }

    public String afegirPuntDeControlFinalToTrackActual(PuntDeControl puntDeControl){
        if (data.getRutaActual()  == null){
            return "No hi ha cap ruta iniciada";
        }else if (data.getRutaActual() .getTramActual() == null){
            return "No hi ha cap tram iniciat";
        }else{
            return data.getRutaActual() .getTramActual().setPuntDeControlFinal(puntDeControl);
        }
    }
    public String crearGrup (String nomGrup){
        for (Grup g: data.getLlistaGrups()) {
            if (g.getNomGrup().equals(nomGrup)) {
                return "Ja existeix un grup amb aquest nom canvia'l siusplau";
            }
        }
        Grup g = new Grup(nomGrup);
        data.addGrupLlista(g);
        return "S' ha creat el grup correctament";
    }

    public String addMembreGrup (String nomGrup, String nomPersona) {
        Persona persona = null;
        for(Persona p : data.getXarxaPersones().getLlista()){
            if (p.getName().equals(nomPersona)){
                persona=p;
            }
        }
        if(persona == null){

            return "L' usuari no ha sigut trobat a la base de dades";
        }
        else if (data.getLlistaGrups().size() != 0) {
            for (Grup grup : data.getLlistaGrups()) {
                if (grup.getNomGrup().equals(nomGrup)) {
                    grup.addGrup(persona);
                    return "S'ha agregat el membre satisfactoriament";
                } else {
                    return "No s'ha trobat cap grup amb aquest nom";
                }
            }
        }
        else{
            return "No hi ha cap grup a la llista afegeix algun primer";
        }
        return null;
    }

    public String marxarGrup (String nomGrup, String nomPersona){
        Persona persona = null;
        for(Persona p : data.getXarxaPersones().getLlista()){
            if (p.getName().equals(nomPersona)){
                persona=p;
            }
        }
        if(persona == null){

            return "L' usuari no ha sigut trobat a la base de dades";
        }
        else if (data.getLlistaGrups().size() != 0) {
            for (Grup grup : data.getLlistaGrups()) {
                if (grup.getNomGrup().equals(nomGrup)) {
                    if (grup.getPersona(persona.getName()) != null) {
                        grup.marxarGrup(persona);
                        return "S'ha eliminat al membre satisfactoriament";
                    } else {
                        return "S'ha trobat el grup pero l'usuari no pertany al grup";
                    }
                } else {
                    return "No s'ha trobat cap grup amb aquest nom";
                }
            }
        }
        else{
            return " No hi ha cap grup a la llista afegeix algun primer";
        }
        return null;
    }

    public Iterable<String> getRankingGrup( String nomGrup){
        List<String> ret = new ArrayList<>();
        if (data.getLlistaGrups().size() != 0) {
            for (Grup g: data.getLlistaGrups()) {
                if (g.getNomGrup().equals(nomGrup)) {
                    ret = (List) g.getRanking();
                    if (ret.size() == 0) {
                        ret.add("No hi ha membres en aquest grup, afegeix algun per veure el ranking");
                        return ret;
                    } else {
                        return ret;
                    }
                }
            }
        }
        else{
            ret.add("No hi ha cap grup amb aquest nom al sistema");
            return ret;
        }
        return null;
    }

    public String addPuntsToPersona(String nom, int punts){
        boolean sumats = false;
        for (Persona pers: data.getXarxaPersones().getLlista()){
            if (pers.getName().equals(nom)){
                sumats = pers.addPunts(punts);
                if (sumats){
                    actualitzarRankings();
                    return "Punts sumats correctament";
                }else{
                    return "Els punts no s'han sumat";
                }
            }

        }
        return "Usuari no trobat";
    }

    public String actualitzarRankingGrup(String nomGrup){
        for( Grup g: data.getLlistaGrups()){
            if (g.getNomGrup().equals(nomGrup)){
                g.actualitzarRanking();
                return "Ranking Actualitzat";
            }
        }
        return "No s'ha trobat el grup";
    }

    public void actualitzarRankings(){
        for( Grup g: data.getLlistaGrups()){
            g.actualitzarRanking();
        }
    }

    public String valorarPuntDePas(int[] estrelles, boolean[] like){
        List<TramTrack> llistaTracks = data.getRutaActual().getLlistaTramTracks();
        int i = 0;
        for (TramTrack t: llistaTracks){
            PuntDeControl[] pList = t.getPuntsDeControl();
            Valoracio valoracio = new Valoracio();
            valoracio.setEstrelles(estrelles[i]);
            valoracio.setLike(like[i]);
            i++;
        }
    }
}