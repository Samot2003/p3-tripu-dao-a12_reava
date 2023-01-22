package ub.edu.spec.finalitzarRuta;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class finalitzarRuta {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public String acabarRuta(){
        return controlador.acabarRuta("ajaleo@gmail.com");
    }

    public void initRuta(){
        controlador.iniciarRuta("ajaleo@gmail.com","Terres de l'Ebre");
    }
}
