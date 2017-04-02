/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Modelo;

import DTO.Reporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Arturo Camargo
 */
public class ReporteDAO {

    ArrayList<Reporte> listaReportes;

    public ArrayList<Reporte> buscarTodo() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = UConnection.getConnection();
            String sql = "SELECT * FROM reporte LIMIT 15;";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            listaReportes = new ArrayList<>();
            Reporte r;

            while (rs.next()) {
                r = new Reporte();
                r.setId_reporte(rs.getInt("id_reporte"));
                r.setFecha(rs.getString("fecha"));
                r.setHora(rs.getString("hora"));
                r.setCalle1(rs.getString("calle1"));
                r.setCalle2(rs.getString("calle2"));
                r.setCoord_x(rs.getString("coord_x"));
                r.setCoord_y(rs.getString("coord_y"));
                r.setCuadrante(rs.getString("cuadrante"));
                r.setColonia(ColoniaDAO.get().buscarPorId(rs.getInt("id_colonia")));
                r.setDelegacion(DelegacionDAO.get().buscarPorId(rs.getInt("id_delegacion")));
                r.setDelito(DelitoDAO.get().buscarPorId(rs.getInt("id_delito")));
                listaReportes.add(r);
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
        return listaReportes;
    }

}
