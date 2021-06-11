/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.modelo;

/**
 *
 * @author HP
 */
public class LibroVO {
    
    // declaracion de campos 
    private int isbn;
    private String titulo;
    private String editorial;
    private String lugarEdicion;
    private int anioEdicion;
    private int numeroPaginas;

    public LibroVO() {
    }
    
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos get and set para manejo de informacion de la base de datos ------------------------------------------------>>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getLugarEdicion() {
        return lugarEdicion;
    }

    public void setLugarEdicion(String lugarEdicion) {
        this.lugarEdicion = lugarEdicion;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }   
    
    
}// fin de la clase LibroVO
