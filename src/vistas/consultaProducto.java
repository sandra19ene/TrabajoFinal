/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.DetalleCompraData;
import accesoADatos.ProductoData;
import accesoADatos.ProveedorData;
import entidades.DetalleCompra;
import entidades.Producto;
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
        jDateFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateFecha1 = new com.toedter.calendar.JDateChooser();
        jcConsulCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jcProve = new javax.swing.JComboBox<>();
        jbStockBajo = new javax.swing.JButton();
        jbMasComprado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBsalir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBsalir.setText("Salir");
        jBsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBsalirMouseClicked(evt);
            }
        });
        jPanel1.add(jBsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 100, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Más comprado entre fechas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Por Proveedor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 110, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Con stock bajo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 110, 20));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 690, 180));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, 680, 40));

        jDateFecha2.setForeground(new java.awt.Color(51, 51, 51));
        jDateFecha2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jDateFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 140, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("y");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 80, 10, -1));

        jDateFecha1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(jDateFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 140, -1));

        jcConsulCategoria.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jcConsulCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoria", "TV y AUDIO", "TECNOLOGIA", "ELECTROHOGAR" }));
        jcConsulCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcConsulCategoriaItemStateChanged(evt);
            }
        });
        jcConsulCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcConsulCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(jcConsulCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 160, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Por Categoria");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 100, 20));

        jcProve.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Proveedor" }));
        jcProve.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcProveItemStateChanged(evt);
            }
        });
        jcProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProveActionPerformed(evt);
            }
        });
        jPanel1.add(jcProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 160, -1));

        jbStockBajo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbStockBajo.setText("Listar");
        jbStockBajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbStockBajoMouseClicked(evt);
            }
        });
        jPanel1.add(jbStockBajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 100, -1));

        jbMasComprado.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbMasComprado.setText("Listar");
        jbMasComprado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMasCompradoMouseClicked(evt);
            }
        });
        jPanel1.add(jbMasComprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 100, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wavy-blue-background-free-vector.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBsalirMouseClicked

        dispose();
                
    }//GEN-LAST:event_jBsalirMouseClicked

    private void jbMasCompradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMasCompradoMouseClicked
        modelo4.setRowCount(0);
        jcProve.setSelectedIndex(0);
        jcConsulCategoria.setSelectedIndex(0);
        masCompradoEntreFechas();
        if (modelo4.getRowCount()==0) {
            JOptionPane.showMessageDialog(this, "No hay compras entre las fechas indicadas");
        }
         
    }//GEN-LAST:event_jbMasCompradoMouseClicked

    private void jcProveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcProveItemStateChanged
        modelo4.setRowCount(0);
        productosPorProve();
        jcConsulCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_jcProveItemStateChanged

    private void jbStockBajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbStockBajoMouseClicked
        jcProve.setSelectedIndex(0);
        jcConsulCategoria.setSelectedIndex(0);
        jDateFecha1.setDate(null);
        jDateFecha2.setDate(null);
        modelo4.setRowCount(0);
        stockBajo();
        if (modelo4.getRowCount()==0) {
            JOptionPane.showMessageDialog(this, "No hay Productos con stock bajo.");
        }    
    }//GEN-LAST:event_jbStockBajoMouseClicked

    private void jcConsulCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcConsulCategoriaItemStateChanged
       modelo4.setRowCount(0);

        productosPorCategoria();
    }//GEN-LAST:event_jcConsulCategoriaItemStateChanged

    private void jcProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProveActionPerformed
        if(jcProve.hasFocus() && modelo4.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Sin compras a este Proveedor");
            jDateFecha1.setDate(null);
            jDateFecha2.setDate(null);
        }else if(jcProve.hasFocus()){
            jDateFecha1.setDate(null);
            jDateFecha2.setDate(null);
        }
       
    }//GEN-LAST:event_jcProveActionPerformed

    private void jcConsulCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcConsulCategoriaActionPerformed
        if(jcConsulCategoria.hasFocus() && modelo4.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Sin compras de esta Categoría");
            jDateFecha1.setDate(null);
            jDateFecha2.setDate(null);
        }else if(jcConsulCategoria.hasFocus()){
            jDateFecha1.setDate(null);
            jDateFecha2.setDate(null);
        }
       
    }//GEN-LAST:event_jcConsulCategoriaActionPerformed

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMasComprado;
    private javax.swing.JButton jbStockBajo;
    private javax.swing.JComboBox<String> jcConsulCategoria;
    private javax.swing.JComboBox<String> jcProve;
    private javax.swing.JTable jtConsultaProduc;
    // End of variables declaration//GEN-END:variables

    public void cargarCabeceraConsultasProductos(){
        modelo4.addColumn("ID Prod");
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
         try {
            DetalleCompraData deta = new DetalleCompraData();
            Date fechaObtenida1 = jDateFecha1.getDate();
            LocalDate fechaUsar1 = fechaObtenida1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date fechaObtenida2 = jDateFecha2.getDate();
            LocalDate fechaUsar2 = fechaObtenida2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if(fechaUsar2.isAfter(fechaUsar1)){
            for (DetalleCompra d : deta.productoMasCompradoEntreFechas(fechaUsar1, fechaUsar2)) {
                modelo4.addRow(new Object[]{
                    d.getProducto().getIdProducto(),
                    d.getProducto().getNombreProducto(),
                    d.getCantidad()});
            }
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese fecha más antigua primero");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Completar fechas");
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
                d.getProducto().getIdProducto(),
                d.getProducto().getNombreProducto(),
                d.getCantidad()});
        }
        }
    }
     
       public void productosPorCategoria() {
        
        if( ! jcConsulCategoria.getSelectedItem().toString().equals("Seleccione Proveedor")){ 
       ProductoData prod=new ProductoData();
        
        String item = (String) jcConsulCategoria.getSelectedItem();
    
        
        for (Producto d : prod.listaProductosPorCategoria(item)) {
            modelo4.addRow(new Object[]{
                d.getIdProducto(),
                d.getNombreProducto(),
                d.getStock()});
        }
        }
    }
     
     public void stockBajo(){
        ProductoData prod = new ProductoData();
        
        for (Producto p : prod.stockMinimo()) {
            modelo4.addRow(new Object[]{
                p.getIdProducto(),
                p.getNombreProducto(),
                p.getStock()});
        }
    }
     
}
