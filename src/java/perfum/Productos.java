/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

import perfum.exceptions.PresentacionNoEncontradaException;
import perfum.exceptions.ProductoNoEncontradoException;

/**
 *
 * @author Hp
 */
public class Productos extends java.util.ArrayList<Producto>{

    public Producto getProducto(int id_producto) throws ProductoNoEncontradoException {
        for(Producto p: this){
            if(id_producto==p.getId_producto()){
                return p;
            }
        }
        throw new ProductoNoEncontradoException(id_producto);
    }
    public Presentacion getPresentacionProducto(int id_presentacion, int id_producto) throws ProductoNoEncontradoException, PresentacionNoEncontradaException{
        Producto p = getProducto(id_producto);
        return p.getPresentacion(id_presentacion);
    }

}
