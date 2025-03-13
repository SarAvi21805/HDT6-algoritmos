/* Autora: */

import java.io.*;
import java.util.*;
@SuppressWarnings("rawtypes")

public class MapFactory {
    public static Map<String, Pokemon> crearMap(int opcion) {
        return switch (opcion) {
            case 1 -> new HashMap<>();
            case 2 -> new TreeMap<>();
            case 3 -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Opción inválida.");
        };
    }

}