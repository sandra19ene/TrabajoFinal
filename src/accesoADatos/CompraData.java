package accesoADatos;

import entidades.Compra;

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

    public void realizarCompra(int idProveedor, LocalDate fecha) {
        Compra comp=new Compra();
        String sql = "INSERT INTO compra (idProveedor, fecha) VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idProveedor);
            ps.setDate(2, Date.valueOf(fecha));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                comp.setIdCompra(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
               
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'compra '/" + ex.getMessage());
        }
    }

    public void eliminarCompra(int idCompra) {
        String sql = "DELETE FROM compra WHERE idCompra = ?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCompra);
            int resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Compra eliminada exitosamente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra  " + ex.getMessage());

        }
    
    }
    
    public int obtenerIdCompra(){
        String sql = "SELECT MAX(idCompra) AS ultimoId FROM compra";
        int ultId = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                
                ultId = rs.getInt("ultimoId");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla 'compra '/ "+ ex.getMessage());
        }
        return ultId;
    }
    
    
public Compra obtenerCompraPorId(int idCompra) {
    String sql = "SELECT * FROM compra WHERE idCompra = ?";
    Compra compra = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCompra);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            compra = new Compra();
            compra.setIdCompra(rs.getInt("idCompra"));
         
            compra.setFecha(rs.getDate("fecha").toLocalDate());
           
           
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'compra' / " + ex.getMessage());
    }

    return compra;
}



    
}
