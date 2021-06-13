/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.controlador;

import actividad.vista.FrmAdministrador;
import actividad.vista.FrmAvanzado;
import actividad.vista.FrmIntermedio;
import actividad.vista.FrmMdiMenu;
import actividad.vista.FrmPrincipiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ControladorMenu implements ActionListener{
    
    // declaracion de campos y objetos 
    FrmMdiMenu viewMenu=new FrmMdiMenu();
    FrmAdministrador viewAdmin=new FrmAdministrador();
    FrmPrincipiante viewPrin=new FrmPrincipiante();
    FrmIntermedio viewInter=new FrmIntermedio();
    FrmAvanzado viewAdvan=new FrmAvanzado();
    

    /*-----------------------------------------------------------
                           Constructor de la clase ControladorMenu  >>
    -------------------------------------------------------------*/
    public ControladorMenu(FrmMdiMenu viewMenu,FrmAdministrador viewAdmin,FrmPrincipiante viewPrin,FrmIntermedio viewInter,FrmAvanzado viewAdvan) {
        //
        this.viewMenu=viewMenu;
        this.viewAdmin=viewAdmin;
        this.viewPrin=viewPrin;
        this.viewInter=viewInter;
        this.viewAdvan=viewAdvan;
        
        viewMenu.setIconImage(new ImageIcon(getClass().getResource("/actividad/img/ic_rompecabezas.png")).getImage());
        viewMenu.setLocationRelativeTo(null);              
        
        // agregando escuchador de eventos a los componentes del frm
        this.viewMenu.jmniAdministrador.addActionListener(this);
        this.viewMenu.jmniPrincipiante.addActionListener(this);
        this.viewMenu.jmeiIntermedio.addActionListener(this);
        this.viewMenu.jmniAvanzado.addActionListener(this);
        this.viewMenu.jmniReporte.addActionListener(this);
        this.viewMenu.jmniSalir.addActionListener(this);
        
        this.viewMenu.jmniAcerca.addActionListener(this);
        
    }// fin del constructor de la clase 
    

    
    
    /*-----------------------------------------------------------
            implemetacion de metodos para manejo de eventos en java >>
    -------------------------------------------------------------*/
    @Override
    public void actionPerformed(ActionEvent e) {
        //boton administrador
        if(e.getSource().equals(viewMenu.jmniAdministrador)){
            viewMenu.jdkpConetenedor.add(viewAdmin);
            viewAdmin.toFront();
            viewAdmin.show();
        }// fin del boton administrador
        
        //boton principiante
        if(e.getSource().equals(viewMenu.jmniPrincipiante)){
            viewMenu.jdkpConetenedor.add(viewPrin);
            viewPrin.toFront();
            viewPrin.show();
        }// fin del boton principiante
        
        //boton intermedio
        if(e.getSource().equals(viewMenu.jmeiIntermedio)){
            viewMenu.jdkpConetenedor.add(viewInter);
            viewInter.toFront();
            viewInter.show();
        }//fin del boton intermedio
        
        // boton avanzado
        if(e.getSource().equals(viewMenu.jmniAvanzado)){
            viewMenu.jdkpConetenedor.add(viewAdvan);
            viewAdvan.toFront();
            viewAdvan.show();            
        }// fin del boton intermedio
        
        // boton reporte
        if(e.getSource().equals(viewMenu.jmniReporte)){
            
        }// fin del boton reporte
        
        // boton Acerca de..
        if(e.getSource().equals(viewMenu.jmniAcerca)){
            
        }// fin del boton Acerca de..
        
        //boton salir.
        if(e.getSource().equals(viewMenu.jmniSalir)){
            
            if(this.viewMenu.jopMensaje.showConfirmDialog(null,"Dedesea salir de la aplicacion ?","Adevertencia",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE)==JOptionPane.YES_OPTION){
                System.exit(0);
            }
            
        }// fin boton salir
            
        
        
    }// fin del evento actionPerformed
    
}// fin de la clase principal
