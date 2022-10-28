package ub.edu.resources.dao;

import ub.edu.model.Persona;

public interface DAOPersona extends DAO<Persona> {
    Persona findPersonaByUserNameAndPassword(String usuari, String pwd) throws Exception;
}
