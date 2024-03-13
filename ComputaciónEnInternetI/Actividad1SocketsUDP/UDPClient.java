import java.net.*;
public class UDPClient {
  public static void main(String[] args) throws Exception {

    /*Esta línea se usa para enviar datagramas por medio del protocolo UDP. Como no hay puerto, se usa uno
     * aleatorio del sistema operativo
     */
    DatagramSocket clientSocket = new DatagramSocket();

    /*Se obtiene la dirección IP del servidor al que se enviarán los datos. localhost hace referencia 
     * a la dirección IP de la propia máquina
     */
    InetAddress IPAddress = InetAddress.getByName("localhost");

    /*Este array tendrá los datos que se enviarán al servidor */
    byte[] sendData = "Hola desde el cliente".getBytes();

    /*Este objeto contiene los datos de sendData, la longitud de estos datos, la dirección IP del servidor
     * previamente encontrada y el número del puerto que en este caso será el 9876
     */
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

    /*Esta línea permite enviar el datagrama al servidor. El método send ya está en el paquete de java.net */
    clientSocket.send(sendPacket);

    /*Se cierra el socket del cliente luego de enviar el datagrama para liberar los recursos utilizados.
     * También lo vuelve inutilizable para futuras operaciones
     */
    clientSocket.close();
  }
}