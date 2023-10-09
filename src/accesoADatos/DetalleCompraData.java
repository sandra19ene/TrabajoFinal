
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
    public /*List<DetalleCompra>*/void productosPorFecha(LocalDate fecha) {
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
//        return listaProductos;

        System.out.println("DETALLE DE PRODUCTOS COMPRADOS EL: "+fecha);
        System.out.println("====================================");
          for (DetalleCompra listaProducto : listaProductos) {
            System.out.println("Cantidad: " + listaProducto.getCantidad());
            System.out.println("Producto: " + listaProducto.getProducto().getNombreProducto());
            System.out.println("Precio: " + listaProducto.getPrecioCosto());
            System.out.println("_______________________________");
        }
    }
    
    public /*List<DetalleCompra>*/ void comprasPorProveedor(int idProveedor){
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
//        return listaCompras;
        System.out.println("DETALLE DE COMPRAS DEL PROVEEDOR ID: "+idProveedor);
        System.out.println("====================================");
        for (DetalleCompra listaCompra : listaCompras) {
            System.out.println("ID Compra"+listaCompra.getCompra().getIdCompra());
            System.out.println("Producto: "+listaCompra.getProducto().getNombreProducto());
            System.out.println("Cantidad: "+listaCompra.getCantidad());
            System.out.println("Precio: "+listaCompra.getPrecioCosto());
            System.out.println("Fecha: "+listaCompra.getCompra().getFecha());
            System.out.println("_____________________________");
        }
    }
    
    public /*List<DetalleCompra>*/ void productosPorCompra(int idCompra) {
        ArrayList<DetalleCompra> listaProductos = new ArrayList<DetalleCompra>();

        try {
            String sql = "SELECT detallecompra.idProducto, producto.nombreProducto, producto.stock, precioCosto, proveedor.razonSocial "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "JOIN proveedor ON proveedor.idProveedor=compra.idProveedor "
                    + "WHERE detallecompra.idCompra=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();

                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                detalleCompra.setProducto(producto);

                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);

                producto.setStock(rs.getInt("stock"));
                detalleCompra.setProducto(producto);

                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));

                Proveedor proveedor = new Proveedor();
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                Compra compra = new Compra();
                compra.setProveedor(proveedor);
                detalleCompra.setCompra(compra);

                listaProductos.add(detalleCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'detallecompra': " + ex.getMessage());
        }

//        return listaProductos;

            System.out.println("Detalle de compra ID: "+idCompra);
            System.out.println("====================================");    
        for (DetalleCompra listaProducto : listaProductos) {
            System.out.println("ID Producto: "+listaProducto.getProducto().getIdProducto());
            System.out.println("Producto: "+listaProducto.getProducto().getNombreProducto());
            System.out.println("Stock "+listaProducto.getProducto().getStock());
            System.out.println("Precio: "+listaProducto.getPrecioCosto());
            System.out.println("Proveedor: "+listaProducto.getCompra().getProveedor().getRazonSocial());
            System.out.println("_______________________________");
        }
    }

    public /*List<DetalleCompra>*/ void productoMasVendidoPorFechas(LocalDate fecha1, LocalDate fecha2){
        ArrayList<DetalleCompra> listaProductos = new ArrayList<DetalleCompra>();

        try {
            String sql="SELECT detallecompra.idProducto, producto.nombreProducto, COUNT(*) AS total "
                    + "FROM detallecompra "
                    + "JOIN producto ON producto.idProducto=detallecompra.idProducto "
                    + "JOIN compra ON compra.idCompra=detallecompra.idCompra "
                    + "WHERE compra.fecha BETWEEN ? AND ? "
                    + "GROUP BY producto.nombreProducto "
                    + "ORDER BY total DESC "
                    + "LIMIT 1";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha1));
            ps.setDate(2, Date.valueOf(fecha2));
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();

                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                detalleCompra.setProducto(producto);

                producto.setNombreProducto(rs.getString("nombreProducto"));
                detalleCompra.setProducto(producto);
                
                int total = rs.getInt("total");
                
                listaProductos.add(detalleCompra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erros al acceder a la tabla 'detalleproducto'/ "+ ex.getMessage());
        }
//        return listaProductos;
        System.out.println("Producto más comprado entre fechas: "+fecha1+" y "+fecha2);
            System.out.println("====================================");    
        for (DetalleCompra listaProducto : listaProductos) {
            System.out.println("ID Producto: "+listaProducto.getProducto().getIdProducto());
            System.out.println("Producto: "+listaProducto.getProducto().getNombreProducto()); 
            System.out.println("_______________________________");
        }
        
    }
    
}