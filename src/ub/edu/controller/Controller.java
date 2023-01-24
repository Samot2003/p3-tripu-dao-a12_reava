package ub.edu.controller;

import ub.edu.model.*;

import ub.edu.model.ValoracioStrategy.ValorarStrategy;

import java.util.*;


public class Controller {

    //ControllerData es una classe que inicialitza i emagatzema les dades
    private volatile static Controller uniqueIstance;
    private final TripUB tripUB;

    String nomPersona;

    private Controller() {
        tripUB = TripUB.getInstance();
        nomPersona = "ajaleo@gmail.com";
    }

    public static Controller getInstance(){
        if (uniqueIstance == null){
            synchronized (Controller.class){
                if (uniqueIstance == null){
                    uniqueIstance = new Controller();
                }
            }
        }
        return uniqueIstance;
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

    public String iniciarRuta(String nomRuta){
        try{
            tripUB.iniciarRuta(nomPersona,nomRuta);
            return "Ruta inciada";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String acabarRuta(){
        try{
            tripUB.acabarRuta(nomPersona);
            return "Ruta actual finalitzada";
        }catch (Exception e){
            return e.getMessage();
        }
    }


    public String iniciarTrackRutaActual(String tramID){
        try{
            tripUB.iniciarTrackRutaActual(nomPersona, tramID);
            return "Estat del tram canviat a EnProces";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String acabarTrackRutaActual(){
        try{
            tripUB.acabarTrackRutaActual(nomPersona);
            return "Tram Track finalitzat amb éxit";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String afegirPuntDeControl(PuntDeControl p){
        try{
            tripUB.afegirPuntDeControl(nomPersona, p);
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

    public List<String> getGrups(){
        return tripUB.getGrups();
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

    public String addPuntsToPersona(String nomPersona,int punts){
        try{
            tripUB.addPuntsToPersona(nomPersona,punts);
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

    public String valorarPuntDePasTrackActual(String ID, ValorarStrategy str, int valoracio){
        try{
            tripUB.valorarPuntsDePas(ID,str, valoracio, nomPersona);
            return "Punts de control valorats correctament";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Iterable<String> llistarPuntsDePasRutaActual(ValorarStrategy str){
        List<String> r = new ArrayList<>();
        try{
            return tripUB.llistarPuntsDePasRutaActual(str);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }
}