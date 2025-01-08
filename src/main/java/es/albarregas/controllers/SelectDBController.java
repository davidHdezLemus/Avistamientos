/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pablo
 */
@WebServlet(name = "SelectDBController", urlPatterns = {"/SelectDBController"})
public class SelectDBController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(".").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "*";

        // Obtén el objeto HttpSession de la solicitud
        HttpSession session = request.getSession();

        String opcion = request.getParameter("db");

        switch (opcion) {
            case "MySQL":
                url = "jsp/selectAnilla.jsp";
                session.setAttribute("baseDeDatos", "MySQL"); // Guardar en la sesión
                break;
            case "Derby":
                url = "jsp/selectAnilla.jsp";
                session.setAttribute("baseDeDatos", "Derby"); // Guardar en la sesión
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}
