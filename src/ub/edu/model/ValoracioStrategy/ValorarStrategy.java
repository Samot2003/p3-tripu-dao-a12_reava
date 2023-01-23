package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public interface ValorarStrategy {

    public ValoracioType valorar(int e) throws Exception;

    public float getNum(ValorarStrategy str, ArrayList<ValoracioType> valoracions);

    public String toString();
}
