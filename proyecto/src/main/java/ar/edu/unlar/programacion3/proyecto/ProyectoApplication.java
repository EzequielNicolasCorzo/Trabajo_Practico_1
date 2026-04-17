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
		service.mostrarDatos();

		}
}