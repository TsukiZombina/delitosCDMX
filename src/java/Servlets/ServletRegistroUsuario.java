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

/**
 *
 * @author Arturo Camargo
 */
@WebServlet("/registroUsuario")
public class ServletRegistroUsuario extends HttpServlet {

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
        String apellidos = "";
        
        String nombre = request.getParameter("name").trim();
        String apellido1 = request.getParameter("lastname").trim();
        String apellido2 = request.getParameter("lastname2").trim();
        if(!apellido2.isEmpty()){
            apellidos = apellido1 + " " + apellido2;
        }
        else{
            apellidos = apellido1;
        }
        String user = request.getParameter("user").trim();
        String pass = request.getParameter("password").trim();
        String email = request.getParameter("email").trim();
        
        Usuario u = new Usuario(user, pass, nombre, apellidos, email);
        UsuarioDAO udao = new UsuarioDAO();
        
        if(udao.nuevoUsuario(u)){
            //Mensaje de ëxito
            System.out.println("Si se agregó");
            //Ventana PoP que avise éxito
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            System.out.println("No se agregó ");
            //Ventana PoP que avise falla
            request.getRequestDispatcher("registro.jsp").forward(request, response);
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
