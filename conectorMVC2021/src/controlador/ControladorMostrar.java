/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmMostra;

/**
 *
 * @author HP
 */
public class ControladorMostrar implements InternalFrameListener{
    
    FrmMostra viewShow=new FrmMostra();
    PaisVO pvo=new PaisVO();
    PaisDAO pdao=new PaisDAO(); 

    public ControladorMostrar(FrmMostra view,PaisVO pvo, PaisDAO pdao) {
        this.viewShow=view;
        this.pvo=pvo;
        this.pdao=pdao;                
        
        viewShow.addInternalFrameListener(this);
    }
    
    
    
    private void mostrar(){
        DefaultTableModel m=new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Pais");
        m.addColumn("Capital");
        m.addColumn("Poblacion");
        
        for(PaisVO pvo:pdao.consultarTabla()){
            m.addRow(new Object[]{pvo.getId_pais(),pvo.getNombre_pais(),pvo.getCapital_pais(),pvo.getPoblacion_pais()});
        }    
        viewShow.jtblMostar.setModel(m);        
        
    }// fin del metodo mostrar     

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        this.mostrar();        
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {               
        
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {       
        
        
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
     this.mostrar();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }

    
    
}// fin de la clase principal 
