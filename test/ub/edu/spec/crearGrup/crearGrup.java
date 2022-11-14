package ub.edu.spec.crearGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.Grup;

@RunWith(ConcordionRunner.class)
public class crearGrup {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String crearGrup (String nomGrup){
        return controlador.crearGrup(nomGrup);
    }
    public void initGrup(){
        controlador.crearGrup("Grup1");
    }
}
