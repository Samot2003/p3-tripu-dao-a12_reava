package ub.edu.model;

import ub.edu.model.ValoracioStrategy.Valoracio;
import ub.edu.model.ValoracioStrategy.ValorarStrategy;

public class PuntDeControl{
    private String highlight;
    private Ubicacio ubicacio;
    private Valoracio valoracio;
    public PuntDeControl(String highlight, Ubicacio ubicacio) {
        this.highlight = highlight;
        valoracio = new Valoracio();
    }

    public void setValoracio(ValorarStrategy str, int val) throws Exception {
        valoracio.valorar(str,val);
    }

    public String getHighlight(){
        return highlight;
    }

    public Ubicacio getUbicacio() {
        return ubicacio;
    }

    public Valoracio getValoracio() {
        return valoracio;
    }
}
