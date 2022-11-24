package ub.edu.model.Facana;

import ub.edu.model.Persona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacanaUser {

    private FacanaData data;

    public FacanaUser() {
        data = new FacanaData();
    }

    public String validateRegisterPersona (String username, String password) {
        if  (data.getDataService().getPersonaByUsername(username).isPresent() )
            return "Soci Duplicat";
        else if (isMail(username) && isPasswordSegur(password))
            return "Soci Validat";
        else return "Format incorrecte";
    }

    public boolean isPasswordSegur(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean isMail(String correu) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }

    public String findPersona(String username) {
        Persona persona = data.getXarxaPersones().find(username);
        if (persona!=null) return "Persona ja existent en el Sistema";
        else return "Persona desconeguda";
    }


    public String validatePassword(String b) {
        if (!isPasswordSegur(b)) {
            return "Contrassenya no prou segura";
        } else
            return "Contrassenya segura";
    }


    public String validateUsername(String b) {
        if (!isMail(b))
            return "Correu en format incorrecte";
        else
            return "Correu en format correcte";
    }

    public String validateRegistrePersona(String username, String password) {
        if (isMail(username) && isPasswordSegur(password)) {
            Persona persona = data.getXarxaPersones().find(username);
            if (persona != null) {
                return "Persona duplicada";
            } else return "Registre vàlid";
        } else return "Format incorrecte";
    }

    public String loguejarPersona(String username, String password){
        Persona persona = data.getXarxaPersones().find(username);
        if(persona == null){
            return "Correu inexistent";
        }
        if(persona.getPwd().equals(password)){
            return "Login correcte";
        }else{
            return "Contrassenya incorrecta";
        }
    }

    public String recuperarContrassenya(String username){
        Persona persona = data.getXarxaPersones().find(username);
        if(persona == null){
            return "Correu inexistent";
        }
        return persona.getPwd();
    }
}
