/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Servlets;

import DTO.Reporte;
import Modelo.ColoniaDAO;
import Modelo.DelegacionDAO;
import Modelo.DelitoDAO;
import Modelo.ReporteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arturo Camargo
 */
@WebServlet("/registroReporte")
public class ServletRegistroReporte extends HttpServlet {

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
        ReporteDAO rdao = new ReporteDAO();
        Reporte r = new Reporte();
        
        r.setFecha(request.getParameter("fecha").trim());
        r.setHora(request.getParameter("hora").trim());
        r.setCalle1(request.getParameter("calle1").trim());
        r.setCalle2(request.getParameter("calle2").trim());
        r.setCoord_x(request.getParameter("coordx"));
        r.setCoord_y(request.getParameter("coordy"));
        r.setDescripcion(request.getParameter("descripcion"));
        r.setDelito(DelitoDAO.get().buscarPorId(Integer.parseInt(request.getParameter("delito"))));
        r.setColonia(ColoniaDAO.get().buscarPorNombre(request.getParameter("colonia")));
        r.setDelegacion(DelegacionDAO.get().buscarPorId(Integer.parseInt(request.getParameter("delegacion"))));
        
        if(rdao.nuevoReporte(r)){
            //Mensaje de ëxito
            System.out.println("Si se agregó");
            //Ventana PoP que avise éxito
            request.getRequestDispatcher("denuncia-user.jsp").forward(request, response);
        }
        else{
            System.out.println("No se agregó ");
            //Ventana PoP que avise falla
            request.getRequestDispatcher("denuncia-user.jsp").forward(request, response);
        }
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
