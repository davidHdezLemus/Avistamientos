package es.albarregas.DAOFactory;

import es.albarregas.DAO.AvistamientoDAO;
import es.albarregas.DAO.IAvistamientoDAO;

/**
 * Fábrica concreta para la fuente de datos MySQL
 */
public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IAvistamientoDAO getAvistamientoDAO() {
        return new AvistamientoDAO();
    }
   
}
