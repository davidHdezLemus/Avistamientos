package es.albarregas.DAO;

import es.albarregas.beans.Avistamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvistamientoDAODerby implements IAvistamientoDAO {

    @Override
    public List<Avistamiento> getAvistamientos() {
        Avistamiento avistamiento = null;
        List<Avistamiento> avistamientos = null;
        ResultSet resultado = null;
        Statement sentencia = null;
        String sql = "SELECT * FROM avistamientos";

        try {
            Connection connection = ConnectionFactory.getConnectionDerby();
            sentencia = connection.createStatement();

            resultado = sentencia.executeQuery(sql);
            // Cargamos un ArrayList con todos los registros de la tabla usuarios
            avistamientos = new ArrayList();
            while (resultado.next()) {
                avistamiento = new Avistamiento();
                avistamiento.setAnilla(resultado.getString(1));
                avistamiento.setEspecie(resultado.getString(2));
                avistamiento.setFecha(resultado.getString(3));
                avistamiento.setLugar(resultado.getString(4));

                avistamientos.add(avistamiento);
            }

        } catch (SQLException e) {

            Logger.getLogger(AvistamientoDAODerby.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.closeConnection();
        }
        return avistamientos;
    }
    
    @Override
    public List<Avistamiento> getAvistamientosPorAnilla(int anilla) {
        Avistamiento avistamiento = null;
        List<Avistamiento> avistamientos = null;
        Connection connection = null;
        ResultSet resultado = null;
        PreparedStatement preparada = null;
        String sql = "SELECT * FROM avistamientos WHERE anilla = ?";
        try {
            connection = ConnectionFactory.getConnectionDerby();
            preparada = connection.prepareStatement(sql);
            preparada.setInt(1, anilla);
            resultado = preparada.executeQuery();

            avistamientos = new ArrayList();
            while (resultado.next()) {
                avistamiento = new Avistamiento();
                avistamiento.setAnilla(resultado.getString(1));
                avistamiento.setEspecie(resultado.getString(2));
                avistamiento.setFecha(resultado.getString(3));
                avistamiento.setLugar(resultado.getString(4));

                avistamientos.add(avistamiento);
            }

        } catch (SQLException e) {
            Logger.getLogger(AvistamientoDAODerby.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            this.closeConnection();
        }
        return avistamientos;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }
}
