package ub.edu.spec.cercaRutes;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class cercaRutesPerTransport {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public Iterable<String> cercaRutesPerTransports(String id) {
        return controlador.getControllerRuta().cercaRutesPerTransport(id);
    }

    public void afegirTransports() {
        controlador.getControllerRuta().afegirTransport("Bici","b4", 9);

    }



}

