package ub.edu.model.ValoracioStrategy;

public class ValorarEstrelles implements ValorarStrategy{

    private static int estrelles;

    public boolean Valorar (int e){
        if (e > 5 || e < 0){
            return false;
        }else{
            estrelles = e;
            return true;
        }
    }
}
