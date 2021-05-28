/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class PaisDAO implements ConsultasDAO{
    
    // Metodo para insertar la informacion a la base de datos --------------------------------------------------------------------------->>    
    @Override
    public void insertar(PaisVO p) {
        // Se inicia la conexion con la base de datos
        Conector c=new Conector();
        try{
            
            c.conectar();
            String consulta="INSERT INTO tbl_pais VALUES(null,'"+p.getNombre_pais()+
                    "','"+p.getCapital_pais()+"',"+p.getPoblacion_pais()+");";
            c.consulas_multiples(consulta);
            
        }catch(Exception e){
            System.err.println("Mensaje inseratar:>"+e.getMessage());
        }
        c.desconectar();
    }// fin del metodo  insertar
    
    // Metodo para actualizar la informacion a la base de datos --------------------------------------------------------------------------->>
    @Override
    public void actualizar(PaisVO p) {
        Conector cnx=new Conector();
        try{
            cnx.conectar();            
            String consulta="UPDATE tbl_pais SET nombre_pais='"+p.getNombre_pais()+"', "
                    +"capital_pais='"+p.getCapital_pais()+"', "
                    + "poblacion_pais="+p.getPoblacion_pais()+" WHERE id_pais="+p.getId_pais();            
            cnx.consulas_multiples(consulta);
        }catch(Exception e){
            System.err.println("Error Mensaje Actualizar:>"+e.getMessage());
        }
        cnx.desconectar();// se desconecta de la base de datos       
    }// fin del meotodo actualizar 
    
    
    // metodo para eliminar informacion de la base de datos -------------------------------------------------------------------------------->>
    @Override
    public void eliminar(PaisVO p) {
        Conector cnx=new Conector();
        try{
            cnx.conectar();
            String consulta="DELETE FROM tbl_pais WHERE	id_pais="+p.getId_pais();
            
            cnx.consulas_multiples(consulta);
        }catch(Exception e){
            System.out.println("Error Mensaje Eliminar:>"+e.getMessage());
        }
        cnx.desconectar();
    }// fin del metodo eliminar

    @Override
    public ArrayList<PaisVO> consultarTabla() {
        
        Conector c=new Conector();
        ArrayList<PaisVO> info=new ArrayList<>();
        
        try{
            
            c.conectar();
            
            String consulta="SELECT * FROM tbl_pais;";
            ResultSet rs=c.consulta_datos(consulta);
            
            while(rs.next()){
                PaisVO pvo=new PaisVO();
                pvo.setId_pais(rs.getInt(1));
                pvo.setNombre_pais(rs.getString(2));
                pvo.setCapital_pais(rs.getString(3));
                pvo.setPoblacion_pais(rs.getLong(4));  
                info.add(pvo);
            }// fin del while
            c.desconectar();
            
        }catch(Exception e){
            
            System.err.println("Mensaje Mostrar Datos:> "+e.getMessage());
            
        }
        return info;
    }//fin del metodo consultaTabla
    
}
