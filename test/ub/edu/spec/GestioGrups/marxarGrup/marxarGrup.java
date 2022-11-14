package ub.edu.spec.GestioGrups.marxarGrup;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class marxarGrup {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String marxarGrup (String nomGrup, String nomPersona){
        return controlador.marxarGrup(nomGrup,nomPersona);
    }
    public void initGrup(){
        controlador.crearGrup("Grup1");
    }
    public void initGrupAmbMembre(){

        controlador.crearGrup("Grup1");
        controlador.addMembreGrup("Grup1","ajaleo@gmail.com");
    }
}
