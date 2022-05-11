/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.consumidorproductor;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "ConsumidorProductor")
public class ConsumidorProductor {

    /**
     * Web service operation
     * @param numero_tarjeta
     * @param monto
     * @param nombre
     * @param codigo_cvv
     * @return 
     */
    @WebMethod(operationName = "Pagar")
    public Boolean Pagar(@WebParam(name = "numero_tarjeta") String numero_tarjeta, @WebParam(name = "monto") int monto, @WebParam(name = "nombre") String nombre, @WebParam(name = "codigo_cvv") String codigo_cvv) {
        //TODO write your implementation code here:        
        String cvv_valido = "456";
        
        return numero_tarjeta.equals("123");//            System.out.println("nombre cliente: " + nombre);
//            System.out.println("numero tarjeta: " + numero_tarjeta);
//            System.out.println("monto: " + monto);
//            System.out.println("verificando tarjeta...");
        
    }

    @WebMethod(operationName = "Comprar")
    public Boolean Comprar(@WebParam(name = "id_producto") int id_producto, @WebParam(name = "precio") float precio, @WebParam(name = "numero_productos") int numero_productos, @WebParam(name = "total") float total) {
        //TODO write your implementation code here:
        if (id_producto<1 && id_producto>5){
            return false;
        }else{
//            System.out.println("idProducto: " + id_producto);
//            System.out.println("precio: " + precio);
//            System.out.println("numero productos: " + numero_productos);
//            System.out.println("Total: " + total);
//            System.out.println("verificando orden...");
            return true;
        }
    }
}
