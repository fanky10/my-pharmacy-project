/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.exceptions;

/**
 *
 * @author fanky
 */
public class PresentacionNoEncontradaException extends Exception{
    public PresentacionNoEncontradaException(int id_presentacion){
        this.id_presentacion=id_presentacion;
    }
    private int id_presentacion;

    public String getMessage(){
        return "Presentacion no encontrada con id "+id_presentacion;
    }
}