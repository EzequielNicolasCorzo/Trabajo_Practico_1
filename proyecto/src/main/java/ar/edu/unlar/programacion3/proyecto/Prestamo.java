package ar.edu.unlar.programacion3.proyecto;

import java.time.LocalDate;

public class Prestamo {
    
    //Declaracion de datos
    
    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    //Constructor

    public Prestamo(Libro libro, Estudiante estudiante, LocalDate fechaPrestamo, LocalDate fechaDevolucion){
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    //Getters y setters

    //libro
    public Libro getLibro(){
        return libro;
    }
    public void setLibro(Libro libro){
        this.libro = libro;
    }

    //estudiante
    public Estudiante getEstudiante(){
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante){
        this.estudiante = estudiante;
    }

    //fechaPrestamo
    public LocalDate getFechaPrestamo(){
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }

    //fechaDevolucion
    public LocalDate getFechaDevolucion(){
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }

}