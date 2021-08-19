/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edlistas6;

/**
 *
 * @author Diego Vivas
 */
public class Estudiante {
    
    private String nombre;
    private int edad;
    
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Estudiante(String nombre, int edad){
        setEdad(edad);
        setNombre(nombre);
    }
}
