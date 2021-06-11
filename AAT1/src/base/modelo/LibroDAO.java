/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class LibroDAO {
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- constructor de la clase para inicializar los componentes----------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      

    public LibroDAO() {
    }   
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos para insertar inofrmaicon en la base de datos ------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void insertarLibro(LibroVO lvo){
        Conexcion cnx=new Conexcion();
        try{
            cnx.conectar();
            String cslt="INSERT INTO libro VALUES("+lvo.getIsbn()+",'"+lvo.getTitulo()+"','"+lvo.getEditorial()+"','"
                    +lvo.getLugarEdicion()+"',"+lvo.getAnioEdicion()+","+lvo.getNumeroPaginas()+");";
            cnx.consultasSql(cslt);
            //String cnst="INSERT INTO autorlibro VALUES("+lavo.getIdAutor() +","+lavo.getIsbn() +");";
            //cnx.consultasSql(cnst);
        }catch(Exception ex){
            System.err.println("Error Insertar Libro:>"+ex.getMessage());
        }// fin del capturador de excepciones 
        
    }// fin del metodo insertar
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos para editar informaicon en la base de datos --------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void editarLibro(){
    }// fin del metodo editar 
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos para Eliminar informaicon en la base de datos ------------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public void elimarLibro(){        
    }// fin del metodo eliminar
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos para obtener los registros de la base de datos ------------------------------------------------------------>>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    public ArrayList<LibroVO> cargarLibros(){
        Conexcion cnx=new Conexcion();// cargamos la conexion a la base de datos
        ArrayList<LibroVO> listado=new ArrayList<>();// arreglo para cargar la informacion a mostrar
        try{
            cnx.conectar();// abrir conexion 
            String cslt="SELECT * FROM libro;";
            ResultSet rs=cnx.obtenerDatos(cslt);
            
            while(rs.next()){
                LibroVO lvo=new LibroVO();
                lvo.setIsbn(rs.getInt(1));
                lvo.setTitulo(rs.getString(2));
                lvo.setEditorial(rs.getString(3));
                lvo.setLugarEdicion(rs.getString(4));
                lvo.setAnioEdicion(rs.getInt(5));
                lvo.setNumeroPaginas(rs.getInt(6));
                
                listado.add(lvo);
            }// fin del ciclo que carga informacion 
            cnx.desconectar();
            
        }catch(Exception ex){
            System.err.println("Error CargarLibros:>"+ex.getMessage());
        }// fin del capturado de excepciones 
        
        return listado;
    }// fin del metodo cargarLibros
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos para cargar los datos de autores de la base de datos------------------------------------------------------->>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/      
    
    public ArrayList<AutorVO> cargarAutores(){
        Conexcion cnx=new Conexcion();
        ArrayList autores=new ArrayList();
        try{
            cnx.conectar();
            String csltAutor="SELECT id_autor, nombre, apellido FROM autor;";
            ResultSet rsa=cnx.obtenerDatos(csltAutor);
            
            while(rsa.next()){
                AutorVO avo=new AutorVO();
                avo.setId_autor(rsa.getInt(1));
                avo.setNombre(rsa.getString(2));
                avo.setApellido(rsa.getString(3));
                avo.setFechaNacimiento(null);
                avo.setNacionalidad(null);     
                
                autores.add(avo);
            }// fin del metodo
            
            cnx.desconectar();
            System.out.println("Cargando autores-------->>");
        }catch(Exception ex){
            System.err.println("Error cargarAutores:>"+ex.getMessage());
        }// fin del capturador de excepciones
        return autores;
    }// fin del metodo
    
    
            
}// fin de la clase LibroDAO
