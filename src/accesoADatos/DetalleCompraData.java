
package accesoADatos;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DetalleCompraData {
    private Connection con = null;

    public DetalleCompraData() {
        con = Conexion.getConexion();
    }
    
    public void generarDetalleCompra(DetalleCompra detComp, int idCompra, int idProducto){
        String sql = "INSERT INTO detallecompra (cantidad, precioCosto, idCompra, idProducto) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, detComp.getCantidad());
            ps.setDouble(2, detComp.getPrecioCosto());
            ps.setInt(3, idCompra);
            ps.setInt(4, idProducto);

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                detComp.setIdDetalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle de Compra generado.");

            }
            ps.close();
                      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'detallecompra'/"+ ex.getMessage());
        }
    }
    
    
    //MÉTODOS PARA LISTAR
    public List<DetalleCompra> productosPorFecha(LocalDate fecha) {
        ArrayList<DetalleCompra> listaProductos = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT cantidad, producto.nombreProducto, precioCosto, compra.fecha"
                    + " FROM detallecompra"
                    + " JOIN producto ON producto.idProducto=detalleCompra.idProducto"
                    + " JOIN compra ON compra.idCompra=detalleCompra.idCompra"
                    + " WHERE compra.fecha=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();

                detalleCompra.setCantidad(rs.getInt("cantidad"));

                Producto producto = new Producto();
                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);

                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));

                Compra compra = new Compra();
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                detalleCompra.setCompra(compra);

                listaProductos.add(detalleCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'detallecompra': " + ex.getMessage());
        }
        return listaProductos;
    }
    
    public List<DetalleCompra> comprasPorProveedor(int idProveedor){
        ArrayList<DetalleCompra> listaCompras = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT compra.idCompra, producto.nombreProducto, detallecompra.cantidad, detallecompra.precioCosto, fecha "
                    + "FROM compra "
                    + "JOIN proveedor ON proveedor.idProveedor=compra.idProveedor "
                    + "JOIN detallecompra ON detallecompra.idCompra=compra.idCompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "WHERE proveedor.idProveedor=? ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();
                
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                detalleCompra.setCompra(compra);

                Producto producto = new Producto();
                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);
                
                detalleCompra.setCantidad(rs.getInt("cantidad"));

                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));

                compra.setFecha(rs.getDate("fecha").toLocalDate());
                detalleCompra.setCompra(compra);

                listaCompras.add(detalleCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'detallecompra': " + ex.getMessage());
        }
        return listaCompras;
    }
    
    
}
