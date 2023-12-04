/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author victor
 */
public class Cita {

    // Atributos
    private String nombreUsuario;
    private final LocalDateTime fechaCita;
    private LocalDate fechaLlamada;
    private String nombreMascota;
    private EstadoCita EstadoCita;
    
    public static final LocalTime apertura = LocalTime.of(10,0,0);
    public static final LocalTime cierre = LocalTime.of(19,0,0);

    //Constructor sin parametros
    public Cita() {
        this.nombreUsuario = " ";
        LocalDate hoy = LocalDate.now();
        LocalDate cita = hoy.plusDays(15); //Hoy + 15 dias
        this.fechaCita = LocalDateTime.of(cita.getYear(),
                cita.getMonth(), cita.getDayOfMonth(),
                10, 0, 0);
        this.fechaLlamada = hoy;
        this.nombreMascota = " ";
        this.EstadoCita = EstadoCita.ACTIVA;
    }

    //Constructor con parametros
    public Cita(String nombreUsuario, LocalDateTime fechaCita, String nombreMascota) {
        this.nombreUsuario = nombreUsuario;
        this.EstadoCita=EstadoCita.ACTIVA;
        this.nombreMascota=nombreMascota;
        this.fechaLlamada=LocalDate.now();

        LocalDateTime hoy = LocalDateTime.now();
        // Si la cita es para antes de la llamada
        if (fechaCita.isAfter(hoy)) {
            this.fechaCita = fechaCita;
        } else {
            throw new IllegalArgumentException("Error no se puede crear esta cita");
        }
        // Controlar que la cita no sea un miercoles
        if (fechaCita.getDayOfWeek().equals(hoy.getDayOfWeek().WEDNESDAY)) {
            throw new IllegalArgumentException("Error no se puede crear esta cita, "
                    + "estamos cerrados");
        } 

        // Controlar que la hora de la cita este entre las 10 y las 19
        
        int horaCita= fechaCita.getHour();
        int horaApertura = fechaCita.getHour();
        int horaCierre= fechaCita.getHour();
        if(fechaCita.getHour()<horaApertura && fechaCita.getHour()>horaCierre){
            throw new IllegalArgumentException("Error no se puede crear esta cita, "
                    + "estamos cerrados");
        }
          
        
        
        //horaCita<horaApertura && horaCita>horaCierre
        
        //IMPLEMENTAMOS GETTERS 
        
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public LocalDate getFechaLlamada() {
        return fechaLlamada;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public EstadoCita getEstadoCita() {
        return EstadoCita;
    }

    //IMPLEMENTAMOS LOS SETTERS

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        
  
        
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
    
    //CREAMOS EL TO.STRING

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cita{");
        sb.append("nombreUsuario=").append(nombreUsuario);
        sb.append(", fechaCita=").append(fechaCita);
        sb.append(", fechaLlamada=").append(fechaLlamada);
        sb.append(", nombreMascota=").append(nombreMascota);
        sb.append(", EstadoCita=").append(EstadoCita.getDescripcion());
        //INDICAMOS GET.DESCRIPCION PARA MOSTRAR LA DESCRIPCION DEL ESTADO
        sb.append('}');
        return sb.toString();
    }
    
    //METODOS PARA EL ESTADO DE LAS CITAS
    
    public void anularCita() {
        this.EstadoCita= EstadoCita.ANULADA;
    }
    
    public void activarCita() {
        this.EstadoCita = EstadoCita.ACTIVA;
    }
    
    public void realizarCita() {
        this.EstadoCita = EstadoCita.REALIZADA;
    }
    
    public void noRealizarCita() {
        this.EstadoCita = EstadoCita.NO_REALIZADA;
    }
    
    
    
}
