package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Cliente que se conecta a localhost:4321 y conversa con el servidor.
 */
public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 4321;

    public void iniciar() {
        try (
            Socket socket = new Socket(HOST, PUERTO);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner teclado = new Scanner(System.in)
        ) {
            System.out.println("Conectado al servidor en " + HOST + ":" + PUERTO);

            String lineaServidor;

            /*
              Estrategia sencilla:
             - Movemos mensajes del servidor a la consola.
              - Si el mensaje termina en ':' o en '?', pedimos una respuesta al usuario
                y la enviamos al servidor.
             */
            while ((lineaServidor = entrada.readLine()) != null) {
                System.out.println("Servidor: " + lineaServidor);

                String trimmed = lineaServidor.trim();
                if (trimmed.endsWith(":") 
                        || trimmed.endsWith("?") 
                        || trimmed.endsWith(")")
                        || trimmed.toLowerCase().contains("(si/no)")) {

                    System.out.print("Tu respuesta: ");
                    String respuesta = teclado.nextLine();
                    salida.println(respuesta);
                }
            }

            System.out.println("Conexión cerrada por el servidor.");

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
