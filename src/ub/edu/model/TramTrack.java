package ub.edu.model;

import ub.edu.model.Estat.Estat;
import ub.edu.model.Estat.NoComencat;

public class TramTrack extends Tram{

    private int distancia,desnivellPositiu, desnivellNegatiu;
    private float duracioEstimada;

    private Estat estat;
    public TramTrack(String ID/*float duracioEstimada, int distancia, int desnivellPositiu, int desnivellNegatiu*/) {
        super(ID);
        /*this.duracioEstimada = duracioEstimada;
        this.distancia = distancia;
        this.desnivellPositiu = desnivellPositiu;
       this.desnivellNegatiu = desnivellNegatiu; */
        estat = new NoComencat();
    }
    public String setEstatTramTrack(String nomEstat){
        estat = estat.cambiarEstat(nomEstat);
        return estat.getEstat();
    }


    public void setDistancia(int distancia){ this.distancia = distancia; }

    public void setDuracioEstimada(float duracioEstimada){ this.duracioEstimada = duracioEstimada; }

    public void setDesnivellPositiu(int desnivellPositiu){ this.desnivellPositiu = desnivellPositiu; }

    public void setDesnivellNegatiu(int desnivellNegatiu){ this.desnivellNegatiu = desnivellNegatiu; }

    public int getDistancia() {return distancia;}

    public int getDesnivellPositiu() {return desnivellPositiu;}

    public int getDesnivellNegatiu() {return desnivellNegatiu;}

    public float getDuracioEstimada() {return duracioEstimada;}

    public String getEstat(){return estat.getEstat();}

}


