package ub.edu.model;

import ub.edu.model.Estat.Estat;
import ub.edu.model.Estat.NoComencat;
import ub.edu.model.Transport.Transport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ruta {
    private String nom;
    private int durada;
    private LocalDate dataCreacio;
    private Set<Comarca> comarques;
    private Set<Localitat> localitats;
    private Set<Transport> transports;

    private ArrayList<TramTrack> tramTracks;
    private Estat estat;

    private TramTrack tramActual;

    public Ruta(String titol, String dataText, int numDies) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>();
        localitats = new HashSet<>();
        transports = new HashSet<>();
        estat = new NoComencat();
        tramTracks = new ArrayList<>();
        tramActual = null;
    }

    public Ruta(String titol, int numDies, String dataText, List<Comarca> comarcaList) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>(comarcaList);
        localitats = new HashSet<>();
        transports = new HashSet<>();
        estat = new NoComencat();
        tramTracks = new ArrayList<>();
        tramActual = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDurada(){
        return this.durada;
    }

    public LocalDate getDataCreacio() { return dataCreacio;}

    public void setDurada(int numdies){
        this.durada = numdies;
    }

    public void setDataCreacio(String dataText){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataCreacio = LocalDate.parse(dataText, formatter);
    }
    public void addComarca(Comarca comarca){
        comarques.add(comarca);
    }

    public boolean containsComarca(Comarca comarca){
        return comarques.contains(comarca);
    }

    public List<Comarca> getComarques() { return new ArrayList<Comarca>(comarques);}

    public void addLocalitat(Localitat localitat){
        localitats.add(localitat);
    }



    public boolean containsLocalitat(Localitat localitat){
        return localitats.contains(localitat);
    }

    public void addTransport(Transport transport){
        transports.add(transport);
    }

    public boolean containsTransport(Transport transport){
        return transports.contains(transport);
    }

    public String getEstatRuta(){
        return estat.getEstat();
    }
    public boolean iniciarRuta(){
        if ("EnProces".equals(estat.getEstat())){
            return false;
        }
        estat = estat.cambiarEstat("EnProces");
        return true;
    }

    public boolean acabarRuta(){
        if ("NoComencat".equals(estat.getEstat())){
            return false;
        }
        estat = estat.cambiarEstat("NoComencat");
        return true;
    }

    public List<TramTrack> getLlistaTramTracks(){
        return tramTracks;
    }
    public boolean addTram(TramTrack t) {
        return tramTracks.add(t);
    }


    public void setTramActual (TramTrack t){
        tramActual = t;
        addTram(t);
    }

    public TramTrack getTramActual(){
        return tramActual;
    }

    public String getEstatTramActual (){
        if (tramActual == null){
            return "";
        }else{
            return tramActual.getEstat();
        }
    }
    public String acabarTramActual (){
        tramActual = null;
        return "Estat canviat";
    }







}

/*if (nomEstat.equals(estat.getEstat())){
            return "ERROR: El estat al que vols canviar es el actual [" + estat.getEstat() + "]";
        }else if(nomEstat.equals("EnProces")){
            estat = new EnProces();
            return "Estat canviat a: " + estat.getEstat();
        }else if(nomEstat.equals("Acabat")){
            estat = new Acabat();
            return "Estat canviat a: " + estat.getEstat();
        }else if(nomEstat.equals("NoComençat")){
            estat = new NoComençat();
            return "Estat canviat a: " + estat.getEstat();
        }
        return "Estat no existent";
        */