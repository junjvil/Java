/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.modelo;

// importamos las clases a utilizar 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *  Esta clase permite realizar la conexion y desconexion  con la base de datos.
 * @author Juan Jossue Villegas Acju
 */


public class Conexcion {   
    
    // Declaracion de variables de instancia  y instanciamiento de objetos
    private final String driver="com.mysql.jdbc.Driver";
    private final String servidor="127.0.0.1";
    private final String usuario="root";
    private final String password="";
    private final String bd="bd_Libro";
    private String cadena;    
    
    Connection cnx;
    Statement sta;
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      -------------------------------------------------- metodo que permite relaizar la conexion a la base de datos -------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void conectar(){
        
        // cadena de conexion
        this.cadena="jdbc:mysql://"+this.servidor+"/"+this.bd;
        
        // Codigo que caputura la excepcion y preeve errores 
        try{
            Class.forName(this.driver).newInstance();
            this.cnx=DriverManager.getConnection(this.cadena,this.usuario,this.password);            
        }catch(Exception ex){
            System.err.println("Error:>"+ex.getMessage());
        }  // fin del capturador de excepciones
        
    }// fin del metodo conectar
    
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      -------------------------------------------------- metodo que permite relaizar la desconexion a la base de datos -------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void desconectar(){
        
        // Codigo que caputura la excepcion y preeve errores 
        try{
            this.cnx.close();
        }catch(Exception ex){
            System.err.println("Error :>"+ex.getMessage());
        }// fin del capturador de execepciones        
        
    }// fin del metodo desconectar
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      -------------------------------------------------- metodo que permite multiples consultas a la base de datos ------------------------------------------------------>>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public int consultasSql(String consulta){
        int resultado;
        
        // Codigo que caputura la excepcion y preeve errores 
        try{
            
            this.conectar();// realiza la conexion en la base de datos
            this.sta=this.cnx.createStatement();
            resultado=this.sta.executeUpdate(consulta);
            
        }catch(Exception ex){
            
            System.err.println("Error consulta:> "+ex.getMessage());            
            return 0;
            
        }finally{
            this.desconectar();
        }// fin del capturador de excepciones 
        
        return resultado;
    } // fin del metodo consultasSql   
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      -------------------------------------------------- metodo que permite multiples consultas a la base de datos ------------------------------------------------------>>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public ResultSet obtenerDatos(String cnst){
        
        // Codigo que caputura la excepcion y preeve errores 
        try{
            
            this.conectar();// realizamos la conexion a la base de datos
            ResultSet rstd=null;
            this.sta=this.cnx.createStatement();
            rstd=sta.executeQuery(cnst);
            //System.out.println("Ingresaste a obtener datos");
            return rstd;            
        }catch(Exception ex){
            
            System.err.println("Error obtenerDatos:>"+ex.getMessage());            
            
        }// fin del capturado de excepciones        
        
        return null;
    }// fin del metodo obtenerDatos
    
}// fin de la clase Conexcion
