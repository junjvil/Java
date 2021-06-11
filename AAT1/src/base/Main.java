/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import base.controlador.ControladorInsertar;
import base.controlador.ControladorLibro;
import base.controlador.ControladorMenu;
import base.modelo.AutorDAO;
import base.modelo.AutorLibroVO;
import base.modelo.AutorVO;
import base.modelo.LibroDAO;
import base.modelo.LibroVO;
import base.vista.FrmAutores;
import base.vista.FrmLibros;
import base.vista.FrmMenu;

/**
 *
 * @author Juan Villegas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here                  
        
        // vistas
        FrmLibros fl=new FrmLibros();
        FrmAutores fa=new FrmAutores();
        FrmMenu mn=new FrmMenu();
        
        
        // acceso a la informacion 
        AutorVO avo=new AutorVO();
        AutorDAO adao=new AutorDAO();
        LibroVO lvo=new LibroVO();
        LibroDAO ldao=new LibroDAO();
        AutorLibroVO alvo=new AutorLibroVO();
        
        // controladores 
        ControladorMenu ctrlMen=new ControladorMenu(mn,fa,fl);
        ControladorInsertar ctrlins=new ControladorInsertar(fa,avo,adao);
        ControladorLibro ctrlBook=new ControladorLibro(fl,lvo,ldao,avo,alvo);        
        
        mn.setVisible(true);
        
    }// fin del metodo main
    
}// fin de la clase principal
