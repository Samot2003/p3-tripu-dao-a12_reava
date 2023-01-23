package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public class ValorarDislike implements ValorarStrategy{
    @Override
    public ValoracioType valorar(int e) throws Exception {
        return new Like(-1);
    }

    @Override
    public float getNum(ValorarStrategy str, ArrayList<ValoracioType> valoracions) {
        int suma = 0;
        for (ValoracioType v: valoracions) {
            if (v.getClass().equals(Like.class) && ((Like) v).getVal() == -1) {
                suma += 1;
            }
        }
        return suma;
    }

    public String toString(){
        return "Dislikes";
    }
}
