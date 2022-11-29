package ub.edu.spec.llistarPuntsDePasPerValoracio;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistarPuntsDePasPerValoracio {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public Iterable<String> llistarPuntsDePasValoracio (String nomRuta) {
         return controlador.llistarPuntsDePasRuta(nomRuta);
    }

    public void initRuta(){
        controlador.iniciarRuta("ajaleo@gmail.com","Terres de l'Ebre");
    }

}
