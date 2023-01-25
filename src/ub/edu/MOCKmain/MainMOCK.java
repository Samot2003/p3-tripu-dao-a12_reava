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
        puntdepas(controlador);
    }

    public void marxarGrup(Controller controller){
        System.out.println(controller.getControllerGrups().crearGrup("G3"));
        System.out.println(controller.getControllerGrups().addMembreGrup("G3", "adtomacal@yahoo.cat"));
        System.out.println(controller.getControllerGrups().marxarGrup("G3","dtomacal@yahoo.cat"));
    }

    public static void puntdepas(Controller controlador){
        System.out.println(controlador.getControllerPuntDePas().llistarPuntsDePasRutaActual(new ValorarEstrelles()));

        controlador.getControllerRuta().iniciarRuta("Terres de l'Ebre");
        controlador.getControllerRuta().iniciarTrackRutaActual("TT1");
        PuntDeControl p1 = new PuntDeControl("p1",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarEstrelles(),1);
        PuntDeControl p2 = new PuntDeControl("p2",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p2);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p2", new ValorarEstrelles(),4);
        PuntDeControl p3 = new PuntDeControl("p3",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p3);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarEstrelles(),2);
        PuntDeControl p4 = new PuntDeControl("p4",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p4);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarEstrelles(),2);
        PuntDeControl p5 = new PuntDeControl("p5",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p5);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p5", new ValorarEstrelles(),3);
        PuntDeControl p6 = new PuntDeControl("p6",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p6);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarEstrelles(),3);
        PuntDeControl p7 = new PuntDeControl("p7",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p7);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarEstrelles(),3);
        PuntDeControl p8 = new PuntDeControl("p8",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p8);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p8", new ValorarEstrelles(),4);
        PuntDeControl p9 = new PuntDeControl("p9",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p9);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p9", new ValorarEstrelles(),4);
        PuntDeControl p10 = new PuntDeControl("p10",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p10);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p10", new ValorarEstrelles(),0);
        PuntDeControl p11 = new PuntDeControl("p11",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p11);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarEstrelles(),5);

        System.out.println(controlador.getControllerPuntDePas().llistarPuntsDePasRutaActual(new ValorarEstrelles()));
    }
}