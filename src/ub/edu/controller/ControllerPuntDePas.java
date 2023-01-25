package ub.edu.controller;

import ub.edu.model.PuntDeControl;
import ub.edu.model.TripUB;
import ub.edu.model.ValoracioStrategy.ValorarStrategy;

import java.util.ArrayList;
import java.util.List;

public class ControllerPuntDePas {




    GeneralDataController data;

    public ControllerPuntDePas(){
        data = GeneralDataController.getInstance();
    }

    public String afegirPuntDeControl(PuntDeControl p){
        try{
            data.tripUB().afegirPuntDeControl(data.nomPersona(), p);
            return "Punt de Control Inicial establert correctament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String removePuntDeControl(String ID){
        try{
            data.tripUB().removePuntDeControl(data.nomPersona(), ID);
            return "Punt de Control eliminat correctament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String valorarPuntDePasTrackActual(String ID, ValorarStrategy str, int valoracio){
        try{
            data.tripUB().valorarPuntsDePas(ID,str, valoracio, data.nomPersona());
            return "Punts de control valorats correctament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Iterable<String> llistarPuntsDePasRutaActual(ValorarStrategy str){
        List<String> r = new ArrayList<>();
        try{
            return data.tripUB().llistarPuntsDePasRutaActual(str);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }
}
