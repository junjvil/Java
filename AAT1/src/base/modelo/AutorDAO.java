/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.modelo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AutorDAO {
  /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ----------------------------------------------- metodos para insertar inofrmaicon en la base de datos ------------------------------------------------------------->>
    -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void insertar(AutorVO avo){
        Conexcion cnx=new Conexcion();
        try{
            cnx.conectar();
            String cnst="INSERT INTO autor VALUES("+avo.getId_autor()+",'"+avo.getNombre()+"','"
                    +avo.getApellido()+"','"+avo.getFechaNacimiento()
                    +"','"+avo.getNacionalidad()+"')";
            cnx.consultasSql(cnst);        
        }catch(Exception ex){
            System.err.println("Error Insertar:>"+ex.getMessage());
        }// fin del capturador de excepciones
        cnx.desconectar();
        
    }// fin del metodo AutorDAO
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ----------------------------------------------- metodos para insertar inofrmaicon en la base de datos ------------------------------------------------------------->>
    -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void editar(AutorVO avo){
        Conexcion cnx=new Conexcion();
        try{
            cnx.conectar();
            
            String cslt="UPDATE autor " +                    
                    "SET nombre='"+avo.getNombre()+"', apellido='"+avo.getApellido()+"', fecha_nacimiento='"+avo.getFechaNacimiento()+"', nacionalidad='"+avo.getNacionalidad()+"'"
                    +" WHERE id_autor="+avo.getId_autor();
            cnx.consultasSql(cslt);
            
        }catch(Exception ex){
            System.err.println("Error Actualizar:>"+ex.getMessage());
        }// fin del capturador de excepciones         
        
    }//fin del metoodo editar 
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos para eliminar inofrmaicon en la base de datos ------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void eliminar(AutorVO avo){
        Conexcion cnx=new Conexcion();
        
        try{
            cnx.conectar();
            String cslt="DELETE FROM autor WHERE id_autor="+avo.getId_autor();
            cnx.consultasSql(cslt);            
        }catch(Exception ex){
            System.err.println("Error Eliminar:>"+ex.getMessage());
        }// fin del capturador de excepciones 
        
    }// fin del metodo eliminar
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodo para la consulta de tablas y mostrar la informacion -------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    
    public ArrayList<AutorVO> consulta(){
        // se realiza la conexion con la bd 
        Conexcion cnx=new Conexcion();
        
        // se crea el arraylist que contendra la informacion 
        ArrayList<AutorVO> cargar=new ArrayList<>();
        
        try{
            cnx.conectar();
            String cnst="SELECT * FROM autor;";
            ResultSet rs=cnx.obtenerDatos(cnst);
            
            while(rs.next()){
                // instancia de objetos 
                AutorVO avo=new AutorVO();
                
                //cargando informacion a avo
                avo.setId_autor(rs.getInt(1));
                avo.setNombre(rs.getString(2));
                avo.setApellido(rs.getString(3));
                avo.setFechaNacimiento(rs.getDate(4).toLocalDate());
                avo.setNacionalidad(rs.getString(5));                
                
                //cargando la informacion al arraylist
                cargar.add(avo);                
                
            }//fin del while para extraer informacion 
            cnx.desconectar();           
            
        }catch(Exception ex){
            System.err.println("Error consulta:> "+ex.getMessage());
        }// fin del capturador de excepciones         
        
        return cargar;
    }// fin del metodo consulta     
    
}//  fin de la clase  AutorDAO
