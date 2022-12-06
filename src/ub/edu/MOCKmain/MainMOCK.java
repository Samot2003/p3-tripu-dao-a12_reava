package ub.edu.MOCKmain;

import ub.edu.controller.Controller;
import ub.edu.model.*;
import ub.edu.model.Estat.EnProces;
import ub.edu.model.Estat.Estat;
import ub.edu.model.Transport.Transport;


public class MainMOCK {
    public static void main(String[] args) {
        Controller controlador = new Controller();
        String p = "ajaleo@gmail.com";
        System.out.println(controlador.iniciarRuta(p,"Terres de l'Ebre"));

        System.out.println(controlador.iniciarTrackRutaActual(p,"T1"));
        System.out.println(controlador.afegirPuntDeControl(p, "a1", new Ubicacio(5,5,5)));
        System.out.println(controlador.valorarPuntDePasTrackActual(p, 3, true));
        System.out.println(controlador.acabarTrackRutaActual(p));

        controlador.iniciarTrackRutaActual(p,"T2");
        controlador.afegirPuntDeControl(p, "b2", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 5, false);
        controlador.acabarTrackRutaActual(p);

        controlador.iniciarTrackRutaActual(p,"T3");
        controlador.afegirPuntDeControl(p, "c3", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 2, false);
        controlador.acabarTrackRutaActual(p);

        controlador.iniciarTrackRutaActual(p,"T4");
        controlador.afegirPuntDeControl(p, "d4", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 4, true);
        controlador.acabarTrackRutaActual(p);

        System.out.println(controlador.llistarPuntsDePasRutaActual(p));
    }
}