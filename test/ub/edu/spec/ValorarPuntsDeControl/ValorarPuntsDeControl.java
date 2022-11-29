package ub.edu.spec.ValorarPuntsDeControl;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class ValorarPuntsDeControl {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String valorarPuntsDePasRutaActual(){
        return controlador.valorarPuntsDePasRutaActual("ajaleo@gmail.com",5 , true);
    }

    public void initRuta(){
        controlador.iniciarRuta("ajaleo@gmail.com","Terres de l'Ebre");
    }

}