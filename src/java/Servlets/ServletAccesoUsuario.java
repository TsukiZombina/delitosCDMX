/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Servlets;

import DTO.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arturo Camargo
 */
@WebServlet("/accesoUsuario")
public class ServletAccesoUsuario extends HttpServlet {
    HttpSession sesion = null;
    static public Usuario currentLog;
    
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
        
        UsuarioDAO udao = new UsuarioDAO();
        
        String user = request.getParameter("user").trim();
        String pass = request.getParameter("password").trim();
        
        Usuario u = udao.login(user, pass);
        
        if (u != null) {
            sesion = request.getSession();
            sesion.setAttribute("user", u);
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("index-user.jsp").forward(request, response);
            
        } else {
            response.setContentType("text/html;charset=UTF-8");
            System.out.println("Contraseña Incorrecta");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
