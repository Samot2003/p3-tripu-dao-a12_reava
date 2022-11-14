package ub.edu.model;

import java.util.ArrayList;
import java.util.List;

public class Grup {

    private  List<Persona> llistaGrup;

    private RankingGrup rankingGrup;

    private String nomGrup;

    public Grup(String nomGrup){
        this.nomGrup = nomGrup;
        llistaGrup = new ArrayList<>();
        rankingGrup = new RankingGrup();
    }
    public void setNomGrup(String nomGrup){
        this.nomGrup=  nomGrup;
    }
    public String getNomGrup() {return nomGrup;}

    public void addGrup(Persona nouMembre){

        llistaGrup.add(nouMembre);
        actualitzarRanking();
    }
    public void actualitzarRanking(){
        rankingGrup.actualitzarRankingGrup(llistaGrup);
    }

    public Iterable<String> getRanking(){ return rankingGrup.prova(llistaGrup);}

    public void marxarGrup(Persona p){

        llistaGrup.remove(p);
        actualitzarRanking();
    }

    public Persona getPersona (String username) {

        for (Persona c: llistaGrup) {
            if (c.getName().equals(username)) return c;
        }
        return null;

    }

}
