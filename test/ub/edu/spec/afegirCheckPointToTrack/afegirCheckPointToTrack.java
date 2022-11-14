package ub.edu.spec.afegirCheckPointToTrack;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.PuntDeControl;
import ub.edu.model.TramTrack;

@RunWith(ConcordionRunner.class)
public class afegirCheckPointToTrack {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
        controlador.iniciarRuta("La Costa Brava");
        controlador.iniciarTrackRutaActual("TT1");
    }

    public String afegirCheckPointInicial (String highlight){
        return controlador.afegirPuntDeControlInicialToTrackActual(new PuntDeControl("Puigcerdà",highlight));
    }

    public void initTrack(){
        controlador.addTrackRuta("La Costa Brava",new TramTrack("TT1"));
        controlador.iniciarTrackRutaActual("TT1");
    }

}
