package ub.edu.model.ValoracioStrategy;

public class ValorarEstrelles implements ValorarStrategy{

    public Estrelles valorar (int e) throws Exception {
        if (e < 5 || e > 0) {
            return new Estrelles(e);
        }
        throw new Exception("La valoracio d'estrelles ha de ser un numero entre 0 i 5");
    }
}
