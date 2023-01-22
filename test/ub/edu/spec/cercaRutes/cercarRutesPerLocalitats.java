package ub.edu.spec.cercaRutes;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class cercarRutesPerLocalitats {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador.getInstance();
    }

    public Iterable<String> cercaRutesPerLocalitats(String nomLocalitat) {
        return controlador.cercaRutesPerLocalitat(nomLocalitat);
    }

    public void afegirLocalitats() {
        controlador.afegirLocalitat("Barcelona");

    }


}
