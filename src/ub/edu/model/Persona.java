package ub.edu.model;


public class Persona {
    private String pwd;
    private String nom;

    private EstadistiquesIndividuals estadistiques;


    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        estadistiques = new EstadistiquesIndividuals();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public boolean addPunts (int punts) { return estadistiques.addPunts(punts);}

    public int getEstadistiques(){
        return estadistiques.getEstadistiques();
    }
}
