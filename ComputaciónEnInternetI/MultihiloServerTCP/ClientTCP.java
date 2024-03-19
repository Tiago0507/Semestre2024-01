import java.io.*;
import java.net.*;

public class ClientTCP {
    public static void main(String[] args) {
        String serverHostname = "localhost"; // Si el servidor está en la misma máquina
        int serverPort = 6789;

        try (
            Socket socket = new Socket(serverHostname, serverPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String userInput;
            System.out.println("Conectado al servidor. Puedes empezar a escribir mensajes:");

            out.println("Hola, servidor"); // Enviar mensaje al servidor
            System.out.println("Respuesta del servidor: " + in.readLine()); // Leer respuesta del servidor
            
            // Enviar un segundo mensaje al servidor
            out.println("Las tetas de ella huelen bien");
            System.out.println("Respuesta del servidor: " + in.readLine()); // Leer respuesta del servidor
        } catch (UnknownHostException e) {
            System.err.println("No se pudo encontrar el host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error de E/S al conectarse a " + serverHostname);
            System.exit(1);
        }
    }
}

