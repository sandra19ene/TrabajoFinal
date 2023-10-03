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
    
    public void guardarProveedor(Proveedor proveedor){
        String sql = "INSERT INTO proveedor(razonSocial, domicilio, telefono) VALUES (?,?,?)";
        
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
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'proveedor'/"+ ex.getMessage());
        }
    }
    
    public void actualizarProveedor(Proveedor proveedor){
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
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'proveedor'/"+ ex.getMessage());
        }
    }
    
    public void eliminarProveedor(Proveedor proveedor){
        String sql = "DELETE FROM proveedor WHERE idProveedor=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, org.mariadb.jdbc.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, proveedor.getIdProveedor());

            int exito = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Proveedor eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla 'proveedor'" + ex.getMessage());
        }
        
    }
}
