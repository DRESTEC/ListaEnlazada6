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
public class ListaEstudiante implements IListaEnlazadaTDA {
    
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
            for (int i=1 ; i<=cantidad ; i++){
                nuevo=nuevo.getSiguiente();
                    if(mayor.getValor().getEdad()<nuevo.getValor().getEdad()){
                        mayor=nuevo; 
                        indice=i+1;
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
            for (int i=1 ; i<=cantidad ; i++){
                nuevo=nuevo.getSiguiente();
                    if(menor.getValor().getEdad()>nuevo.getValor().getEdad()){
                        menor=nuevo; 
                        indice = i+1;
            }
        }
        System.out.println("El menor es: "+menor.mostrarInformacion()+"\nIndice: "+indice);
        }
    }
    
    public void agregar(Nodo n){
        
        if(isEmpty()){
            primero=n;
            ultimo=primero;
            cantidad++;
        }else{ 
            Nodo nuevo = primero; 
            Nodo anterior = primero;
         
            String nuevoIngreso = String.valueOf(n.getValor().getNombre().trim().toLowerCase().charAt(0));
            String x = String.valueOf(nuevo.getValor().getNombre().trim().toLowerCase().charAt(0));
            
            if(nuevoIngreso.compareTo(x)<=0){ 
            n.setSiguiente(nuevo);
            primero=n;   
        
            }else if(nuevoIngreso.compareTo(String.valueOf(ultimo.getValor().getNombre().trim().toLowerCase().charAt(0)))>=0){  
                ultimo.setSiguiente(n); 
                ultimo=n ;   
                cantidad++;
            }else { 
                for(int i=0 ; i<cantidad-1 ; i++){   
                    nuevo=nuevo.getSiguiente(); 
                    if(i!=0){ 
                        anterior= anterior.getSiguiente();
                    } 
                    x = String.valueOf(nuevo.getValor().getNombre().trim().toLowerCase().charAt(0)); 
                    if(nuevoIngreso.compareTo(x)<=0){   
                        anterior.setSiguiente(n);
                        n.setSiguiente(nuevo);    
                        cantidad++;
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
        if(isEmpty()){
            System.out.println("lista vacia");
        }else{ 
            Nodo n = primero;
            for(int i = 0 ; i <= cantidad ; i++){
                System.out.println(n.mostrarInformacion()); 
                n = n.getSiguiente(); 
            }
        }
    }
    
    public Nodo buscarPorIndice(int indice){
        Nodo n = primero;
        for(int i=0 ; i==indice-1 ; i++){
            n = n.getSiguiente();
        }
        return n;
    }
    
    public void eliminarPorIndice(int indice){
        Nodo nuevo = primero;
        Nodo anterior = primero;
        if(isEmpty()){
            primero=primero.getSiguiente(); 
        }else if(indice==cantidad-1){
            for(int i=0 ; i<cantidad-1 ; i++){
                nuevo=nuevo.getSiguiente();
            }
            ultimo=nuevo; 
        }else{
            for(int i=0 ; i<indice ; i++){
                nuevo=nuevo.getSiguiente();
                if(i!=0){
                    anterior=anterior.getSiguiente();
                }
            } 
            anterior.setSiguiente(nuevo.getSiguiente()); 
        }
        cantidad--;
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

