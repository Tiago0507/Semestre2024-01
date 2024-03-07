import java.net.*;
public class UDPServer {
  public static void main(String[] args) throws Exception {
		
		/*Esta línea se usa para recibir paquetes de datos mediante el protocolo UDP en el puerto 9876 (pero
		podría ser cualquier puerto) */
  	DatagramSocket serverSocket = new DatagramSocket(9876);

		/*Este array de 1 kB se usa para almacenar los datos recibidos del cliente */
    byte[] receiveData = new byte[1024];

		/*Se inicia un bucle infinito hasta que se detenga manualmente o se genere una excepción */
    while (true) {

			/*Este objeto permite recibir los datos enviados por el cliente. Usará el array de bytes creado
			 * anteriormente y la longitud de este
			 */
    	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			/*Se usa el método receive del paquete java.net para recibir un datagrama del cliente */
    	serverSocket.receive(receivePacket);

			/*Se extraen los datos recibidos del datagrama y se convierten en un String para luego mostrarlos
			 * en mensaje
			 */
    	String mensaje = new String(receivePacket.getData());
    	System.out.println("Mensaje recibido: " + mensaje);
    }
	}
}