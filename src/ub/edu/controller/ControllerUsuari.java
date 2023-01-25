package ub.edu.controller;

import ub.edu.model.TripUB;

public class ControllerUsuari {

    GeneralDataController data;

    public ControllerUsuari(){
        data = GeneralDataController.getInstance();
    }
    public String findPersona(String username) {
        boolean found = data.tripUB.getLogicaUsuari().findPersona(username);
        if (found) return "Persona ja existent en el Sistema";
        else return "Persona desconeguda";
    }

    public String validatePassword(String b) {
        try{
            data.tripUB.getLogicaUsuari().validatePassword(b);
            return "Contrassenya segura";
        }catch (Exception e){
            return e.getMessage();
        }
    }


    public String validateUsername(String b) {
        try{
            data.tripUB.getLogicaUsuari().validateUsername(b);
            return "Correu en format correcte";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String validateRegistrePersona(String username, String password) {
        try {
            data.tripUB.getLogicaUsuari().validateRegistrePersona(username,password);
            return "Registre vàlid";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String loguejarPersona(String username, String password){
        try{
            data.tripUB.getLogicaUsuari().loguejarPersona(username, password);
            return "Login correcte";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String recuperarContrassenya(String username){
        try{
            return data.tripUB.getLogicaUsuari().recuperarContrassenya(username);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String addPuntsToPersona(String nomPersona,int punts){
        try{
            data.tripUB.addPuntsToPersona(nomPersona,punts);
            return "Punts sumats correctament";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
