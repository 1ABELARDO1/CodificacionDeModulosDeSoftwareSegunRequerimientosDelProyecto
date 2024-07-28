            /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconexionjdbc;

/**
 *
 * @author DELL
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


    /**
     * @param args the command line arguments
     */

        
      
                
    public class EjemploConexionJDBC {
        private static final String url = "jdbc:mysql://localhost:3310/SISTEMAPOS";
        private static final String usuario = "root";
        private static final String password = "";
    
   
    
    public static void main(String[] args) {
        //insertarDatos();
        actualizarDatos();
        eliminarDatos();
        mostrarDatos();
    }

    public static void insertarDatos() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement(); // se crea un objeto
            statement.executeUpdate("INSERT INTO ADMINISTRADOR (NOMBRE, TELEFONO, EMAIL) VALUES('abelardo','3207841165','ABELARDO.LOS@HOTMAIL.ES')");
            System.out.println("Datos insertados correctamente.");
        } catch (SQLException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void actualizarDatos() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("UPDATE administrador SET nombre='juan', telefono='3207841165', email='abelardo.los@hotmail.es' WHERE idadministrador=16");
            System.out.println("Datos actualizados correctamente.");
        } catch (SQLException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public static void eliminarDatos() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("DELETE FROM administrador WHERE idadministrador=17");
            System.out.println("Datos eliminados correctamente.");
        } catch (SQLException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void mostrarDatos() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM administrador");
            while (rs.next()) {
                System.out.println(rs.getInt("idadministrador") + " : " + rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
   }
    
