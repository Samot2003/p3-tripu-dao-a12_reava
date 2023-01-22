package ub.edu.MOCKmain;

import ub.edu.controller.Controller;
import ub.edu.model.*;
import ub.edu.model.Estat.EnProces;
import ub.edu.model.Estat.Estat;
import ub.edu.model.Transport.Transport;


public class MainMOCK {
    public static void main(String[] args) {
        Controller controlador = null;
        controlador.getInstance();
        String p = "ajaleo@gmail.com";
        controlador.iniciarRuta(p,"La Costa Brava");
        System.out.println(controlador.iniciarTrackRutaActual(p,"T1"));
        controlador.afegirPuntDeControl(p,"h",new Ubicacio(1,1,1));
    }
}