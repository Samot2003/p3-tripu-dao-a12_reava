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
        System.out.println(c.getRankingGrup("G1"));
        System.out.println(c.crearGrup("G1"));
        System.out.println(c.getRankingGrup("G1"));


    }
}