import java.net.*;
import java.io.*;

public class TCPServer {
  private static boolean servidorOcupado = false;

  public static void main(String[] args) throws IOException{
    ServerSocket serverSocket = new ServerSocket(6789);
    Socket sc = null; //Para aceptar al cliente
    System.out.println("Servidor iniciado...");
    PrintWriter out;
    BufferedReader in;
    while(true) {
      // Verificar si el servidor está ocupado
      if (servidorOcupado) {
        System.out.println("Servidor ocupado. Espere por favor...");
        try {
          Thread.sleep(5000);
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
        continue; // Ir al siguiente ciclo del bucle while
      }
      
      System.out.println("Esperando conexión...");
      sc = serverSocket.accept();
      servidorOcupado = true;

      out = new PrintWriter(sc.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(sc.getInputStream()));

      String mensajeCliente = in.readLine();
      System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

      // Retardo del servidor antes de responder una solicitud del cliente
      try {
        Thread.sleep(5000);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }

      out.println("Mensaje modificado: " + mensajeCliente.toUpperCase());

      sc.close();
      servidorOcupado = false; // Liberar el servidor después de atender la solicitud
    }
  }
}



