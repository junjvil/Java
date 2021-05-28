package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Juan 
 */
public class Conector {
    // declaracion de la variables que se utilizan en la clase conexion     
    private String driver="com.mysql.jdbc.Driver";
    private String servidor="127.0.0.1";
    private String usuario="root";
    private String password="";
    private String bd ="bd_java_con1";
    private String cadena;
    
    //declarar el objeto conexion
    Connection cxn;
    
    // Objeto que permite realizar consultas
    Statement st;
    
    //metodos para la conexion -------------------------------------------------->>
    public void conectar(){
        this.cadena="jdbc:mysql://"+this.servidor+"/"+this.bd;
        
        try{
            
            Class.forName(this.driver).newInstance();
            this.cxn=DriverManager.getConnection(this.cadena,this.usuario,this.password);
            
        }catch(Exception e){
            
            System.err.println("Mensaje 1:>"+e.getMessage());
            
        }
    }// fin del metodo conectar
    
    //Metodo para desconectar -------------------------------------------------->>
    public void desconectar(){
        try{
            
            this.cxn.close();// cerramos la conexion a la base de datos
            
        }catch(Exception e){
            System.err.println("Mensaje 2:>"+e.getMessage());
        }
        
    }// fin dle metodo desconectar
    
    //metodo para relaizar diversas consultas(insert,update,delete) -------------------------------------------------->>
    public int consulas_multiples(String consulta){
        int resultado;
        try{
            
            this.conectar();// se realiza la conexion
            this.st=this.cxn.createStatement();
            resultado=this.st.executeUpdate(consulta);
            
        }catch(Exception e){
            
            System.err.println("Mensaje 3:>"+e.getMessage());
            return 0;
        }finally{
            this.desconectar();
        }
        
        return resultado;
    }// fin del metodo consultas_multiples
    
    // metodo para obtener datas de una tabla en base de datos , select -------------------------------------------------->>
    public ResultSet consulta_datos(String consulta){
        try{
            this.conectar();
            ResultSet resultado=null;
            this.st=this.cxn.createStatement();
            resultado = st.executeQuery(consulta);
            return resultado;            
        }catch(Exception e){
            System.err.println("Mensaje 4:>" +e.getMessage());
        }

        
        return null;
    }// fin del metodo consulta_datos()
    
    
}// fin de la clase Conector