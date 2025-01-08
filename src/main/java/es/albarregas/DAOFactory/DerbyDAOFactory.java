package es.albarregas.DAOFactory;

import es.albarregas.DAO.AvistamientoDAODerby;
import es.albarregas.DAO.IAvistamientoDAO;

/**
 * Fábrica concreta para la fuente de datos MySQL
 * @author jesus
 */
public class DerbyDAOFactory extends DAOFactory{

    @Override
    public IAvistamientoDAO getAvistamientoDAO() {
        return new AvistamientoDAODerby();
    }
   
}