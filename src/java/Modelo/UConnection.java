package Modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class UConnection implements Serializable {
    private static Connection conn1 = null;
    private static Connection conn2 = null;
    private static Connection conn3 = null;
    private static Connection conn4 = null;

    public static Connection getConnection1() {
        try {
            if(conn1 == null) {
                String driver = "com.mysql.jdbc.Driver";
                String usr = "MrLennon";
                String pwd = "123456";
                String bd = "delitoscdmx_norte_general";
                String url = "jdbc:mysql://127.0.0.1:3306/";

                Class.forName(driver);
                System.out.println("Conectando a la base de datos...");
                conn1 = DriverManager.getConnection(url + bd, usr, pwd);
            }
            return conn1;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }
    
    public static Connection getConnection2() {
        try {
            if(conn2 == null) {
                String driver = "com.mysql.jdbc.Driver";
                String usr = "MrLennon";
                String pwd = "123456";
                String bd = "delitoscdmx_sur_general";
                String url = "jdbc:mysql://127.0.0.1:3306/";

                Class.forName(driver);
                System.out.println("Conectando a la base de datos...");
                conn2 = DriverManager.getConnection(url + bd, usr, pwd);
            }
            return conn2;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }
    
    public static Connection getConnectionR1() {
        try {
            if(conn4 == null) {
                String driver = "com.mysql.jdbc.Driver";
                String usr = "MrLennon";
                String pwd = "123456";
                String bd = "delitosCDMX_Norte_General";
                String url = "jdbc:mysql://35.184.96.43:3306/" + bd;

                Class.forName(driver);
                System.out.println("Conectando a la base de datos...");
                conn4 = DriverManager.getConnection(url, usr, pwd);
            }
            return conn4;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }
    
    public static Connection getConnectionR2() {
        try {
            if(conn3 == null) {
                String driver = "com.mysql.jdbc.Driver";
                String usr = "bddistribuidas";
                String pwd = "crimenescdmx17-i";
                String bd = "delitosCDMX_Sur_General";
                String url = "jdbc:mysql://rds-mysql-crimenescdmx.cmfcq4jc7hw8.us-west-2.rds.amazonaws.com:3306/";

                Class.forName(driver);
                System.out.println("Conectando a la base de datos...");
                conn3 = DriverManager.getConnection(url + bd, usr, pwd);
            }
            return conn3;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }
}
