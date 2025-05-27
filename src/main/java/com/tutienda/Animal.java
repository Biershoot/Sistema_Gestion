package com.tutienda;

/**
 * Esta clase sirve para crear objetos de tipo Animal.
 * Cada animal tiene un nombre, un tipo (si es terrestre, aéreo o acuático)
 * y un género (masculino o femenino).
 */
public class Animal {
    // El nombre del animal, por ejemplo: "León", "Águila", etc.
    private String nombre;
    
    // El tipo puede ser: "terrestre", "aéreo" o "acuático"
    private String tipo;
    
    // El género puede ser: "masculino" o "femenino"
    private String genero;

    /**
     * Constructor para crear un animal nuevo.
     * @param nombre El nombre que tendrá el animal
     * @param tipo Si es terrestre, aéreo o acuático
     * @param genero Si es masculino o femenino
     */
    public Animal(String nombre, String tipo, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
    }

    // Métodos para obtener y establecer el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para obtener y establecer el tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Métodos para obtener y establecer el género
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Este método se usa para mostrar el animal como texto.
     * Por ejemplo, si el animal se imprime, mostrará su nombre.
     */
    @Override
    public String toString() {
        return nombre;
    }
} 