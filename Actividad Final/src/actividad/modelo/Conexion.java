/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Conexion {
    // declaracion de campos 
    private String driver="com.mysql.jdbc.Driver";
    private String server="127.0.0.1";    
    private String user="root";
    private String password="";
    private String db="db_juego";
    private String stngCone;
    
    Connection cn;
    Statement st;
    /*-----------------------------------------------------------
                                    Conexion con la base de datos  >>
    -------------------------------------------------------------*/
    public void dbConect(){        
        // cadena de conexion
        this.stngCone="jdbc:mysql:://"+this.server+"/"+this.db;
        
        try{
            Class.forName(this.driver).newInstance();
            this.cn=DriverManager.getConnection(this.stngCone,this.user,this.password);
            System.out.println("Conexion Exitosa!!");
        }catch(Exception ex){
            System.err.println("Error conexion:> "+ex.getMessage());
        }// fin del manejador de exepciones        
        
    }// fin de metodo conectar
    
    /*-----------------------------------------------------------
                                 Desconexion con la base de datos  >>
    -------------------------------------------------------------*/
    public void dbDisconect(){
        try{
            this.cn.close();
            System.out.println("Desconexion exitosa!!");
        }catch(Exception ex){
            System.err.println("Error Desconexion:> "+ex.getMessage());
        }// fin del capturador de excepciones
        
    } // fin del metodo desconectar
    
    /*-----------------------------------------------------------
                                  metodo que ejecuta las consulta  >>
    -------------------------------------------------------------*/
    public void dbConsultaSql(String cslt){
        // variables locales
        int result;
        
        try{
            this.dbConect();
            this.st=this.cn.createStatement();
            result=this.st.executeUpdate(cslt);
            System.out.println("Consulta Realizada exitosamente ");
            
        }catch(Exception ex){
            System.err.println("Error dbConsultaSql:>"+ex.getMessage());
        }finally{
            this.dbDisconect();
        }// fin del capturador de excepciones            
        
    }// fin del metodo consultas
    
    /*-----------------------------------------------------------
                    metodo que ejecuta las consulta para reportes  >>
    -------------------------------------------------------------*/
    public void dbReportes(String csltRep){
    }// fin del metodo de reportes
    
}// fin de la clase conexion
