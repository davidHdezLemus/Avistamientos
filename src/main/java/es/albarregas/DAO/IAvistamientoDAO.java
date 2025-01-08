package es.albarregas.DAO;

import es.albarregas.beans.Avistamiento;

import java.util.List;

public interface IAvistamientoDAO {
    
    /**
     * Obtiene toda la información de todos los usuarios 
     * @return Lista con los usuarios
     */
    public List<Avistamiento> getAvistamientos();
    public List<Avistamiento> getAvistamientosPorAnilla(int anilla);
    
    /**
     * Abandona el hilo del pool de conexiones
     */
    public void closeConnection();
    
}
