//Recuerda iniciar el servidor primero
/*
 * Autor: Carlos J. Venegas Berrones
 * Fecha: 24/11/2025
 * Descripción: Clase Servidor que gestiona la comunicación por sockets.
 */

package servidor;


/*
 * Clase con el método main del servidor.
 */
public class MainServidor {

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciar();
    }
}
