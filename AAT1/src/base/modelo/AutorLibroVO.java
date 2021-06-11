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
public class AutorLibroVO {
    int idAutor;
    int isbn;
    
    public AutorLibroVO() {
    }// fin del constructor de la clase

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    
    
}
