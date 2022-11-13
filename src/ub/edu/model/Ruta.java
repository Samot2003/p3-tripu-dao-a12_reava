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
    private Set<Tram> trams;
    private Estat estat;

    private Tram tramActual;

    public Ruta(String titol, String dataText, int numDies) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>();
        localitats = new HashSet<>();
        transports = new HashSet<>();
        estat = new NoComencat();
        trams = new HashSet<>();
        tramActual = null;
    }

    public Ruta(String titol, int numDies, String dataText, List<Comarca> comarcaList) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>(comarcaList);
        localitats = new HashSet<>();
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

    public String cambiarEstatRuta(String nomEstat){
        if (nomEstat.equals(estat.getEstat())){
            return ("L'estat al que vols canviar ja es l'actual");
        }
        estat = estat.cambiarEstat(nomEstat);
        return "Estat canviat a: " + estat.getEstat();
    }

    public boolean addTram(Tram t) {
        return trams.add(t);
    }

    public List<Tram> getTrams() { return new ArrayList<Tram>(trams);}

    public void setTramActual (Tram t){
        tramActual = t;
    }

    public Tram getTramActual(){
        return tramActual;
    }

    public String getEstatTramActual (){
        if (tramActual == null){
            return "";
        }else{
            return tramActual.getEstat();
        }
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