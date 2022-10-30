package ub.edu.resources.dao.MOCK;

import ub.edu.model.Localitat;
import ub.edu.model.Transport.*;
import ub.edu.resources.dao.DAOTransport;

import java.util.*;

public class DAOTransportMOCK implements DAOTransport {

    private Map<String, Transport> llistaTransports= new HashMap<>();

    public DAOTransportMOCK() {
        //BICI
        addTransport("Bici","b1",15);
        addTransport("Bici","b2",12);
        addTransport("Bici","b3",20);
        //COTXE
        addTransport("Cotxe","c1",70);
        addTransport("Cotxe","c2",60);
        //A PEU
        addTransport("APeu","p",5);

    }

    public boolean addTransport(String nom, String id, float velocitat){
        if (nom.equals("Bici")){
            llistaTransports.put(nom, new Bici(id, velocitat));
            return true;
        }else if (nom.equals("Cotxe")){
            llistaTransports.put(nom, new Cotxe(id, velocitat));
            return true;
        }else if(nom.equals("APeu")){
            llistaTransports.put(nom, new APeu(id, velocitat));
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Optional<Transport> getById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Transport> getAll() throws Exception {
        return new ArrayList<>(llistaTransports.values());
    }

    @Override
    public boolean add(Transport t) throws Exception {
        if (getById(t.getId()).isPresent()) {
            return false;
        }
        llistaTransports.put(t.getId(), t);
        return true;
    }

    @Override
    public boolean update(Transport transport, String[] params) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Transport t) throws Exception {
        return llistaTransports.remove(t.getId()) != null;
    }
}
