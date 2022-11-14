package ub.edu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public Iterable<String> prova(List<Persona> llista){
        if (llista.isEmpty()){
            return (Iterable)llista;
        }
        List<Persona> sortedList = llista;
        sortedList.sort(new Comparator<Persona>() {

            public int compare(Persona a1, Persona a2) {
                return (Integer.compare(a2.getEstadistiques(), a1.getEstadistiques()));
            }
        });
        List<String> ranking = new ArrayList<>();
        for (Persona p: sortedList){
            ranking.add("NOM: " + p.getName() + " PUNTS: " + p.getEstadistiques());
        }
        return ranking;
    }

    public String mostrarRanking() {
        return ranking;
    }
}
