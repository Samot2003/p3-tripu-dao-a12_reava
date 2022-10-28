package ub.edu.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ruta {
    private String nom;
    private int durada;
    private LocalDate dataCreacio;
    private Set<Comarca> comarques;

    public Ruta(String titol, String dataText, int numDies) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>();
    }

    public Ruta(String titol, int numDies, String dataText, List<Comarca> comarcaList) {
        this.nom = titol;
        setDurada(numDies);
        setDataCreacio(dataText);
        comarques = new HashSet<>(comarcaList);
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



}