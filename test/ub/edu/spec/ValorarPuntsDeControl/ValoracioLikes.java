package ub.edu.spec.ValorarPuntsDeControl;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.PuntDeControl;
import ub.edu.model.Ubicacio;
import ub.edu.model.ValoracioStrategy.ValorarLikes;

@RunWith(ConcordionRunner.class)
public class ValoracioLikes {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public String valorarPuntsDePasRutaActual(String id, int val){
        String s=controlador.valorarPuntDePasTrackActual(id,new ValorarLikes(),val);
        return s;
    }
    public void acabarRuta(){
        controlador.acabarRuta();
    }
    public void initPuntDePas(){
        controlador.iniciarRuta("Terres de l'Ebre");
        controlador.iniciarTrackRutaActual("TT1");
        PuntDeControl p1 = new PuntDeControl("p1",new Ubicacio(1,1,1));
        controlador.afegirPuntDeControl(p1);
    }


}
