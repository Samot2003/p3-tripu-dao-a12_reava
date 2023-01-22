package ub.edu.resources.service;

import ub.edu.resources.dao.*;

import ub.edu.resources.dao.MOCK.*;


public class FactoryMOCK implements AbstractFactoryData {

    private volatile static FactoryMOCK uniqueInstance;

    public static FactoryMOCK getInstance(){
        if (uniqueInstance == null){
            synchronized (FactoryMOCK.class){
                if (uniqueInstance == null){
                    uniqueInstance = new FactoryMOCK();
                }
            }
        }
        return uniqueInstance;
    }

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

    public DAOLocalitat createDAOLocalitat() {
        return new DAOLocalitatMOCK();
    }

    public DAORelacioLocalitatRuta createDAORelacioRutaLocalitat() {
        return new DAORelacioLocalitatRutaMOCK();
    }

    public DAOTransport createDAOTransport() {
        return new DAOTransportMOCK();
    }

    @Override
    public DAORelacioTransportRuta createDAORelacioTransportRuta() {return new DAORelacioTransportRutaMOCK();}

    // TO DO Pràctica 2:  Crear els altres DAOs de les altres classes
}
