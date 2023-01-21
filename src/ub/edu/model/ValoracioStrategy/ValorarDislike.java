package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public class ValorarDislike implements ValorarStrategy{
    @Override
    public Object valorar(int e) throws Exception {
        return new Like(-1);
    }

    @Override
    public float getNum(ValorarStrategy str, ArrayList<Object> valoracions) {
        int suma = 0;
        for (Object v: valoracions) {
            if (v.getClass().equals(Like.class) && ((Like) v).getVal() == -1) {
                suma += 1;
            }
        }
        return suma;
    }
}
