package ub.edu.model;

import ub.edu.model.Estat.Estat;
import ub.edu.model.Estat.NoComencat;

public class TramTrack {

    private int distancia,desnivellPositiu, desnivellNegatiu;
    private float duracioEstimada;

    private String tramID;

    private Estat estat;
    public TramTrack(String tramID,float duracioEstimada, int distancia, int desnivellPositiu, int desnivellNegatiu) {
        this.tramID=tramID;
        this.duracioEstimada = duracioEstimada;
        this.distancia = distancia;
        this.desnivellPositiu = desnivellPositiu;
        this.desnivellNegatiu = desnivellNegatiu;
        estat = new NoComencat();
    }
    public Estat setEstatTramTrack(String nomEstat){
        estat = estat.cambiarEstat(nomEstat);
        return estat;
    }

    public void setTramID(String tramID){ this.tramID = tramID; }

    public void setDistancia(int distancia){ this.distancia = distancia; }

    public void setDuracioEstimada(float duracioEstimada){ this.duracioEstimada = duracioEstimada; }

    public void setDesnivellPositiu(int desnivellPositiu){ this.desnivellPositiu = desnivellPositiu; }

    public void setDesnivellNegatiu(int desnivellNegatiu){ this.desnivellNegatiu = desnivellNegatiu; }

    public String getTramID() { return tramID; }

    public int getDistancia() {return distancia;}

    public int getDesnivellPositiu() {return desnivellPositiu;}

    public int getDesnivellNegatiu() {return desnivellNegatiu;}

    public float getDuracioEstimada() {return duracioEstimada;}

    public String getEstat(){return estat.getEstat();}

}


