package ub.edu.model;

import java.util.List;

public class XarxaPersones {
    private List<Persona> llista;

    public XarxaPersones(List<Persona> allSocis) {
        llista = allSocis;
    }

    public Persona find(String username) {

        for (Persona c: llista) {
            if (c.getName().equals(username)) return c;
        }
        return null;

    }

}
