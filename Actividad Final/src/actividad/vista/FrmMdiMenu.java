/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.vista;

/**
 *
 * @author HP
 */
public class FrmMdiMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMdiMenu
     */
    public FrmMdiMenu() {
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

        jopMensaje = new javax.swing.JOptionPane();
        jdkpConetenedor = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jfmnArchivo = new javax.swing.JMenu();
        jmniAdministrador = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmniPrincipiante = new javax.swing.JMenuItem();
        jmeiIntermedio = new javax.swing.JMenuItem();
        jmniAvanzado = new javax.swing.JMenuItem();
        jmniReporte = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmniSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmniAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jdkpConetenedor.setBackground(new java.awt.Color(255, 255, 255));

        jfmnArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/menu_1.png"))); // NOI18N
        jfmnArchivo.setMnemonic('f');
        jfmnArchivo.setText("Archivo");

        jmniAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_configuraciones_color.png"))); // NOI18N
        jmniAdministrador.setMnemonic('o');
        jmniAdministrador.setText("Administrador");
        jfmnArchivo.add(jmniAdministrador);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_rompecabezas.png"))); // NOI18N
        jMenu1.setText("Juego");

        jmniPrincipiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_bronze-medal_pri.png"))); // NOI18N
        jmniPrincipiante.setText("Principiante");
        jMenu1.add(jmniPrincipiante);

        jmeiIntermedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_silver-medal_int.png"))); // NOI18N
        jmeiIntermedio.setText("Intermedio");
        jMenu1.add(jmeiIntermedio);

        jmniAvanzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_gold-medal_adc.png"))); // NOI18N
        jmniAvanzado.setText("Avanzado");
        jMenu1.add(jmniAvanzado);

        jfmnArchivo.add(jMenu1);

        jmniReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_reporte.png"))); // NOI18N
        jmniReporte.setText("Reporte Resulados");
        jfmnArchivo.add(jmniReporte);
        jfmnArchivo.add(jSeparator1);

        jmniSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_exit.png"))); // NOI18N
        jmniSalir.setMnemonic('x');
        jmniSalir.setText("Exit");
        jfmnArchivo.add(jmniSalir);

        menuBar.add(jfmnArchivo);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_ayuda.png"))); // NOI18N
        jMenu2.setText("Ayuda");

        jmniAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad/img/ic_acerca.png"))); // NOI18N
        jmniAcerca.setText("Acerca de..");
        jMenu2.add(jmniAcerca);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdkpConetenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdkpConetenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(FrmMdiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMdiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMdiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMdiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMdiMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JDesktopPane jdkpConetenedor;
    private javax.swing.JMenu jfmnArchivo;
    public javax.swing.JMenuItem jmeiIntermedio;
    public javax.swing.JMenuItem jmniAcerca;
    public javax.swing.JMenuItem jmniAdministrador;
    public javax.swing.JMenuItem jmniAvanzado;
    public javax.swing.JMenuItem jmniPrincipiante;
    public javax.swing.JMenuItem jmniReporte;
    public javax.swing.JMenuItem jmniSalir;
    public javax.swing.JOptionPane jopMensaje;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
