package ub.edu.model;

import ub.edu.model.Estat.Estat;
import ub.edu.model.Estat.NoComencat;
import ub.edu.model.ValoracioStrategy.ValorarEstrelles;
import ub.edu.model.ValoracioStrategy.ValorarStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TramTrack extends Tram{

    private int distancia,desnivellPositiu, desnivellNegatiu;
    private float duracioEstimada;

    private ArrayList<PuntDeControl> puntsDeControl;

    public TramTrack(String ID) {
        super(ID);
        estat = new NoComencat();
        puntsDeControl = new ArrayList<>();
    }
    public String setEstatTramTrack(String nomEstat){
        estat = estat.cambiarEstat(nomEstat);
        return estat.getEstat();
    }

    public void addPuntDeControl(PuntDeControl p){
        if (!puntsDeControl.contains(p)){
            puntsDeControl.add(p);
        }
    }
    public PuntDeControl getPuntDeControlByID(String ID) throws Exception {
        for (PuntDeControl p: puntsDeControl){
            if (p.getID().equals(ID)){
                return p;
            }
        }
        throw new Exception("No s'ha trobat el punt de control");
    }
    public void removePuntdeControl(String ID) {
        for (PuntDeControl p : puntsDeControl) {
            if (p.getID().equals(ID)) {
                puntsDeControl.remove(p);
            }
        }
    }
    public ArrayList<PuntDeControl> getPuntsDeControl(){
        return puntsDeControl;
    }

    public void setDistancia(int distancia){ this.distancia = distancia; }

    public void setDuracioEstimada(float duracioEstimada){ this.duracioEstimada = duracioEstimada; }

    public void setDesnivellPositiu(int desnivellPositiu){ this.desnivellPositiu = desnivellPositiu; }

    public void setDesnivellNegatiu(int desnivellNegatiu){ this.desnivellNegatiu = desnivellNegatiu; }

    public int getDistancia() {return distancia;}

    public int getDesnivellPositiu() {return desnivellPositiu;}

    public int getDesnivellNegatiu() {return desnivellNegatiu;}

    public float getDuracioEstimada() {return duracioEstimada;}

    public ArrayList<PuntDeControl> getPuntsDeControlValorats(ValorarStrategy str) {
        ArrayList<PuntDeControl> punts = new ArrayList<>();
        for (PuntDeControl p: puntsDeControl){
            if(p.getValoracio().getNumValoracioPerType(str) != 0 || str.toString().equals("Estrelles")){
                punts.add(p);
            }
        }
        return punts;
    }
}


