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
import vista.FrmEditar;

/**
 *
 * @author HP
 */
public class ControladorActualizar implements ActionListener,InternalFrameListener,MouseListener{
    
    // declaracion de variables de instacia y objetos
    FrmEditar viewEdit=new FrmEditar();
    PaisDAO pdao=new PaisDAO();
    PaisVO pvo=new PaisVO();
    
    // constructor de la clase  ------------------------------------------------------------------------------------------------------>>
    public ControladorActualizar(FrmEditar viewEdit,PaisVO pvo,PaisDAO pdao) {
        this.viewEdit=viewEdit;
        this.pdao=pdao;
        this.pvo=pvo;        
        
        viewEdit.jbtnEditar.addActionListener(this);
        viewEdit.jtblCargarDatos.addMouseListener(this);
        viewEdit.addInternalFrameListener(this);
    }// fin del constructor de la clase 
    
    // metodo insertarPais ------------------------------------------------------------------------------------------------------------>>
    public void editarPais(){        
        pvo.getId_pais();
        //Validaciones de cajas         
        if(viewEdit.jtxfNombrePais.equals("")){
            viewEdit.joPane.showMessageDialog(null,"El Campo no pueden ir vacios","ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
            viewEdit.jtxfNombrePais.requestFocus();
        }else{
            pvo.setNombre_pais(viewEdit.jtxfNombrePais.getText());
            if(viewEdit.jtxfCapital.equals("")){
                viewEdit.joPane.showMessageDialog(null,"El Campo no puede ir vacion","ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
                viewEdit.jtxfPoblacion.requestFocus();                
            }else{
                pvo.setCapital_pais(viewEdit.jtxfCapital.getText());
                try{
                    pvo.setPoblacion_pais(Long.parseLong(viewEdit.jtxfPoblacion.getText()));
                    pdao.actualizar(pvo);
                    viewEdit.joPane.showMessageDialog(null,"Los datos se actualizaron Exitosamente","INFORMACION",JOptionPane.INFORMATION_MESSAGE);
                    this.limpiarCampos();
                    
                }catch(NumberFormatException nfe){
                    viewEdit.joPane.showMessageDialog(null,"Error:>"+nfe.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
                    this.viewEdit.jtxfPoblacion.requestFocus();
                }
            }
        }// fin de la primera condicional  
        
    }// fin del metodo editarPais
    
    
    // metodo que cargar la inforamacion en la tabla -------------------------------------------------------------------------------->>
    public void mostrar(){
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("Id");
        model.addColumn("Pais");
        model.addColumn("Capital");
        model.addColumn("Poblacion");
        
        for(PaisVO pvo:pdao.consultarTabla()){
            model.addRow(new Object[]{pvo.getId_pais(),pvo.getNombre_pais(),pvo.getCapital_pais(),pvo.getPoblacion_pais()});        
        }// fin del cicilo foreach
        
        viewEdit.jtblCargarDatos.setModel(model);
    
    }// fin del metodo mostrar 
    
    // metodo para limpiar los botones en la tabla ----------------------------------------------------------------------------------->>
    public void limpiarCampos(){
        viewEdit.jtxfNombrePais.setText("");
        viewEdit.jtxfCapital.setText("");
        viewEdit.jtxfPoblacion.setText("0");
        viewEdit.jtxfNombrePais.requestFocus();
        
    }// fin del metodo limpiar campos
    
    // Eventos del programa  ---------------------------------------------------------------------------------------------------------->>
    
    //  ActionPerformed -----------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(viewEdit.jbtnEditar)){
            this.editarPais();
            this.mostrar();
        }
        
    }
    
    // eventos de la venta interna  -----------------------------
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
    
    // eventos de click en la aplicacion ---------------------------
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource().equals(this.viewEdit.jtblCargarDatos)){
            int filaSeleccionada=this.viewEdit.jtblCargarDatos.getSelectedRow();
            
            pvo.setId_pais((int)viewEdit.jtblCargarDatos.getValueAt(filaSeleccionada, 0));
            viewEdit.jtxfNombrePais.setText((String)viewEdit.jtblCargarDatos.getValueAt(filaSeleccionada,1));
            viewEdit.jtxfCapital.setText((String)viewEdit.jtblCargarDatos.getValueAt(filaSeleccionada, 2));
            viewEdit.jtxfPoblacion.setText(viewEdit.jtblCargarDatos.getValueAt(filaSeleccionada, 3).toString());                        
            
        }// fin de la seleccion
        
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
    
}// fin de la clase ControladorActualizar 
