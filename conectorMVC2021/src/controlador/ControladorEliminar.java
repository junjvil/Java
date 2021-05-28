/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmEliminar;

/**
 *
 * @author HP
 */
public class ControladorEliminar implements ActionListener,InternalFrameListener,MouseListener {
    // declaracion de campos y instaciaminetos de objetos
    FrmEliminar viewDel=new FrmEliminar();    
    PaisVO pvo=new PaisVO();
    PaisDAO pdao=new PaisDAO();
    
    // Constructor de la clase ----------------------------------------------------------------------------------------->>
    public ControladorEliminar(FrmEliminar viewDel,PaisVO pvo,PaisDAO pdao) {
        this.viewDel=viewDel;
        this.pvo=pvo;
        this.pdao=pdao;        
        
        viewDel.jbtnEliminar.addActionListener(this);
        viewDel.jtblCargar.addMouseListener(this);
        viewDel.addInternalFrameListener(this);
    }// fin del metodo cargar
    
    // metodo para eliminar informacion de la base de datos ------------------------------------------------------------->>
    public void eliminar(){
        pdao.eliminar(pvo);
        
    }// fin del metodo eliminar 
    
    // metodo que permite tomar el id de la tabla para pode eliminarlo -------------------------------------------------->>
    public void obtenerIdEliminar(){
        int obtenerSelecion=this.viewDel.jtblCargar.getSelectedRow();
        pvo.setId_pais((int)this.viewDel.jtblCargar.getValueAt(obtenerSelecion, 0));
        pvo.setNombre_pais((String)this.viewDel.jtblCargar.getValueAt(obtenerSelecion, 1));
        pvo.setCapital_pais((String)this.viewDel.jtblCargar.getValueAt(obtenerSelecion, 2));
        pvo.setPoblacion_pais((long)this.viewDel.jtblCargar.getValueAt(obtenerSelecion, 3));        
    }// fin del metodo obtenerIdEliminar
    
    
    // metodo para cargar datos a la tabla ------------------------------------------------------------------------------>>
    public void mostrarDatos(){
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Pais");
        model.addColumn("Capital");
        model.addColumn("Poblacion");
        
        for(PaisVO pvo:pdao.consultarTabla()){
            model.addRow(new Object[]{pvo.getId_pais(),pvo.getNombre_pais(),pvo.getCapital_pais(),pvo.getPoblacion_pais()});
        }// fin del ciclo for 
        
        viewDel.jtblCargar.setModel(model);
        
    }// fin del metodo mostrar datos     
    
    // Metodo para trabajar con eventos  -------------------------------------------------------------------------------->>
    
    // internalFrame 
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        this.mostrarDatos();
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
     this.mostrarDatos();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    
    // eventos de mouse 
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(viewDel.jtblCargar)){
            this.obtenerIdEliminar();
        }
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
    // eventos del action listener  --------------------------------------------------------------------------->>

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(viewDel.jbtnEliminar)){
            int opcion=this.viewDel.joMensaje.showConfirmDialog(null,"Esta seguro de querer eliminar el registro?","ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
            if(opcion==JOptionPane.YES_OPTION){
                this.eliminar();
                this.mostrarDatos();
            }
        }
    }// fin del metodo actionPerformed
    
}// fin de la clase ControladorEliminar
