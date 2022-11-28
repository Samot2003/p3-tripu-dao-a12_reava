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
        controlador = new Controller();
    }

    public String comencarTramTrack(String tramID){
        return controlador.iniciarTrackRutaActual("ajaleo@gmail.com",tramID);
    }

    public void initTramTracks(){
        controlador.iniciarRuta("ajaleo@gmail.com","La Costa Brava");
    }

}
