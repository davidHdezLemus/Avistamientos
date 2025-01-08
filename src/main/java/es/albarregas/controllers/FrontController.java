package es.albarregas.controllers;

import es.albarregas.DAO.IAvistamientoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Avistamiento;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(".").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "jsp/resultado.jsp";
        List<Avistamiento> avistamientos = null;
        DAOFactory daoF;
        HttpSession session = request.getSession(); // Obtener la sesión del usuario

        String bd = request.getParameter("baseDeDatos");

        System.out.println(bd);

        if ("MySQL".equals(bd)) {
            daoF = DAOFactory.getDAOFactory(1);
        } else {
            daoF = DAOFactory.getDAOFactory(2);
        }

        session.setAttribute("baseDeDatos", bd); // Guardar en la sesión
        IAvistamientoDAO aDAO = daoF.getAvistamientoDAO();

        String opcion = request.getParameter("enviar");

        switch (opcion) {
            case "Solicitar":
                String anilla = request.getParameter("anilla");

                if (!anilla.isEmpty()) {
                    int anilla2 = Integer.parseInt(anilla);
                    avistamientos = aDAO.getAvistamientosPorAnilla(anilla2);
                } else {
                    avistamientos = aDAO.getAvistamientos();
                }

                session.setAttribute("avistamientos", avistamientos); // Guardar en la sesión
                break;

            case "Volver":
                url = "index.jsp";
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}
