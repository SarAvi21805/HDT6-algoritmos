/* Autora: Alejandra Avilés - 24722
 * Fecha de última modificación: 13/03/2025
 * Descripción: Clase que representa un objeto de tipo Pokemon
 */

import java.util.List;

public class Pokemon{
    String name, pokedex_Number, type1, type2, classification, height, weight, generation, lengendary_Status;
        List<String> abilities;

    public Pokemon(String name, String pokedex_Number, String type1, String type2, String classification, String height, String weight, 
                    List<String> abilities, String generation, String lengendary_Status) {
        this.name = name;
        this.pokedex_Number = pokedex_Number;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.lengendary_Status = lengendary_Status;
    }   

    @Override
    public String toString() {
        return "\nNombre: " + name + "\\nNúmero de la pokedex: " + pokedex_Number +"\nTipo 1: " + type1 + "\nTipo 2: " + type2 + "\nClasificación: " + classification + "\nAltura: " + height + "\nPeso: " + weight + "\nHabilidades: " + abilities + "\nGeneración: " + generation + "\nEstado legendario: " + lengendary_Status;
    }
}