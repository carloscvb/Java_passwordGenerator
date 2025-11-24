//Recuerda iniciar el servidor primero
/*
 * Autor: Carlos J. Venegas Berrones
 * Fecha: 24/11/2025
 * Descripción: Clase ciente que gestiona la comunicación por sockets.
 */
package cliente;

/*
 * Clase con el método main del cliente.
 */
public class MainCliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.iniciar();
    }
}

