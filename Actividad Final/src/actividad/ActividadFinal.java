/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad;

import actividad.controlador.ControladorLogin;
import actividad.controlador.ControladorMenu;
import actividad.vista.FrmAdministrador;
import actividad.vista.FrmAvanzado;
import actividad.vista.FrmIntermedio;
import actividad.vista.FrmLogin;
import actividad.vista.FrmMdiMenu;
import actividad.vista.FrmPrincipiante;

/**
 *
 * @author HP
 */
public class ActividadFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //vistas
        FrmLogin vl=new FrmLogin();
        FrmMdiMenu vm=new FrmMdiMenu();
        FrmAdministrador va=new FrmAdministrador();
        FrmPrincipiante vp=new FrmPrincipiante();
        FrmIntermedio vi=new FrmIntermedio();
        FrmAvanzado vad=new FrmAvanzado();
        
        
        // controladores 
        ControladorLogin  ctrlLog=new ControladorLogin(vl,vm);
        ControladorMenu ctrlMenu=new ControladorMenu(vm,va,vp,vi,vad);
        
        vl.setVisible(true);
        //vm.setVisible(true);
    }
    
}
