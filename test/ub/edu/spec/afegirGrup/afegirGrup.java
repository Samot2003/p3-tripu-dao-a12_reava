package ub.edu.spec.afegirGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.Grup;
import ub.edu.model.Persona;

@RunWith(ConcordionRunner.class)
public class afegirGrup {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public void afegirGrup (String nomGrup, String nomPersona){
        controlador.addMembreGrup(nomGrup,nomPersona);
    }
    public void initGrup(){
        Grup g = new Grup("Grup1");
    }

}
