/* Autora: Alejandra Avilés - 24722
 * Fecha de última modificación: 13/03/2025
 * Descripción: Clase que interactúa con el usuario
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de implementación que desea usar: \n1) HashMap \n2) TreeMap \n3) LinkedHashMap");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        Manejo_Pokemones manejo = new Manejo_Pokemones(opcion);
        manejo.cargarDatosPokemones("pokemon_data_pokeapi.csv");

        int opcion2 = 0;
        while (opcion2 != 6) { //El menú se muestra hasta que el usuario decida salir
            try {
                System.out.println("\n¿Qué acción desea realizar?\n1) Agregar pokémon a colección\n2) Mostrar datos de un pokémon\n3) Mostrar colección ordenada\n4) Mostrar todos los pokémon en orden\n5) Buscar pokémon por habilidad\n6) Salir");
                System.out.println("Ingrese el número de la opción a ejecutar: ");
                System.out.println();

                if (scanner.hasNextInt()){
                    opcion2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion2) {
                        case 1: { // Agregar pokémon
                            System.out.println("Ingrese el nombre del pokémon que desea agregar: ");
                            String name = scanner.nextLine().trim().toLowerCase(); // Normalización de entrada del usuario
                            manejo.agregarPokemonAColeccion(name);
                            break;
                        }
                        case 2: { //Mostrar datos de un pokémon
                            System.out.println("Ingrese el nombre del pokémon que desea buscar: ");
                            String name = scanner.nextLine();
                            manejo.mostrarDatosPokemon(name);
                            break;
                        }
                        case 3: { //Mostrar colección ordenada
                            if (manejo.coleccionVacia()) {
                                System.out.println("La colección está vacía.");
                            } else {
                            manejo.mostrarColeccionOrdenada(); 
                            }
                            break;
                        } 
                        case 4: { //Mostrar todos los pokémon en orden
                            manejo.mostrarTodosLosPokemonesOrdenados(); 
                            break; 
                        }
                        case 5: { // Buscar pokémon por habilidad
                            System.out.print("Ingrese la habilidad deseada: ");
                            String habilidad = scanner.nextLine();
                            manejo.mostrarPokemonPorHabilidades(habilidad);
                            break;
                        }
                        case 6: { // Salir
                            System.out.println("Saliendo del programa...");
                            break;
                        }
                        default: System.out.println("Opción inválida.");
                    }
                }  else { //Opciones inválidas ingresadas
                    System.out.println("Opción inválida.");
                    scanner.next();
                }
            } catch (Exception e) { //Manejo de errores
                System.out.println();
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    scanner.close();
    }
}