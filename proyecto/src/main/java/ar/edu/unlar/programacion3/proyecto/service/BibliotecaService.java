package ar.edu.unlar.programacion3.proyecto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unlar.programacion3.proyecto.model.Estudiante;
import ar.edu.unlar.programacion3.proyecto.model.Libro;
import ar.edu.unlar.programacion3.proyecto.model.Prestamo;

public class BibliotecaService {
        
    //Colecciones
    private List<Libro>libros = new ArrayList<>();
    private Map<String, Estudiante>estudiantes = new  HashMap<>();
    private Set<Prestamo>prestamos = new HashSet<>();

    public void cargaDatos(){

    //Catalogo de libros 
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

	//Registro de estudiantes
	Estudiante estudiante1 = new Estudiante(    "1212", 
											    "Lucas Romero", 
												"Medicina", 
												"lucasromero.edu.unlar");
		
	Estudiante estudiante2 = new Estudiante(    "1232", 
												"Matias Lozano", 
												"Ingenieria en Sistemas", 
												"matiaslozano.edu.unlar");
		
	Estudiante estudiante3 = new Estudiante(    "1252", 
												"Marcos Castro", 
												"Licenciatura en Sistemas", 
												"marcoscastro.edu.unlar");
	estudiantes.put(estudiante1.getLegajo(), estudiante1);
	estudiantes.put(estudiante2.getLegajo(), estudiante2);
	estudiantes.put(estudiante3.getLegajo(), estudiante3);

		/*
		Prestamo prestamo1 = new Prestamo(libro1, estudiante1, 
											LocalDate.of(2026, 01, 10),  //Fecha prestamo
											LocalDate.of(2026, 02, 20)); //Fecha devolucion

		Prestamo prestamo2 = new Prestamo(libro3, estudiante2, 
											LocalDate.of(2026, 03, 10),  //Fecha prestamo
											LocalDate.of(2026, 04, 17)); //Fecha devolucion

		Prestamo prestamo3 = new Prestamo(libro5, estudiante3, 
											LocalDate.of(2026, 02, 17),  //Fecha prestamo
											LocalDate.of(2026, 03, 17)); //Fecha devolucion
		prestamos.add(prestamo1);
		prestamos.add(prestamo2);
		prestamos.add(prestamo3);

		La forma la forma en que cargabamos los prestamos al hashset no estaba bien porque no se actualizaba la disponibilidad xd
		*/
		
    }
	
    public void mostrarDatos(){

        System.out.println("|	Catalogo de libros	|");

		for (Libro l : libros) {
			System.out.println(l);
		}
		
		System.out.println("|	Registro de estudiantes 	|");
		for (Estudiante e : estudiantes.values()) {
			System.out.println(e);
		}

		System.out.println("|	Prestamos activos 	|");
		
		for (Prestamo p : prestamos) {
			System.out.println(p);
		}	

    }

	//metodo para realizar prestamos, con validaciones y excepciones
	public void realizarPrestamo(String legajo, String ISBN) throws Exception{
		Estudiante estudiante = estudiantes.get(legajo);
		if(estudiante == null){
			throw new Exception("Estudiante con legajo " + legajo + " no registrado"); //EstudianteNoEncontradoException
		}
		
		int countPrestamos = 0;
		for (Prestamo p : prestamos) {
			if(p.getEstudiante().getLegajo().equals(legajo)){ //contar prestamos activos del estudiante
				countPrestamos++;
			}
		}
		if(countPrestamos >= 3){
			throw new Exception("El estudiante " + estudiante.getNombre() + " ya tiene 3 prestamos activos"); //LimitePrestamosExcedidoException
		}

		Libro libro = null;
		for (Libro l : libros) {
			if(l.getISBN().equals(ISBN)){
				libro = l;
				break;
			}
		}
		if(libro == null){
			throw new Exception("Libro con ISBN " + ISBN + " no encontrado"); //LibroNoEncontradoException
		}
		if(!libro.getDisponible()){
			throw new Exception("Libro con ISBN " + ISBN + " no disponible para prestamo");//LibroNoDisponibleException (en caso de que el libro exista pero ya este prestado)
		}
		
		libro.setDisponible(false);
		
		LocalDate fechaPrestamo = LocalDate.now();
		LocalDate fechaDevolucion = fechaPrestamo.plusDays(30);
		
		Prestamo prestamo = new Prestamo(libro, estudiante, fechaPrestamo, fechaDevolucion);
		
		prestamos.add(prestamo);
		
		System.out.println("Prestamo realizado con exito");
	}

	//metodo recursivo en private para calcular multa
	private double calcularMulta(int diasRetraso, double valorLibro){
		if (diasRetraso < 30 && diasRetraso > 0) {
			valorLibro = valorLibro * 0.01;
			diasRetraso--;
			return calcularMulta(diasRetraso, valorLibro);
		}
		return valorLibro;
	}
	
	//metodo para registrar devolucion, calcular multa y 
	public void registrarDevolucion(String legajo, String ISBN, int diasRetraso, double valorLibro) throws Exception{
		Estudiante estudiante = estudiantes.get(legajo);
		if(estudiante == null){
			throw new Exception("Estudiante con legajo " + legajo + " no registrado"); //EstudianteNoEncontradoException
		}

		Libro libro = null;
		for (Libro l : libros) {
			if(l.getISBN().equals(ISBN)){
				libro = l;
				break;
			}
		}
		if(libro == null){
			throw new Exception("Libro con ISBN " + ISBN + " no encontrado"); //LibroNoEncontradoException
		}

		Prestamo prestamoEncontrado = null;
		for (Prestamo p : prestamos) {
			if(p.getEstudiante().getLegajo().equals(legajo) && p.getLibro().getISBN().equals(ISBN)){
				prestamoEncontrado = p;
				break;
			}
		}
		if(prestamoEncontrado == null){
			throw new Exception("No se encontro un prestamo activo para el estudiante con legajo " + legajo); //PrestamoNoEncontradoException
		}

		double multa = calcularMulta(diasRetraso, valorLibro);
		if(multa > 0){
			System.out.println("El estudiante " + estudiante.getNombre() + " tiene una multa de $" + multa + " por la devolucion tardia del libro '" + libro.getTitulo() + "'");
		} else {
			System.out.println("Devolucion registrada sin multas. Gracias por devolver el libro '" + libro.getTitulo() + "' a tiempo, " + estudiante.getNombre());
		}

		prestamos.remove(prestamoEncontrado);
		libro.setDisponible(true);
	}

	//metodo para buscar libro en base al nombre e imprimir resultados del libro con toString()
	public void buscarLibro(String titulo) throws Exception{
		List<Libro> resultados = new ArrayList<>();
		for (Libro l : libros) {
			if(l.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
				resultados.add(l);
			}
		}
		if(resultados.isEmpty()){
			throw new Exception("No se encontraron libros con el titulo " + titulo);
		}
		
		System.out.println("Resultados de busqueda para el titulo '" + titulo + "':");
		for (Libro l : resultados) {
			System.out.println(l.toString());
		}
	} 

	//metodo para mostrar los prestamos por estudiante, basado en legajo
	public void mostrarPrestamosPorEstudiante(String legajo) throws Exception{
		Estudiante estudiante = estudiantes.get(legajo);
		if(estudiante == null){
			throw new Exception("Estudiante con legajo " + legajo + " no registrado");
		}
		
		System.out.println("Prestamos activos para el estudiante " + estudiante.getNombre() + ":");
		for (Prestamo p : prestamos) {
			if(p.getEstudiante().getLegajo().equals(legajo)){
				System.out.println(p.toString());
			}
		}
	}

}