/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;

import accesoADatos.ProveedorData;
import entidades.Compra;

import entidades.DetalleCompra;
import entidades.Proveedor;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;

import java.util.List;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class factura extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
 

    JFrame frame = new JFrame();
    DetalleCompra dc = new DetalleCompra();
    DetalleCompraData dcd = new DetalleCompraData();
    ProveedorData prove = new ProveedorData();
    Proveedor pro = new Proveedor();
    Compra co = new Compra();
    CompraData cda = new CompraData();

    public factura(int idCompra) {
        initComponents();

        jlNroCompra.setText("" + idCompra);
        cargarCabezera();
        cargarTablaDetalleFac(idCompra);
        calcularTotal(idCompra);
        pro = prove.getDatos(idCompra);
        co = cda.obtenerCompraPorId(idCompra);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // El formato que desees
        jlfechafa.setText(co.getFecha().format(formatter));

        razonSocialFac.setText("PROVEMAX S.A");
        membreteProve.setText(pro.getRazonSocial());
        membretedomi.setText(pro.getDomicilio());
        membretetel.setText(pro.getTelefono());
        DomicilioFac.setText("Av.Group 45 Caba");
        TelefonoFac.setText("4545-4545");
        generarNroCompra(idCompra);

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
        jlfechafa = new javax.swing.JLabel();
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
        membreteProve = new javax.swing.JLabel();
        membretedomi = new javax.swing.JLabel();
        membretetel = new javax.swing.JLabel();
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
        jlNroCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNroCompra.setAlignmentX(0.5F);
        jlNroCompra.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        facturaView.add(jlNroCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 150, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("TOTAL A PAGAR: $");
        facturaView.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 160, -1));

        jtTotal.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        facturaView.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, 170, 40));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("N° de Compra:");
        facturaView.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 120, -1));

        jlfechafa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlfechafa.setAlignmentX(1.0F);
        jlfechafa.setAlignmentY(1.0F);
        jlfechafa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        facturaView.add(jlfechafa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 140, 40));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAutoscrolls(true);
        facturaView.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 50, 180));
        facturaView.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 248, 585, -1));
        facturaView.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 590, 10));
        facturaView.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 178, 585, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Razon Social:");
        facturaView.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Domicilio:");
        facturaView.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setText("Telefono:");
        facturaView.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        TelefonoFac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TelefonoFac.setBorder(null);
        TelefonoFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TelefonoFac.setSelectionColor(new java.awt.Color(255, 255, 255));
        facturaView.add(TelefonoFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 150, 20));

        razonSocialFac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        razonSocialFac.setBorder(null);
        razonSocialFac.setCaretColor(new java.awt.Color(255, 255, 255));
        razonSocialFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        razonSocialFac.setSelectionColor(new java.awt.Color(255, 255, 255));
        facturaView.add(razonSocialFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 270, 20));

        DomicilioFac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        DomicilioFac.setBorder(null);
        DomicilioFac.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        DomicilioFac.setSelectionColor(new java.awt.Color(255, 255, 255));
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

        membreteProve.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        membreteProve.setText("LG ELECTRONICS S.R.L");
        facturaView.add(membreteProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 60));

        membretedomi.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        facturaView.add(membretedomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 220, 20));

        membretetel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        membretetel.setForeground(new java.awt.Color(51, 51, 51));
        facturaView.add(membretetel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 220, 20));

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
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 180, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 630, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed

        try{
        Toolkit tk = facturaView.getToolkit();
        PrintJob pj = tk.getPrintJob(this, null, null);
        Graphics g = pj.getGraphics();
        facturaView.print(g);
        g.dispose();
        pj.end();
        }catch(NullPointerException ex){
        }
        
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked

        dispose();


    }//GEN-LAST:event_jbSalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DomicilioFac;
    private javax.swing.JTextField TelefonoFac;
    private javax.swing.JPanel facturaView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel membreteProve;
    private javax.swing.JLabel membretedomi;
    private javax.swing.JLabel membretetel;
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
            ob[3] = String.format("%.2f",lista.get(i).getSubTotal());
            modelo.addRow(ob);
        }

        jtfactura.setModel(modelo);
        JTableHeader header = jtfactura.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.white);
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

    private void calcularTotal(int idCompra) { 
       DetalleCompraData lista = new DetalleCompraData();
        double total = 0;
        double subtotal=0;
        for (DetalleCompra c : lista.obtenerDetalleCompraFull(idCompra)) {
               subtotal+= c.getSubTotal();
        }  
        jtTotal.setText(String.format("%.2f", subtotal));
    }


    public void generarNroCompra(int idCom) {
       

        if (idCom < 10) {
            jlNroCompra.setText("000-00000" + idCom);
        } else {
            if (idCom < 100) {
                jlNroCompra.setText("000-0000" + idCom);
            } else {
                if (idCom < 1000) {
                    jlNroCompra.setText("000-000" + idCom);

                }
            }

        }
    }
}
