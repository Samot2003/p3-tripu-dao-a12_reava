package ub.edu.controller;

import ub.edu.model.Comarca;
import ub.edu.model.Localitat;
import ub.edu.model.Ruta;
import ub.edu.model.TripUB;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ControllerRuta {


    GeneralDataController data;
    public ControllerRuta(){
        data = GeneralDataController.getInstance();
    }

    public Iterable<String> llistarCatalegRutesPerNom() {
        List<String> r = new ArrayList<>();
        try{
            return data.tripUB().llistarCatalegRutesPerNom();
        }catch(Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }

    public Iterable<String> llistarCatalegRutesPerDurada(){
        List<String> r = new ArrayList<>();
        try{
            return data.tripUB().llistarCatalegRutesPerDurada();
        }catch (Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }

    public Iterable<String> cercaRutesPerComarca(String nomComarca){
        SortedSet<String> r = new TreeSet<>();
        try{
            return data.tripUB().cercaRutesPerComarca(nomComarca);
        }catch (Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }


    public Comarca afegirComarca(String nomComarca){
        return data.tripUB().afegirComarca(nomComarca);
    }

    public Iterable<String> cercarRutesPerTempsDeDurada(int numDies){
        SortedSet<String> r = new TreeSet<>();
        try{
            return data.tripUB().cercarRutesPerTempsDeDurada(numDies);
        }catch (Exception e){
            r.add(e.getMessage());
            return (Iterable)r;
        }
    }

    public Ruta afegirRuta(String nomRuta, String dataText, int numDies){
        return data.tripUB().afegirRuta(nomRuta, dataText, numDies);
    }

    public Localitat afegirLocalitat(String nomLocalitat) {
        return data.tripUB().afegirLocalitat(nomLocalitat);
    }

    public Iterable<String>  cercaRutesPerLocalitat(String nomLocalitat) {
        SortedSet<String> r = new TreeSet<>();
        try{
            return data.tripUB().cercaRutesPerLocalitat(nomLocalitat);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }

    public boolean afegirTransport(String nom, String id, float velocitat) {
        return data.tripUB().afegirTransport(nom,id,velocitat);
    }

    public Iterable<String>  cercaRutesPerTransport(String id) {
        SortedSet<String> r = new TreeSet<>();
        try{
            return data.tripUB().cercaRutesPerTransport(id);
        }catch (Exception e){
            r.add(e.getMessage());
            return r;
        }
    }
    public String iniciarRuta(String nomRuta){
        try{
            data.tripUB().iniciarRuta(data.nomPersona(),nomRuta);
            return "Ruta inciada";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String acabarRuta(){
        try{
            data.tripUB().acabarRuta(data.nomPersona());
            return "Ruta actual finalitzada";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String iniciarTrackRutaActual(String tramID){
        try{
            data.tripUB().iniciarTrackRutaActual(data.nomPersona(), tramID);
            return "Estat del tram canviat a EnProces";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String acabarTrackRutaActual(){
        try{
            data.tripUB().acabarTrackRutaActual(data.nomPersona());
            return "Tram Track finalitzat amb éxit";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
