package servidor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Clase de lógica: genera la contraseña y calcula su longitud.
 * Lógica de negocio.
 */
public class ServicioPass {

    // Conjuntos de caracteres permitidos
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITOS = "0123456789";
    private static final String ESPECIALES = "!@#$%^&*()_-+=.:?";

    private final SecureRandom random = new SecureRandom();

    /*
     * Devuelve la longitud total de la contraseña que se generará.
     */
    public int longitudPass(RequisitosPass req) {
        if (req == null) {
            return 0;
        }
        return req.getNumMayusculas()
                + req.getNumMinusculas()
                + req.getNumDigitos()
                + req.getNumCaractEspeciales();
    }

    /*
     * Genera una contraseña que cumple los requisitos.
     * Incluye puntos extra:
     *  - No genera bloques ordenados (se baraja al final).
     */
    public String generaPass(RequisitosPass req) {
        if (req == null) {
            throw new IllegalArgumentException("Los requisitos no pueden ser nulos");
        }

        List<Character> caracteres = new ArrayList<>();

        // Añadimos los caracteres necesarios de cada tipo
        anadirAleatorios(caracteres, MAYUSCULAS, req.getNumMayusculas());
        anadirAleatorios(caracteres, MINUSCULAS, req.getNumMinusculas());
        anadirAleatorios(caracteres, DIGITOS, req.getNumDigitos());
        anadirAleatorios(caracteres, ESPECIALES, req.getNumCaractEspeciales());

        // Barajamos para evitar bloques (punto extra)
        Collections.shuffle(caracteres, random);

        // Convertimos la lista en String
        StringBuilder sb = new StringBuilder();
        for (Character c : caracteres) {
            sb.append(c);
        }

        return sb.toString();
    }

    /*
     * Método auxiliar para añadir 'cantidad' caracteres aleatorios
      del conjunto indicado a la lista.
     */
    private void anadirAleatorios(List<Character> lista, String conjunto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int indice = random.nextInt(conjunto.length());
            lista.add(conjunto.charAt(indice));
        }
    }
}

