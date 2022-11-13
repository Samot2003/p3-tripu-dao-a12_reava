package ub.edu.model;

import ub.edu.model.Estat.Estat;
import ub.edu.model.Estat.NoComencat;

public class Tram {

    String ID;
    Estat estat;

    public Tram(String ID){
        this.ID = ID;
        estat = new NoComencat();
    }

    public String getID(){
        return ID;
    }

    public String getEstat(){
        return estat.getEstat();
    }

    public String cambiarEstat(String nomEstat){
        if (nomEstat.equals(estat.getEstat())){
            return ("L'estat al que vols canviar ja es l'actual");
        }
        estat = estat.cambiarEstat(nomEstat);
        return "Estat canviat a: " + estat.getEstat();
    }

}
