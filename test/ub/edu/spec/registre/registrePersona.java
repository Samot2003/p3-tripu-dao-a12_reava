package ub.edu.spec.registre;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class registrePersona {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }


    public String getPersona(String a) {
        return controlador.findPersona(a);
    }

    public String validatePassword(String b) {
        return controlador.validatePassword(b);
    }

    public String validateUsername(String a) {return controlador.validateUsername(a);}

    public String isValidRegistre(String personaName, String password) {
        return controlador.validateRegistrePersona(personaName, password);
    }
}
