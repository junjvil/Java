/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.controlador;

import base.modelo.AutorLibroVO;
import base.modelo.AutorVO;
import base.modelo.LibroDAO;
import base.modelo.LibroVO;
import base.vista.FrmLibros;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ControladorLibro implements MouseListener,InternalFrameListener{
    //declaracion de objectos 
    FrmLibros viewLibro=new FrmLibros();
    LibroVO lvo=new LibroVO();
    LibroDAO ldao=new LibroDAO();
    AutorVO avo=new AutorVO();
    AutorLibroVO alvo=new AutorLibroVO();
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- constructor de la clase para inicializar componentes--------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public ControladorLibro(FrmLibros viewLibro,LibroVO lvo,LibroDAO ldao,AutorVO avo,AutorLibroVO alvo) {
        this.viewLibro=viewLibro;
        this.lvo=lvo;
        this.ldao=ldao;
        this.avo=avo;
        this.alvo=alvo;
        
        this.viewLibro.addInternalFrameListener(this); 
        viewLibro.jbtnInsertar.addMouseListener(this);
    }// fin del constructor de la clase 
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que insertar datos del libros a la base de datos ----------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void insertarLibro(){
        lvo.setIsbn(0);
        if(viewLibro.jtxfTitulo.equals("")){
            viewLibro.jopMsgLibro.showMessageDialog(null,"Este campo no puede estar vacio!!","Advertencia",JOptionPane.ERROR_MESSAGE);
            viewLibro.jtxfTitulo.requestFocus();                                  
        }else{
            lvo.setTitulo(viewLibro.jtxfTitulo.getText());
            if(viewLibro.jtxfEditorial.equals("")){
                viewLibro.jopMsgLibro.showMessageDialog(null,"Este campo no puede estar vacio!!");
                viewLibro.jtxfEditorial.requestFocus();                
            }else{
                lvo.setEditorial(viewLibro.jtxfEditorial.getText());
                lvo.setLugarEdicion(viewLibro.jtxfEdicion.getText());
                lvo.setAnioEdicion(Integer.parseInt(viewLibro.jtxAnio.getText()));
                lvo.setNumeroPaginas(Integer.parseInt(viewLibro.jtxfPaginas.getText()));
                
                ldao.insertarLibro(lvo);
            }
        }// fin de la condicion 
        
        
    }// fin del metodo
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite editar la informacion en la tabla del frm------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void editarLibro(){
    }// fin del metodo 
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite cargar la informacion en la tabla del frm------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void eliminarLibro(){
    }// fin del metodo
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite limpiar los elementos del frm ------------------------------------------------------------------>>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void clean(){
        viewLibro.jtxfTitulo.setText("");
        viewLibro.jtxfEditorial.setText("");
        viewLibro.jtxfEdicion.setText("");
        viewLibro.jtxAnio.setText("");
        viewLibro.jtxfPaginas.setText("");
        viewLibro.jtxfTitulo.requestFocus();        
    }// fin del metodo limpiar
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo que permite cargar la informacion en la tabla del frm------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void datosTabla(){
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("ISBN");
        model.addColumn("Titulo-Subtitulo");
        model.addColumn("Editorial");
        model.addColumn("Lugar Edicion");
        model.addColumn("Año Edicion ");
        model.addColumn("Numero Paginas");
        
        for(LibroVO lvo:ldao.cargarLibros()){
            model.addRow(new Object[]{lvo.getIsbn(),lvo.getTitulo(),lvo.getEditorial(),lvo.getLugarEdicion(),lvo.getAnioEdicion(),lvo.getNumeroPaginas()});
        }// fin del for each
        viewLibro.jtblLibros.setModel(model);
        System.out.println("Datos cargados");
        
    }//fin del metodo datosTabla
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos que permite cargar la informacion en combobox-------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void datosAutor(){
        viewLibro.jcbxAutores.addItem("");
        viewLibro.jcbxAutores.addItem("No Existe..");
        for(AutorVO avo:ldao.cargarAutores()){
            viewLibro.jcbxAutores.addItem(avo.getNombre()+" "+avo.getApellido());
        }        
    }// fin del metodo 
    
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- Eventos de la clase ----------------------------------------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    
    //Eventos del mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        
        // boton insertar
        if(e.getSource().equals(viewLibro.jbtnInsertar)){
            this.insertarLibro();
            this.datosTabla();
            viewLibro.jopMsgLibro.showMessageDialog(null,"Registro se ingreso exitosamente!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
            this.clean();            
        }// fin de la operacion del boton insertar
        
        
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
    
    // Eventos de la ventana interna
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        this.datosTabla();
        this.datosAutor();
     
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
       // this.datosTabla();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    
}// fin de la clase ControladorLibro
