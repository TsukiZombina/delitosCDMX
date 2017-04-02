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
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = UConnection.getConnection();
            String sql = "SELECT * FROM delegacion;";
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            listaDelegaciones = new ArrayList<>();
            Delegacion d;

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
