package Modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class UConnection implements Serializable {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if(conn == null) {
                String driver = "com.mysql.jdbc.Driver";
                String usr = "MrLennon";
                String pwd = "123456";
                String bd = "delitoscdmx";
                String url = "jdbc:mysql://127.0.0.1:3306/" + bd;

                Class.forName(driver);
                System.out.println("Conectando a la base de datos...");
                conn = DriverManager.getConnection(url, usr, pwd);
            }
            return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }
}
