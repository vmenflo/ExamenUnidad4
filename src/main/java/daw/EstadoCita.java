/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author victor
 */
public enum EstadoCita {
    ACTIVA("Aún no ha llegado la fecha de la cita y no se ha cancelado"), 
    ANULADA("La cita se canceló"),
    REALIZADA("El usuario acudió a la cita"),
    NO_REALIZADA ("no acudió ni canceló la reserva");
    
    //Declaramos la variable descripcion
    private final String descripcion;
    
    //Realizamos el constructor
    private EstadoCita(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //Realizamos el Getter, los enum no necesita setter
    public String getDescripcion() {
        return descripcion;
    }
    
    
}
