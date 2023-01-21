package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public class Valoracio {
    private ArrayList<Object> valoracions;
    public Valoracio(){
        valoracions = new ArrayList<>();
    }
    public void valorar(ValorarStrategy str,int e ) throws Exception {
        valoracions.add(str.valorar(e));

    }
}
