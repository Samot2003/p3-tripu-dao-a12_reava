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
        return controlador.cambiarEstatTramTrack(TramID,"EnProces");
    }

    public void initTram(){

        controlador.addTramTrack(new TramTrack("TT1",3.45f,10,5,2));
        controlador.addTramTrack(new TramTrack("TT2",5.24f,7,0,3));
        controlador.addTramTrack(new TramTrack("TT3",9.53f,30,2,4));
        controlador.addTramTrack(new TramTrack("TT4",1.09f,2,1,1));

    }

}
