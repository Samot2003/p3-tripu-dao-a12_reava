package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public class ValorarEstrelles implements ValorarStrategy{

    public Estrelles valorar (int e) throws Exception {
        if (e <= 5 && e >= 0) {
            return new Estrelles(e);
        }
        throw new Exception("La valoracio d'estrelles ha de ser un numero entre 0 i 5");
    }

    @Override
    public float getNum(ValorarStrategy str, ArrayList<ValoracioType> valoracions) {
        float valor = 0;
        float num = 0;
        for (ValoracioType v: valoracions){
            if (v.getClass().equals(Estrelles.class)){
                valor += ((Estrelles) v).getVal();
                num += 1;
            }
        }
        return (valor/num);
    }

    public String toString(){
        return "Estrelles";
    }
}
