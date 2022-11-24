package ub.edu.model.Facana;

import ub.edu.model.*;
import ub.edu.model.Transport.*;
import ub.edu.resources.dao.Parell;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FacanaData {

    private Map<String, Ruta> rutaMap;
    private Map<String, Comarca> comarcaMap;
    private Map<String, Localitat> localitatMap;
    private Map<String, Transport> transportMap;
    private AbstractFactoryData factory;
    private DataService data;

    private Ruta rutaActual;

    private XarxaPersones xarxaPersones;

    private List<Grup> llistaGrup;

    public FacanaData() {
        factory = new FactoryMOCK();
        data = new DataService(factory);
        rutaMap = new HashMap<>();
        comarcaMap = new HashMap<>();
        localitatMap = new HashMap<>();
        transportMap = new HashMap<>();
        llistaGrup = new ArrayList<>();
        rutaActual = null;
        initData();

    }

    public void initData(){
            initRutaMap();
            initComarcaMap();
            initLocalitatMap();
            initTransportMap();
            initXarxaPersones();
            relacionarRutesComarques();
            relacionarRutesLocalitats();
            relacionarRutesTransports();
    }

    public DataService getDataService(){
        return data;
    }

    public boolean initRutaMap(){
        try{
            rutaMap = (data.getAllRutes().stream()
                .collect(Collectors.toMap(Ruta::getNom, Function.identity())));
            if (rutaMap != null)
                return true;
            else return false;

        }catch(Exception e){
            System.out.println("initRutaMap ERROR");
            return false;
        }
    }
    public Map<String,Ruta> getRutaMap(){
        return rutaMap;
    }

    public List<Ruta> getRutaList(){
        return new ArrayList<>(rutaMap.values());
    }

    public Ruta afegirRuta(String nomRuta,String dataText, int numDies){
        Ruta r;
        if(rutaMap.containsKey(nomRuta)){
            r = rutaMap.get(nomRuta);
        }else{
            r = new Ruta(nomRuta, dataText, numDies);
            rutaMap.put(nomRuta, r);
        }
        return r;
    }

    private boolean initComarcaMap(){
        try{
            comarcaMap =  (data.getAllComarques().stream()
                    .collect(Collectors.toMap(Comarca::getNom, Function.identity())));
            if (comarcaMap != null)
                return true;
            else return false;
        }catch(Exception e){
            System.out.println("initComarcaMap ERROR");
            return false;
        }

    }

    public Map<String,Comarca> getComarcaMap(){
        return comarcaMap;
    }

    private boolean initLocalitatMap(){
        try{
            localitatMap = (data.getAllLocalitats().stream()
                    .collect(Collectors.toMap(Localitat::getNom, Function.identity())));
            if (localitatMap != null)
                return true;
            else return false;
        }catch(Exception e){
            System.out.println("initLocalitatMap ERROR");
            return false;
        }
    }
    public Map<String,Localitat> getLocalitatMap(){
        return localitatMap;
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

    public boolean initXarxaPersones() {
        try {
            List<Persona> l = data.getAllPersones();
            if (l != null) {
                xarxaPersones = new XarxaPersones(l);
                return true;
            } else return false;
        } catch (Exception e) {
            System.out.println("initxarxaPers ERROR");
            return false;
        }
    }


    public XarxaPersones getXarxaPersones(){return xarxaPersones;}

    private boolean initTransportMap() {
        try {
            transportMap = (data.getAllTransports().stream()
                    .collect(Collectors.toMap(Transport::getId, Function.identity())));
            if (localitatMap != null)
                return true;
            else return false;
        } catch (Exception e) {
            System.out.println("initTransportMap ERROR");
            return false;
        }
    }


    public Map<String,Transport> getTransportMap(){
        return transportMap;
    }

    public boolean afegirTransport(String nom, String id, float velocitat) {
        Transport t;
        if(transportMap.containsKey(id)){
            t = transportMap.get(id);
        }else if (nom == "Bici"){
            t = new Bici(id, velocitat);
            transportMap.put(id, t);
        }else if (nom == "Cotxe") {
            t = new Cotxe(id, velocitat);
            transportMap.put(id, t);
        }else if (nom == "APeu") {
            t = new APeu(id, velocitat);
            transportMap.put(id, t);
        }else{
            return false;
        }
        return true;
    }

    public List<Grup> getLlistaGrups(){
        return llistaGrup;
    }

    public void addGrupLlista(Grup grup){
        llistaGrup.add(grup);
    }
    private void relacionarRutesComarques(){
        try{
            List<Parell<String, String>> relacionsRC = data.getAllRelacionsRutesComarques();
            for (Parell p : relacionsRC) {
                Ruta r = rutaMap.get(p.getElement2());
                Comarca c = comarcaMap.get(p.getElement1());
                r.addComarca(c);
            }
        }catch(Exception e){
            System.out.println("initRelRuCo ERROR");
        }

    }

    private void relacionarRutesLocalitats() {
        try{
            List<Parell<String, String>> relacionsRL = data.getAllRelacionsRutesLocalitats();
            for (Parell p : relacionsRL) {
                Ruta r = rutaMap.get(p.getElement2());
                Localitat l = localitatMap.get(p.getElement1());
                r.addLocalitat(l);
            }
        }catch(Exception e){
            System.out.println("initRuLo ERROR");
        }

    }
    private void relacionarRutesTransports() {
        try{
            List<Parell<String, String>> relacionsRT = data.getAllRelacionsRutesTransports();
            for (Parell p : relacionsRT) {
                Ruta r = rutaMap.get(p.getElement2());
                Transport t = transportMap.get(p.getElement1());
                r.addTransport(t);
            }
        }catch(Exception e){
            System.out.println("initRuTra ERROR");
        }
    }

    public void setRutaActual(Ruta r){
        rutaActual = r;
    }

    public Ruta getRutaActual(){
        return rutaActual;
    }
}
