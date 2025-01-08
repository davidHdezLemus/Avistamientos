package es.albarregas.DAOFactory;

import es.albarregas.DAO.IAvistamientoDAO;

public abstract class DAOFactory {
    
    public static final int MYSQL = 1;
    public static final int DERBY = 2;

    /**
     * Una clase abstracta por cada tabla de la base de datos
     * @return Inteface de las operaciones a realizar con la tabla
     */
    public abstract IAvistamientoDAO getAvistamientoDAO();

    /**
     * Fábrica abstracta
     * @return Objeto de la fábrica abstracta
     */
    public static DAOFactory getDAOFactory(int tipo) {
        
        DAOFactory daof = null;
        
        switch(tipo){
            case MYSQL:
                daof = new MySQLDAOFactory();
                break;
               
            case DERBY:
                daof = new DerbyDAOFactory();
                break;
        }
        return daof;
    }

}
