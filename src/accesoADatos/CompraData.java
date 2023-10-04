
package accesoADatos;

import entidades.Compra;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class CompraData {
    private Connection con = null;

    public CompraData() {
        con = Conexion.getConexion();
    }
    
    public void realizarCompra(int idProveedor, Compra comp){
        String sql = "INSERT INTO compra (idProveedor, fecha) VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idProveedor);
            ps.setDate(2, Date.valueOf(comp.getFecha()));
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                comp.setIdCompra(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");

            }
            ps.close();
                      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'compra'/"+ ex.getMessage());
        }
    }
}
