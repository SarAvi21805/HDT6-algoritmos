import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.io.IOException;
import java.util.Map;

public class Manejo_PokemonesTest {
    private Manejo_Pokemones manejo_Pokemones;
    
    @BeforeEach
    void setUp() {
        manejo_Pokemones = new Manejo_Pokemones(1); /* Hará un HashMap por default (modificable) */
    }

    @Test
    void testAgregarPokemonAColeccion() {
        try {
            manejo_Pokemones.cargarDatosPokemones("pokemon_data_pokeapi.csv");
            manejo_Pokemones.agregarPokemonAColeccion("pikachu");
            assertFalse(manejo_Pokemones.coleccionVacia(), "La colección no debe estar vacía.");
        } catch (IOException e) {
            fail("Error al cargar datos de Pokémon: " + e.getMessage());
        }
    }

    @Test
    void testColeccionVacia() {
        assertTrue(manejo_Pokemones.coleccionVacia(), "La colección debe estar vacía al principio.");
    }
}