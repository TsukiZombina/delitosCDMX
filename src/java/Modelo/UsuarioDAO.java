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

    Usuario u;

    public boolean login(String user, String pass) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean st = false;

        try {
            conn = UConnection.getConnection();
            String sql = "SELECT * FROM usuario WHERE usuario = '" + user + "' AND password = '" + pass + "';";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            st = rs.next();

            if (st) {
                u = new Usuario();
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setNombre(rs.getString("nombre_usuario"));
                u.setApellidos(rs.getString("apellido_usuario"));
                u.setEmail(rs.getString("email"));
            }

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
        return st;

    }

    public Usuario getUsuario() {
        return u;
    }
}
