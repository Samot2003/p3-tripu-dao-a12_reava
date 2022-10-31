package ub.edu.spec.acabarRuta;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class acabarRuta {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String acabarRuta(String nomRuta){
        return controlador.cambiarEstatRuta(nomRuta, "NoComençat");
    }

    public void initRuta(){
        controlador.cambiarEstatRuta("Terres de l'Ebre", "EnProces");
    }
}

