package ub.edu.resources.service;

import ub.edu.model.*;
import ub.edu.resources.dao.*;

import java.util.List;
import java.util.Optional;

public class DataService {
    private DAORuta daoRuta;
    private DAOPersona daoPersona;
    private DAOComarca daoComarca;
    private DAORelacioComarcaRuta daoRelacioRutaComarca;

    private DAOLocalitat daoLocalitat;

    private DAORelacioLocalitatRuta daoRelacioLocalitatRuta;


    public DataService(AbstractFactoryData factory) {

        this.daoPersona = factory.createDAOPersona();
        this.daoRuta = factory.createDAORuta();
        this.daoComarca = factory.createDAOComarca();
        this.daoLocalitat = factory.createDAOLocalitat();
        this.daoRelacioRutaComarca = factory.createDAORelacioRutaComarca();
        this.daoRelacioLocalitatRuta = factory.createDAORelacioRutaLocalitat();
        // TO DO: Crear els altres DAO de les altres estructures
    }


    public Optional<Persona> getPersonaByUsername(String usuari) {
        try {
            return daoPersona.getById(usuari);
        } catch (Exception e) {
            //TODO
        }
        return null;
    }

    public List<Persona> getAllPersones() throws Exception {
        return daoPersona.getAll();
    }

    public List<Ruta> getAllRutes() throws Exception {
        return daoRuta.getAll();
    }

    public List<Comarca> getAllComarques() throws Exception{
        return daoComarca.getAll();
    }

    public List<Localitat> getAllLocalitats() throws Exception{
        return daoLocalitat.getAll();
    }

    public Optional<Parell<String, String>> getComarquesRuta(String nom) throws Exception {
        return daoRelacioRutaComarca.getById(nom);
    }
    public List<Parell<String, String>> getAllRelacionsRutesComarques() throws Exception{
        return daoRelacioRutaComarca.getAll();
    }

    public List<Parell<String, String>> getAllRelacionsRutesLocalitats() throws Exception{
        return daoRelacioLocalitatRuta.getAll();
    }

}