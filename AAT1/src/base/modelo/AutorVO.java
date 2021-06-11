/*
 *  Esta clase permite el manejo de la informacion para las tablas de la base de datos
 */
package base.modelo;


import java.time.LocalDate;

/**
 *
 * @author Juan Jossue Villegas Acju
 */

public class AutorVO { 
    
    // Declaracion de campos para el manejo de informacion de la base de datos    
    private int id_autor;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;

    public AutorVO() {
    }
    
    
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------------
      ----------------------------------------------- metodos get and set para manejo de informacion de la base de datos ------------------------------------------------>>
      -------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
    
}// fin de la clase principal 
