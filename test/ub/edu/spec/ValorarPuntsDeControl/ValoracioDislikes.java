package ub.edu.spec.ValorarPuntsDeControl;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.PuntDeControl;
import ub.edu.model.Ubicacio;
import ub.edu.model.ValoracioStrategy.ValorarDislike;

@RunWith(ConcordionRunner.class)
public class ValoracioDislikes {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
        controlador.getControllerRuta().iniciarRuta("Terres de l'Ebre");
        controlador.getControllerRuta().iniciarTrackRutaActual("TT1");
    }

    public String valorarPuntsDePasRutaActual(String id, int val){
        String s=controlador.getControllerPuntDePas().valorarPuntDePasTrackActual(id,new ValorarDislike(),val);
        return s;
    }
    public void acabarRuta(){
        controlador.getControllerRuta().acabarRuta();
    }
    public void acabarTrack(){
        controlador.getControllerRuta().acabarTrackRutaActual();
    }
    public void removePuntdeControl(String ID){controlador.getControllerPuntDePas().removePuntDeControl(ID);}
    public void initPuntDePas(){
        PuntDeControl p1 = new PuntDeControl("p1",new Ubicacio(1,1,1));
        controlador.getControllerPuntDePas().afegirPuntDeControl(p1);
    }


}
