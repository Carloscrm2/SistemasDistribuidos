/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionproductorconsumidor;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class AplicacionProductorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seleccione un producto:");
        System.out.println("1. Refresco $20");
        System.out.println("2. Leche $23");
        System.out.println("3. Carne  $85");
        System.out.println("4. Cereal $45");
        System.out.println("5. Atun $18");
        int idProducto = entrada.nextInt();
        float precio = 0;
        switch(idProducto){
            case 1:
                precio = 20;
                break;
            case 2:
                precio = 23;
                break;
            case 3:
                precio = 85;
                break;
            case 4:
                precio = 45;
                break;
            case 5:
                precio = 18;
                break;
        }
        System.out.println("¿Cuanta cantidad desea del producto seleccionado?");
        int numeroProductos = entrada.nextInt();
        float total = numeroProductos * precio;
        
        boolean respuesta = comprar(idProducto, precio, numeroProductos, total);
        if(respuesta){
            System.out.println("compra correcta... ingrese sus datos para el pago");
            System.out.println("idProducto: " + idProducto);
            System.out.println("precio: " + precio);
            System.out.println("numero productos: " + numeroProductos);
            System.out.println("Total: " + total);
            
            System.out.println("verificando orden...");
            System.out.println("ingrese su numero de tarjeta:");
            String numeroTarjeta = entrada.nextLine();
            entrada.nextLine();
            System.out.println("Ingrese el monto");
            int monto = entrada.nextInt();
            if (monto < total){
                System.out.println("Saldo insuficiente");
            }else{
                System.out.println("Ingrese nombre del cliente");
                String nombre = entrada.nextLine();
                entrada.nextLine();
                System.out.println("Ingrese el cvv");
                String codigo_cvv = entrada.nextLine();
                boolean respuesta2 = pagar(numeroTarjeta, monto, nombre, codigo_cvv);
                if(!respuesta2){
                    System.out.println("Transaccion exitosa");
                }else{
                    System.out.println("Ha fallado la operación intente nuevamente");
                }
            }
        }
    }

    private static Boolean comprar(int idProducto, float precio, int numeroProductos, float total) {
        aplicacionproductorconsumidor.ConsumidorProductor_Service service = new aplicacionproductorconsumidor.ConsumidorProductor_Service();
        aplicacionproductorconsumidor.ConsumidorProductor port = service.getConsumidorProductorPort();
        return port.comprar(idProducto, precio, numeroProductos, total);
    }

    private static Boolean pagar(java.lang.String numeroTarjeta, int monto, java.lang.String nombre, java.lang.String codigoCvv) {
        aplicacionproductorconsumidor.ConsumidorProductor_Service service = new aplicacionproductorconsumidor.ConsumidorProductor_Service();
        aplicacionproductorconsumidor.ConsumidorProductor port = service.getConsumidorProductorPort();
        return port.pagar(numeroTarjeta, monto, nombre, codigoCvv);
    }
    
}
