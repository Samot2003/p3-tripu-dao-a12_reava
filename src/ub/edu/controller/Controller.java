package ub.edu.controller;

import ub.edu.model.*;

import ub.edu.model.Facana.FacanaData;
import ub.edu.model.Facana.FacanaUser;
import ub.edu.model.Transport.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    //ControllerData es una classe que inicialitza i emagatzema les dades

    private TripUB tripUB;

    public Controller() {
        tripUB = new TripUB();
    }

    public String validateRegisterPersona (String username, String password) throws Exception {
        try {
            tripUB.validateRegisterPersona(username,password);
            return "Registre vàlid";
        }catch (Exception e) {
            return e.getMessage();
        }
    }
    public String findPersona(String username) {
        boolean found = tripUB.findPersona(username);
        if (found) return "Persona ja existent en el Sistema";
        else return "Persona desconeguda";
    }

    public String validatePassword(String b) {
        try{
            tripUB.validatePassword(b);
            return "Contrassenya segura";
        }catch (Exception e){
            return e.getMessage();
        }
    }


    public String validateUsername(String b) {
        try{
            tripUB.validateUsername(b);
            return "Correu en format correcte";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String validateRegistrePersona(String username, String password) {
        try {
            tripUB.validateRegistrePersona(username,password);
            return "Registre vàlid";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String loguejarPersona(String username, String password){
        try{
            tripUB.loguejarPersona(username, password);
            return "Login correcte";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String recuperarContrassenya(String username){
        try{
            return tripUB.recuperarContrassenya(username);
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public Iterable<String> llistarCatalegRutesPerNom() {
        List<String> r = new ArrayList<>();
         try{
            return tripUB.llistarCatalegRutesPerNom();
         }catch(Exception e){
             r.add(e.getMessage());
             return (Iterable)r;
         }
    }

    public Iterable<String> llistarCatalegRutesPerDurada(){
        List<String> r = new ArrayList<>();
        try{
            return tripUB.llistarCatalegRutesPerDurada();
        }catch (Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }

    public Iterable<String> cercaRutesPerComarca(String nomComarca){
        SortedSet<String> r = new TreeSet<>();
        try{
            return tripUB.cercaRutesPerComarca(nomComarca);
        }catch (Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }


    public Comarca afegirComarca(String nomComarca){
        return tripUB.afegirComarca(nomComarca);
    }

    public Iterable<String> cercarRutesPerTempsDeDurada(int numDies){
        SortedSet<String> r = new TreeSet<>();
        try{
            return tripUB.cercarRutesPerTempsDeDurada(numDies);
        }catch (Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }

    public Ruta afegirRuta(String nomRuta,String dataText, int numDies){
        return tripUB.afegirRuta(nomRuta, dataText, numDies);
    }

    public Localitat afegirLocalitat(String nomLocalitat) {
        return tripUB.afegirLocalitat(nomLocalitat);
    }

    public Iterable<String>  cercaRutesPerLocalitat(String nomLocalitat) {
        SortedSet<String> r = new TreeSet<>();
        try{
            return tripUB.cercaRutesPerLocalitat(nomLocalitat);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }

    public boolean afegirTransport(String nom, String id, float velocitat) {
        return tripUB.afegirTransport(nom,id,velocitat);
    }

    public Iterable<String>  cercaRutesPerTransport(String id) {
        SortedSet<String> r = new TreeSet<>();
        try{
            return tripUB.cercaRutesPerTransport(id);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }

    public String iniciarRuta(String nomPersona,String nomRuta){
        try{
            tripUB.iniciarRuta(nomPersona,nomRuta);
            return "Ruta inciada";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String acabarRuta(String nomPersona){
        try{
            tripUB.acabarRuta(nomPersona);
            return "Ruta actual finalitzada";
        }catch (Exception e){
            return e.getMessage();
        }
    }


    public String iniciarTrackRutaActual(String nomPersona,String tramID){
        try{
            tripUB.iniciarTrackRutaActual(nomPersona, tramID);
            return "Estat del tram canviat a EnProces";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String acabarTrackRutaActual(String nomPersona){
        try{
            tripUB.acabarTrackRutaActual(nomPersona);
            return "Tram Track finalitzat amb éxit";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String afegirPuntDeControl(String nomPersona, String highlight, Ubicacio ubi){
        try{
            tripUB.afegirPuntDeControl(nomPersona, highlight, ubi);
            return "Punt de Control Inicial establert correctament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String crearGrup (String nomGrup){
        try{
            tripUB.crearGrup(nomGrup);
            return "S'ha creat el grup correctament";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public String addMembreGrup (String nomGrup, String nomPersona) {
        try{
            tripUB.addMembreGrup(nomGrup,nomPersona);
            return "S'ha agregat el membre satisfactoriament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String marxarGrup (String nomGrup, String nomPersona){
        try{
            tripUB.marxarGrup(nomGrup, nomPersona);
            return "S'ha eliminat al membre satisfactoriament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Iterable<String> getRankingGrup( String nomGrup){
        List<String> ret = new ArrayList<>();
        try{
            return tripUB.getRankingGrup(nomGrup);
        }catch (Exception e){
            ret.add(e.getMessage());
            return ret;
        }
    }

    public String addPuntsToPersona(String nom, int punts){
        try{
            tripUB.addPuntsToPersona(nom,punts);
            return "Punts sumats correctament";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public String actualitzarRankingGrup(String nomGrup){
        try{
            tripUB.actualitzarRankingGrup(nomGrup);
            return "Ranking actualitzat";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public void actualitzarRankings(){
        tripUB.actualitzarRankings();
    }

    public String valorarPuntsDePasRutaActual( String nomPersona, int estrelles, boolean like){
        try{
            tripUB.valorarPuntsDePasRutaActual(nomPersona, estrelles,like);
            return "Punts de control valorats correctament";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public Iterable<String> llistarPuntsDePasRuta(String nomRuta){
        List<String> r = new ArrayList<>();
        try{
            return tripUB.llistarPuntsDePasRuta(nomRuta);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }
}