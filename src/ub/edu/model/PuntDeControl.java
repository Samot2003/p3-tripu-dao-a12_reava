package ub.edu.model;

import java.util.List;

public class PuntDeControl extends Localitat{
    private String highlight;
    private Valoracio valoracio;
    public PuntDeControl(String nomLocalitat,String highlight) {
        super(nomLocalitat);
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
}
