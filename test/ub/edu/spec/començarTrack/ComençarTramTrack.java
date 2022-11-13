package ub.edu.spec.començarTrack;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.TramTrack;

@RunWith(ConcordionRunner.class)
public class ComençarTramTrack {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String comencarTramTrack(String TramID){
        return "";
    }

    public void initTram(){
        controlador.iniciarRuta("La Costa Brava");
        controlador.addTrackRutaActual(new TramTrack("TT1"));
        controlador.addTrackRutaActual(new TramTrack("TT2"));
        controlador.addTrackRutaActual(new TramTrack("TT3"));
        controlador.addTrackRutaActual(new TramTrack("TT4"));

    }

}
