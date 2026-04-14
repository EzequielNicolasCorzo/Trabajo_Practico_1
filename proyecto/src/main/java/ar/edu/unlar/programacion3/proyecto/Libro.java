package ar.edu.unlar.programacion3.proyecto;

public class Libro {
    
    //Declaracion de datos

    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;  
    

    //Constructor

    public Libro(String ISBN, String titulo, String autor, int anio, boolean disponible){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
       
    }
    
    //Getters y setters

    //ISBN
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    //titulo
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    //autor
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    //año
    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }

    //disponible
    public boolean getDisponible(){
        return disponible;
    }
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
}
