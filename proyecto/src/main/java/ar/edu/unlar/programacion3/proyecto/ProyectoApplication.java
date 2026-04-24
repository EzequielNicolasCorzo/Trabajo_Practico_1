package ar.edu.unlar.programacion3.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unlar.programacion3.proyecto.service.BibliotecaService;

@SpringBootApplication
public class ProyectoApplication {
		public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		
		BibliotecaService service = new BibliotecaService();
		service.cargaDatos();
		
		//Pruebas de excepciones
		//Excepcion de legajo no encontrado (EstudianteNoEncontradoException)
		try {
			service.realizarPrestamo("1234", "978-8491052143");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Estudiante existente pero libro no encontrado (LibroNoEncontradoException)
		try {
			service.realizarPrestamo("1212", "978-8467046475");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Prestamos 3 libros al mismo estudiante para probar excepcion de limite de prestamos (LimitePrestamosExcedidoException) y luego intentar prestar un libro ya prestado para probar excepcion de libro no disponible (LibroNoDisponibleException)
		try {
			service.realizarPrestamo("1212", "978-8467046465");
			service.realizarPrestamo("1212", "978-8491052142");
			service.realizarPrestamo("1212", "978-8437604312");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Forzamos la excepcion de limite de prestamos excedido al intentar prestar un cuarto libro al mismo estudiante
		try {
			service.realizarPrestamo("1212","978-8439728368");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			service.mostrarPrestamosPorEstudiante("1212");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			service.registrarDevolucion("1212", "978-8467046465", 15, 1200);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}