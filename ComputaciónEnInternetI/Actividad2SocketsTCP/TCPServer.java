import java.net.*;
import java.io.*;

public class TCPServer {
  public static void main(String[] args) throws IOException{
    ServerSocket serverSocket = new ServerSocket(6789);
    System.out.println("Servidor iniciado...");
  
    while(true) {
      System.out.println("Esperando conexión...");
      Socket clientSocket = serverSocket.accept();

      //Crear un nuevo hilo para manejar al cliente
      Thread clientThread = new ClientHandlerThread(clientSocket);
      clientThread.start();
    }
  }

  static class ClientHandlerThread extends Thread {
    private Socket clientSocket;

    public ClientHandlerThread(Socket socket) {
      this.clientSocket = socket;
    }

    @Override
    public void run() {
      try {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String mensajeCliente = in.readLine();
        System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

        //Retardo antes de responder al cliente
        try {
          Thread.sleep(10000);
        } catch(InterruptedException e) {
          e.printStackTrace();
        }

        out.println("Mensaje modificado: " + mensajeCliente.toUpperCase());

        clientSocket.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
}
