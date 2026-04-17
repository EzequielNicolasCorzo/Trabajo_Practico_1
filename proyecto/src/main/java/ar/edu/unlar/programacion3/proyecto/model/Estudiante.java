package ar.edu.unlar.programacion3.proyecto.model;

public class Estudiante {

    //Declaracion de datos

    private String legajo;
    private String nombre;
    private String carrera;
    private String email;
    
    //Constructor por defecto

    public Estudiante(){    
    }


    //Constructor parametrizado

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

    //Metodo toString() informativo

    @Override
    public String toString() {
        return "legajo: " + legajo + ", nombre: " + nombre + ", carrera: " + carrera + ", email: " + email;
    }

    //Metodos hashCode() equals() necesarios para HashMap() 

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((legajo == null) ? 0 : legajo.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((carrera == null) ? 0 : carrera.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        if (legajo == null) {
            if (other.legajo != null)
                return false;
        } else if (!legajo.equals(other.legajo))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (carrera == null) {
            if (other.carrera != null)
                return false;
        } else if (!carrera.equals(other.carrera))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    
    
    
}