
package server;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
import rmi.EchoInterface;
public class EchoObjectSkeleton implements EchoInterface {
    String myURL="localhost";
    //Constructor de la clase EchoObjectSkeleton
    public EchoObjectSkeleton()
    {
        try {
// obtengo el nombre del equipo donde estoy ejecutando y lo guardo en la propiedad MyURL
            myURL=InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) 
               {
                // si no pude conocer el nombre del equipo, mantengo el nombre localhost para MyURL
               myURL="localhost";
              }
    }
// el Metodo Echo que es la implementacion de la interfaz EchoInterface
    public String echo(String input) throws java.rmi.RemoteException 

    {
// toma la fecha y hora 
        // escribe la fecha y la hora, nombre de compuadora y lo regresa
        Date h = new Date();
        // obtengo la fecha y hora actual 
        String fecha = DateFormat.getTimeInstance(3,Locale.FRANCE).format(h);
        String ret = myURL + ":" + fecha + "> " + input;
        System.out.println("Procesando: '" + input + "'");
        try {
            Thread.sleep(3000); // hilo actual
            ret = ret + " (retrasada 3 segundos)";
        } catch (InterruptedException e) {}
        System.out.println("Procesamiento de '"+ input +"'terminado.");
        return ret;
    }

    @Override
    public int pago(int cantidad_a_pagar, String tarjeta, String cvv) {
        String tarjeta_valida = "3041 2023 1307 0407";
        String cvv_valido = "123";
        
        if(tarjeta_valida.equals(tarjeta) && cvv_valido.equals(cvv)){
            return 0;
        }else{
            return 1;
        }
    }
   }
