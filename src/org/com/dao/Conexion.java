package org.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author lrvera
 */
public class Conexion {
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/conta";
    private static String usuario = "postgres";
    private static String clave = "1234";
    private static Connection con;
    
    public static Connection getConexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la BD \n"+e.getMessage());
        }
        return con;
    }
}
