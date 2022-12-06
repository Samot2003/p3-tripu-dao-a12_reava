package ub.edu.model;

import ub.edu.model.Estat.Estat;
import ub.edu.model.Estat.NoComencat;

import java.awt.*;
import java.util.ArrayList;

public class TramTrack extends Tram{

    private int distancia,desnivellPositiu, desnivellNegatiu;
    private float duracioEstimada;

    private PuntDeControl puntDeControl;

    public TramTrack(String ID) {
        super(ID);
        estat = new NoComencat();
        puntDeControl = null;
    }
    public String setEstatTramTrack(String nomEstat){
        estat = estat.cambiarEstat(nomEstat);
        return estat.getEstat();
    }

    public void addPuntDeControl(String highLight,Ubicacio ubi){
        puntDeControl = new PuntDeControl(highLight,ubi);
    }
    public PuntDeControl getPuntDeControl(){
        return puntDeControl;
    }

    public void setDistancia(int distancia){ this.distancia = distancia; }

    public void setDuracioEstimada(float duracioEstimada){ this.duracioEstimada = duracioEstimada; }

    public void setDesnivellPositiu(int desnivellPositiu){ this.desnivellPositiu = desnivellPositiu; }

    public void setDesnivellNegatiu(int desnivellNegatiu){ this.desnivellNegatiu = desnivellNegatiu; }

    public int getDistancia() {return distancia;}

    public int getDesnivellPositiu() {return desnivellPositiu;}

    public int getDesnivellNegatiu() {return desnivellNegatiu;}

    public float getDuracioEstimada() {return duracioEstimada;}
}


