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
import java.awt.Color;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;

import java.util.List;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class factura extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    menu m = new menu();

    JFrame frame = new JFrame();
    DetalleCompra dc = new DetalleCompra();
    DetalleCompraData dcd = new DetalleCompraData();
    ProveedorData prove = new ProveedorData();
    Proveedor pro = new Proveedor();

    public factura(int idCompra) {
        initComponents();
        jlfechafa.setText(m.fechaActual());
        jlNroCompra.setText("" + idCompra);
        cargarCabezera();
        cargarTablaDetalleFac(idCompra);
        calcularTotal();
        pro = prove.getDatos(idCompra);
        razonSocialFac.setText(pro.getRazonSocial());
        DomicilioFac.setText(pro.getDomicilio());
        TelefonoFac.setText(pro.getTelefono());
        generarNroCompra();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        facturaView = new javax.swing.JPanel();
        jlNroCompra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlfechafa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TelefonoFac = new javax.swing.JTextField();
        razonSocialFac = new javax.swing.JTextField();
        DomicilioFac = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtfactura = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbImprimir = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(570, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        facturaView.setBackground(new java.awt.Color(255, 255, 255));
        facturaView.setEnabled(false);
        facturaView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlNroCompra.setBackground(new java.awt.Color(255, 255, 255));
        jlNroCompra.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlNroCompra.setForeground(new java.awt.Color(0, 0, 0));
        jlNroCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNroCompra.setAlignmentX(0.5F);
        jlNroCompra.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        facturaView.add(jlNroCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 150, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("TOTAL A PAGAR: $");
        facturaView.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 160, -1));

        jtTotal.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jtTotal.setForeground(new java.awt.Color(0, 0, 0));
        jtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        facturaView.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, 170, 40));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("N° de Compra:");
        facturaView.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 120, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOPVM.png"))); // NOI18N
        facturaView.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 220, 160));

        jlfechafa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlfechafa.setForeground(new java.awt.Color(0, 0, 0));
        jlfechafa.setAlignmentX(1.0F);
        jlfechafa.setAlignmentY(1.0F);
        jlfechafa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        facturaView.add(jlfechafa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 140, 40));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Av.Group 45 Caba.  Tel. 4545-4545");
        facturaView.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 270, 20));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAutoscrolls(true);
        facturaView.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 50, 180));
        facturaView.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 248, 585, -1));
        facturaView.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 590, 10));
        facturaView.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 178, 585, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Razon Social:");
        facturaView.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Domicilio:");
        facturaView.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefono:");
        facturaView.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        TelefonoFac.setBackground(new java.awt.Color(255, 255, 255));
        TelefonoFac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TelefonoFac.setForeground(new java.awt.Color(0, 0, 0));
        TelefonoFac.setBorder(null);
        TelefonoFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TelefonoFac.setSelectionColor(new java.awt.Color(255, 255, 255));
        TelefonoFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoFacActionPerformed(evt);
            }
        });
        facturaView.add(TelefonoFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 150, 20));

        razonSocialFac.setBackground(new java.awt.Color(255, 255, 255));
        razonSocialFac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        razonSocialFac.setForeground(new java.awt.Color(0, 0, 0));
        razonSocialFac.setBorder(null);
        razonSocialFac.setCaretColor(new java.awt.Color(255, 255, 255));
        razonSocialFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        razonSocialFac.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        razonSocialFac.setSelectionColor(new java.awt.Color(255, 255, 255));
        razonSocialFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                razonSocialFacActionPerformed(evt);
            }
        });
        facturaView.add(razonSocialFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 270, 20));

        DomicilioFac.setBackground(new java.awt.Color(255, 255, 255));
        DomicilioFac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        DomicilioFac.setForeground(new java.awt.Color(0, 0, 0));
        DomicilioFac.setBorder(null);
        DomicilioFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        DomicilioFac.setSelectionColor(new java.awt.Color(255, 255, 255));
        DomicilioFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DomicilioFacActionPerformed(evt);
            }
        });
        facturaView.add(DomicilioFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 350, 20));

        jtfactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jtfactura.setEnabled(false);
        jScrollPane2.setViewportView(jtfactura);

        facturaView.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 590, 280));
        facturaView.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 585, 10));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Fecha de Compra:");
        facturaView.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 150, 40));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("PROVEMAX S.A");
        facturaView.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 150, 20));

        getContentPane().add(facturaView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 650));

        jbImprimir.setBackground(new java.awt.Color(102, 102, 102));
        jbImprimir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbImprimir.setForeground(new java.awt.Color(255, 255, 255));
        jbImprimir.setText("IMPRIMIR");
        jbImprimir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(jbImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 170, 50));

        jbSalir.setBackground(new java.awt.Color(102, 102, 102));
        jbSalir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalirMouseClicked(evt);
            }
        });
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 180, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 630, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TelefonoFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoFacActionPerformed

    private void razonSocialFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_razonSocialFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_razonSocialFacActionPerformed

    private void DomicilioFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DomicilioFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DomicilioFacActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed

        Toolkit tk = facturaView.getToolkit();
        PrintJob pj = tk.getPrintJob(this, null, null);
        Graphics g = pj.getGraphics();
        facturaView.print(g);
        g.dispose();
        pj.end();

    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked


        dispose();


    }//GEN-LAST:event_jbSalirMouseClicked

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalirActionPerformed

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
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new factura().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DomicilioFac;
    private javax.swing.JTextField TelefonoFac;
    private javax.swing.JPanel facturaView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlNroCompra;
    private javax.swing.JLabel jlfechafa;
    private javax.swing.JLabel jtTotal;
    private javax.swing.JTable jtfactura;
    private javax.swing.JTextField razonSocialFac;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaDetalleFac(int idCompra) {
        List<DetalleCompra> lista = dcd.obtenerDetalleCompraFull(idCompra);

        modelo = (DefaultTableModel) jtfactura.getModel();
        Object[] ob = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getCantidad();
            ob[1] = lista.get(i).getProducto().getNombreProducto();
            ob[2] = lista.get(i).getPrecioCosto();
            ob[3] = lista.get(i).getSubTotal();
            modelo.addRow(ob);
        }

        jtfactura.setModel(modelo);
        JTableHeader header = jtfactura.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.blue);
        header.setForeground(Color.black);

        TableColumnModel columnModel = jtfactura.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);

    }

    private void cargarCabezera() {

        modelo.addColumn("Cantidad");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio ");
        modelo.addColumn("SubTotal");

        jtfactura.setModel(modelo);

    }

    private void calcularTotal() {
        double total = 0;

        for (int i = 0; i < jtfactura.getRowCount(); i++) {
            Object subtt = jtfactura.getValueAt(i, 3);
            total += Double.parseDouble(subtt.toString());
        }

        jtTotal.setText("" + total);

    }

//private void pdf(){
//        try{
//        
//        FileOutputStream archivo;
//        File file = new File("src/pdf/factura.pdf");
//        archivo = new FileOutputStream(file);
//       Document doc= new Document();
//       PdfWriter.getInstance(doc, archivo);
//       doc.open();
//       Image img = Image.getInstance("src/imagenes/LOGOPVM.png");
//       
//       Paragraph fecha = new Paragraph();
//       
//       Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLUE);
//       fecha.add(Chunk.NEWLINE);
//       Date date = new Date();
//       fecha.add("Factura: 1\n"+"Fecha: "+ new SimpleDateFormat("dd-mm-yyyy").format(date)+ "\n\n");
//       PdfPTable Encabezado = new PdfPTable(4);
//       Encabezado.setWidthPercentage(100);
//       Encabezado.getDefaultCell().setBorder(0);
//       float[] ColumnaEncabezado = new float[]{20f,40f,70f,20f,20f};
//       Encabezado.setWidths(ColumnaEncabezado);
//       Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
//       
//       Encabezado.addCell(img);
//      // String ruc ="2125565654";
//       String nom ="Provemax";
//       String dir ="Av.Groups 45 ";
//       String tel ="1130975132";
//       
//       Encabezado.addCell("");
//       Encabezado.addCell("Nombre: "+nom+ "\nDireccion: "+dir+ "\nTelefono: " +tel);
//       Encabezado.addCell(fecha);
//       doc.add(Encabezado);
//       
//       
//       doc.close();
//       archivo.close();
//       
//       
//        }catch (Exception e){
//        }
//}
    public void generarNroCompra() {
        Integer nro = dcd.obtenerIdDetalle();

        if (nro < 10) {
            jlNroCompra.setText("000-00000"+nro);
        } else {
            if (nro < 100) {
            jlNroCompra.setText("000-0000"+nro);
            } else {
            if (nro < 1000) {
            jlNroCompra.setText("000-000"+nro);
            
        }
    }
    
        }
    }
}