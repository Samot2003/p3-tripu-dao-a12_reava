package ub.edu.resources.dao.MOCK;

import ub.edu.resources.dao.DAORelacioLocalitatRuta;
import ub.edu.resources.dao.Parell;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAORelacioLocalitatRutaMOCK implements DAORelacioLocalitatRuta {

    List<Parell<String, String> > relacions = new ArrayList<>();

    public DAORelacioLocalitatRutaMOCK() {
        afegirLocalitatInicialRuta("Puigcerdà","De la Cerdanya fins al Mar");
        afegirLocalitatInicialRuta("Llivia","De la Cerdanya fins al Mar");
        afegirLocalitatInicialRuta("Ripoll","De la Cerdanya fins al Mar");

        afegirLocalitatInicialRuta("Girona","Ribera del Ter");
        afegirLocalitatInicialRuta("Ripoll","Ribera del Ter");

        afegirLocalitatInicialRuta("Cadaqués","La Costa Brava");
        afegirLocalitatInicialRuta("Ampuriabrava","La Costa Brava");
        afegirLocalitatInicialRuta("Palamós","La Costa Brava");




    }

    private boolean afegirLocalitatInicialRuta(String nomLocalitat, String nomRuta){
        return relacions.add(new Parell<>(nomLocalitat, nomRuta));
    }




    @Override
    public Optional<Parell<String, String>> getById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Parell<String, String>> getAll() throws Exception {
        return relacions;
    }

    @Override
    public boolean add(Parell<String, String> stringStringParell) throws Exception {
        if (relacions.contains(stringStringParell)) {
            return false;
        } else {
            relacions.add(stringStringParell);
            return true;
        }
    }

    @Override
    public boolean update(Parell<String, String> stringStringParell, String[] params) throws Exception {
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

    public List<String> getLocalitatsByRuta(String idRuta) throws Exception {
        List<String> comarques = new ArrayList<>();
        for (Parell<String, String> parell : relacions) {
            if (parell.getElement2().equals(idRuta)) {
                comarques.add(parell.getElement1());
            }
        }
        return comarques;
    }

    public List<String> getRutesByLocalitat(String idComarca) throws Exception {
        List<String> rutes = new ArrayList<>();
        for (Parell<String, String> parell : relacions) {
            if (parell.getElement1().equals(idComarca)) {
                rutes.add(parell.getElement2());
            }
        }
        return rutes;
    }
}
