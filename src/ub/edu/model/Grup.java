package ub.edu.model;

import java.util.ArrayList;
import java.util.List;

public class Grup {

    private  List<Persona> llistaGrup;

    private RankingGrup rankingGrup;

    public Grup(){
        llistaGrup = new ArrayList<>();
        rankingGrup = new RankingGrup();
    }
    public void addGrup(Persona nouMembre){
        llistaGrup.add(nouMembre);
        actualitzarRanking();
    }
    public void actualitzarRanking(){
        rankingGrup.actualitzarRankingGrup(llistaGrup);
    }

    public String getRanking(){ return rankingGrup.a();}

    public void marxarGrup(Persona p){
        llistaGrup.remove(p);
        actualitzarRanking();

    }

}
