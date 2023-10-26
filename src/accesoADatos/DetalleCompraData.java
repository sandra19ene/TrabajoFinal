package accesoADatos;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
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

    public void generarDetalleCompra(int cantidad, double precio,double subTotal, int idCompra, int idProducto) {
        String sql = "INSERT INTO detallecompra (cantidad, precioCosto,subTotal,idCompra, idProducto) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int idDetalle = 0;
            ps.setInt(1, cantidad);
            ps.setDouble(2, precio);
            ps.setDouble(3, subTotal);           
            ps.setInt(4, idCompra);
            ps.setInt(5, idProducto);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idDetalle = rs.getInt(1);
            

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'detallecompra'/" + ex.getMessage());
        }
    }

    //MÉTODOS PARA LISTAR
    public List<DetalleCompra> comprasPorFecha(LocalDate fecha) {
        ArrayList<DetalleCompra> listaCompras = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT detallecompra.idCompra, proveedor.razonSocial, detallecompra.idProducto, producto.nombreProducto, detallecompra.cantidad, detallecompra.precioCosto, compra.fecha "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "JOIN proveedor ON proveedor.idProveedor=compra.idProveedor "
                    + "WHERE fecha=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                DetalleCompra detalleCompra = new DetalleCompra();
                Producto producto = new Producto();
                Proveedor proveedor = new Proveedor();
                
                compra.setIdCompra(rs.getInt("idCompra"));
                
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                compra.setProveedor(proveedor);
                
                producto.setIdProducto(rs.getInt("idProducto"));
                
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

    public List<DetalleCompra> comprasPorProveedor(int idProveedor) {
        ArrayList<DetalleCompra> listaCompras = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT detallecompra.idCompra, proveedor.razonSocial, detallecompra.idProducto, producto.nombreProducto, detallecompra.cantidad, detallecompra.precioCosto, compra.fecha "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "JOIN proveedor ON proveedor.idProveedor=compra.idProveedor "
                    + "WHERE compra.idProveedor=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                DetalleCompra detalleCompra = new DetalleCompra();
                Producto producto = new Producto();
                Proveedor proveedor = new Proveedor();
                
                compra.setIdCompra(rs.getInt("idCompra"));
                
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                compra.setProveedor(proveedor);
                
                producto.setIdProducto(rs.getInt("idProducto"));
                
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

    public List<DetalleCompra> productosPorCompra(int idCompra) {
        ArrayList<DetalleCompra> listaProductos = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT detallecompra.idCompra, proveedor.razonSocial, detallecompra.idProducto, producto.nombreProducto, detallecompra.cantidad, detallecompra.precioCosto, compra.fecha "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "JOIN proveedor ON proveedor.idProveedor=compra.idProveedor "
                    + "WHERE compra.idCompra=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                DetalleCompra detalleCompra = new DetalleCompra();
                Producto producto = new Producto();
                Proveedor proveedor = new Proveedor();
                
                compra.setIdCompra(rs.getInt("idCompra"));
                
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                compra.setProveedor(proveedor);
                
                producto.setIdProducto(rs.getInt("idProducto"));
                
                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);
                
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                
                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));

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

   public List<DetalleCompra> obtenerDetalleCompraFull(int idCompra) {
    ArrayList<DetalleCompra> listaCompra = new ArrayList<DetalleCompra>();
    String sql = "SELECT detallecompra.idDetalle, detallecompra.cantidad, detallecompra.precioCosto, detallecompra.subTotal, " +
                 "producto.nombreProducto, producto.descripcion, proveedor.razonSocial,compra.fecha " +
                 "FROM compra " +
                 "INNER JOIN detallecompra ON detallecompra.idCompra = compra.idCompra " +
                 "INNER JOIN producto ON producto.idProducto = detallecompra.idProducto " +
                 "INNER JOIN proveedor ON proveedor.idProveedor = compra.idProveedor " +
                 "WHERE compra.idCompra = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCompra);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) { // Cambiado a while para manejar múltiples resultados
            DetalleCompra detalleCompra = new DetalleCompra();
            Compra compra = new Compra();
            Producto producto = new Producto();
            Proveedor proveedor = new Proveedor();

            detalleCompra.setIdDetalle(rs.getInt("idDetalle"));
            detalleCompra.setCantidad(rs.getInt("cantidad"));
            detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
            detalleCompra.setSubTotal(rs.getDouble("subTotal"));

            proveedor.setRazonSocial(rs.getString("razonSocial"));
            compra.setProveedor(proveedor);

            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setDescripcion(rs.getString("descripcion"));
           compra.setFecha(rs.getDate("fecha").toLocalDate());
            detalleCompra.setProducto(producto);

            detalleCompra.setCompra(compra);
            
            listaCompra.add(detalleCompra);
        }

        return listaCompra;
    } catch (SQLException ex) {
        ex.printStackTrace(); 
    }

    return null; 
   }


   
    public List<DetalleCompra> productoMasCompradoEntreFechas(LocalDate fecha1, LocalDate fecha2) {
        ArrayList<DetalleCompra> listaProductos = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT producto.idProducto, producto.nombreProducto, SUM(detallecompra.cantidad) AS cantidadUnidades "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "WHERE compra.fecha BETWEEN ? AND ? "
                    + "GROUP BY producto.nombreProducto "
                    + "ORDER BY cantidadUnidades DESC "
                    + "LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha1));
            ps.setDate(2, Date.valueOf(fecha2));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();

                Producto producto = new Producto();
                
                producto.setIdProducto(rs.getInt("idProducto"));
                
                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);
                
                int total = rs.getInt("cantidadUnidades");
                detalleCompra.setCantidad(total);
                
                listaProductos.add(detalleCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'detalleproducto'/ " + ex.getMessage());
        }
        return listaProductos;
    }
    
    public List<DetalleCompra> productoPorProveedor(int idProveedor) {
        ArrayList<DetalleCompra> listaProductos = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT producto.idProducto, producto.nombreProducto, SUM(detallecompra.cantidad) AS cantidadUnidades "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "JOIN proveedor ON proveedor.idProveedor=compra.idProveedor "
                    + "WHERE proveedor.idProveedor = ? "
                    + "GROUP BY producto.nombreProducto "
                    + "ORDER BY cantidadUnidades DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();

                Producto producto = new Producto();
                
                producto.setIdProducto(rs.getInt("idProducto"));
                
                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);
                
                int total = rs.getInt("cantidadUnidades");
                detalleCompra.setCantidad(total);
                
                listaProductos.add(detalleCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'detalleproducto'/ " + ex.getMessage());
        }
        return listaProductos;
    }
}
