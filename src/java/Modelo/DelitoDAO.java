/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Modelo;

import DTO.Delito;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Arturo Camargo
 */
public class DelitoDAO implements Serializable {
    private static DelitoDAO delitoDAO;
    private ArrayList<Delito> listaDelitos;

    private DelitoDAO(){}
    
    public static DelitoDAO get(){
        if (delitoDAO == null){
            delitoDAO = new DelitoDAO();
        }
        return delitoDAO;
    }
    
    private void buscarTodos(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = UConnection.getConnection1();
            String sql = "SELECT id_delito, nombre_delito FROM delito;";
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            listaDelitos = new ArrayList<>();
            Delito d;

            while (rs.next()) {
                d = new Delito();
                d.setId_delito(rs.getInt("id_delito"));
                d.setNombre_delito(rs.getString("nombre_delito"));
                listaDelitos.add(d);
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
    
    public Delito buscarPorId(int id) {
        if(listaDelitos == null){
            buscarTodos();
        }
        for(int i = 0; i < listaDelitos.size(); i++){
            if(listaDelitos.get(i).getId_delito() == id){
                return listaDelitos.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Delito> getListaDelitos(){
        if(listaDelitos == null){
            buscarTodos();
        }
        return listaDelitos;
    }
    
    
    
}
