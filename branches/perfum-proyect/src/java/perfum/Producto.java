/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

import perfum.exceptions.PresentacionNoEncontradaException;

/**
 *
 * @author Hp
 */
public class Producto implements java.io.Serializable{
    public Producto(){
        
    }
    public Producto(int id, String nombre, String desc){
        this.id_producto = id;
        this.nombre = nombre;
        this.descripcion=desc;
    }
    private int id_producto;
    private String nombre;
    private Marca marca;
    private byte[] imagen;
    private String descripcion;
    private Presentaciones presentaciones;

    public Presentaciones getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(Presentaciones presentaciones) {
        this.presentaciones = presentaciones;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public Presentacion getPresentacion(int id_presentacion) throws PresentacionNoEncontradaException{
        return presentaciones.getPresentacion(id_presentacion);
    }
}
