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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaEstudiante lista = new ListaEstudiante();
        
        int num=400;
        
        while (num!=0){
            num = lista.Menu();
            
            if(num==1){
                Scanner leer= new Scanner(System.in);
                System.out.println("Nombre:");
                String nombre = leer.next();
                
                Scanner leeredad= new Scanner(System.in);
                System.out.println("Edad:");
                int edad = leeredad.nextInt();
                
                Nodo n = new Nodo(nombre,edad);
                
                lista.agregar(n);
                
            }else if(num==2){
                Scanner leer= new Scanner(System.in);
                System.out.println("Indice:");
                int indice = leer.nextInt();
                
                Nodo n = lista.buscarPorIndice(indice);
                System.out.println(n.mostrarInformacion());  
            }else if(num==3){
                Scanner leer= new Scanner(System.in);
                System.out.println("Indice:");
                int indice = leer.nextInt();
                
                lista.eliminarPorIndice(indice);
            }else if(num==4){
                System.out.println(lista.obtenerPrimero().mostrarInformacion());
            }else if(num==5){
                System.out.println(lista.obtenerUltimo().mostrarInformacion());
            }else if(num==6){
                lista.Vaciar();
            }else if(num==7){
                lista.eliminarUltimo();
            }else if(num==8){
                lista.imprimir();
            }else if(num==9){
                System.out.println("Promedio: "+lista.calcularPromedioEdad());
                lista.calcularEdadMenor();
                lista.calcularEdadMayor();
            }
        }
    }
}
