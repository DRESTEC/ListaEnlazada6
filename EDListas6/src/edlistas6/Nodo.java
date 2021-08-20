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
public class Nodo {
    
    private Nodo siguiente;
    private Estudiante valor;
    
    public Nodo(String nombre, int edad){
        Estudiante nuevo = new Estudiante(nombre, edad);
        setValor(nuevo);
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Estudiante getValor() {
        return valor;
    }

    private void setValor(Estudiante valor) {
        this.valor = valor;
    }
    
    public String mostrarInformacion(){
        return "Estudiante: "+ valor.getNombre()+"  Edad: "+valor.getEdad();
    }
}
