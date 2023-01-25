package ub.edu.spec.començarTrack;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.TramTrack;

@RunWith(ConcordionRunner.class)
public class ComencarTramTrack {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();;
        controlador.getControllerRuta().iniciarRuta("La Costa Brava");
    }

    public String comencarTramTrack(String tramID){
        return controlador.getControllerRuta().iniciarTrackRutaActual(tramID);
    }

}
