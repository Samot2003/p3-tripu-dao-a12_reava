package ub.edu.resources.dao.MOCK;

import ub.edu.resources.dao.DAORelacioComarcaRuta;
import ub.edu.resources.dao.DAORelacioTransportRuta;
import ub.edu.resources.dao.Parell;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAORelacioTransportRutaMOCK implements DAORelacioTransportRuta {

    // el primer element del parell és la comarca i el segon, la ruta

    List<Parell<String, String> > relacions = new ArrayList<>();

    public DAORelacioTransportRutaMOCK() {
        
        afegirTransportRuta("b1","La Costa Brava");
        afegirTransportRuta("b1","Ribera del Ter");
        afegirTransportRuta("b2","Ribera del Ter");
        
        afegirTransportRuta("c1","De la Cerdanya fins al Mar");
        afegirTransportRuta("c2","Terres de l'Ebre");
        afegirTransportRuta("c2","De la Cerdanya fins al Mar");
        
        afegirTransportRuta("p","La Costa Brava");
        afegirTransportRuta("p","Ribera del Ter");
        afegirTransportRuta("p","Terres de l'Ebre");
        
    }

    private boolean afegirTransportRuta(String idTransport, String nomRuta){
        return relacions.add(new Parell<>(idTransport, nomRuta));
    }

    @Override
    public Optional<Parell<String, String>> getById(String id) throws Exception {
        // Mètode que no té gaire sentit en aquesta classe
        return Optional.empty();
    }

    @Override
    public List<Parell<String, String>> getAll() throws Exception {
        return relacions;
    }

    @Override
    public boolean add(Parell<String, String> stringStringParell)  {
        if (relacions.contains(stringStringParell)) {
            return false;
        } else {
            relacions.add(stringStringParell);
            return true;
        }
    }

    @Override
    public boolean update(Parell<String, String> stringStringParell, String[] params) {
        // Mètode que no té gaire sentit en aquesta classe
        return false;
    }

    @Override
    public boolean delete(Parell<String, String> parell) throws Exception {
        if (relacions.contains(parell)) {
            relacions.remove(parell);
            return true;
        } else {
            return false;
        }
    }

    public List<String> getTransportsByRuta(String idRuta) throws Exception {
        List<String> transports = new ArrayList<>();
        for (Parell<String, String> parell : relacions) {
            if (parell.getElement2().equals(idRuta)) {
                transports.add(parell.getElement1());
            }
        }
        return transports;
    }

    public List<String> getRutesByTransport(String idTransport) throws Exception {
        List<String> rutes = new ArrayList<>();
        for (Parell<String, String> parell : relacions) {
            if (parell.getElement1().equals(idTransport)) {
                rutes.add(parell.getElement2());
            }
        }
        return rutes;
    }
}

