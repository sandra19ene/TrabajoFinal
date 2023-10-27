
package accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "equipo45-turnonoche-provemax";
    private static final String USUARIO = "root";
    private static final String PASSWORD ="";
    private static Connection connection = null;

    private Conexion() {
    }

    public static Connection getConexion() {

        if (connection == null) {

            try {

                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                
                JOptionPane.showMessageDialog(null, "CONECTADO A LA BASE DE DATOS");

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar driver" + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion" + ex.getMessage());
            }
        }

        return connection;
    }

    
}
