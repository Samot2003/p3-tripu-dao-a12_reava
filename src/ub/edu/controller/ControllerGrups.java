package ub.edu.controller;

import ub.edu.model.TripUB;

import java.util.ArrayList;
import java.util.List;

public class ControllerGrups{

    GeneralDataController data;

    public ControllerGrups(){
        data = GeneralDataController.getInstance();
    }

    public String crearGrup (String nomGrup){
        try{
            data.tripUB().crearGrup(nomGrup);
            return "S'ha creat el grup correctament";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public List<String> getGrups(){
        return data.tripUB().getGrups();
    }

    public String addMembreGrup (String nomGrup, String nomPersona) {
        try{
            data.tripUB().addMembreGrup(nomGrup,nomPersona);
            return "S'ha agregat el membre satisfactoriament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String marxarGrup (String nomGrup, String nomPersona){
        try{
            data.tripUB().marxarGrup(nomGrup, nomPersona);
            return "S'ha eliminat al membre satisfactoriament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Iterable<String> getRankingGrup( String nomGrup){
        List<String> ret = new ArrayList<>();
        try{
            return data.tripUB().getRankingGrup(nomGrup);
        }catch (Exception e){
            ret.add(e.getMessage());
            return ret;
        }
    }

    public String actualitzarRankingGrup(String nomGrup){
        try{
            data.tripUB().actualitzarRankingGrup(nomGrup);
            return "Ranking actualitzat";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public void actualitzarRankings(){
        data.tripUB().actualitzarRankings();
    }
}
