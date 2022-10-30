package ub.edu.model;

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

    public Ruta(String titol, String dataText, int numDies) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>();
        localitats = new HashSet<>();
        transports = new HashSet<>();


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





}