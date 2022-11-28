package ub.edu.spec.afegirCheckPointToTrack;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.PuntDeControl;
import ub.edu.model.TramTrack;
import ub.edu.model.Ubicacio;

@RunWith(ConcordionRunner.class)
public class afegirCheckPointToTrack {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
        controlador.iniciarRuta("ajaleo@gmail.com","La Costa Brava");
        controlador.iniciarTrackRutaActual("ajaleo@gmail.com","TT1");
    }

    public String afegirCheckPoint (String highlight){
        return controlador.afegirPuntDeControl("ajaleo@gmail.com",highlight,new Ubicacio(3,5,2));
    }

    public void initTrack(){
        controlador.iniciarTrackRutaActual("ajaleo@gmail.com","TT1");
    }

}
