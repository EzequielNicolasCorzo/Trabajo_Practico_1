package ar.edu.unlar.programacion3.proyecto.exception;

public class LibroNoDisponibleException extends Exception{
    //Constructir parametrizado
    public LibroNoDisponibleException(String mensaje){
        super(mensaje); //super envia este mensaje a la clase madre exception
    }

}

