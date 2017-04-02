/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Servlets;

import DTO.Reporte;
import Modelo.ReporteDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author Arturo Camargo
 */
@WebServlet("/consultaDelito")
public class ServletConsultaDelito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Reporte> listaResultados = null;
        ReporteDAO rdao = new ReporteDAO();

        String fecha1 = request.getParameter("fechaStart").trim();
        String fecha2 = request.getParameter("fechaEnd").trim();
        String hora1 = request.getParameter("horaStart").trim();
        String hora2 = request.getParameter("horaEnd").trim();
        String[] listaDelito = request.getParameterValues("delitos");
        if(listaDelito == null){
            listaDelito = new String[0];
        }
        String calle1 = request.getParameter("calle1").trim();
        String calle2 = request.getParameter("calle2").trim();
        String colonia = request.getParameter("colonia").trim();
        String[] listaDelegacion = request.getParameterValues("delegacion");
        if(listaDelegacion == null){
            listaDelegacion = new String[0];
        }
        String coord_x = request.getParameter("coordx");
        String coord_y = request.getParameter("coordy");
        
        if((fecha1.isEmpty()) && (fecha2.isEmpty()) && (hora1.isEmpty()) && (hora2.isEmpty()) && (listaDelito.length == 0) && (calle1.isEmpty()) && (calle2.isEmpty()) && (colonia.isEmpty()) && (listaDelegacion.length == 0) && (coord_x.isEmpty()) && (coord_y.isEmpty())) {
            listaResultados = rdao.buscarTodo();
        }
        else {
            
        }
        
        request.setAttribute("listaResultados", listaResultados);
        request.getRequestDispatcher("resultados.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
