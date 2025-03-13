import java.io.*;
import java.util.*;

public class Manejo_Pokemones {
    private final Map<String, Pokemon> pokemonMap;
    private final Set<Pokemon> coleccion_Usuario;

    public Manejo_Pokemones(int opcionMap) {
        this.pokemonMap = MapFactory.crearMap(opcionMap); //Se genera el map elegido
        this.coleccion_Usuario = new HashSet<>(); //No permite duplicados
    }

    public void cargarDatosPokemos(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) {
                    List<String> abilities = Arrays.asList(data[7].split(";"));
                    Pokemon p = new Pokemon(data[0], data[1], data[2], data[3], data[4], data[5], data[6], abilities, data[8], data[9]);
                    pokemonMap.put(data[0], p);
                }
            }
        }
    }

    public void agregarPokemonAColeccion(String name) {
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error! El pokémon no existe en la base de datos");
            return;
        }
        Pokemon p = pokemonMap.get(name);
        if (!coleccion_Usuario.add(p)) {
            System.out.println("El pokémon " + name + " ya se encuentra en su colección.");
        } else {
            System.out.println("El pokémon " + name + " se ha agregado a su colección.");
        }
    }

    public void mostrarDatosPokemon(String name){
        if (pokemonMap.containsKey(name)){
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("No se encontró al pokémon " + name);
        }
    }

    public void mostrarColeccionOrdenada() {
        coleccion_Usuario.stream()
                        .sorted(Comparator.comparing(p -> p.type1))
                        .forEach(p -> System.out.println(p.name + " - " + p.type1));
    }

    public void mostrarTodosLosPokemonesOrdenados() {
        pokemonMap.values().stream()
                .sorted(Comparator.comparing(p -> p.type1))
                .forEach(p -> System.out.println(p.name + " - " + p.type1));
    }

    public void mostrarPokemonPorHabilidades(String abilities) {
        pokemonMap.values().stream()
                            .filter(p -> p.abilities.contains(abilities))
                            .forEach(p -> System.out.println(p.name + " - " + p.abilities));
    }
}