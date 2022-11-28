package ub.edu.model;


public class Persona {
    private String pwd;
    private String nom;

    private EstadistiquesIndividuals estadistiques;

    private Ubicacio ubicacio;

    private Ruta rutaActual;


    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        estadistiques = new EstadistiquesIndividuals();
        ubicacio = new Ubicacio((float) (Math.random() * 20),(float) (Math.random() * 20),(float) (Math.random() * 20));
        rutaActual = null;
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
    public void setRutaActual(Ruta r){rutaActual = r;}

    public Ruta getRutaActual(){
        return rutaActual;
    }
}
