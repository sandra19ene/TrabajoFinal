package accesoADatos;

import entidades.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProductoData {
    int sto;
    int pre;
    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
       
    }

    public Producto buscarProducto(String nombre) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto " + ex.getMessage());
        }
        return produc;
    }

    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, categoria,estado) VALUES (?,?,?,?,?,true)";

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'prodcuto '/" + ex.getMessage());
        }
    }

    public void actualizarProducto(Producto producto) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'producto '/" + ex.getMessage());
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
    public void eliminarProducto(int idProducto) {
        String sql = "UPDATE producto SET estado=0 WHERE idProducto = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'producto '/" + ex.getMessage());
        }
    }

    public List<Producto> listaProductos() {
        String sql = "SELECT * FROM producto WHERE estado=1";
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto  " + ex.getMessage());
        }

        return productos;
    }

    public Producto buscarIDProducto(String nombre) {
        String sql = "SELECT  idProducto FROM producto WHERE nombreProducto=? ";
        Producto producto = new Producto();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                producto.setIdProducto(rs.getInt("idProducto"));

            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'producto '/ " + ex.getMessage());
        }
        return producto;
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
  


   public Producto obtenerProducto(int id) {
    String sql = "SELECT * FROM producto WHERE idProducto = ?";
    Producto producto = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getString("categoria"));
        }

        rs.close(); 
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
    }

    return producto;
}


           

    

    public int actualizarStock(int cant,int idPro) {
        String sql = "UPDATE producto SET stock=? WHERE idProducto = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cant);
            ps.setInt(2, idPro);
           
     

            int exito = ps.executeUpdate();

           if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Stock actualizado  con éxito");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'producto '/" + ex.getMessage());
        }
        
        return sto;
    }

    public int actualizarPrecio(int precio,int idPro) {
        String sql = "UPDATE producto SET precioActual=? WHERE idProducto = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, precio);
            ps.setInt(2, idPro);
           
     

            int exito = ps.executeUpdate();

           if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Precio actualizado  con éxito");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'producto '/" + ex.getMessage());
        }
        
        return pre;
    }
    
    public List<Producto> stockMinimo(){
       String sql = "SELECT idProducto, nombreProducto, stock FROM producto WHERE stock < 200 AND estado =1";
        List<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setStock(rs.getInt("stock"));

                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
        
        return productos;
   }
    
}
