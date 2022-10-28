package ub.edu.resources.service;

import ub.edu.resources.dao.*;

public interface AbstractFactoryData {
     DAOPersona createDAOPersona();
     DAORuta createDAORuta();
     DAOComarca createDAOComarca();
     DAORelacioComarcaRuta createDAORelacioRutaComarca();
}
