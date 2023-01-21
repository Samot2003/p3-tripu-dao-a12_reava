package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public interface ValorarStrategy {

    public Object valorar(int e) throws Exception;

    public float getNum(ValorarStrategy str, ArrayList<Object> valoracions);
}
