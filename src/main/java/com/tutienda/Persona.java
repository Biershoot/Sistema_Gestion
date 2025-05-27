package com.tutienda;

/**
 * Esta clase sirve para crear objetos de tipo Persona.
 * Guarda información básica de una persona como su nombre, apellido,
 * edad, género, sueldo por hora y su cargo en el trabajo.
 */
public class Persona {
    // Nombre de la persona
    private String nombre;
    
    // Apellido de la persona
    private String apellido;
    
    // Edad en años
    private int edad;
    
    // Género: "M" para masculino, "F" para femenino
    private String genero;
    
    // Cuánto gana por hora
    private double sueldoHora;
    
    // Su trabajo, por ejemplo: "desarrollador", "director", etc.
    private String cargo;

    /**
     * Constructor para crear una persona nueva.
     * @param nombre El nombre de la persona
     * @param apellido El apellido de la persona
     * @param edad La edad en años
     * @param genero "M" para masculino, "F" para femenino
     * @param sueldoHora Cuánto gana por hora
     * @param cargo Su trabajo
     */
    public Persona(String nombre, String apellido, int edad, String genero, double sueldoHora, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.sueldoHora = sueldoHora;
        this.cargo = cargo;
    }

    // Métodos para obtener y establecer el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y establecer el apellido
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Métodos para obtener y establecer la edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Métodos para obtener y establecer el género
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Métodos para obtener y establecer el sueldo por hora
    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    // Métodos para obtener y establecer el cargo
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Este método se usa para mostrar la persona como texto.
     * Por ejemplo, si la persona se imprime, mostrará su nombre y apellido.
     */
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
} 