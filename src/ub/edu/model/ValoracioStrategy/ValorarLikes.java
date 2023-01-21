package ub.edu.model.ValoracioStrategy;

import java.util.ArrayList;

public class ValorarLikes implements ValorarStrategy{
    public Object valorar(int e) throws Exception {
        if (e == 1 ) {
            return new Like(e);
        } else if (e == -1) {
            return new Dislike(e);
        }
        throw new Exception("La valoracio de likes ha de ser 1 (Like) o -1 (Dislike)");

    }

}

