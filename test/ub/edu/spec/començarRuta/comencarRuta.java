package ub.edu.spec.començarRuta;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class comencarRuta {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String comencarRuta(String nomRuta){
        return controlador.cambiarEstatRuta(nomRuta, "EnProces");
    }

    public void initRuta(){
        controlador.cambiarEstatRuta("Terres de l'Ebre", "EnProces");
    }
}
