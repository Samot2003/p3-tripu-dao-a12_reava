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
        controlador = Controller.getInstance();
        controlador.getControllerRuta().iniciarRuta("La Costa Brava");
    }

    public String afegirCheckPoint (String ID){
        PuntDeControl p = new PuntDeControl(ID,new Ubicacio(3,5,2));
        return controlador.getControllerPuntDePas().afegirPuntDeControl(p);
    }
    public void removePuntdeControl(String ID){controlador.getControllerPuntDePas().removePuntDeControl(ID);}
    public void acabarTrack(){
        controlador.getControllerRuta().acabarTrackRutaActual();
    }
    public void acabarRuta(){
        controlador.getControllerRuta().acabarRuta();
    }
    public void initTrack(){
        controlador.getControllerRuta().iniciarTrackRutaActual("TT1");
    }

}
