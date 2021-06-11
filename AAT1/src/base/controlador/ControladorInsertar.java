/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.controlador;

import base.modelo.AutorDAO;
import base.modelo.AutorVO;
import base.vista.FrmAutores;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author HP
 */
public class ControladorInsertar implements MouseListener,InternalFrameListener{
    FrmAutores frmAutor=new FrmAutores();
    AutorVO avo=new AutorVO();
    AutorDAO adao=new AutorDAO();
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- constructor de la clase ------------------------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public ControladorInsertar(FrmAutores frmAutor,AutorVO avo,AutorDAO adao) {
        this.frmAutor=frmAutor;
        this.avo=avo;
        this.adao=adao;
        
        
        // agregrando los eventos 
        frmAutor.jbtnInsertar.addMouseListener(this);
        frmAutor.jbtnActualizar.addMouseListener(this);
        frmAutor.jbtnEliminar.addMouseListener(this);
       // frmAutor.jbtnBuscar.addMouseListener(this);        
        frmAutor.addInternalFrameListener(this);
        frmAutor.jtDatos.addMouseListener(this);
    }// fin de constructor de la clase 
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite el ingreso de datos ---------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    private void insertarAutor(){
        avo.setId_autor(0);
        
        if (this.frmAutor.jtxfNombre.getText().equals("")){
            
            frmAutor.jopMensaje.showMessageDialog(null,"Este campo no puede estar vacio ingrese un valor","Erro",JOptionPane.ERROR_MESSAGE);
            frmAutor.jtxfNombre.requestFocus();
            
        }else {
            
            avo.setNombre(frmAutor.jtxfNombre.getText());
            
            if(this.frmAutor.jtxfApellido.getText().equals("")){
                
                frmAutor.jopMensaje.showMessageDialog(null,"Este campo no puede estar vacio ingrese un valor","Error",JOptionPane.ERROR_MESSAGE);
                frmAutor.jtxfApellido.getText().equals("");
                
            }else{
                
                avo.setApellido(frmAutor.jtxfApellido.getText());
                avo.setFechaNacimiento((frmAutor.jdcFecha.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                avo.setNacionalidad(frmAutor.jtxfNacionalidad.getText());
                
                adao.insertar(avo);                
                this.frmAutor.jopMensaje.showMessageDialog(null,"Informacion ingresada exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                this.cleanComponets();                
            }
        }// fin de la validacion de campos         
        
    }// fin del metodo 
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite la edicion de datos ---------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void editarAutor(){
        avo.getId_autor();
        if(frmAutor.jtxfNombre.equals("")){
            
            frmAutor.jopMensaje.showMessageDialog(null,"El campo de nombre no puede estar vacio","Advertenncia",JOptionPane.INFORMATION_MESSAGE);
            frmAutor.jtxfNombre.requestFocus();
            
        }else{
            
            avo.setNombre((String)frmAutor.jtxfNombre.getText());
            if(frmAutor.jtxfApellido.equals("")){
                
                frmAutor.jopMensaje.showMessageDialog(null,"El campo de apellido no puede estar vacio","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                frmAutor.jtxfApellido.requestFocus();
            }else{
                
                avo.setApellido((String)frmAutor.jtxfApellido.getText());
                avo.setFechaNacimiento(frmAutor.jdcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                avo.setNacionalidad((String)frmAutor.jtxfNacionalidad.getText());
                
                adao.editar(avo);
                frmAutor.jopMensaje.showMessageDialog(null,"informacion actualizada exitosamente!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                this.cleanComponets();
                }
        }// fin de la validacion de campo
    }// fin del metodo editar autor
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite la eliminacion de datos------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void eliminarAutor(){
        this.cargarSeleccion();
        this.adao.eliminar(avo);
        this.cleanComponets();
    }// fin del metodo eliminar
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite cargar la informacion seleccionada de la tabla-------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    
    public void cargarSeleccion(){
        int rowSelec=this.frmAutor.jtDatos.getSelectedRow();
        
        avo.setId_autor((int)this.frmAutor.jtDatos.getValueAt(rowSelec, 0));
        frmAutor.jtxfNombre.setText((String)frmAutor.jtDatos.getValueAt(rowSelec, 1));
        frmAutor.jtxfApellido.setText((String)frmAutor.jtDatos.getValueAt(rowSelec, 2));
        try{            
            LocalDate fec=(LocalDate) frmAutor.jtDatos.getValueAt(rowSelec, 3);
            Date fecha=Date.from(fec.atStartOfDay(ZoneId.systemDefault()).toInstant());
            frmAutor.jdcFecha.setDate(fecha);
        }catch(Exception ex){
            System.err.println("Error fecha:>"+ex.getMessage());            
        }
        frmAutor.jtxfNacionalidad.setText((String)frmAutor.jtDatos.getValueAt(rowSelec, 4));
        
        //
    }// fin del metodo cargarSeleccion     
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- Cargar la informacion de la tabla en la jTable--------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void cargarDatos(){
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("id_autor");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha_Nacimiento");
        model.addColumn("Nacionalidad");
            
        for (AutorVO avo:adao.consulta()){
            model.addRow(new Object[]{avo.getId_autor(),avo.getNombre(),avo.getApellido(),avo.getFechaNacimiento(),avo.getNacionalidad()});            
        }// fin del ciclo for 
        
        // cargar a la tabla 
        frmAutor.jtDatos.setModel(model);       
        System.out.println("Datos cargados autor");
        
    }// fin del metodo cargarDatos()
    
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- Limpieza de botones---------------------------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void cleanComponets(){
        this.frmAutor.jtxfNombre.setText("");
        this.frmAutor.jtxfApellido.setText("");
        this.frmAutor.jdcFecha.setDate(null);
        this.frmAutor.jtxfNacionalidad.setText("");
        this.frmAutor.jtxfNombre.requestFocus();
        
    }// fin del metodo cleanComponets
    
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- Eventos de la clase ----------------------------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    // eventos para el uso del Mouse

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // boton insertar
        if(e.getSource().equals(frmAutor.jbtnInsertar)){
            this.insertarAutor();
            this.cargarDatos();
        }// fin de la condicional
        
        
        // boton editar
        if(e.getSource().equals(frmAutor.jbtnActualizar)){
            this.editarAutor();
            this.cargarDatos();
        }// fin de editar
        
        // seleccion de elementos de la tabla
        if(e.getSource().equals(frmAutor.jtDatos)){
            this.cargarSeleccion();
        }//fin de seleccion de elementos
        
        // boton eliminar
        if(e.getSource().equals(frmAutor.jbtnEliminar)){
            int opcion=frmAutor.jopMensaje.showConfirmDialog(null,"Esta seguro que desea eliminar el registro?","ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
            if(opcion==JOptionPane.YES_OPTION){
                this.eliminarAutor();
                this.cargarDatos();
            }                
        }// fin del metodo eleminar 
        
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
        
    }// fin de los metodo del evento mouse

    @Override
    
    // eventos de la venta interna
    public void internalFrameOpened(InternalFrameEvent e) {
        //this.cargarDatos();        
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
        this.cargarDatos();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    
    
    
    
    
}// fin de la clase controlador 
