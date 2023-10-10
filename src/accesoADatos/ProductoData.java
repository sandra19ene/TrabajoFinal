
package accesoADatos;

import entidades.Producto;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ProductoData {
    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }
    public Producto buscarProducto(String nombre){
        String sql = "SELECT  * FROM producto WHERE nombreProducto=? ";
        Producto produc = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            produc = new Producto();
            produc.setIdProducto(rs.getInt("idProducto"));
            produc.setNombreProducto(rs.getString("nombreProducto"));
            produc.setDescripcion(rs.getString("descripcion"));
            produc.setPrecioActual(rs.getDouble("precioActual"));
            produc.setStock(rs.getInt("stock"));
            produc.setCategoria(rs.getString("categoria"));
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe");
        }
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());
    }
    return produc;
    }
    public void guardarProducto(Producto producto){
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, categoria) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getCategoria());
           
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
    
    public void actualizarProducto(Producto producto){
        String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?,categoria=? WHERE idProducto = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
          
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getCategoria());
            ps.setInt(6, producto.getIdProducto());
            
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'producto'/"+ ex.getMessage());
        }
    }
    
//    public void eliminarProducto(Producto producto){
//        String sql = "UPDATE producto SET estado=? WHERE idProducto = ? ";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setBoolean(1, producto.isEstado());
//            ps.setInt(2, producto.getIdProducto());
//            
//            int exito = ps.executeUpdate();
//
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Estado de producto actualizado");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'producto'/"+ ex.getMessage());
//        }
//    }
    
    
//   public void modificarProducto(Producto producto) {
//    String sql = "UPDATE producto SET nombreProducto = ?, descripcion = ?,precioActual = ?, stock = ?, estado = ? WHERE idProducto = ?";
//    
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, producto.getNombreProducto());
//        ps.setString(2, producto.getDescripcion());
//        ps.setDouble(3, producto.getPrecioActual());
//        ps.setInt(4, producto.getStock());
//        ps.setBoolean(5, producto.isEstado());
//        ps.setInt(6, producto.getIdProducto());
//        
//        int exito = ps.executeUpdate();
//
//        if (exito == 1) {
//            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encontró el producto con el ID especificado");
//        }
//
//        ps.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'producto'/"+ ex.getMessage());
//    }
//}
//    
     public void eliminarProducto(int idProducto){
    String sql = "DELETE FROM producto WHERE idProducto = ? ";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idProducto);
        
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
        }         
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'producto'/"+ ex.getMessage());
    }
}

    
    
    public List<Producto> listaProductos() {
    String sql = "SELECT * FROM producto ";   
    List<Producto> productos = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Producto producto = new Producto();
       
            producto.setIdProducto(rs.getInt("idProducto")); 
            producto.setNombreProducto(rs.getString("nombreProducto")); 
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecioActual(rs.getDouble("precioActual"));
            producto.setStock(rs.getInt("stock"));
            producto.setCategoria(rs.getString("categoria"));
            

            productos.add(producto);
        }

        rs.close(); 
        ps.close(); 

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
    }

    return productos;
}
    
//     public void consultaProveedor (JComboBox proveedor) {
//    String sql = "SELECT nombre FROM proveedor ";   
//    List<Producto> productos = new ArrayList<>();
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//           
//       
//            
//           proveedor.addItem(rs.getString("razonSocial"));
//            
//        }
//
//        rs.close(); 
//        ps.close(); 
//
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
//    }
//
//    
//}
    
}
