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

    public Reporte buscarPorId(String id_reporte) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reporte r = new Reporte();

        try {
            conn = UConnection.getConnection();
            String sql = "SELECT * FROM reporte WHERE id_reporte = " + id_reporte + ";";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            rs.next();
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
        return r;
    }

    public ArrayList<Reporte> busquedaSelectiva(String fecha1, String fecha2, String hora1, String hora2, String[] listaDelito, String calle1, String calle2, String colonia, String[] listaDelegacion, String coord_x, String coord_y) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = UConnection.getConnection();

            String sql = buildQuery(fecha1, fecha2, hora1, hora2, listaDelito, calle1, calle2, colonia, listaDelegacion, coord_x, coord_y);
            System.out.println(sql);
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

    private String buildQuery(String fecha1, String fecha2, String hora1, String hora2, String[] listaDelito, String calle1, String calle2, String colonia, String[] listaDelegacion, String coord_x, String coord_y) {
        String sql = "SELECT reporte.id_reporte, reporte.fecha, reporte.hora, reporte.calle1, reporte.calle2, reporte.coord_x, reporte.coord_y, reporte.cuadrante, reporte.id_colonia, reporte.id_delegacion, reporte.id_delito FROM (reporte INNER JOIN colonia ON reporte.id_colonia = colonia.id_colonia) WHERE ";
        int flag = 0;

        if (!(fecha1.isEmpty() || fecha2.isEmpty())) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(reporte.fecha BETWEEN '" + fecha1 + "' AND '" + fecha2 + "')";
            flag = 1;
        }
        if (!(hora1.isEmpty() || hora2.isEmpty())) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(reporte.hora BETWEEN '" + hora1 + "' AND '" + hora2 + "')";
            flag = 1;
        }
        if (listaDelito.length != 0) {
            if (flag == 1) {
                sql += " AND ";
            }
            for (int i = 0; i < listaDelito.length; i++) {
                sql += "(reporte.id_delito = " + listaDelito[i] + " OR ";
            }
            sql += "FALSE)";
            flag = 1;
        }
        if (!calle1.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(reporte.calle1 = '" + calle1 + "')";
            flag = 1;
        }
        if (!calle2.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(reporte.calle2 = '" + calle2 + "')";
            flag = 1;
        }
        if (!colonia.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(colonia.nombre_colonia = '" + colonia + "')";
            flag = 1;
        }
        if (listaDelegacion.length != 0) {
            if (flag == 1) {
                sql += " AND ";
            }
            for (int i = 0; i < listaDelegacion.length; i++) {
                sql += "(reporte.id_delegacion = " + listaDelegacion[i] + " OR ";
            }
            sql += "FALSE)";
            flag = 1;
        }
        if (!coord_x.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(reporte.coord_x = '" + coord_x + "')";
            flag = 1;
        }
        if (!coord_y.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(reporte.coord_y = '" + coord_y + "')";
            flag = 1;
        }

        return sql;
    }

}
