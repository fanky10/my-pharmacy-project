/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

/**
 *
 * @author Hp
 */
public class Presentacion{
    /**
     * cuando hablamos que una presentacion tiene un stock y precio, nos referimos a una presentacion con un producto
     * para 'entrar por producto' y sacar todas las presentaciones con sus precios y stock
     */
    public Presentacion(){
        this.id=0;
        this.descripcion = "";
        this.precio=0f;
        this.stock=0;
    }
    public Presentacion(int id,String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }
    private int id;
    private String descripcion;
    private int stock;
    private float precio;

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
