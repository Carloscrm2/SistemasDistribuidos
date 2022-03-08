
package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Echo {
    //definimos el Stub del cliente
    private static EchoObjectStub ss;
    
    public static void main(String[] args) 
    {
        // revisamos que los argumentos para ejecutar el programa son correctos
        String cadena="";
        if (args.length<2) {
            System.out.println("Para ejecutar , hazlo en este formato: Echo <nombre o IP del Equipo> <numero de puerto>");
            System.exit(1);
        }
        //creamos el STUB
        ss = new EchoObjectStub();
        //EJERCICIO: crear una instancia del stub
    // le asignamos al STUB el puerto y nombre del equipo HOST 
        //( es decir el nombre del servidor)
        ss.setHostAndPort(args[0],Integer.parseInt(args[1]));
       // leemos de teclado 
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        //escribimos en pantalla
        PrintWriter stdOut = new PrintWriter(System.out);
        String input,output;
        //try {  
            int confirmacion = 0;
            while(confirmacion!=1){
            //EJERCICIO: el bucle infinito:
                /*BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));//EJERCICIO: Leer de teclado
                // leo del teclado 
                cadena=in.readLine();
                     //EJERCICIO: Invocar el stub
                //EJERCICIO: Imprimir por pantalla
                System.out.println(ss.echo(cadena));*/
                
                //EJERCICIO: hacer que el cliente llame al metodo int pago()
                Scanner in = new Scanner(System.in);
                System.out.println("Ingrese cantidad a pagar:");
                int pago = in.nextInt();
                in.nextLine();
                System.out.println("Ingrese su tarjtea:");
                String tarjeta = in.nextLine();
                System.out.println("Ingrese el CVV");
                String cvv = in.nextLine();
                confirmacion = ss.pago(pago, tarjeta, cvv);
                if (confirmacion==1) {
                    System.out.println("transaccion exitosa, su pedido esta en camino");
                }else{
                    System.out.println("error, ingrese nuevamente los datos");
                }
            }
        } 
        //catch (UnknownHostException e) {
            //System.err.println("Don't know about host: "+ args[0]);
        //} 
        /*catch (IOException e) {
            System.err.println("Falla conexion de E/S con el host:"+args[0]);
        }*/
    //}
}
