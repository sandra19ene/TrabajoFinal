/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;


import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ProveedorData {

    private Connection con = null;
    
    public ProveedorData() {
        con = Conexion.getConexion();
    }
    
    public void guardarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor(razonSocial, domicilio, telefono,estado) VALUES (?,?,?,true)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente.");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'proveedor'/" + ex.getMessage());
        }
    }
    
    public void actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET razonSocial=? , domicilio=? , telefono = ? WHERE idProveedor=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            ps.setInt(4, proveedor.getIdProveedor());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Proveedor actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'proveedor'/" + ex.getMessage());
        }
    }
    

    


    
   public void eliminarProveedor(int idProveedor) {
        String sql = "UPDATE proveedor SET estado=0 WHERE idProveedor = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'proveedor '/" + ex.getMessage());
        }
    }
    
    public List<Proveedor> listaProveedores() {
        String sql = "SELECT * FROM proveedor WHERE estado=1";
        List<Proveedor> prove = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("idProveedor"));
                p.setRazonSocial(rs.getString("razonSocial"));
                p.setDomicilio(rs.getString("domicilio"));
                p.setTelefono(rs.getString("telefono"));
                
               
                
                prove.add(p);
            }
            
            rs.close();            
            ps.close();            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor " + ex.getMessage());
        }
        
        return prove;
    }
    
    
    
    public Proveedor buscarProveedor( String razonSocial) {
    String sql = "SELECT  * FROM proveedor WHERE razonSocial=? ";
    Proveedor proveedor = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, razonSocial);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            proveedor = new Proveedor();
            proveedor.setIdProveedor(rs.getInt("idProveedor"));
            proveedor.setRazonSocial(rs.getString("razonSocial"));
            proveedor.setDomicilio(rs.getString("domicilio"));
            proveedor.setTelefono(rs.getString("telefono"));
        } else {
            JOptionPane.showMessageDialog(null, "El proveedor no existe");
        }
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proveedor" + ex.getMessage());
    }
    return proveedor;
}

    

   public Proveedor getDatos(int idCompra){
    String sql = "SELECT proveedor.*, compra.* " +
                 "FROM proveedor " +
                 "INNER JOIN compra ON proveedor.idProveedor = compra.idProveedor " +
                 "WHERE compra.idCompra = ?";
    
    Proveedor pr = new Proveedor();
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCompra);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            pr.setRazonSocial(rs.getString("razonSocial"));
            pr.setDomicilio(rs.getString("domicilio"));
            pr.setTelefono(rs.getString("telefono"));
          
        }
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
    }
    return pr;
}

   

}
