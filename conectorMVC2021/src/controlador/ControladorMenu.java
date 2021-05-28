/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
// importamos librerias a utilizar
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmAgregar;
import vista.FrmEditar;
import vista.FrmEliminar;
import vista.FrmMenu;
import vista.FrmMostra;

/**
 *
 * @author HP
 */
public class ControladorMenu implements ActionListener{
    // instanciamiento de objetos ------------------------------------>>
    FrmMenu viewMenu=new FrmMenu();
    FrmAgregar viewAdd=new FrmAgregar();
    FrmEditar viewEdit=new FrmEditar();
    FrmEliminar viewDel=new FrmEliminar();
    FrmMostra viewShow=new FrmMostra();
    
    
    public ControladorMenu(FrmMenu viewMenu,FrmAgregar viewAdd,FrmEditar viewEdit,FrmEliminar viewDel,FrmMostra viewShow){
        
        this.viewMenu=viewMenu;
        this.viewAdd=viewAdd;
        this.viewEdit=viewEdit;
        this.viewDel=viewDel;
        this.viewShow=viewShow;        
        
        this.viewMenu.jmitAgregar.addActionListener(this);
        this.viewMenu.jmitEditar.addActionListener(this);
        this.viewMenu.jmitElliminar.addActionListener(this);
        this.viewMenu.jmitCargar.addActionListener(this);
        this.viewMenu.jmitSalir.addActionListener(this);
        
    } // fin del constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Muestra el formulario de agregar ------------------------------------>>
        if(e.getSource().equals(this.viewMenu.jmitAgregar)){
            
            this.viewMenu.dkpEscritorio.add(this.viewAdd); 
            this.viewAdd.setLocation(10,10);
            this.viewAdd.toFront();
            this.viewAdd.show();           
            
        }//fin del llamado al metodo agregar
        
        // Muestra el formulario de ingreso ------------------------------------>>
        if(e.getSource().equals(this.viewMenu.jmitEditar)){
            
            this.viewMenu.dkpEscritorio.add(this.viewEdit);
            this.viewEdit.toFront();
            this.viewEdit.show();
            
        }// fin del llamado al frmEditar
        
        // Muestra el formulario de Eliminar ------------------------------------>>
        if(e.getSource().equals(this.viewMenu.jmitElliminar)){
            
            this.viewMenu.dkpEscritorio.add(this.viewDel);
            this.viewDel.toFront();
            this.viewDel.show();
            
        }// fin del llamado al frmEliminar
        
        // Muestra el formulario el formulario para cargar la informacion ------------------------------------>>
        if(e.getSource().equals(this.viewMenu.jmitCargar)){
            
            this.viewMenu.dkpEscritorio.add(this.viewShow);
            this.viewShow.setLocation(20,20);
            this.viewShow.toFront();
            this.viewShow.show();
            
        }// fin del metodo para llamar frmMostrar
        
        // Realiza la operacion de salida ------------------------------------>>
        if(e.getSource().equals(this.viewMenu.jmitSalir)){            
            if(this.viewMenu.joMensaje.showConfirmDialog(null,"Desea salir de la aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                System.exit(0);
            }
            
        }//fin de la opcion salir
        
    }// fin del metodo actionPerformed ------>>
    
}// Fin de la clase ControladorMenu
