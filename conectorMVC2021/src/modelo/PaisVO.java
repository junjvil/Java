/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author HP
 */
public class PaisVO {
    
    // campos, variables de instancia ----------------------------------------------------------------->>
    private int id_pais;
    private String nombre_pais;
    private String capital_pais;
    private long poblacion_pais;
    
    // metodos set and gets ----------------------------------------------------------------->>
    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getCapital_pais() {
        return capital_pais;
    }

    public void setCapital_pais(String capital_pais) {
        this.capital_pais = capital_pais;
    }

    public long getPoblacion_pais() {
        return poblacion_pais;
    }

    public void setPoblacion_pais(long poblacion_pais) {
        this.poblacion_pais = poblacion_pais;
    }
                
    
    public PaisVO(){
        
    }
}
