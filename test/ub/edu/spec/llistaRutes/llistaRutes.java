package ub.edu.spec.llistaRutes;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistaRutes {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public Iterable<String> listCatalegRutesPerNom() {
        return controlador.llistarCatalegRutesPerNom();
    }

    public Iterable<String>  listCatalegRutesPerDurada() {
        return controlador.llistarCatalegRutesPerDurada();
    }

}