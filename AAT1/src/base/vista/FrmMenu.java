/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        jpMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblAutores = new javax.swing.JLabel();
        jlblLibros = new javax.swing.JLabel();
        jlblEliminar = new javax.swing.JLabel();
        jlblMostrar = new javax.swing.JLabel();
        jlblReporte = new javax.swing.JLabel();
        jlblSalir = new javax.swing.JLabel();
        jdpEscritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jpFondo.setBackground(new java.awt.Color(255, 255, 255));

        jpMenu.setBackground(new java.awt.Color(230, 126, 34));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/almacenamiento-de-base-de-datos.png"))); // NOI18N

        jlblAutores.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlblAutores.setForeground(new java.awt.Color(255, 255, 255));
        jlblAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/shakespeare.png"))); // NOI18N
        jlblAutores.setText("Autores");

        jlblLibros.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlblLibros.setForeground(new java.awt.Color(255, 255, 255));
        jlblLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/libro-abierto.png"))); // NOI18N
        jlblLibros.setText("Libros");

        jlblEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlblEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jlblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/file.png"))); // NOI18N
        jlblEliminar.setText("Autores Informacion");

        jlblMostrar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlblMostrar.setForeground(new java.awt.Color(255, 255, 255));
        jlblMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/file1.png"))); // NOI18N
        jlblMostrar.setText("Libros Informacion");

        jlblReporte.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlblReporte.setForeground(new java.awt.Color(255, 255, 255));
        jlblReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/portapapeles.png"))); // NOI18N
        jlblReporte.setText("Generar Reporte");

        jlblSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jlblSalir.setForeground(new java.awt.Color(255, 255, 255));
        jlblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base/img/cerrado.png"))); // NOI18N
        jlblSalir.setText("close");

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblSalir)
                .addGap(65, 65, 65))
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addComponent(jlblReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblAutores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpMenuLayout.createSequentialGroup()
                                .addComponent(jlblMostrar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jlblAutores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblLibros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jlblSalir)
                .addGap(64, 64, 64))
        );

        jdpEscritorio.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpEscritorio))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jdpEscritorio)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JDesktopPane jdpEscritorio;
    public javax.swing.JLabel jlblAutores;
    public javax.swing.JLabel jlblEliminar;
    public javax.swing.JLabel jlblLibros;
    public javax.swing.JLabel jlblMostrar;
    public javax.swing.JLabel jlblReporte;
    public javax.swing.JLabel jlblSalir;
    public javax.swing.JPanel jpFondo;
    private javax.swing.JPanel jpMenu;
    // End of variables declaration//GEN-END:variables
}
