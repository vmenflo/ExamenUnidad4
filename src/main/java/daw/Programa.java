/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Programa {
    
    public static void main(String[] args) {
        final Scanner teclado = new Scanner(System.in);
        int opcion=0;
        do{ // Bucle principal para controlar el programa
        String menu ="""
                     
                     Opciones del menu:
                     1- Crear cita por defecto
                     2- Solicitar datos al usuario
                     3- Cita por defecto y permite modificar la fecha
                     4- Salir
                     
                     """;
       
       
        //System.out.println(menu);
        //opcion = teclado.nextInt();
        
      boolean repetir = true;
      do {
            System.out.println(menu);
            try {
                opcion = teclado.nextInt();
                repetir = false;
            } catch (InputMismatchException ime) {
                // En caso de error
                System.out.println("Error en el formato" +ime);
                // Limpieza del buffer
                teclado.nextLine();
            }
        } while (repetir);
        
        
        //Creamos el menu con una estructura de seleccion
        switch(opcion){
        
            case 1-> {
               Cita citaPorDefecto = new Cita();
               citaPorDefecto.anularCita(); //Llamamos al metodo para anularla
                System.out.println(citaPorDefecto.toString());
               
            
            }
            case 2-> {
                Cita citaNueva=null;
                boolean seguir = true;
                do{
                try{
                citaNueva = UtilidadesCita.pedirDatosCita();
                seguir=false;
                
                }catch(IllegalArgumentException e) {
                    System.out.println("Error. ha saltado una excepcion." + e 
                            + " Inserte los datos de nuevo ");
                    teclado.nextLine();
                }
                }while(seguir);
                
                
                System.out.println(citaNueva.toString());
                
            
            }
            case 3-> {
                Cita citaPorDefecto = new Cita();
                System.out.println(citaPorDefecto.toString());
                citaPorDefecto.setFechaCita(UtilidadesCita.pedirFechaHora());
                System.out.println("Su cita ha sido modificada con exito " 
                        + citaPorDefecto.toString());
                
            }
            
        
        }
        
        }while(opcion!=4); //Si pulso 4 salimos del programa
        
        
    }
    
}
