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

    public String marxarGrup (String nomGrup, String nomPersona) throws InterruptedException {
        return controlador.marxarGrup(nomGrup, nomPersona);
    }
    public void initGrup(String nomGrup){
        controlador.crearGrup(nomGrup);
    }
    public void initGrupAmbMembre(String nomGrup, String nomPersona) throws InterruptedException {
        System.out.println(controlador.crearGrup(nomGrup));
        System.out.println(controlador.getGrups());
        System.out.println(controlador.addMembreGrup(nomGrup, nomPersona));
    }
}
