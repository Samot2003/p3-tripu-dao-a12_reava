package ub.edu.MOCKmain;

import ub.edu.controller.Controller;
import ub.edu.model.Estat.EnProces;
import ub.edu.model.Estat.Estat;
import ub.edu.model.Transport.Transport;


public class MainMOCK {
    public static void main(String[] args) {

        Controller c = new Controller();
        System.out.println(c.getEstatRuta("De la Cerdanya fins al Mar"));
        System.out.println(c.cambiarEstatRuta("De la Cerdanya fins al Mar","EnProces"));
        System.out.println(c.cambiarEstatRuta("De la Cerdanya fins al Mar","EnProces"));
        System.out.println(c.cambiarEstatRuta("De la Cerdanya fins al Mar","Acabat"));
        System.out.println(c.cambiarEstatRuta("De la Cerdanyadawdns aal Mar","EnProces"));
        System.out.println(c.cambiarEstatRuta("Terres de l'Ebre", "NoComencat"));
        System.out.println(c.cambiarEstatRuta("Terres de l'Ebre", "NoComencat"));

    }
}
/*

    public Iterable<String> cercaRutesPerComarques(String nomComarca) {
        return controlador.cercaRutesPerComarca(nomComarca);
    }

    public void afegirComarques() {
        controlador.afegirComarca("Barcelonès");

    }
 */
