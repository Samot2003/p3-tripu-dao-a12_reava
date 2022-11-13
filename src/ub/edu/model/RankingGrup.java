package ub.edu.model;

import java.util.Collections;
import java.util.List;

public class RankingGrup {

    private  String ranking;

    public RankingGrup(){
        ranking = "";
    }

    public void actualitzarRankingGrup( List<Persona> llista){
        ranking = "";
        for (Persona persona : llista) {
            ranking += (persona.getName() + " --> PUNTS: " + persona.getEstadistiques()) + "\n";

        }
    }

    public String mostrarRanking() {
        return ranking;
    }
}
