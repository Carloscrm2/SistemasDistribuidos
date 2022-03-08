
package server;
import java.net.*;
import java.io.*;
public class EchoServer {
	// Objeto remoto ( es el Stub del servidor, conocido como Skeleton)
    private static EchoObjectSkeleton eo = new EchoObjectSkeleton();
    private static String myURL="localhost";
    private static ServerSocket serverSocket =null;
    private static Socket clientSocket = null;
    private static BufferedReader is = null;
    private static PrintWriter os = null;
    private static String inputline = new String();
    private static int pago = 0;
    private static String tarjeta = new String();
    private static String cvv = new String();
    
    public static void main(String[] args) {
        try {
            // obtengo el nombre de mi computadora
            myURL=InetAddress.getLocalHost().getHostName(); 
        } catch (UnknownHostException e) {
            System.out.println("Host Desconocido  :" + e.toString());
            System.exit(1);
        }
        try {
            // abro el socket para el servidor ( para que este a la escucha) en el puerto 1007
            serverSocket = new ServerSocket(1007);
        } catch (IOException e) {
            System.out.println(myURL + ": no puedo escuchar en el puerto: 1007, " +e.toString());
            System.exit(1);
        }
        System.out.println(myURL + ": EchoServer esta escuchando en el  puerto: 1007");
       // Servidor esta ahora a la escucha ( esperando conexiones)
        try {
            boolean listening = true;
            while(listening) // bucle infinito
            {
                clientSocket = serverSocket.accept();// aceptamos conexion de un client
                // preparamos para leer  del socket
                is = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
                //preparamos para escribir en el socket
                os = new PrintWriter(clientSocket.getOutputStream());
                // revisamos que en el socket el cliente ha enviado algun texto
                while ((inputline = is.readLine()) != null) 
                {    
                    pago = is.read();
                    tarjeta = is.readLine();
                    cvv = is.readLine();
                    //os.println(eo.echo(inputline));//escribimos en el socket lo recibido mas mensaje
                    System.out.println("Se recibio...");
                    System.out.println("tarjeta:" + tarjeta);
                    System.out.println("cvv:" + cvv);
                    System.out.println("pago:" + pago);
                    int valor = eo.pago(pago, tarjeta, cvv);
                    if (valor == 0) {
                        System.out.println("Transacción validada...");
                        System.out.println("Se ha terminado de atender el cliente");
                    }else{
                        System.out.println("tarjeta no valida");
                    }
                    os.flush();//limpiamos el socket
                }
                os.close();
                is.close();
                clientSocket.close();
            }
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error enviando/recibiendo" + e.getMessage());
            e.printStackTrace();
        }
    }
}