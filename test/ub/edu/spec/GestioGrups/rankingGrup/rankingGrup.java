package ub.edu.spec.GestioGrups.rankingGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class rankingGrup {
    final private Controller controlador= Controller.getInstance();

    @BeforeExample
    private void init() {
        controlador.getControllerGrups().crearGrup("G1");
        controlador.getControllerGrups().crearGrup("G2");

    }

    public Iterable<String> getRankingGrup(String nomGrup) {
        return controlador.getControllerGrups().getRankingGrup(nomGrup);
    }

    public void initGrupsiMembres(){
        controlador.getControllerGrups().addMembreGrup("G1","ajaleo@gmail.com");
        controlador.getControllerUsuari().addPuntsToPersona("ajaleo@gmail.com", 6);
        controlador.getControllerGrups().addMembreGrup("G1","heisenberg@gmail.com");
        controlador.getControllerUsuari().addPuntsToPersona("heisenberg@gmail.com", 43);
        controlador.getControllerGrups().addMembreGrup("G1","dtomacal@yahoo.cat");
        controlador.getControllerUsuari().addPuntsToPersona("dtomacal@yahoo.cat", 22);
    }

}
