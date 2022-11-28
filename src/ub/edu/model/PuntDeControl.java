package ub.edu.model;

import java.util.List;

public class PuntDeControl{
    private String highlight;
    private Valoracio valoracio;

    private Ubicacio ubicacio;
    public PuntDeControl(String highlight, Ubicacio ubicacio) {
        this.highlight = highlight;
        valoracio = new Valoracio();
    }

    public void setValoracio(int estrelles, boolean like) {
        valoracio.setEstrelles(estrelles);
        valoracio.setLike(like);
    }

    public Valoracio getValoracio(){
        return valoracio;
    }

    public Ubicacio getUbicacio() {
        return ubicacio;
    }
}
