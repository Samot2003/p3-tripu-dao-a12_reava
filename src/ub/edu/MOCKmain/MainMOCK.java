package ub.edu.MOCKmain;

import ub.edu.controller.Controller;
import ub.edu.model.Estat.EnProces;
import ub.edu.model.Estat.Estat;
import ub.edu.model.Localitat;
import ub.edu.model.PuntDeControl;
import ub.edu.model.Tram;
import ub.edu.model.TramTrack;
import ub.edu.model.Transport.Transport;


public class MainMOCK {
    public static void main(String[] args) {
        Controller c = new Controller();

        System.out.println(c.addTrackRuta("La Costa Brava", new TramTrack("tCB1")));
        System.out.println(c.addTrackRuta("La Costa Brava", new TramTrack("tCB2")));
        System.out.println(c.addTrackRuta("La Costa Brava", new TramTrack("tCB3")));
        System.out.println(c.addTrackRuta("Ribera del Ter", new TramTrack("tRT1")));
        System.out.println(c.addTrackRutaActual(new TramTrack("tCB4")));
        System.out.println(c.afegirPuntDeControlInicialToTrackActual(new PuntDeControl("Puigcerdà","p1")));
        System.out.println(c.iniciarRuta("La Costa Brava"));
        System.out.println(c.afegirPuntDeControlInicialToTrackActual(new PuntDeControl("Puigcerdà","p1")));
        System.out.println(c.iniciarTrackRutaActual("tCB1"));
        System.out.println(c.afegirPuntDeControlInicialToTrackActual(new PuntDeControl("Puigcerdà","p1")));
        System.out.println(c.acabarTrackRutaActual());

    }
}