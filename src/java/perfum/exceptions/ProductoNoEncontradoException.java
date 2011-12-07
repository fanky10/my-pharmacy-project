/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.exceptions;

/**
 *
 * @author Noelia S Franco
 */
public class ProductoNoEncontradoException extends Exception{
    public ProductoNoEncontradoException(int id_producto){
        this.id_producto=id_producto;
    }
    private int id_producto;

    public String getMessage(){
        return "Producto no encontrado con id "+id_producto;
    }
}
