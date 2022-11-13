package ub.edu.MOCKmain;

import ub.edu.controller.Controller;
import ub.edu.model.Estat.EnProces;
import ub.edu.model.Estat.Estat;
import ub.edu.model.Tram;
import ub.edu.model.Transport.Transport;


public class MainMOCK {
    public static void main(String[] args) {
        Controller c = new Controller();

        System.out.println(c.addTrackRuta("La Costa Brava", new Tram("tCB1")));
        System.out.println(c.addTrackRuta("La Costa Brava", new Tram("tCB2")));
        System.out.println(c.addTrackRuta("La Costa Brava", new Tram("tCB3")));
        System.out.println(c.addTrackRuta("Ribera del Ter", new Tram("tRT1")));

        System.out.println(c.addTrackRutaActual(new Tram("tCB1")));
        System.out.println(c.iniciarRuta("La Costa Brava"));
        System.out.println(c.addTrackRutaActual(new Tram("tCB1")));

        System.out.println(c.iniciarTrackRutaActual("tCB1"));
        System.out.println(c.iniciarTrackRutaActual("tCB3"));
        System.out.println(c.acabarTrackRutaActual());
        System.out.println(c.acabarTrackRutaActual());
    }
}