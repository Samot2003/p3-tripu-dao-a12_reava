package ub.edu.model;

import ub.edu.model.ValoracioStrategy.ValorarEstrelles;
import ub.edu.model.ValoracioStrategy.ValorarLikes;
import ub.edu.model.ValoracioStrategy.ValorarStrategy;

public class PuntDeControl{
    private String highlight;
    private Ubicacio ubicacio;
    private int likes;
    private float estrelles;
    private int numEstrelles;
    private ValorarStrategy ValorarLikes;
    private ValorarStrategy ValorarEstrelles;
    public PuntDeControl(String highlight, Ubicacio ubicacio) {
        this.highlight = highlight;
        numEstrelles=0;
        ValorarLikes = null;
        ValorarEstrelles = null;
    }

    public void setValoracio(ValorarStrategy str, int valoracio) {
        if (str.Valorar(valoracio) && str.equals(ValorarLikes)){
            likes =+ valoracio;
        };
        if (str.Valorar(valoracio) && str.equals(ValorarEstrelles)){
            estrelles =+ valoracio;
            numEstrelles =+ 1;
        };
    }

    public String getHighlight(){
        return highlight;
    }

    public float  getValoracio(ValorarStrategy str){
        if (str.equals(ValorarLikes)){
            return likes;
        };
        if (str.equals(ValorarEstrelles)){
            return estrelles/numEstrelles;
        };
        return -2;
    }

    public Ubicacio getUbicacio() {
        return ubicacio;
    }
}
