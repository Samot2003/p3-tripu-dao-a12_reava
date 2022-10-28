package ub.edu.MOCKmain;

import ub.edu.controller.Controller;



public class MainMOCK {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.afegirLocalitat("Barcelonès");
        System.out.println(c.cercaRutesPerLocalitat("Ripoll"));
        System.out.println(c.cercaRutesPerLocalitat("Barcelona"));
        System.out.println(c.cercaRutesPerComarca("Cerdanya"));

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
