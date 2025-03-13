import java.util.List;

public class Pokemon{
    String name, pokedex_Number, type1, type2, classification, height, weight, abilities, generation, lengendary_Status;

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
        return "Nombre: " + name + "\\n, Número de la pokedex: " + pokedex_Number +"\n, Tipo 1: " + type1 + "\n, Tipo 2: " + type2 + "\n, Clasificación: " + classification + "\n, Altura: " + height + "\n Peso: " + weight + "\n Habilidades: " + abilities + "\n Generación: " + generation + "\n Estado legendario: " + lengendary_Status;
    }
}