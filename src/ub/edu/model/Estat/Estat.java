package ub.edu.model.Estat;

public class Estat {
    public Estat(){

    }
    public String getEstat(){
        return getClass().getSimpleName();
    }

    public Estat cambiarEstat(String nomEstat){
        Estat estat;

        if(nomEstat.equals("EnProces")){
            estat = new EnProces();
            return estat;
        }else if(nomEstat.equals("Acabat")){
            estat = new Acabat();
            return estat;
        }else if(nomEstat.equals("NoComençat")) {
            estat = new NoComençat();
            return estat;
        }
        return null;
    }
}
