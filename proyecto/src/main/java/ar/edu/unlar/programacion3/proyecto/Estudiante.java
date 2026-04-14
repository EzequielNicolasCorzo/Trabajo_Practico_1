package ar.edu.unlar.programacion3.proyecto;

public class Estudiante {

    //Declaracion de datos

    private String legajo;
    private String nombre;
    private String carrera;
    private String email;
 
    //Constructor

    public Estudiante(String legajo, String nombre, String carrera, String email){
        this.legajo = legajo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.email = email;

    }

    //Getters y setters

    //legajo
    public String getLegajo(){
        return legajo;
    }
    public void setLegajo(String legajo){
        this.legajo = legajo;
    }

    //nombre
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    //carrera
    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    //email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}