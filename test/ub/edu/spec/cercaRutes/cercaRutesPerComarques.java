package ub.edu.spec.cercaRutes;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class cercaRutesPerComarques {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public Iterable<String> cercaRutesPerComarques(String nomComarca) {
        return controlador.cercaRutesPerComarca(nomComarca);
    }

    public void afegirComarques() {
        controlador.afegirComarca("Barcelonès");

    }

}
