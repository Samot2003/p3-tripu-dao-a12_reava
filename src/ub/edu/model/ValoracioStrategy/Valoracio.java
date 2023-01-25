package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public class Valoracio {
    private ArrayList<ValoracioType> valoracions;

    private ValorarStrategy str;
    public Valoracio(){
        valoracions = new ArrayList<>();
        str = null;
    }
    public void valorar(int e) throws Exception {
        valoracions.add(str.valorar(e));
    }

    public void setStrategy(ValorarStrategy str){
        this.str = str;
    }

    public float getNumValoracioPerType(ValorarStrategy str){
        return str.getNum(str,valoracions);
    }

    public ArrayList<ValoracioType> getValoracions(){
        return valoracions;
    }
}
