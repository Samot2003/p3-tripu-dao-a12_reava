package ub.edu.model;

public class EstadistiquesIndividuals {

    private int punts;

    public EstadistiquesIndividuals () {
        punts = 0;
    }

    public int getEstadistiques(){
        return punts;
    }

    public boolean addPunts(int punts) {
        this.punts += punts;
        return true;
    }
}
