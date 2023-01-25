package ub.edu.spec.llistarPuntsDePasPerValoracio;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.PuntDeControl;
import ub.edu.model.Ubicacio;
import ub.edu.model.ValoracioStrategy.ValorarDislike;
import ub.edu.model.ValoracioStrategy.ValorarEstrelles;
import ub.edu.model.ValoracioStrategy.ValorarLikes;

@RunWith(ConcordionRunner.class)
public class llistarPuntsDePasPerValoracio {

    private Controller controlador;


    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();

    }

    public Iterable<String> llistarPuntsDePasValoracioEstrelles () {
        return controlador.getControllerPuntDePas().llistarPuntsDePasRutaActual(new ValorarEstrelles());
    }
    public Iterable<String> llistarPuntsDePasValoracioLikes () {
        return controlador.getControllerPuntDePas().llistarPuntsDePasRutaActual(new ValorarLikes());
    }
    public Iterable<String> llistarPuntsDePasValoracioDislikes () {
        return controlador.getControllerPuntDePas().llistarPuntsDePasRutaActual(new ValorarDislike());
    }

    public void acabarTrack(){
        controlador.getControllerRuta().acabarTrackRutaActual();
    }
    public void acabarRuta(){
        controlador.getControllerRuta().acabarRuta();
    }

    public void initPunts(){
        controlador.getControllerRuta().iniciarRuta("Terres de l'Ebre");
        controlador.getControllerRuta().iniciarTrackRutaActual("TT1");
        PuntDeControl p1 = new PuntDeControl("p1",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p1);
        PuntDeControl p2 = new PuntDeControl("p2",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p2);
        PuntDeControl p3 = new PuntDeControl("p3",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p3);
        PuntDeControl p4 = new PuntDeControl("p4",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p4);
        PuntDeControl p5 = new PuntDeControl("p5",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p5);
        PuntDeControl p6 = new PuntDeControl("p6",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p6);
        PuntDeControl p7 = new PuntDeControl("p7",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p7);
        PuntDeControl p8 = new PuntDeControl("p8",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p8);
        PuntDeControl p9 = new PuntDeControl("p9",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p9);
        PuntDeControl p10 = new PuntDeControl("p10",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p10);
        PuntDeControl p11 = new PuntDeControl("p11",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p11);

    }
    public void valorarEstrelles(){
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarEstrelles(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p2", new ValorarEstrelles(),4);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarEstrelles(),2);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarEstrelles(),2);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p5", new ValorarEstrelles(),3);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarEstrelles(),3);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarEstrelles(),3);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p8", new ValorarEstrelles(),4);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p9", new ValorarEstrelles(),4);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p10", new ValorarEstrelles(),0);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarEstrelles(),5);
    }
    public void valorarLikes(){
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p2", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p5", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p8", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p9", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarLikes(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarLikes(),1);
    }
    public void valorarDislikes(){
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p1", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p2", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p2", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p2", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p3", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p4", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p5", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p6", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p7", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p8", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p9", new ValorarDislike(),1);
        controlador.getControllerPuntDePas().valorarPuntDePasTrackActual("p11", new ValorarDislike(),1);
    }

}
