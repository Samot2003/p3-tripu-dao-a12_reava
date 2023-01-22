package ub.edu.spec.GestioGrups.afegirGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class afegirGrup {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
    }

    public String afegirGrup (String nomGrup, String nomPersona){
        return controlador.addMembreGrup(nomGrup,nomPersona);
    }
    public void initGrup(){
        controlador.crearGrup("Grup1");
    }

}
