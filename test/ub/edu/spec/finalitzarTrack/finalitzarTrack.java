package ub.edu.spec.finalitzarTrack;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.TramTrack;

@RunWith(ConcordionRunner.class)
public class finalitzarTrack {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();;
        initRuta();
    }

    public String finalitzarTramTrack(){
        return controlador.getControllerRuta().acabarTrackRutaActual();
    }

    public void initRuta(){
        controlador.getControllerRuta().iniciarRuta("La Costa Brava");
    }

    public void initTrack(){
        controlador.getControllerRuta().iniciarTrackRutaActual("TT1");
    }

}
