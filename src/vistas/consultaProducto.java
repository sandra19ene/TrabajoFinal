/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.DetalleCompraData;
import accesoADatos.ProveedorData;
import entidades.DetalleCompra;
import entidades.Proveedor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class consultaProducto extends javax.swing.JFrame {

    private DefaultTableModel modelo4 = new DefaultTableModel() {
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
    
    
    public consultaProducto() {
        initComponents();
        jDateFecha1.getDateEditor().setEnabled(false);
        jDateFecha2.getDateEditor().setEnabled(false);
        cargarCabeceraConsultasProductos();
        cargarComboProve2();
        
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
        jBsalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultaProduc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDateFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateFecha1 = new com.toedter.calendar.JDateChooser();
        jcProve = new javax.swing.JComboBox<>();
        jbStockBajo = new javax.swing.JButton();
        jbMasComprado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBsalir.setText("salir");
        jBsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBsalirMouseClicked(evt);
            }
        });
        jPanel1.add(jBsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Más comprado entre fechas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 80, 180, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Por Proveedor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 120, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Con stock bajo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 100, 20));

        jtConsultaProduc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtConsultaProduc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 690, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 40));

        jPanel2.setBackground(new java.awt.Color(6, 60, 140));
        jPanel2.setForeground(new java.awt.Color(6, 60, 140));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 60));
        jPanel1.add(jDateFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("y");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 80, 10, -1));
        jPanel1.add(jDateFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 140, -1));

        jcProve.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Proveedor" }));
        jcProve.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcProveItemStateChanged(evt);
            }
        });
        jPanel1.add(jcProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 160, -1));

        jbStockBajo.setText("Listar");
        jbStockBajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbStockBajoMouseClicked(evt);
            }
        });
        jPanel1.add(jbStockBajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jbMasComprado.setText("Listar");
        jbMasComprado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMasCompradoMouseClicked(evt);
            }
        });
        jPanel1.add(jbMasComprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBsalirMouseClicked

        dispose();
                
    }//GEN-LAST:event_jBsalirMouseClicked

    private void jbMasCompradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMasCompradoMouseClicked
        modelo4.setRowCount(0);
        masCompradoEntreFechas();
    }//GEN-LAST:event_jbMasCompradoMouseClicked

    private void jcProveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcProveItemStateChanged
        modelo4.setRowCount(0);
        productosPorProve();
    }//GEN-LAST:event_jcProveItemStateChanged

    private void jbStockBajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbStockBajoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbStockBajoMouseClicked

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
            java.util.logging.Logger.getLogger(consultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalir;
    private com.toedter.calendar.JDateChooser jDateFecha1;
    private com.toedter.calendar.JDateChooser jDateFecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMasComprado;
    private javax.swing.JButton jbStockBajo;
    private javax.swing.JComboBox<String> jcProve;
    private javax.swing.JTable jtConsultaProduc;
    // End of variables declaration//GEN-END:variables

    public void cargarCabeceraConsultasProductos(){
        
        modelo4.addColumn("Producto");
        modelo4.addColumn("Cantidad");

        jtConsultaProduc.setModel(modelo4);
    }
    
    public void cargarComboProve2() {
        ProveedorData prove = new ProveedorData();
        for (Proveedor proveedor : prove.listaProveedores()) {
            jcProve.addItem(proveedor.getRazonSocial());
        }
    }
     public void masCompradoEntreFechas(){
         DetalleCompraData deta = new DetalleCompraData();
         Date fechaObtenida1 = jDateFecha1.getDate();
        LocalDate fechaUsar1 = fechaObtenida1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date fechaObtenida2 = jDateFecha2.getDate();
        LocalDate fechaUsar2 = fechaObtenida2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        
        for (DetalleCompra d : deta.productoMasCompradoEntreFechas(fechaUsar1, fechaUsar2)) {
            modelo4.addRow(new Object[]{
                d.getProducto().getNombreProducto(),
                d.getCantidad()});
        }
     }
     
     public void productosPorProve() {
        
        if( ! jcProve.getSelectedItem().toString().equals("Seleccione Proveedor")){ 
        DetalleCompraData deta = new DetalleCompraData();
        ProveedorData prove = new ProveedorData();
        
        String item = (String) jcProve.getSelectedItem();
        Proveedor proveedor = prove.buscarProveedor(item);
        int idProveedor = proveedor.getIdProveedor();
        
        for (DetalleCompra d : deta.productoPorProveedor(idProveedor)) {
            modelo4.addRow(new Object[]{
                d.getProducto().getNombreProducto(),
                d.getCantidad()});
        }
        }
    }
     
}
