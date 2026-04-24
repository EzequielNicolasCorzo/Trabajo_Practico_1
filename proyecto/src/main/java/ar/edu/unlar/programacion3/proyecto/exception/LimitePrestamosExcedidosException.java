package ar.edu.unlar.programacion3.proyecto.exception;

public class LimitePrestamosExcedidosException extends Exception{
    //Constructor parametrizado
    public LimitePrestamosExcedidosException(String mensaje){
        super(mensaje); //super envia este mensaje a la clase madre exception
    }
}
