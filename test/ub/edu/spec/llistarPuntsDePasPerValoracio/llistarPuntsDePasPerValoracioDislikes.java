package ub.edu.spec.llistarPuntsDePasPerValoracio;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.PuntDeControl;
import ub.edu.model.Ubicacio;
import ub.edu.model.ValoracioStrategy.ValorarDislike;

@RunWith(ConcordionRunner.class)
public class llistarPuntsDePasPerValoracioDislikes {

    private Controller controlador;


    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();

    }

    public Iterable<String> llistarPuntsDePasValoracio () {
        return controlador.llistarPuntsDePasRutaActual(new ValorarDislike());
    }

    public void acabarTrack(){
        controlador.acabarTrackRutaActual();
    }
    public void acabarRuta(){
        controlador.acabarRuta();
    }

    public void initAll(){
        controlador.iniciarRuta("Terres de l'Ebre");
        controlador.iniciarTrackRutaActual("TT1");
        PuntDeControl p1 = new PuntDeControl("p1",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p1);
        controlador.valorarPuntDePasTrackActual("p1", new ValorarDislike(),1);
        PuntDeControl p2 = new PuntDeControl("p2",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p2);
        controlador.valorarPuntDePasTrackActual("p2", new ValorarDislike(),4);
        PuntDeControl p3 = new PuntDeControl("p3",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p3);
        controlador.valorarPuntDePasTrackActual("p3", new ValorarDislike(),2);
        PuntDeControl p4 = new PuntDeControl("p4",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p4);
        controlador.valorarPuntDePasTrackActual("p4", new ValorarDislike(),2);
        PuntDeControl p5 = new PuntDeControl("p5",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p5);
        controlador.valorarPuntDePasTrackActual("p5", new ValorarDislike(),3);
        PuntDeControl p6 = new PuntDeControl("p6",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p6);
        controlador.valorarPuntDePasTrackActual("p6", new ValorarDislike(),3);
        PuntDeControl p7 = new PuntDeControl("p7",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p7);
        controlador.valorarPuntDePasTrackActual("p7", new ValorarDislike(),3);
        PuntDeControl p8 = new PuntDeControl("p8",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p8);
        controlador.valorarPuntDePasTrackActual("p8", new ValorarDislike(),4);
        PuntDeControl p9 = new PuntDeControl("p9",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p9);
        controlador.valorarPuntDePasTrackActual("p9", new ValorarDislike(),4);
        PuntDeControl p10 = new PuntDeControl("p10",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p10);
        controlador.valorarPuntDePasTrackActual("p10", new ValorarDislike(),0);
        PuntDeControl p11 = new PuntDeControl("p11",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p11);
        controlador.valorarPuntDePasTrackActual("p11", new ValorarDislike(),5);

    }

}
