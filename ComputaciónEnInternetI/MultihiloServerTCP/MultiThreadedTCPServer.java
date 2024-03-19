import java.io.*;
import java.net.*;

public class MultiThreadedTCPServer {
    public static void main(String[] args) {
        try {
            // Crear un socket de servidor TCP en el puerto especificado
            ServerSocket serverSocket = new ServerSocket(6789);
            
            System.out.println("Servidor TCP listo para recibir clientes.");

            while (true) {
                // Esperar a que llegue una conexión de un cliente
                Socket sc = serverSocket.accept();
                
                // Crear un hilo para manejar la solicitud del cliente
                Thread hiloCliente = new HiloCliente(sc);
                hiloCliente.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HiloCliente extends Thread {
    private Socket sc;

    public HiloCliente(Socket sc) {
        this.sc = sc;
    }

    public void run() {
        try {
            // Obtener los flujos de entrada y salida del cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);

            String mensajeCliente = in.readLine();//leemos mensaje 1
            System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

            out.println(" Espere un momento....");
            mensajeCliente = in.readLine();
            System.out.println(mensajeCliente);
                
            Thread.sleep(5000);
                
            out.println(" Su caso ha sido resuelto....");

            sc.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}