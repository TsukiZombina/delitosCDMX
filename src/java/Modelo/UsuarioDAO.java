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
        Connection conn1 = null;
        Connection conn2 = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean st = false;
        String sql;

        try {
            conn1 = UConnection.getConnection1();
            sql = "SELECT usuario, password, nombre_usuario, apellido_usuario, email FROM usuario WHERE usuario = '" + user + "' AND password = '" + pass + "';";

            ps = conn1.prepareStatement(sql);
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
            else {
                conn2 = UConnection.getConnection2();
                sql = "SELECT usuario, password, nombre_usuario, apellido_usuario, email FROM usuario WHERE usuario = '" + user + "' AND password = '" + pass + "';";

                ps = conn2.prepareStatement(sql);
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

    public boolean nuevoUsuario(Usuario u) {
        boolean msn = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = UConnection.getConnection1();
            String sql = "INSERT INTO usuario (usuario, password, nombre_usuario, apellido_usuario, email) VALUES (?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getApellidos());
            ps.setString(5, u.getEmail());

            int rtdo = ps.executeUpdate();

            if (rtdo != 1) {
                msn = false;
                throw new RuntimeException("Error en insert");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (ps != null) {
                    msn = true;
                    ps.close();
                };
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return msn;
    }

    public Usuario getUsuario() {
        return u;
    }
}
