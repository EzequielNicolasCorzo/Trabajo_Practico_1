package ar.edu.unlar.programacion3.proyecto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ar.edu.unlar.programacion3.proyecto.exception.EstudianteNoEncontradoException;
import ar.edu.unlar.programacion3.proyecto.exception.LibroNoDisponibleException;
import ar.edu.unlar.programacion3.proyecto.exception.LimitePrestamosExcedidosException;
import ar.edu.unlar.programacion3.proyecto.model.Estudiante;
import ar.edu.unlar.programacion3.proyecto.model.Libro;
import ar.edu.unlar.programacion3.proyecto.model.Prestamo;

public class BibliotecaService {
        
    //Colecciones
    ArrayList<Libro>libros = new ArrayList<>();
    HashMap<String, Estudiante>estudiantes = new  HashMap<>();
    HashSet<Prestamo>prestamos = new HashSet<>();


    public void registrarPrestamo(String legajo, String ISBN) throws 
    EstudianteNoEncontradoException, LibroNoDisponibleException, LimitePrestamosExcedidosException{
        
        //Validacion del estudiante
        Estudiante estudiante = estudiantes.get(legajo);
        if (estudiante == null) {
            throw new EstudianteNoEncontradoException("Legajo " + legajo + " inexistente.");
            
        }else{
            System.out.println("Estudiante encontrado: " + legajo);
        }

        //Validacion disponibilidad del libro 
        Libro libroSeleccionado = null;

        for (Libro l : libros) {
            if (l.getISBN().equals(ISBN)) {
                libroSeleccionado = l;
                break;
            }
        }

        if (libroSeleccionado == null || !libroSeleccionado.getDisponible()) {
            throw new LibroNoDisponibleException("El libro con " + ISBN + " no existe o no esta disponible.");
        }

        //Validacion del limite de estudiante por prestamo
        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.getEstudiante().getLegajo().equals(legajo)) {
                contador ++;
            }
        }

        if (contador>=3) {
            throw new LimitePrestamosExcedidosException("El estudiante ya posee 3 libros.");
        }

        //Registrar fecha
        libroSeleccionado.setDisponible(false);
        Prestamo nuevo = new Prestamo(libroSeleccionado, estudiante, LocalDate.now(), LocalDate.now().plusDays(15));
        prestamos.add(nuevo);
    }

    //Listar prestamos por estudiante
    public void mostrarPrestamosActivos(){
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos activos.");
        }else{
            for (Prestamo p : prestamos) {
                System.out.println(p);
            }
        }
    }

    //Catalogo de libros 
    public void cargarCatalogoLibros(){
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
    }

    //Busqueda libro por titulo

    public void buscarLibroPorTitulo(String busqueda){

        boolean encontrado = false;

        String busquedaMinuscula = busqueda.toLowerCase();
        
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(busquedaMinuscula)) {
                System.out.println(l);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontrron libros que coincida con: " +busqueda);
        }
    }


    //Registro de estudiantes
    public void cargarEstudiantes(){
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
    }

	
    /*public void cargarPrestamos(Estudiante estudiante , Libro libro ){
    
    //Prestamos activos
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

    }*/
	
    //Impresiones por pantalla

    public void mostrarCatalogoLibros(){

        System.out.println("|	Catalogo de libros	|");

		for (Libro l : libros) {
			System.out.println(l);
		}
    }

    public void mostrarRegistroEstudiantes(){
        
        System.out.println("|	Registro de estudiantes 	|");
		for (Estudiante e : estudiantes.values()) {
			System.out.println(e);
		}
    }

    public void mostrarPrestamos(){

        System.out.println("|	Prestamos activos 	|");
		
		for (Prestamo p : prestamos) {
			System.out.println(p);
		}	

        }

	}

