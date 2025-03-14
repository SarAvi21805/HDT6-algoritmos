/* Autora: Alejandra Avilés - 24722
 * Fecha de última modificación: 13/03/2025
 * Descripción: Clase que maneja la colección de Pokemones del usuario y las demás
 *              operaciones solicitadas en la HDT6.
 */

import java.io.*;
import java.util.*;

public class Manejo_Pokemones {
    private final Map<String, Pokemon> pokemonMap;
    private final Set<Pokemon> coleccion_Usuario;

    public Manejo_Pokemones(int mapChoice) {
        this.pokemonMap = MapFactory.crearMap(mapChoice); //Se genera el map elegido
        this.coleccion_Usuario = new HashSet<>(); //No permite duplicados
    }

    public void cargarDatosPokemones(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { /* Lectura del CSV */
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) { /* Revisa la cantidad de elementos ingresados */
                    List<String> abilities = Arrays.asList(data[7].replace("\"", "").split(", ")); // Eliminación de comillas antes de dividir habilidades
                    /* Eliminación de posibles espacios extras en el nombre del Pokémon */
                    Pokemon p = new Pokemon(data[0].trim().toLowerCase(), data[1], data[2], data[3], data[4], data[5], data[6], abilities, data[8], data[9]); 
                    pokemonMap.put(data[0].toLowerCase(), p); //Se guarda el nombre del pokémon en minúscula (evitación de errores por letras no coincidibles)
                }
            }
        }
    }

    public void agregarPokemonAColeccion(String name) {
        if (!pokemonMap.containsKey(name)) { /* Búsqueda del Pokémon en el Map */
            System.out.println("¡Error! El pokémon no existe en la base de datos");
            return;
        }
        Pokemon p = pokemonMap.get(name); /* El pokémon está en el Map */
        if (!coleccion_Usuario.add(p)) { /* Regresa false por si el pokémon ya está en la colección */
            System.out.println("El pokémon " + name + " ya se encuentra en su colección.");
        } else {
            System.out.println("El pokémon " + name + " se ha agregado a su colección.");
        }
    }

    public void mostrarDatosPokemon(String name){
        if (pokemonMap.containsKey(name)){ /* Verificación de la presencia del pokémon en el Map */
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("No se encontró al pokémon " + name);
        }
    }

    public void mostrarColeccionOrdenada() {
        coleccion_Usuario.stream()
                        .sorted(Comparator.comparing(p -> p.type1)) /* Ordenamiento por type1 */
                        .forEach(p -> System.out.println(p.name + " - " + p.type1)); /* Devuelve los pokemones en orden */
    }

    public void mostrarTodosLosPokemonesOrdenados() {
        pokemonMap.values().stream() /* Conversión a una secuencia de elementos para manejar procesos */
                .sorted(Comparator.comparing(p -> p.type1)) /* Ordenamiento por type1 */
                .forEach(p -> System.out.println(p.name + " - " + p.type1)); /* Devuelve los pokemones ordenados */
    }

    public void mostrarPokemonPorHabilidades(String ability){
        final String abilityFinal = ability.trim(); /* Eliminación de espacios extras */

        List<Pokemon> matchingPokemons = pokemonMap.values().stream() /* Conversión a secuencia de elementos */
                                                    .filter(p -> p.abilities.stream().map(String::trim).anyMatch(a -> a.equalsIgnoreCase(ability))) /* Búsqueda de la habilidad requerida en el CSV */
                                                    .toList(); /* Enlista el resultado obtenido */

        if (matchingPokemons.isEmpty()) { /* Validación de presencia de pokemones en las colecciones */
            System.out.println("No se encontraron pokemones con la habilidad: " + ability);
        } else {
            matchingPokemons.forEach(p -> System.out.println(p.name));
        }
    }

    public boolean coleccionVacia() { /* Manejo de colección de usuario vacía */
        return coleccion_Usuario.isEmpty();
    }
}