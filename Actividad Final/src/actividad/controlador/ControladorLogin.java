/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.controlador;

import actividad.vista.FrmLogin;
import actividad.vista.FrmMdiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author HP
 */
public class ControladorLogin implements ActionListener{
    // declaracion de campos e instaciamiento de objetos
    FrmLogin viewLog=new FrmLogin();
    FrmMdiMenu viewMenu=new FrmMdiMenu();
    
    /*-----------------------------------------------------------
                           Constructor de la clase ControladorLogin  >>
    -------------------------------------------------------------*/   
    public ControladorLogin(FrmLogin viewLog,FrmMdiMenu viewMenu) {       
        this.viewLog=viewLog;        
        this.viewMenu=viewMenu;
        
        this.viewLog.setLocationRelativeTo(null);
        // agregando eventos a los elementos
        this.viewLog.jbtnAcceder.addActionListener(this);
        this.viewLog.jbtnCancelar.addActionListener(this);
        this.viewLog.jbtnCerrar.addActionListener(this);
        
        
    }// fin del constructor de la clase
    
    public void validarUsuario(){
        
    }// fin del metodo validar usuario
    
    /*-----------------------------------------------------------
                                           Eventos del formulario  >>
    -------------------------------------------------------------*/
    @Override
    public void actionPerformed(ActionEvent e) {
        //codificacion de boton Acceder
        if(e.getSource().equals(viewLog.jbtnAcceder)){
            this.validarUsuario();
            
            
            viewLog.dispose();
            this.viewMenu.setVisible(true);
        }// fin del codigo
        
        // codificacion de boton cancelar
        if(e.getSource().equals(viewLog.jbtnCancelar)){ 
            System.exit(0);
        }// fin del codigo de boton cancelar
        
        //codificacion del boton cerrar
        if(e.getSource().equals(viewLog.jbtnCerrar)){
            System.exit(0);            
        }//fin del codigo de botron cerrar
        
    }// fin del manejador de eventos 
    
}// fin de la clase ControladorLogin 
