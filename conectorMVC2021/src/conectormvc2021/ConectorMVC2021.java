/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectormvc2021;

import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMostrar;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmAgregar;
import vista.FrmEditar;
import vista.FrmEliminar;
import vista.FrmMenu;
import vista.FrmMostra;

/**
 *
 * @author HP
 */
public class ConectorMVC2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       // vistas ------------------------------------------------------>>
        FrmMenu mdiFrm=new FrmMenu();        
        FrmAgregar ins=new FrmAgregar();
        FrmEditar ed=new FrmEditar();
        FrmEliminar de=new FrmEliminar();
        FrmMostra ms=new FrmMostra();
        
        // Acceso a la informacion ------------------------------------>>
        PaisVO pvo=new PaisVO();
        PaisDAO pdao=new PaisDAO();
        
        // controladores ----------------------------------------------->>
        ControladorMenu ctrl=new ControladorMenu(mdiFrm,ins,ed,de,ms);
        ControladorInsertar ctrlins=new ControladorInsertar(ins,pvo,pdao);
        ControladorMostrar cmo=new ControladorMostrar(ms,pvo,pdao);
        ControladorActualizar crtlUpd=new ControladorActualizar(ed,pvo,pdao);
        ControladorEliminar ctrlDel=new ControladorEliminar(de,pvo,pdao);
        
        
        mdiFrm.setVisible(true);        
    }
    
}// fin de la clase principal ConectorMVC2021
