package ub.edu.model.Facana;

import ub.edu.model.Persona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacanaUser {

    private FacanaData data;

    public FacanaUser() {
        data = new FacanaData();
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

    public boolean findPersona(String username) {
        Persona persona = data.getXarxaPersones().find(username);
        if (persona != null) return true;
        else return false;
    }


    public void validatePassword(String b) throws Exception {
        if (!isPasswordSegur(b)) {
            throw new Exception("Contrassenya no prou segura");
        }
    }


    public void validateUsername(String b) throws Exception {
        if (!isMail(b))
            throw new Exception("Correu en format incorrecte");
    }

    public void validateRegistrePersona(String username, String password) throws Exception {
        if (isMail(username) && isPasswordSegur(password)) {
            Persona persona = data.getXarxaPersones().find(username);
            if (persona != null) {
                throw new Exception("Persona duplicada");
            }
        } else throw new Exception("Format incorrecte");
    }

    public void loguejarPersona(String username, String password) throws Exception {
        Persona persona = data.getXarxaPersones().find(username);
        if (persona == null) {
            throw new Exception("Correu inexistent");
        }
        if (!persona.getPwd().equals(password)) {
            throw new Exception("Contrassenya incorrecta");
        }
    }

    public String recuperarContrassenya(String username) throws Exception {
        Persona persona = data.getXarxaPersones().find(username);
        if (persona == null) {
            throw new Exception("Correu inexistent");
        }
        return persona.getPwd();
    }
}
