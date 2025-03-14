/* Autora: Alejandra Avilés - 24722
 * Fecha de última modificación: 13/03/2025
 * Descripción: Clase que sirve para aplicar el patrón Factory al seleccionar la estructura de Map deseada.
 */

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