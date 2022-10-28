package ub.edu.resources.service;

import ub.edu.resources.dao.DAOComarca;
import ub.edu.resources.dao.DAOPersona;
import ub.edu.resources.dao.DAORelacioComarcaRuta;
import ub.edu.resources.dao.DAORuta;

import ub.edu.resources.dao.MOCK.*;


public class FactoryMOCK implements AbstractFactoryData {

    @Override
    public DAOPersona createDAOPersona() {
        return new DAOPersonaMOCK();
    }

    @Override
    public DAORuta createDAORuta() {
        return new DAORutaMOCK();
    }

    @Override
    public DAOComarca createDAOComarca() {
        return new DAOComarcaMOCK();
    }

    @Override
    public DAORelacioComarcaRuta createDAORelacioRutaComarca() {
        return new DAORelacioComarcaRutaMOCK();
    }

    // TO DO Pràctica 2:  Crear els altres DAOs de les altres classes
}
