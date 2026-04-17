package ar.edu.unlar.programacion3.proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unlar.programacion3.proyecto.Objetos.Estudiante;
import ar.edu.unlar.programacion3.proyecto.Objetos.Libro;
import ar.edu.unlar.programacion3.proyecto.Objetos.Prestamo;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		

		//Catalogo de libros

		ArrayList<Libro>libros = new ArrayList<>();
		
		Libro libro1 = new Libro(	"978-8491052142",
								    "Orgullo y Prejuicio",
									"Jane Austen", 
									1813, 
									true);
		
		Libro libro2 = new Libro(	"978-8467046465", 
									"Crimen y Castigo", 
									"eFiodor Dostoyevski", 
									1866, 
									true);

		Libro libro3 = new Libro(	"978-8439728368", 
									"Cien años de soledad", 
									"Gabriel García Márquez",
									1967, 
									true);

		Libro libro4 = new Libro(	"978-8420432878", 
									"Rayuela", 
									"Julio Cortazar", 
									1963, 
									true);
		
		Libro libro5 = new Libro(	"978-8437604312",
									"Los siete locos", 
									"Roberto Arlt", 
									1929, 
									true);							
		
		libros.add(libro1);
		libros.add(libro2);
		libros.add(libro3);
		libros.add(libro4);
		libros.add(libro5);

		System.out.println("|	Catalogo de libros	|");

		for (Libro l : libros) {
			System.out.println(l);
		}
		
		//Registro de estudiantes

		HashMap<String, Estudiante>estudiantes = new  HashMap<>();

		Estudiante estudiante1 = new Estudiante("1212", 
												"Lucas Romero", 
												"Medicina", 
												"lucasromero.edu.unlar");
		
		Estudiante estudiante2 = new Estudiante("1232", 
												"Matias Lozano", 
												"Ingenieria en Sistemas", 
												"matiaslozano.edu.unlar");
		
		Estudiante estudiante3 = new Estudiante("1252", 
												"Marcos Castro", 
												"Licenciatura en Sistemas", 
												"marcoscastro.edu.unlar");

		estudiantes.put(estudiante1.getLegajo(), estudiante1);
		estudiantes.put(estudiante2.getLegajo(), estudiante2);
		estudiantes.put(estudiante3.getLegajo(), estudiante3);
		
		System.out.println("|	Registro de estudiantes 	|");
		for (Estudiante e : estudiantes.values()) {
			System.out.println(e);
		}

		//Prestamos activos

		HashSet<Prestamo>prestamos = new HashSet<>();

		Prestamo prestamo1 = new Prestamo(libro1, estudiante1, 
										  LocalDate.of(2026, 01, 10),  //Fecha prestamo
										  LocalDate.of(2026, 02, 20)); //Fecha devolucion

		Prestamo prestamo2 = new Prestamo(libro3, estudiante2, 
										  LocalDate.of(2026, 03, 10),  //Fecha prestamo
										  LocalDate.of(2026, 04, 17)); //Fecha devolucion

		Prestamo prestamo3 = new Prestamo(libro5, estudiante3, 
										  LocalDate.of(2026, 02, 17),  //Fecha prestamo
										  LocalDate.of(2026, 03, 17)); //Fecha devolucion

		System.out.println("|	Prestamos activos 	|");
		
		prestamos.add(prestamo1);
		prestamos.add(prestamo2);
		prestamos.add(prestamo3);

		for (Prestamo p : prestamos) {
			System.out.println(p);
		}
		

	}

}
