package ar.edu.unlar.programacion3.proyecto;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unlar.programacion3.proyecto.service.BibliotecaService;
import ar.edu.unlar.programacion3.proyecto.ui.MenuPrincipal;

@SpringBootApplication
public class ProyectoApplication {
		public static void main(String[] args) {
		BibliotecaService service = new BibliotecaService();
		
		service.cargarCatalogoLibros();
		service.cargarEstudiantes();

		MenuPrincipal menu = new MenuPrincipal(null, service);
		menu.mostrarMenuBiblioteca();

		}
}