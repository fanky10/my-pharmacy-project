/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

import perfum.exceptions.PresentacionNoEncontradaException;

/**
 *
 * @author Lacha
 */

public class Presentaciones extends java.util.ArrayList<Presentacion> implements java.io.Serializable {
    public Presentacion getPresentacion(int id_presentacion) throws PresentacionNoEncontradaException{
        for(Presentacion presentacion : this){
            if(presentacion.getId()==id_presentacion){
                return presentacion;
            }
        }
        throw new PresentacionNoEncontradaException(id_presentacion);
    }
}
