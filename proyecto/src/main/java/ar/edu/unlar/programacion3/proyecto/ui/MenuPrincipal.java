package ar.edu.unlar.programacion3.proyecto.ui;

import java.util.Scanner;

import ar.edu.unlar.programacion3.proyecto.exception.EstudianteNoEncontradoException;
import ar.edu.unlar.programacion3.proyecto.exception.LibroNoDisponibleException;
import ar.edu.unlar.programacion3.proyecto.exception.LimitePrestamosExcedidosException;
import ar.edu.unlar.programacion3.proyecto.service.BibliotecaService;

public class MenuPrincipal {
    private Scanner teclado;
    private BibliotecaService service; 

    public MenuPrincipal(Scanner teclado, BibliotecaService service){
        this.teclado = new Scanner(System.in);
        this.service = service;
    }

        public void mostrarMenuBiblioteca(){
        int opcion = 0;

        do {
            System.out.println("--Interfaz biblioteca");
            System.out.println("1.Buscar libros");
            System.out.println("2.Registrar prestamo");
            System.out.println("3.Registrar devolucion");
            System.out.println("4.Listar prestamos");
            System.out.println("5.Salir");
            System.out.println("--Seleccione una opcion: ");
            
            opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion){
                case 1 -> {
                    service.mostrarCatalogoLibros();
                    System.out.println("Ingrese el titulo del libro a buscar: ");
                    String tituloABuscar= teclado.nextLine();
                    service.buscarLibroPorTitulo(tituloABuscar);
                }
                case 2 -> {
                    System.out.println("Ingrese legajo del estudiante: ");
                    String legajo = teclado.nextLine();
                    System.out.println("Ingrese el ISBN del libro: ");
                    String isbn = teclado.nextLine();

                    try {
                        service.registrarPrestamo(legajo, isbn);
                        System.out.println("Prestamo registrado exitosamente.");
                    } catch (EstudianteNoEncontradoException | LibroNoDisponibleException  | LimitePrestamosExcedidosException e) {
                        System.out.println("Error en prestamo - " + e.getMessage());
                    }finally{
                        System.out.println("Proceso de registro finalizado.");
                    }
                }
                case 3 -> System.out.println();
                case 4 -> {
                    service.mostrarPrestamosActivos();
                }
                case 5 -> System.out.println("Saliendo de la interfaz biblioteca");
                default -> System.out.println("Invalida opcion");
            }

        } while (opcion != 5 );

}
}
