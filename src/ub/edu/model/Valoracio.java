package ub.edu.model;

public class Valoracio {
    private int estrelles;
    private String like;
    private boolean likeValorat;
    public Valoracio(){
        estrelles = -1;
        likeValorat = false;
    }

    public boolean setEstrelles(int e){
        if (e > 5 || e < 0){
            return false;
        }else{
            estrelles = e;
            return true;
        }
    }

    public int getEstrelles(){
        return estrelles;
    }

    public String setLike(boolean l){
        if(l){
            like = "LIKE";
        }else{
            like = "DISLIKE";
        }
        likeValorat = true;
        return like;
    }

    public String getLike() {
        if (likeValorat) {
            return like;
        } else return "NoValorat";
    }

}
