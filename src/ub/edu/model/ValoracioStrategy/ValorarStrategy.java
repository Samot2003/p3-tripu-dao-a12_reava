package ub.edu.model.ValoracioStrategy;

public interface ValorarStrategy {

    public default boolean Valorar(int e){

        return false;
    }

}
