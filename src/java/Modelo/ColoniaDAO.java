/*
 *  author:    Arturo Camargo
 *  mail:      scarturocamargo@gmail.com
 *  license:   Copyright © SC Soluciones en Computacion 2017
 */
package Modelo;

import DTO.Colonia;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Arturo Camargo
 */
public class ColoniaDAO implements Serializable {
    private static ColoniaDAO coloniaDAO;
    private ArrayList<Colonia> listaColonias;

    private ColoniaDAO(){}
    
    public static ColoniaDAO get() {
        if (coloniaDAO == null){
            coloniaDAO = new ColoniaDAO();
        }
        return coloniaDAO;
    }
    
    private void buscarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = UConnection.getConnection();
            String sql = "SELECT * FROM colonia;";
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            listaColonias = new ArrayList<>();
            Colonia d;

            while (rs.next()) {
                d = new Colonia();
                d.setid_colonia(rs.getInt("id_colonia"));
                d.setnombre_colonia(rs.getString("nombre_colonia"));
                listaColonias.add(d);
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
    
    public Colonia buscarPorId(int id) {
        if(listaColonias == null){
            buscarTodos();
        }
        for(int i = 0; i < listaColonias.size(); i++){
            if(listaColonias.get(i).getid_colonia() == id){
                return listaColonias.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Colonia> getListaDelegacion() {
        if(listaColonias == null){
            buscarTodos();
        }
        return listaColonias;
    }
}
