package ub.edu.MOCKmain;

import ub.edu.controller.Controller;
import ub.edu.model.*;
import ub.edu.model.Estat.EnProces;
import ub.edu.model.Estat.Estat;
import ub.edu.model.Transport.Transport;
import ub.edu.model.ValoracioStrategy.ValorarDislike;
import ub.edu.model.ValoracioStrategy.ValorarEstrelles;
import ub.edu.model.ValoracioStrategy.ValorarLikes;


public class MainMOCK {
    public static void  main(String[] args) {
        Controller controlador = Controller.getInstance();
        String p = "ajaleo@gmail.com";
        //System.out.println(controlador.crearGrup("G3"));
        //System.out.println(controlador.addMembreGrup("G3", "dtomacal@yahoo.cat"));
        puntdepas(controlador);

    }

    public void marxarGrup(Controller controller){
        System.out.println(controller.crearGrup("G3"));
        System.out.println(controller.addMembreGrup("G3", "adtomacal@yahoo.cat"));
        System.out.println(controller.marxarGrup("G3","dtomacal@yahoo.cat"));
    }

    public static void puntdepas(Controller controlador){
        System.out.println(controlador.llistarPuntsDePasRutaActual(new ValorarEstrelles()));

        controlador.iniciarRuta("Terres de l'Ebre");
        controlador.iniciarTrackRutaActual("TT1");
        PuntDeControl p1 = new PuntDeControl("p1",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p1);
        controlador.valorarPuntDePasTrackActual("p1", new ValorarEstrelles(),1);
        PuntDeControl p2 = new PuntDeControl("p2",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p2);
        controlador.valorarPuntDePasTrackActual("p2", new ValorarEstrelles(),4);
        PuntDeControl p3 = new PuntDeControl("p3",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p3);
        controlador.valorarPuntDePasTrackActual("p3", new ValorarEstrelles(),2);
        PuntDeControl p4 = new PuntDeControl("p4",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p4);
        controlador.valorarPuntDePasTrackActual("p4", new ValorarEstrelles(),2);
        PuntDeControl p5 = new PuntDeControl("p5",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p5);
        controlador.valorarPuntDePasTrackActual("p5", new ValorarEstrelles(),3);
        PuntDeControl p6 = new PuntDeControl("p6",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p6);
        controlador.valorarPuntDePasTrackActual("p6", new ValorarEstrelles(),3);
        PuntDeControl p7 = new PuntDeControl("p7",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p7);
        controlador.valorarPuntDePasTrackActual("p7", new ValorarEstrelles(),3);
        PuntDeControl p8 = new PuntDeControl("p8",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p8);
        controlador.valorarPuntDePasTrackActual("p8", new ValorarEstrelles(),4);
        PuntDeControl p9 = new PuntDeControl("p9",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p9);
        controlador.valorarPuntDePasTrackActual("p9", new ValorarEstrelles(),4);
        PuntDeControl p10 = new PuntDeControl("p10",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p10);
        controlador.valorarPuntDePasTrackActual("p10", new ValorarEstrelles(),0);
        PuntDeControl p11 = new PuntDeControl("p11",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p11);
        controlador.valorarPuntDePasTrackActual("p11", new ValorarEstrelles(),5);

        System.out.println(controlador.llistarPuntsDePasRutaActual(new ValorarEstrelles()));
    }
}