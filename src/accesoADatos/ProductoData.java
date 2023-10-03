
package accesoADatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ProductoData {
    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarProducto(Producto producto){
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, estado) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");

            }
            ps.close();
                      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'prodcuto'/"+ ex.getMessage());
        }
    }
    
    public void actualizarProdcuto(Producto producto){
        String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=? WHERE idProducto = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getIdProducto());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'producto'/"+ ex.getMessage());
        }
    }
    
    public void eliminarProducto(Producto producto){
        String sql = "UPDATE producto SET estado=? WHERE idProducto = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, producto.isEstado());
            ps.setInt(2, producto.getIdProducto());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Estado de producto actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'producto'/"+ ex.getMessage());
        }
    }
    
    
    
}
