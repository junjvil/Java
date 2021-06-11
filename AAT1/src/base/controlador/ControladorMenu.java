/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.controlador;

import base.vista.FrmAutores;
import base.vista.FrmLibros;
import base.vista.FrmMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author HP
 */
public class ControladorMenu implements MouseListener{
    FrmMenu frmPrincipal=new FrmMenu();
    FrmAutores frmAutor=new FrmAutores();
    FrmLibros viewLibros=new FrmLibros();
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- constructor de la clase ------------------------------------------------------------------------------------------;.,->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public ControladorMenu(FrmMenu frmPrincipal,FrmAutores frmAutor,FrmLibros viewLibros) {
        this.frmPrincipal=frmPrincipal;
        this.frmAutor=frmAutor;
        this.viewLibros=viewLibros;
        this.frmPrincipal.setLocationRelativeTo(null);     

        // agregando escuchadores
        this.frmPrincipal.jlblAutores.addMouseListener(this);
        this.frmPrincipal.jlblLibros.addMouseListener(this);
        this.frmPrincipal.jlblSalir.addMouseListener(this);
        
    }// fin del constructor de la clase
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      --------------------------------------------------Eventos de la clase --------------------------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
            
    // eventos del mouse 
    @Override
    public void mouseClicked(MouseEvent e) {
                
        // formulario de autores 
        if(e.getSource().equals(frmPrincipal.jlblAutores)){
            frmPrincipal.jdpEscritorio.add(frmAutor);            
            frmAutor.show();
        }//fin del metodo
        
        // formulario Libros
        if(e.getSource().equals(frmPrincipal.jlblLibros)){
            frmPrincipal.jdpEscritorio.add(viewLibros);
            viewLibros.show();
        }// fin del metodo
        
        // salir de la aplicacion 
        if(e.getSource().equals(frmPrincipal.jlblSalir)){            
            System.exit(0);
        }// fin del metodo 
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
}// fin de la clase principal ControladorMenu
