package ub.edu.spec.cercaRutes;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class cercarRutesPerLocalitats {
    Controller controlador;
    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public Iterable<String> cercaRutesPerLocalitats(String nomLocalitat) {
        return controlador.getControllerRuta().cercaRutesPerLocalitat(nomLocalitat);
    }

    public void afegirLocalitats() {
        controlador.getControllerRuta().afegirLocalitat("Barcelona");

    }


}
