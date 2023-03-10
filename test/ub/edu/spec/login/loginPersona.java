package ub.edu.spec.login;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class loginPersona {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public String recuperarContrassenya(String user) {return controlador.getControllerUsuari().recuperarContrassenya(user);}

    public String loginPersona(String user, String pass) {return controlador.getControllerUsuari().loguejarPersona(user, pass);}

}
