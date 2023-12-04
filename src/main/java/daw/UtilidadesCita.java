/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class UtilidadesCita {
    
    //Metodo devolver fechaValida
    public static LocalDateTime pedirFechaHora() {
        
        Scanner teclado = new Scanner(System.in);
        
        int año, mes, dia, hora, minutos, segundos;
        boolean valido;
        LocalDateTime fechaValida=null;
        
        do{
        System.out.println("Introduce año");
        año = teclado.nextInt();
        
        System.out.println("Introduce mes");
        mes = teclado.nextInt();
        
        System.out.println("Introduce dia");
        dia = teclado.nextInt();
        
        System.out.println("Introduce hora");
        hora = teclado.nextInt();
        
        System.out.println("Introduce minutos");
        minutos = teclado.nextInt();
        
        //System.out.println("Introduce segundos");
        //segundos = teclado.nextInt();
        
        
        try{
        fechaValida= LocalDateTime.of(año,mes,dia,hora,minutos);
        valido = true;
        
        } catch(DateTimeException ei){
            System.out.println("Vuelva a introducir los datos");
        }
        }while(valido=false);
        
        return fechaValida;
    }
    
    public static Cita pedirDatosCita() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Como te llamas?");
        String nombre = teclado.nextLine();
        
        System.out.println("¿Nombre de la mascota?");
        String nombreMascota = teclado.nextLine();
        
        
        //Construimos la cita con nuestro constructor de 3 parametros
        
        try{
        Cita citaCreada = new Cita(nombre, pedirFechaHora(),nombreMascota);
        return citaCreada;
        
        }catch(IllegalArgumentException iae){
            Cita citaCreada = new Cita();
            return citaCreada;
        }
        
    }
}
