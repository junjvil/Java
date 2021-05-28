package controlador;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmAgregar;

/**
 *
 * @author HP
 */
public class ControladorInsertar implements ActionListener,InternalFrameListener {
    // instanciamiento de objetos    
    FrmAgregar viewAdd=new FrmAgregar();
    PaisVO pvo=new PaisVO();
    PaisDAO pdao=new PaisDAO();
    

    public ControladorInsertar(FrmAgregar viewAdd,PaisVO pvo,PaisDAO pdao) {
        this.viewAdd=viewAdd;
        this.pvo=pvo;
        this.pdao=pdao;
        
        viewAdd.jbtnAgregar.addActionListener(this);
        viewAdd.jbtnCancelar.addActionListener(this);
        viewAdd.addInternalFrameListener(this);
        
    }// fin del contstructor de la clase
    
    private void insertarPais(){
        // ingresa un valor 0 en el campo ya que el valor en la tabla es auto incrementable
        pvo.setId_pais(0);
        
        // valida que los campos no esten vacios 
        if(viewAdd.jtxfNombrePais.getText().equals("")){
            
            this.viewAdd.joMensaje.showMessageDialog(null,"Los Campos no pueden ir vacios ingrese datos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
            this.viewAdd.jtxfNombrePais.requestFocus();
            
        }else{
            
            pvo.setNombre_pais(viewAdd.jtxfNombrePais.getText());
            if(viewAdd.jtxfCapital.getText().equals("")){
                
                this.viewAdd.joMensaje.showMessageDialog(null,"Los Campos no pueden ir vacios ingrese datos","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                this.viewAdd.jtxfNombrePais.requestFocus();
                
            }else{
                
                pvo.setCapital_pais(viewAdd.jtxfCapital.getText());                  
                try {

                    pvo.setPoblacion_pais(Long.parseLong(viewAdd.jtfPoblacion.getText()));
                    pdao.insertar(pvo);
                    this.viewAdd.joMensaje.showMessageDialog(null,"Datos ingresados exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    this.limpiarCampos();

                } catch (NumberFormatException nfe) {

                    this.viewAdd.joMensaje.showMessageDialog(null, nfe.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                    this.viewAdd.jtfPoblacion.requestFocus();

                }// fin del try
                
            }// fin de la condicion            
        }// fin del if de validacion de campos              
        
    }// fin del metodo insertarPais    
    
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
        viewAdd.jtblDatos.setModel(m);
        
    }
    
    
    private void limpiarCampos(){
        
        this.viewAdd.jtxfNombrePais.setText("");
        this.viewAdd.jtxfCapital.setText("");
        this.viewAdd.jtfPoblacion.setText("");
        this.viewAdd.jtxfNombrePais.requestFocus();
        
    }// fin del metodo limpiar campos

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==viewAdd.jbtnAgregar){
            this.insertarPais();
            this.mostrar();
        }        
        if(e.getSource()==viewAdd.jbtnCancelar){
            viewAdd.dispose();
        }
    }// metodo
    
    // Eventetos de la venta -------------------------------------------------->>
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
    
    
}// fin del la clase controladorInsertar
