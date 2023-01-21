package ub.edu.model.ValoracioStrategy;

public class ValorarLikes implements ValorarStrategy{
    private int like;
    public boolean Valorar(int e){
        if(e == 1){
            like =+ 1;
        } else if (e == -1) {

            like =-1 ;
        }
        else{
            return false;
        }
        return true;
    }

}

