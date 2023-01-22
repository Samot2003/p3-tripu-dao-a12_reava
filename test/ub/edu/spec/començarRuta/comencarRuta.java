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
        controlador = Controller.getInstance();
    }

    public String comencarRuta(String nomRuta){
        return controlador.iniciarRuta("ajaleo@gmail.com",nomRuta);
    }

    public void initRuta(){
        controlador.iniciarRuta("ajaleo@gmail.com","Terres de l'Ebre");
    }
}
