package es.albarregas.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

    /*
    * Declaramos el pool de conexiones
     */
    static DataSource dataSource = null;
    static Connection conexion = null;
    static final String DATASOURCE_NAME_MYSQL = "java:comp/env/jdbc/Avistamientos";
    static final String DATASOURCE_NAME_DERBY = "java:comp/env/jdbc/AvistamientosDerby";

    public static Connection getConnection() {

        try {
            Context contextoInicial = new InitialContext();
            dataSource = (DataSource) contextoInicial.lookup(DATASOURCE_NAME_MYSQL);
            conexion = dataSource.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

        }
        return conexion;
    }
    
    
    
    public static Connection getConnectionDerby() {
        try {
            Context contextoInicial = new InitialContext();
            dataSource = (DataSource) contextoInicial.lookup(DATASOURCE_NAME_DERBY);
            conexion = dataSource.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

        }
        return conexion;
    }

    public static void closeConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
