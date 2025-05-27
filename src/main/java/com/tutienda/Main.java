package com.tutienda;

import java.util.*;

/**
 * Esta es la clase principal del programa.
 * Aquí está todo el código que hace funcionar el programa.
 * Podemos guardar animales y personas, y hacer diferentes cosas con ellos.
 */
public class Main {
    /** Mapa para clasificar animales por tipo */
    private static Map<String, List<Animal>> clasificacion = new TreeMap<>();
    
    /** Lista de animales registrados */
    private static List<Animal> animales = new ArrayList<>();
    
    /** Lista de personas registradas */
    private static List<Persona> personas = new ArrayList<>();
    
    /** Scanner para entrada de datos */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Este es el método principal que se ejecuta cuando iniciamos el programa.
     * Muestra un menú y nos deja elegir qué queremos hacer.
     */
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Animales");
            System.out.println("2. Gestionar Personas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Esto es para que no se salte la siguiente lectura

            switch (opcion) {
                case 1:
                    gestionarAnimales();
                    break;
                case 2:
                    gestionarPersonas();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }

    /**
     * Este método maneja todo lo relacionado con los animales.
     * Podemos agregar animales nuevos y ver cómo están clasificados.
     */
    private static void gestionarAnimales() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== GESTIÓN DE ANIMALES ===");
            System.out.println("1. Agregar animal");
            System.out.println("2. Mostrar clasificación");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarAnimal();
                    break;
                case 2:
                    mostrarClasificacion();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    /**
     * Este método nos permite agregar un animal nuevo.
     * Nos pide el nombre, tipo y género del animal.
     */
    private static void agregarAnimal() {
        System.out.print("Nombre del animal: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Tipo de animal:");
        System.out.println("1. Terrestre");
        System.out.println("2. Aéreo");
        System.out.println("3. Acuático");
        System.out.print("Seleccione el tipo: ");
        int tipoOp = scanner.nextInt();
        scanner.nextLine();
        
        String tipo = switch (tipoOp) {
            case 1 -> "terrestre";
            case 2 -> "aéreo";
            case 3 -> "acuático";
            default -> "desconocido";
        };

        System.out.println("Género:");
        System.out.println("1. Masculino");
        System.out.println("2. Femenino");
        System.out.print("Seleccione el género: ");
        int generoOp = scanner.nextInt();
        scanner.nextLine();
        
        String genero = generoOp == 1 ? "masculino" : "femenino";

        Animal animal = new Animal(nombre, tipo, genero);
        animales.add(animal);
        
        // Guardamos el animal en su tipo correspondiente
        clasificacion.computeIfAbsent(tipo, k -> new ArrayList<>()).add(animal);
    }

    /**
     * Este método muestra todos los animales clasificados por tipo.
     */
    private static void mostrarClasificacion() {
        System.out.println("\n=== CLASIFICACIÓN DE ANIMALES ===");
        clasificacion.forEach((tipo, lista) -> {
            System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + ":");
            lista.forEach(animal -> System.out.println("    " + animal.getNombre()));
        });
    }

    /**
     * Este método maneja todo lo relacionado con las personas.
     * Podemos agregar personas y hacer diferentes operaciones con ellas.
     */
    private static void gestionarPersonas() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== GESTIÓN DE PERSONAS ===");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Mostrar sueldos de directores");
            System.out.println("4. Buscar desarrolladora");
            System.out.println("5. Mostrar desarrollador mejor pagado");
            System.out.println("6. Mostrar mujeres ordenadas por nombre");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    mostrarSueldosDirectores();
                    break;
                case 4:
                    buscarDesarrolladora();
                    break;
                case 5:
                    mostrarDesarrolladorMejorPagado();
                    break;
                case 6:
                    mostrarMujeresOrdenadas();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    /**
     * Este método nos permite agregar una persona nueva.
     * Nos pide todos los datos de la persona.
     */
    private static void agregarPersona() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Género (M/F): ");
        String genero = scanner.nextLine();
        
        System.out.print("Sueldo por hora: ");
        double sueldoHora = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
    }

    /**
     * Este método muestra diferentes estadísticas de las personas:
     * - Cuántas personas hay en total
     * - El promedio de edades
     * - Cuántas personas son mayores de edad
     * - Personas con nombres que empiezan por A
     * - Personas con apellidos que contienen M
     */
    private static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        
        // Contamos cuántas personas hay
        long totalPersonas = personas.stream().count();
        System.out.println("Total de personas: " + totalPersonas);

        // Calculamos el promedio de edades
        double promedioEdades = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de edades: " + promedioEdades);

        // Contamos cuántas personas son mayores de edad
        long mayoresEdad = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .count();
        System.out.println("Personas mayores de edad: " + mayoresEdad);

        // Mostramos personas con nombres que empiezan por A
        System.out.println("\nPersonas con nombre que empieza por A:");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));

        // Mostramos personas con apellidos que contienen M
        System.out.println("\nPersonas con apellido que contiene M:");
        personas.stream()
                .filter(p -> p.getApellido().contains("M"))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));
    }

    /**
     * Este método muestra cuánto ganan los directores por 8 horas de trabajo.
     */
    private static void mostrarSueldosDirectores() {
        System.out.println("\n=== SUELDOS DE DIRECTORES ===");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("director") && p.getGenero().equalsIgnoreCase("M"))
                .forEach(p -> System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido() + 
                        " Sueldo por 8 horas: $" + (p.getSueldoHora() * 8)));
    }

    /**
     * Este método busca la primera mujer que sea desarrolladora.
     */
    private static void buscarDesarrolladora() {
        System.out.println("\n=== BUSCAR DESARROLLADORA ===");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador") && p.getGenero().equalsIgnoreCase("F"))
                .findFirst()
                .ifPresentOrElse(
                    p -> System.out.println("Primera desarrolladora encontrada: " + p.getNombre() + " " + p.getApellido()),
                    () -> System.out.println("No se encontró ninguna desarrolladora")
                );
    }

    /**
     * Este método busca el desarrollador que gana más por hora.
     */
    private static void mostrarDesarrolladorMejorPagado() {
        System.out.println("\n=== DESARROLLADOR MEJOR PAGADO ===");
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .max(Comparator.comparingDouble(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            Persona p = masGana.get();
            System.out.println("Desarrollador mejor pagado: " + p.getNombre() + " " + p.getApellido());
            System.out.println("Sueldo por hora: $" + p.getSueldoHora());
        } else {
            System.out.println("No se encontró ningún desarrollador");
        }
    }

    /**
     * Este método muestra todas las mujeres ordenadas por su nombre.
     */
    private static void mostrarMujeresOrdenadas() {
        System.out.println("\n=== MUJERES ORDENADAS POR NOMBRE ===");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("F"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));
    }
}