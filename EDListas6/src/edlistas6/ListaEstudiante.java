/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edlistas6;
import java.util.Scanner;

/**
 *
 * @author Diego Vivas
 */
public class ListaEstudiante {
    
    private Nodo primero;
    private Nodo ultimo;
    private int cantidad;
    
    private boolean isEmpty(){ //metodo adicional para control de excepciones
        return primero == null;
    }
    
    public int calcularPromedioEdad(){

        if (isEmpty()){
            return 0;
        }else{
            Nodo nuevo = primero;
            int promedio = 0;
            for(int i = 0 ; i < cantidad ; i++){
                promedio += nuevo.getValor().getEdad();  
                nuevo = nuevo.getSiguiente(); 
            }
            promedio/=cantidad;
            return promedio;
        }
    }
    
    public void calcularEdadMayor(){
        if(isEmpty()){
              System.out.println("0");
        }else{
            Nodo mayor=primero;
            Nodo nuevo=primero;
            int indice =1;
            for (int i=1 ; i<cantidad ; i++){
                nuevo=nuevo.getSiguiente();
                    if(mayor.getValor().getEdad()<nuevo.getValor().getEdad()){
                        mayor=nuevo; 
                        indice=i;
            }
        }
        System.out.println("El mayor es: "+mayor.mostrarInformacion()+"\nIndice: "+indice);
        }
    }
    
    public void calcularEdadMenor(){
        if(isEmpty()){
            System.out.println("0");  
        }else{
            Nodo menor=primero;
            Nodo nuevo=primero;
            int indice = 1;
            for (int i=0 ; i<cantidad-1 ; i++){
                nuevo=nuevo.getSiguiente();
                    if(menor.getValor().getEdad()>nuevo.getValor().getEdad()){
                        menor=nuevo; 
                        indice = i;
            }
        }
        System.out.println("El menor es: "+menor.mostrarInformacion()+"\nIndice: "+indice);
        }
    }
    
    public void agregar(Nodo n){
        
        if(isEmpty()){
            primero=n;
            ultimo=primero;
        }else{ 
            Nodo current = primero; 
            Nodo anterior = primero;
         
            String nuevoIngreso = String.valueOf(n.getValor().getNombre().trim().toLowerCase().charAt(0));
            String elementoX = String.valueOf(current.getValor().getNombre().trim().toLowerCase().charAt(0));
        
            if(nuevoIngreso.compareTo(String.valueOf(ultimo.getValor().getNombre().trim().toLowerCase().charAt(0)))>=0){  
                ultimo.setSiguiente(n); 
                ultimo=n ;   
            }else { 
                for(int i=0 ; i<cantidad-1 ; i++){   
                    //current=current; 
                    if(i!=0){ 
                        anterior= anterior.getSiguiente();
                    } 
                    elementoX = String.valueOf(current.getValor().getNombre().trim().toLowerCase().charAt(0)); 
                    if(nuevoIngreso.compareTo(elementoX)<=0){   
                        anterior.setSiguiente(n);
                        n.setSiguiente(current);    
                        break; 
                    } 
                }
            }
        }    
    }
    
    public int Menu(){
        
        Scanner leer= new Scanner(System.in);
        System.out.println("""
                           Digite 1: Agregar
                           Digite 2: Buscar por indice
                           Digite 3: Eliminar por incice
                           Digite 4: Obtener primero
                           Digite 5: Obtener ultimo
                           Digite 6: Vaciar lista
                           Digite 7: Eliminar ultimo
                           Digite 8: Imprimir solo lista
                           Digite 9: Otros calculos
                           Digite 0: Finalizar""");
        int num=leer.nextInt();
        
        return num;
    }
    
    public void imprimir(){
        System.out.println(primero.mostrarInformacion());
    }
    
    public Nodo buscarPorIndice(int indice){
        Nodo n = primero;
        for(int i=0 ; i==indice-1 ; i++){
            n = n.getSiguiente();
        }
        return n;
    }
    
    public void eliminarPorIndice(int indice){
        Nodo n = primero;
        int i=0;
        for( i=0 ; i==indice-1 ; i++){
            n = n.getSiguiente();
        }
        if(i==indice){
            n = null;
        }
    }
    
    public Nodo obtenerPrimero(){
        return primero;
    }
     
    public Nodo obtenerUltimo(){
        return ultimo;
    }
     
    public void eliminarPrimero(){
        primero=null;
        cantidad=0;
    }
     
    public void eliminarUltimo(){
        ultimo = null;
        cantidad--;
    }
    
    public void Vaciar(){
        eliminarPrimero();
    }
}

