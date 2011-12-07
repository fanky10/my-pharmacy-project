/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

import java.util.Date;

/**
 *
 * @author Hp
 */
public class Precio {
    public Precio(){

    }
    public Precio(Presentacion presentacion, Date fec_mod,float precio,int stock){
        this.presentacion = presentacion;
        this.fecha_modificacion = fec_mod;
        this.precio = precio;
        this.stock = stock;
    }
    private Presentacion presentacion;
    private Date fecha_modificacion;
    private float precio;
    private int stock;

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
