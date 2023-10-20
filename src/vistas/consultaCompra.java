/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;
import accesoADatos.ProductoData;
import accesoADatos.ProveedorData;
import entidades.DetalleCompra;
import entidades.Proveedor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class consultaCompra extends javax.swing.JFrame {

    private DefaultTableModel modelo3 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            if (column == 0) {
                return false;
            } else if (column == 1) {
                return false;
            } else if (column == 2) {
                return false;
            } else if (column == 3) {
                return false;
            } else if (column == 4) {
                return false;
            } else if (column == 5) {
                return false;
            } else if (column == 6) {
                return false;
            } else if (column == 7) {
                return false;
            } else {
                return true;
            }
        }
    };
    public consultaCompra() {
        initComponents();
        jDateCompras.getDateEditor().setEnabled(false);
        cargarCabeceraConsultasCompras();
        cargarComboProve2();
        columnasCompras();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultasCompras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jDateCompras = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jcCompXProve = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtCompXFact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbListarFact = new javax.swing.JButton();
        jbListarFecha = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSalir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalirMouseClicked(evt);
            }
        });
        jPanel1.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 110, -1));

        jtConsultasCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtConsultasCompras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 790, 300));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Por Fecha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 80, 20));

        jDateCompras.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jDateCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 170, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Por Proveedor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 110, 20));

        jcCompXProve.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Proveedor" }));
        jcCompXProve.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCompXProveItemStateChanged(evt);
            }
        });
        jPanel1.add(jcCompXProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 170, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Por Nro de Factura: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 130, 20));
        jPanel1.add(jtCompXFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 170, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CONSULTA DE COMPRAS");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 750, 40));

        jbListarFact.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbListarFact.setText("Listar");
        jbListarFact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbListarFactMouseClicked(evt);
            }
        });
        jPanel1.add(jbListarFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 110, -1));

        jbListarFecha.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbListarFecha.setText("Listar");
        jbListarFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbListarFechaMouseClicked(evt);
            }
        });
        jPanel1.add(jbListarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 110, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wavy-blue-background-free-vector.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_jbSalirMouseClicked

    private void jbListarFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbListarFechaMouseClicked
        jcCompXProve.setSelectedIndex(0);
        modelo3.setRowCount(0);
        cargarTablaComprasPorFecha();
        jDateCompras.setDate(null);
    }//GEN-LAST:event_jbListarFechaMouseClicked

    private void jbListarFactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbListarFactMouseClicked
        jcCompXProve.setSelectedIndex(0);
        modelo3.setRowCount(0);
        cargarTablaComprasPorFactura();
        jtCompXFact.setText("");
    }//GEN-LAST:event_jbListarFactMouseClicked

    private void jcCompXProveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCompXProveItemStateChanged
        modelo3.setRowCount(0);
        cargarTablaComprasPorProveedor();   
    }//GEN-LAST:event_jcCompXProveItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(consultaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultaCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbListarFact;
    private javax.swing.JButton jbListarFecha;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcCompXProve;
    private javax.swing.JTextField jtCompXFact;
    private javax.swing.JTable jtConsultasCompras;
    // End of variables declaration//GEN-END:variables

    public void cargarCabeceraConsultasCompras(){
        
        modelo3.addColumn("N°de Compra");
        modelo3.addColumn("Proveedor");
        modelo3.addColumn("ID Producto");
        modelo3.addColumn("Producto");
        modelo3.addColumn("Cantidad");
        modelo3.addColumn("Precio Unit");
        modelo3.addColumn("Total");
        modelo3.addColumn("Fecha");

        jtConsultasCompras.setModel(modelo3);
    }
    
    public void cargarTablaComprasPorFecha(){
        DetalleCompraData deta = new DetalleCompraData();
        Date fechaObtenida = jDateCompras.getDate();
        LocalDate fechaUsar = fechaObtenida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (DetalleCompra d : deta.comprasPorFecha(fechaUsar)) {
            Double subtotal = d.getPrecioCosto()*d.getCantidad();
            modelo3.addRow(new Object[]{
                d.getCompra().getIdCompra(),
                d.getCompra().getProveedor().getRazonSocial(),
                d.getProducto().getIdProducto(),
                d.getProducto().getNombreProducto(),
                d.getCantidad(),
                d.getPrecioCosto(),
                subtotal.longValue(),
                d.getCompra().getFecha()});
        }
    }
    
    public void cargarComboProve2() {
        ProveedorData prove = new ProveedorData();
        for (Proveedor proveedor : prove.listaProveedores()) {
            jcCompXProve.addItem(proveedor.getRazonSocial());
        }
    }
    
    public void cargarTablaComprasPorProveedor(){
        
        if( ! jcCompXProve.getSelectedItem().toString().equals("Seleccione Proveedor")){
        DetalleCompraData deta = new DetalleCompraData();
        ProveedorData prove = new ProveedorData();
        
        String item = (String) jcCompXProve.getSelectedItem();
        Proveedor proveedor = prove.buscarProveedor(item);
        int idProveedor = proveedor.getIdProveedor();

        for (DetalleCompra d : deta.comprasPorProveedor(idProveedor)) {
            Double subtotal = d.getPrecioCosto()*d.getCantidad();
            modelo3.addRow(new Object[]{
                d.getCompra().getIdCompra(),
                d.getCompra().getProveedor().getRazonSocial(),
                d.getProducto().getIdProducto(),
                d.getProducto().getNombreProducto(),
                d.getCantidad(),
                d.getPrecioCosto(),
                subtotal,
                d.getCompra().getFecha()});
        }
        }
    }

    public void cargarTablaComprasPorFactura() {
        DetalleCompraData deta = new DetalleCompraData();
        try {
            int factura = Integer.parseInt(jtCompXFact.getText());
            boolean facturaEncontrada = false;

            for (DetalleCompra d : deta.productosPorCompra(factura)) {
                Double subtotal = d.getPrecioCosto() * d.getCantidad();

                if (factura == d.getCompra().getIdCompra()) {
                    facturaEncontrada = true;
                    modelo3.addRow(new Object[]{
                        d.getCompra().getIdCompra(),
                        d.getCompra().getProveedor().getRazonSocial(),
                        d.getProducto().getIdProducto(),
                        d.getProducto().getNombreProducto(),
                        d.getCantidad(),
                        d.getPrecioCosto(),
                        subtotal.longValue(),
                        d.getCompra().getFecha()});
                }
            }
            if (!facturaEncontrada) {
                JOptionPane.showMessageDialog(null, "La factura no existe.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingresar número de Factura válido.");
        }
    }

    private void columnasCompras() {

        jtConsultasCompras.setModel(modelo3);

        jtConsultasCompras.getColumnModel().getColumn(0).setPreferredWidth(70);
        jtConsultasCompras.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtConsultasCompras.getColumnModel().getColumn(2).setPreferredWidth(60);
        jtConsultasCompras.getColumnModel().getColumn(3).setPreferredWidth(150);
        jtConsultasCompras.getColumnModel().getColumn(4).setPreferredWidth(60);
        jtConsultasCompras.getColumnModel().getColumn(5).setPreferredWidth(60);
        jtConsultasCompras.getColumnModel().getColumn(6).setPreferredWidth(50);
        jtConsultasCompras.getColumnModel().getColumn(7).setPreferredWidth(60);
    }

}
