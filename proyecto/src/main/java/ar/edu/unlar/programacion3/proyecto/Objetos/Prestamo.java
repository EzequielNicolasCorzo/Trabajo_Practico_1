package ar.edu.unlar.programacion3.proyecto.Objetos;

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

    public double calcularMulta(int diasRetraso, double precioLibro) {
        int contador = 0;
        precioLibro = precioLibro * 0.01;
        contador = contador + 1;

        if (contador < diasRetraso || contador < 30) {
            return calcularMulta(contador, precioLibro);   
        }
        return precioLibro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((libro == null) ? 0 : libro.hashCode());
        result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
        result = prime * result + ((fechaPrestamo == null) ? 0 : fechaPrestamo.hashCode());
        result = prime * result + ((fechaDevolucion == null) ? 0 : fechaDevolucion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        if (libro == null) {
            if (other.libro != null)
                return false;
        } else if (!libro.equals(other.libro))
            return false;
        if (estudiante == null) {
            if (other.estudiante != null)
                return false;
        } else if (!estudiante.equals(other.estudiante))
            return false;
        if (fechaPrestamo == null) {
            if (other.fechaPrestamo != null)
                return false;
        } else if (!fechaPrestamo.equals(other.fechaPrestamo))
            return false;
        if (fechaDevolucion == null) {
            if (other.fechaDevolucion != null)
                return false;
        } else if (!fechaDevolucion.equals(other.fechaDevolucion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro='" + libro + '\'' +
                ", estudiante='" + estudiante + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                '}';
    }
}