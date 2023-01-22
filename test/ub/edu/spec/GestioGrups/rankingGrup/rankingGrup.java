package ub.edu.spec.GestioGrups.rankingGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class rankingGrup {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
        initGrupsiMembres();
    }

    public Iterable<String> getRankingGrup(String nomGrup) {
        return controlador.getRankingGrup(nomGrup);
    }

    public void initGrupsiMembres(){
        controlador.crearGrup("G1");
        controlador.crearGrup("G2");
        controlador.addMembreGrup("G1","ajaleo@gmail.com");
        controlador.addPuntsToPersona("ajaleo@gmail.com", 6);
        controlador.addMembreGrup("G1","heisenberg@gmail.com");
        controlador.addPuntsToPersona("heisenberg@gmail.com", 43);
        controlador.addMembreGrup("G1","dtomacal@yahoo.cat");
        controlador.addPuntsToPersona("dtomacal@yahoo.cat", 22);

    }

}
