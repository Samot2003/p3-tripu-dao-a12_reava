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

    public void setValoracio(Valoracio valoracio) {
        this.valoracio = valoracio;
    }

    public Valoracio getValoracio(){
        return valoracio;
    }
}
