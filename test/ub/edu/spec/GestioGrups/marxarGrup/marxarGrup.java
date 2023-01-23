package ub.edu.spec.GestioGrups.marxarGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class marxarGrup {
    final private Controller controlador = Controller.getInstance();

    @BeforeExample
    private void init() {
    }

    public String marxarGrup (String nomGrup, String nomPersona){
        return controlador.marxarGrup(nomGrup);
    }
    public void initGrup(){
        controlador.crearGrup("Grup3");
    }
    public void initGrupAmbMembre(){
        controlador.crearGrup("Grup3");
        controlador.addMembreGrup("Grup3","dtomacal@yahoo.cat");
    }
}
