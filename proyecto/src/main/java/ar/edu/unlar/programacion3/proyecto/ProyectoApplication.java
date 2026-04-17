package ar.edu.unlar.programacion3.proyecto;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unlar.programacion3.proyecto.Objetos.Estudiante;
import ar.edu.unlar.programacion3.proyecto.Objetos.Libro;
import ar.edu.unlar.programacion3.proyecto.Objetos.Prestamo;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);

		List<Libro> libros = new ArrayList<>();
		Map<String, Estudiante> estudiantes = new HashMap<>();
		Set<Prestamo> prestamos = new HashSet<>();

		Scanner entrada = new Scanner(System.in);

		Prestamo prestamo1 = new Prestamo(null, null, null, null);


		//agregar libros al arraylist
		libros.add(new Libro("978-3-16-148410-0",
							 "El Quijote", 
							 "Miguel de Cervantes", 
							 1605, 
							 true));
		
		 libros.add(new Libro("978-0-14-044913-6", 
		 					 "La Odisea", 
							 "Homero", 
							 -800, 
							 true));


		 //agregar estudiantes al hashmap
		estudiantes.put("12345", new Estudiante("12345", "Juan Perez", "Ingenieria Informatica", "juan.perez@unlar.edu.ar"));
		estudiantes.put("67890", new Estudiante("67890", "Maria Gomez", "Licenciatura en Informatica", "maria.gomez@unlar.edu.ar"));

		//agregar prestamos al hashset
		prestamos.add(new Prestamo(libros.get(0), estudiantes.get("12345"), java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(14)));
		prestamos.add(new Prestamo(libros.get(1), estudiantes.get("67890"), java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(14)));

		//imprimir todos los valores de las listas
		String legajo = entrada.nextLine();

		//manejo de exception estudiante con if
		if (estudiantes.get(legajo) == null) {
			System.out.println("Estudiante no encontrado");
		} else {
			System.out.println(estudiantes.get(legajo.toString()));
		}

		System.out.println(prestamo1.calcularMulta(5, 50));
	}

}