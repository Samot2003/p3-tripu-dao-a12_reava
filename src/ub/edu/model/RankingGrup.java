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
        for (int i=0; i<llista.size(); i++){
            ranking += (llista.get(i).getName()+" --> PUNTS: " +llista.get(i).getEstadistiques())+ "\n";

        }
    }

    public String a() {
        return ranking;
    }
}
