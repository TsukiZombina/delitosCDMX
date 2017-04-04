/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Modelo;

import DTO.Delegacion;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Arturo Camargo
 */
public class DelegacionDAO implements Serializable {
    private static DelegacionDAO delegacionDAO;
    private ArrayList<Delegacion> listaDelegaciones;

    private DelegacionDAO(){}
    
    public static DelegacionDAO get(){
        if (delegacionDAO == null){
            delegacionDAO = new DelegacionDAO();
        }
        return delegacionDAO;
    }
    
    private void buscarTodos(){
        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "";
        
        try {
            conn1 = UConnection.getConnection1();
            sql = "SELECT delitosCDMX_Norte_General.delegacion.id_delegacion, delitosCDMX_Norte_General.delegacion.nombre_delegacion FROM delitosCDMX_Norte_General.delegacion";
            
            pstm = conn1.prepareStatement(sql);
            rs = pstm.executeQuery();

            listaDelegaciones = new ArrayList<>();
            Delegacion d;

            while (rs.next()) {
                d = new Delegacion();
                d.setid_delegacion(rs.getInt("id_delegacion"));
                d.setnombre_delegacion(rs.getString("nombre_delegacion"));
                listaDelegaciones.add(d);
            }
            
            conn2 = UConnection.getConnection2();
            sql = "SELECT delitosCDMX_Sur_General.delegacion.id_delegacion, delitosCDMX_Sur_General.delegacion.nombre_delegacion FROM delitosCDMX_Sur_General.delegacion";
            
            pstm = conn2.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                d = new Delegacion();
                d.setid_delegacion(rs.getInt("id_delegacion"));
                d.setnombre_delegacion(rs.getString("nombre_delegacion"));
                listaDelegaciones.add(d);
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } 
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }
    
    public Delegacion buscarPorId(int id) {
        if(listaDelegaciones == null){
            buscarTodos();
        }
        for(int i = 0; i < listaDelegaciones.size(); i++){
            if(listaDelegaciones.get(i).getid_delegacion() == id){
                return listaDelegaciones.get(i);
            }
        }
        return null;
    }
    
    public String buscarNombrePorId(int id) {
        if(listaDelegaciones == null){
            buscarTodos();
        }
        for(int i = 0; i < listaDelegaciones.size(); i++){
            if(listaDelegaciones.get(i).getid_delegacion() == id){
                return listaDelegaciones.get(i).getnombre_delegacion();
            }
        }
        return null;
    }
    
    public ArrayList<Delegacion> getListaDelegacion(){
        if(listaDelegaciones == null){
            buscarTodos();
        }
        return listaDelegaciones;
    }
    
}
