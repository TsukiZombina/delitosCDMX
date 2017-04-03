/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Modelo;

import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arturo Camargo
 */
public class UsuarioDAO {

    public Usuario login(String user, String pass) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
        try {
            conn = UConnection.getConnection();
            String sql = "SELECT * FROM usuario WHERE usuario = '" + user + "' AND password = '" + pass + "';";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            usuario = new Usuario();
            rs.next();
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setPassword(rs.getString("password"));
            usuario.setNombre(rs.getString("nombre_usuario"));
            usuario.setApellidos(rs.getString("apellido_usuario"));
            usuario.setEmail(rs.getString("email"));
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return usuario;
        
    }
}
