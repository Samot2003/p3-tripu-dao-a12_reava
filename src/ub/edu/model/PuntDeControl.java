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

    public void setEstrelles(int estrelles){
        valoracio.setEstrelles(estrelles);
    }

    public void setLike(boolean like){
        valoracio.setLike(like);
    }
    public int getEstrelles(){
        return valoracio.getEstrelles();
    }

    public String getLike(){
        return valoracio.getLike();
    }
}
