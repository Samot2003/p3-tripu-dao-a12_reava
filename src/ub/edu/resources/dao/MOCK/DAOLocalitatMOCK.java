package ub.edu.resources.dao.MOCK;

import ub.edu.model.Comarca;
import ub.edu.model.Localitat;
import ub.edu.resources.dao.DAOLocalitat;

import java.util.*;

public class DAOLocalitatMOCK implements DAOLocalitat {

    private Map<String, Localitat> llistaLocalitats = new HashMap<>();

    public DAOLocalitatMOCK(){
        addLocalitat("Puigcerdà");//Cerdanya
        addLocalitat("Llivia");//Cerdanya
        addLocalitat("Girona");//Gironès
        addLocalitat("Ripoll");//Ripollès
        addLocalitat("Cadaqués");//Alt Empordà
        addLocalitat("Ampuriabrava");//Alt Empordà
        addLocalitat("Palamós");//Baix Empordà
    }

    private void addLocalitat(String nom){
        llistaLocalitats.put(nom, new Localitat(nom));
    }

    public boolean add(Localitat l){
        if (getById(l.getNom()).isPresent()) {
            return false;
        }
        llistaLocalitats.put(l.getNom(), l);
        return true;
    }

    public boolean update(final Localitat localitat, String[] params) {
        localitat.setNom(Objects.requireNonNull(
                params[0], "Title cannot be null"));
        return llistaLocalitats.replace(localitat.getNom(), localitat) != null;
    }


    public List<Localitat> getAll() {
        return new ArrayList<>(llistaLocalitats.values());
    }

    public Optional<Localitat> getById(String id) {
        return Optional.ofNullable(llistaLocalitats.get(id));
    }

    public boolean delete(final Localitat l) {
        return llistaLocalitats.remove(l.getNom()) != null;
    }

}
