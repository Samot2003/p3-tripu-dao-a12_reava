package ub.edu.controller;

import ub.edu.model.*;

import ub.edu.resources.dao.Parell;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Controller {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades


    private XarxaPersones xarxaPersones;   // Model
    private Map<String, Ruta> rutaMap;
    private Map<String, Comarca> comarcaMap;

    private Map<String, Localitat> localitatMap;

    public Controller() {
        factory = new FactoryMOCK();
        dataService = new DataService(factory);

        try {
            initXarxaPersones();
            initRutesMap();
            initComarquesMap();
            initLocalitatMap();
            relacionarRutesComarques();
            relacionarRutesLocalitats();
        } catch (Exception e) {
        }

    }


    public boolean initXarxaPersones() throws Exception {
        List<Persona> l = dataService.getAllPersones();
        if (l != null) {
            xarxaPersones = new XarxaPersones(l);
            return true;
        } else return false;
    }

    public boolean initRutesMap() throws Exception {
        rutaMap =  (dataService.getAllRutes().stream()
                .collect(Collectors.toMap(Ruta::getNom, Function.identity())));
        if (rutaMap != null)
            return true;
        else return false;
    }

    private boolean initComarquesMap() throws Exception {
        comarcaMap =  (dataService.getAllComarques().stream()
                .collect(Collectors.toMap(Comarca::getNom, Function.identity())));
        if (comarcaMap != null)
            return true;
        else return false;
    }

    private boolean initLocalitatMap() throws Exception {
        localitatMap = (dataService.getAllLocalitats().stream()
                .collect(Collectors.toMap(Localitat::getNom, Function.identity())));
        if (localitatMap != null)
            return true;
        else return false;
    }

    private void relacionarRutesComarques() throws Exception {
        List<Parell<String, String>> relacionsRC = dataService.getAllRelacionsRutesComarques();
        for (Parell p : relacionsRC) {
            Ruta r = rutaMap.get(p.getElement2());
            Comarca c = comarcaMap.get(p.getElement1());
            r.addComarca(c);
        }
    }

    private void relacionarRutesLocalitats() throws Exception {
        List<Parell<String, String>> relacionsRL = dataService.getAllRelacionsRutesLocalitats();
        System.out.println(relacionsRL.toString());
        for (Parell p : relacionsRL) {
            Ruta r = rutaMap.get(p.getElement2());
            Localitat l = localitatMap.get(p.getElement1());
            r.addLocalitat(l);
        }
    }



    // Validem la Persona a la capa de persistencia i no a memoria, per seguretat en les possibles sincronitzacions
    public String validateRegisterPersona (String username, String password) {
        if  (dataService.getPersonaByUsername(username).isPresent() )
            return "Soci Duplicat";
        else if (isMail(username) && isPasswordSegur(password))
            return "Soci Validat";
        else return "Format incorrecte";
    }

    private List<Ruta> getRutaList(){
        return new ArrayList<>(rutaMap.values());
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

    public Iterable<String> llistarCatalegRutesPerNom() {
        SortedSet<String> excursionsDisponibles = new TreeSet<>();
        if (getRutaList().isEmpty()) {
            excursionsDisponibles.add("No hi ha excursions disponibles");
        } else {
            for (Ruta r : getRutaList()) {
                excursionsDisponibles.add(r.getNom());
            }
        }
        return excursionsDisponibles;
    }

    public Iterable<String> llistarCatalegRutesPerDurada(){
        List<Ruta> sortedList = getRutaList();
        sortedList.sort(new Comparator<Ruta>() {
            public int compare(Ruta a1, Ruta a2) {
                return (Integer.compare(a1.getDurada(), a2.getDurada()));
            }
        });

        List<String> excursionsDisponibles = new ArrayList<>();
        for (Ruta r : sortedList) {
            excursionsDisponibles.add(r.getNom());
        }

        return excursionsDisponibles;
    }

    public String findPersona(String username) {
        Persona persona = xarxaPersones.find(username);
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
            Persona persona = xarxaPersones.find(username);
            if (persona != null) {
                return "Persona duplicada";
            } else return "Registre vàlid";
        } else return "Format incorrecte";
    }

    public String loguejarPersona(String username, String password){
        Persona persona = xarxaPersones.find(username);
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
        Persona persona = xarxaPersones.find(username);
        if(persona == null){
            return "Correu inexistent";
        }
        return persona.getPwd();
    }

    public Iterable<String> cercaRutesPerComarca(String nomComarca){
        SortedSet<String> comarques = new TreeSet<>();

        if (comarcaMap.size() == 0){
            comarques.add("No hi han comarques enregistrades");
            return comarques;
        }

        Comarca comarca = comarcaMap.get(nomComarca);
        if (comarca == null)
            comarques.add("Comarca no trobada en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : rutaMap.values()){
                if (ruta.containsComarca(comarca)) {
                    comarques.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) comarques.add("No hi han rutes en aquesta comarca");
        }

        return comarques;
    }


    public Comarca afegirComarca(String nomComarca){
        Comarca comarca;
        if(comarcaMap.containsKey(nomComarca)){
            comarca = comarcaMap.get(nomComarca);
        }else{
            comarca = new Comarca(nomComarca);
            comarcaMap.put(nomComarca, comarca);
        }
        return comarca;
    }

    public Iterable<String> cercarRutesPerTempsDeDurada(int numDies){
        SortedSet<String> llista = new TreeSet<>();
        for(Ruta ruta: rutaMap.values()){
            if (ruta.getDurada() == numDies){
                llista.add(ruta.getNom());
            }
        }

        if (llista.isEmpty()){
            llista.add("No hi ha rutes amb aquest temps de durada");
        }

        return llista;

    }

    public Localitat afegirLocalitat(String nomLocalitat) {
        Localitat l;
        if(localitatMap.containsKey(nomLocalitat)){
            l = localitatMap.get(nomLocalitat);
        }else{
            l = new Localitat(nomLocalitat);
            localitatMap.put(nomLocalitat, l);
        }
        return l;
    }

    public Iterable<String>  cercaRutesPerLocalitat(String nomLocalitat) {
        SortedSet<String> localitats = new TreeSet<>();

        if (localitatMap.size() == 0){
            localitats.add("No hi ha localitats enregistrades");
            return localitats;
        }

        Localitat localitat = localitatMap.get(nomLocalitat);
        if (localitat == null)
            localitats.add("Localitat no trobada en el sistema");

        else {
            int ncount = 0;
            for (Ruta ruta : rutaMap.values()){
                if (ruta.containsLocalitat(localitat)) {
                    localitats.add(ruta.getNom());
                    ncount++;
                }
            }
            if (ncount == 0) localitats.add("No hi ha rutes en aquesta localitat");
        }

        return localitats;
    }
}