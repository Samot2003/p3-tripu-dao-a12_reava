package ub.edu.spec.llistarPuntsDePasPerValoracio;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.Ubicacio;

@RunWith(ConcordionRunner.class)
public class llistarPuntsDePasPerValoracio {

    private Controller controlador;


    @BeforeExample
    private void init() {
        controlador = Controller.getInstance();
        controlador.iniciarRuta("Terres de l'Ebre");
    }

    public Iterable<String> llistarPuntsDePasValoracio () {
         //return controlador.llistarPuntsDePasRutaActual(p);
        return null;
    }


    public void initAll(){
/*
        controlador.iniciarTrackRutaActual(p,"T1");
        controlador.afegirPuntDeControl(p, "a1", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 3, true);
        controlador.acabarTrackRutaActual(p);

        controlador.iniciarTrackRutaActual(p,"T2");
        controlador.afegirPuntDeControl(p, "b2", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 5, false);
        controlador.acabarTrackRutaActual(p);

        controlador.iniciarTrackRutaActual(p,"T3");
        controlador.afegirPuntDeControl(p, "c3", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 2, false);
        controlador.acabarTrackRutaActual(p);

        controlador.iniciarTrackRutaActual(p,"T4");
        controlador.afegirPuntDeControl(p, "d4", new Ubicacio(5,5,5));
        controlador.valorarPuntDePasTrackActual(p, 4, true);
        controlador.acabarTrackRutaActual(p);

 */
    }

}
