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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Arturo Camargo
 */
public class ReporteDAO {

    ArrayList<Reporte> listaReportes;

    public ArrayList<Reporte> buscarTodo() {
        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        Reporte r;

        try {
            //Maneja a que fragmento horizontal enviar la consulta.

            conn1 = UConnection.getConnection1();
            //La base maneja la union de los fragmentos verticales.
            sql = "SELECT delitosCDMX_Norte_General.reporte.id_reporte, delitosCDMX_Norte_General.reporte.fecha, delitosCDMX_Norte_Especifico.reporte.hora, delitosCDMX_Norte_Especifico.reporte.calle1, delitosCDMX_Norte_Especifico.reporte.calle2, delitosCDMX_Norte_Especifico.reporte.coord_x, delitosCDMX_Norte_Especifico.reporte.coord_y, delitosCDMX_Norte_Especifico.reporte.cuadrante, delitosCDMX_Norte_General.reporte.id_colonia, delitosCDMX_Norte_General.reporte.id_delegacion, delitosCDMX_Norte_General.reporte.id_delito, delitosCDMX_Norte_Especifico.reporte.descripcion "
                    + "FROM (delitosCDMX_Norte_General.reporte INNER JOIN delitosCDMX_Norte_Especifico.reporte ON delitosCDMX_Norte_General.reporte.id_reporte = delitosCDMX_Norte_Especifico.reporte.id_reporte) LIMIT 50";
            ps = conn1.prepareStatement(sql);
            rs = ps.executeQuery();

            listaReportes = new ArrayList<>();

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
                r.setDescripcion(rs.getString("descripcion"));
                listaReportes.add(r);
            }

            conn2 = UConnection.getConnection2();
            //La base maneja la union de los fragmentos verticales.
            sql = "SELECT delitosCDMX_Sur_General.reporte.id_reporte, delitosCDMX_Sur_General.reporte.fecha, delitosCDMX_Sur_Especifico.reporte.hora, delitosCDMX_Sur_Especifico.reporte.calle1, delitosCDMX_Sur_Especifico.reporte.calle2, delitosCDMX_Sur_Especifico.reporte.coord_x, delitosCDMX_Sur_Especifico.reporte.coord_y, delitosCDMX_Sur_Especifico.reporte.cuadrante, delitosCDMX_Sur_General.reporte.id_colonia, delitosCDMX_Sur_General.reporte.id_delegacion, delitosCDMX_Sur_General.reporte.id_delito, delitosCDMX_Sur_Especifico.reporte.descripcion "
                    + "FROM (delitosCDMX_Sur_General.reporte INNER JOIN delitosCDMX_Sur_Especifico.reporte ON delitosCDMX_Sur_General.reporte.id_reporte = delitosCDMX_Sur_Especifico.reporte.id_reporte) LIMIT 50";
            ps = conn2.prepareStatement(sql);
            rs = ps.executeQuery();

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
                r.setDescripcion(rs.getString("descripcion"));
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

    public Reporte buscarPorId(String id_reporte, String id_delegacion) {
        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        Reporte r = new Reporte();

        try {
            //Maneja a que fragmento horizontal enviar la consulta.
            if (id_delegacion.equals("3") || id_delegacion.equals("4") || id_delegacion.equals("7") || id_delegacion.equals("8") || id_delegacion.equals("9") || id_delegacion.equals("10") || id_delegacion.equals("12") || id_delegacion.equals("16")) {
                conn1 = UConnection.getConnection1();
                //La base maneja la union de los fragmentos verticales.
                sql = "SELECT delitosCDMX_Norte_General.reporte.id_reporte, delitosCDMX_Norte_General.reporte.fecha, delitosCDMX_Norte_Especifico.reporte.hora, delitosCDMX_Norte_Especifico.reporte.calle1, delitosCDMX_Norte_Especifico.reporte.calle2, delitosCDMX_Norte_Especifico.reporte.coord_x, delitosCDMX_Norte_Especifico.reporte.coord_y, delitosCDMX_Norte_Especifico.reporte.cuadrante, delitosCDMX_Norte_General.reporte.id_colonia, delitosCDMX_Norte_General.reporte.id_delegacion, delitosCDMX_Norte_General.reporte.id_delito, delitosCDMX_Norte_Especifico.reporte.descripcion "
                        + "FROM (delitosCDMX_Norte_General.reporte INNER JOIN delitosCDMX_Norte_Especifico.reporte ON delitosCDMX_Norte_General.reporte.id_reporte = delitosCDMX_Norte_Especifico.reporte.id_reporte) "
                        + "WHERE delitosCDMX_Norte_General.reporte.id_reporte = " + id_reporte;
                ps = conn1.prepareStatement(sql);
            }
            if (id_delegacion.equals("1") || id_delegacion.equals("2") || id_delegacion.equals("5") || id_delegacion.equals("6") || id_delegacion.equals("11") || id_delegacion.equals("13") || id_delegacion.equals("14") || id_delegacion.equals("15") || id_delegacion.equals("17")) {
                conn2 = UConnection.getConnection2();
                //La base maneja la union de los fragmentos verticales.
                sql = "SELECT delitosCDMX_Sur_General.reporte.id_reporte, delitosCDMX_Sur_General.reporte.fecha, delitosCDMX_Sur_Especifico.reporte.hora, delitosCDMX_Sur_Especifico.reporte.calle1, delitosCDMX_Sur_Especifico.reporte.calle2, delitosCDMX_Sur_Especifico.reporte.coord_x, delitosCDMX_Sur_Especifico.reporte.coord_y, delitosCDMX_Sur_Especifico.reporte.cuadrante, delitosCDMX_Sur_General.reporte.id_colonia, delitosCDMX_Sur_General.reporte.id_delegacion, delitosCDMX_Sur_General.reporte.id_delito, delitosCDMX_Sur_Especifico.reporte.descripcion "
                        + "FROM (delitosCDMX_Sur_General.reporte INNER JOIN delitosCDMX_Sur_Especifico.reporte ON delitosCDMX_Sur_General.reporte.id_reporte = delitosCDMX_Sur_Especifico.reporte.id_reporte) "
                        + "WHERE delitosCDMX_Sur_General.reporte.id_reporte = " + id_reporte;
                ps = conn2.prepareStatement(sql);
            }

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
            r.setDescripcion(rs.getString("descripcion"));

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

    public ArrayList<Reporte> busquedaSelectiva(String fecha1, String fecha2, String hora1, String hora2, String[] delitos, String calle1, String calle2, String colonia, String[] delegaciones, String coord_x, String coord_y) {
        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reporte r;

        List listaDelegacion = Arrays.asList(delegaciones);

        try {

            if (listaDelegacion.contains("3") || listaDelegacion.contains("4") || listaDelegacion.contains("7") || listaDelegacion.contains("8") || listaDelegacion.contains("9") || listaDelegacion.contains("10") || listaDelegacion.contains("12") || listaDelegacion.contains("16")) {
                conn1 = UConnection.getConnection1();
                String sql = buildQuery("delitosCDMX_Norte_General", "delitosCDMX_Norte_Especifico", fecha1, fecha2, hora1, hora2, delitos, calle1, calle2, colonia, delegaciones, coord_x, coord_y);
                System.out.println(sql);
                ps = conn1.prepareStatement(sql);
                rs = ps.executeQuery();

                if (listaReportes == null) {
                    listaReportes = new ArrayList<>();
                }

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
                    r.setDescripcion(rs.getString("descripcion"));
                    listaReportes.add(r);
                }
            }

            if (listaDelegacion.contains("1") || listaDelegacion.contains("2") || listaDelegacion.contains("5") || listaDelegacion.contains("6") || listaDelegacion.contains("11") || listaDelegacion.contains("13") || listaDelegacion.contains("14") || listaDelegacion.contains("15") || listaDelegacion.contains("17")) {
                conn2 = UConnection.getConnection2();
                String sql = buildQuery("delitosCDMX_Sur_General", "delitosCDMX_Sur_Especifico", fecha1, fecha2, hora1, hora2, delitos, calle1, calle2, colonia, delegaciones, coord_x, coord_y);
                System.out.println(sql);
                ps = conn2.prepareStatement(sql);
                rs = ps.executeQuery();

                if (listaReportes == null) {
                    listaReportes = new ArrayList<>();
                }

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
                    r.setDescripcion(rs.getString("descripcion"));
                    listaReportes.add(r);
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
        return listaReportes;
    }

    public boolean nuevoReporte(Reporte r) {
        boolean msn = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql1 = "";
        String sql2 = "";

        String id_delegacion = String.valueOf(r.getDelegacion().getid_delegacion());

        try {
            if (id_delegacion.equals("3") || id_delegacion.equals("4") || id_delegacion.equals("7") || id_delegacion.equals("8") || id_delegacion.equals("9") || id_delegacion.equals("10") || id_delegacion.equals("12") || id_delegacion.equals("16")) {
                conn = UConnection.getConnection1();
                conn.setAutoCommit(false);
                sql1 = "INSERT INTO delitosCDMX_Norte_General.reporte (delitosCDMX_Norte_General.reporte.fecha, delitosCDMX_Norte_General.reporte.id_colonia, delitosCDMX_Norte_General.reporte.id_delegacion, delitosCDMX_Norte_General.reporte.id_delito) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, r.getFecha());
                ps.setInt(2, r.getColonia().getid_colonia());
                ps.setInt(3, r.getDelegacion().getid_delegacion());
                ps.setInt(4, r.getDelito().getId_delito());
                ps.executeUpdate();

                sql2 = "INSERT INTO delitosCDMX_Norte_Especifico.reporte (delitosCDMX_Norte_Especifico.reporte.hora, delitosCDMX_Norte_Especifico.reporte.calle1, delitosCDMX_Norte_Especifico.reporte.calle2, delitosCDMX_Norte_Especifico.reporte.coord_x, delitosCDMX_Norte_Especifico.reporte.coord_y, delitosCDMX_Norte_Especifico.reporte.cuadrante, delitosCDMX_Norte_Especifico.reporte.descripcion) VALUES (?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql2);
                ps.setString(1, r.getHora());
                ps.setString(2, r.getCalle1());
                ps.setString(3, r.getCalle2());
                ps.setString(4, r.getCoord_x());
                ps.setString(5, r.getCoord_y());
                ps.setString(6, "");
                ps.setString(7, r.getDescripcion());
                ps.executeUpdate();

                conn.commit();
                conn.setAutoCommit(true);
            } else {
                conn = UConnection.getConnection2();
                conn.setAutoCommit(false);
                sql1 = "INSERT INTO delitosCDMX_Sur_General.reporte (delitosCDMX_Sur_General.reporte.fecha, delitosCDMX_Sur_General.reporte.id_colonia, delitosCDMX_Sur_General.reporte.id_delegacion, delitosCDMX_Sur_General.reporte.id_delito) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, r.getFecha());
                ps.setInt(2, r.getColonia().getid_colonia());
                ps.setInt(3, r.getDelegacion().getid_delegacion());
                ps.setInt(4, r.getDelito().getId_delito());
                ps.executeUpdate();

                sql2 = "INSERT INTO delitosCDMX_Sur_Especifico.reporte (delitosCDMX_Sur_Especifico.reporte.hora, delitosCDMX_Sur_Especifico.reporte.calle1, delitosCDMX_Sur_Especifico.reporte.calle2, delitosCDMX_Sur_Especifico.reporte.coord_x, delitosCDMX_Sur_Especifico.reporte.coord_y, delitosCDMX_Sur_Especifico.reporte.cuadrante, delitosCDMX_Sur_Especifico.reporte.descripcion) VALUES (?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql2);
                ps.setString(1, r.getHora());
                ps.setString(2, r.getCalle1());
                ps.setString(3, r.getCalle2());
                ps.setString(4, r.getCoord_x());
                ps.setString(5, r.getCoord_y());
                ps.setString(6, "");
                ps.setString(7, r.getDescripcion());
                ps.executeUpdate();

                conn.commit();
                conn.setAutoCommit(true);
            }
        } catch (Exception ex) {
            msn = false;
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        } finally {
            try {
                if (ps != null) {
                    msn = true;
                    ps.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return msn;
    }

    private String buildQuery(String dbv1, String dbv2, String fecha1, String fecha2, String hora1, String hora2, String[] listaDelito, String calle1, String calle2, String colonia, String[] listaDelegacion, String coord_x, String coord_y) {
        String sql = "SELECT "
                + dbv1 + ".reporte.id_reporte, "
                + dbv1 + ".reporte.fecha, "
                + dbv2 + ".reporte.hora, "
                + dbv2 + ".reporte.calle1, "
                + dbv2 + ".reporte.calle2, "
                + dbv2 + ".reporte.coord_x, "
                + dbv2 + ".reporte.coord_y, "
                + dbv2 + ".reporte.cuadrante, "
                + dbv1 + ".reporte.id_colonia, "
                + dbv1 + ".reporte.id_delegacion, "
                + dbv1 + ".reporte.id_delito, "
                + dbv2 + ".reporte.descripcion "
                + "FROM (("
                + dbv1 + ".reporte INNER JOIN "
                + dbv2 + ".reporte ON "
                + dbv1 + ".reporte.id_reporte = "
                + dbv2 + ".reporte.id_reporte) INNER JOIN "
                + dbv1 + ".colonia ON "
                + dbv1 + ".reporte.id_colonia = "
                + dbv1 + ".colonia.id_colonia) WHERE ";
        int flag = 0;

        if (!(fecha1.isEmpty() || fecha2.isEmpty())) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv1 + ".reporte.fecha BETWEEN '" + fecha1 + "' AND '" + fecha2 + "')";
            flag = 1;
        }
        if (!(hora1.isEmpty() || hora2.isEmpty())) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv2 + ".reporte.hora BETWEEN '" + hora1 + "' AND '" + hora2 + "')";
            flag = 1;
        }
        if (listaDelito.length != 0) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(";
            for (int i = 0; i < listaDelito.length; i++) {
                sql += dbv1 + ".reporte.id_delito = " + listaDelito[i] + " OR ";
            }
            sql += "FALSE)";
            flag = 1;
        }
        if (!calle1.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv2 + ".reporte.calle1 = '" + calle1 + "')";
            flag = 1;
        }
        if (!calle2.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv2 + ".reporte.calle2 = '" + calle2 + "')";
            flag = 1;
        }
        if (!colonia.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv1 + ".colonia.nombre_colonia = '" + colonia + "')";
            flag = 1;
        }
        if (listaDelegacion.length != 0) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(";
            for (int i = 0; i < listaDelegacion.length; i++) {
                sql += dbv1 + ".reporte.id_delegacion = " + listaDelegacion[i] + " OR ";
            }
            sql += "FALSE)";
            flag = 1;
        }
        if (!coord_x.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv2 + ".reporte.coord_x = '" + coord_x + "')";
            flag = 1;
        }
        if (!coord_y.isEmpty()) {
            if (flag == 1) {
                sql += " AND ";
            }
            sql += "(" + dbv2 + ".reporte.coord_y = '" + coord_y + "')";
            flag = 1;
        }

        return sql;
    }

}
