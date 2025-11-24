package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 	Servidor que escucha en el puerto 4321 y atiende peticiones de clientes
 	para generar contraseñas según unos requisitos.
 */
public class Servidor {

    private static final int PUERTO = 4321;

    /*
      Método principal del servidor: se queda escuchando y
      atiende a los clientes uno a uno.
     */
    public void iniciar() {
        System.out.println("Iniciando servidor en el puerto " + PUERTO + "...");

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            while (true) {
                System.out.println("Servidor esperando conexiones...");
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + socketCliente.getInetAddress());

                // Atendemos al cliente (se podría hacer con hilos, pero no es obligatorio).
                atenderCliente(socketCliente);
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /*
      Atiende a un único cliente siguiendo el flujo que indica el enunciado.
     */
    private void atenderCliente(Socket socketCliente) {
        try (
            Socket socket = socketCliente;
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)
        ) {
            // 1. Preguntar el nombre del cliente
            salida.println("Bienvenido al generador de contraseñas.");
            salida.println("¿Cómo te llamas?");
            String nombre = entrada.readLine();

            if (nombre == null) {
                System.out.println("Cliente desconectado antes de enviar el nombre.");
                return;
            }

            salida.println("Hola " + nombre + ", vamos a crear una contraseña segura.");
            salida.println("Te pediré número de mayúsculas, minúsculas, dígitos y caracteres especiales.");

            // 2. Solicitar los requisitos de la contraseña
            RequisitosPass requisitos = solicitarRequisitos(entrada, salida);
            if (requisitos == null) {
                // Ya se habrá enviado el mensaje de error al cliente
                System.out.println("Parámetros inválidos recibidos. Conexión cerrada.");
                return;
            }

            ServicioPass servicio = new ServicioPass();

            // 3. Enviar la longitud de la contraseña
            int longitud = servicio.longitudPass(requisitos);
            salida.println("La longitud total de la contraseña será: " + longitud);

            // 4. Preguntar si quiere generar la contraseña
            salida.println("¿Quieres generar ahora la contraseña? (si/no)");

            String respuesta = entrada.readLine();
            if (respuesta == null) {
                System.out.println("Cliente desconectado al responder si/no.");
                return;
            }

            if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("sí")) {
                String passwordGenerada = servicio.generaPass(requisitos);
                salida.println("Contraseña generada: " + passwordGenerada);
                salida.println("Gracias por usar el servicio. ¡Hasta luego!");
            } else {
                salida.println("No se generará ninguna contraseña. ¡Hasta luego!");
            }

            System.out.println("Conexión con el cliente '" + nombre + "' finalizada.");

        } catch (IOException e) {
            System.err.println("Error comunicando con el cliente: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Por ejemplo, si los parámetros son inválidos
            System.err.println("Error de parámetros del cliente: " + e.getMessage());
        }
    }

    /*
     * Pide los cuatro parámetros al cliente y valida que sean enteros no negativos.
     * Si hay error, devuelve null y ya envía un mensaje informando al cliente.
     */
    private RequisitosPass solicitarRequisitos(BufferedReader entrada, PrintWriter salida) throws IOException {
        try {
            int mayus = pedirEnteroNoNegativo("Introduce el número de MAYÚSCULAS:", entrada, salida);
            int minus = pedirEnteroNoNegativo("Introduce el número de minúsculas:", entrada, salida);
            int digitos = pedirEnteroNoNegativo("Introduce el número de dígitos:", entrada, salida);
            int especiales = pedirEnteroNoNegativo("Introduce el número de caracteres especiales:", entrada, salida);

            RequisitosPass req = new RequisitosPass();
            req.setNumMayusculas(mayus);
            req.setNumMinusculas(minus);
            req.setNumDigitos(digitos);
            req.setNumCaractEspeciales(especiales);

            return req;
        } catch (IllegalArgumentException e) {
            // Punto extra: parámetros inválidos -> mensaje de error y cierre
            salida.println("ERROR: Alguno de los parámetros introducidos no es válido. Se cerrará la conexión.");
            return null;
        }
    }

    /*
     * Pide un número entero no negativo al cliente.
     * Lanza excepción si el valor no es válido.
     */
    private int pedirEnteroNoNegativo(String mensaje, BufferedReader entrada, PrintWriter salida)
            throws IOException {

        salida.println(mensaje);
        String linea = entrada.readLine();

        if (linea == null) {
            throw new IllegalArgumentException("Entrada nula del cliente.");
        }

        int valor = Integer.parseInt(linea.trim()); // puede lanzar NumberFormatException

        if (valor < 0) {
            throw new IllegalArgumentException("No se permiten valores negativos.");
        }

        return valor;
    }
}

