/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

/**
 *
 * @author Hp
 */
public class Marca {
    public Marca(){

    }
    public Marca(int id,String desc){
        this.id = id;
        this.descripcion = desc;
    }
    private int id;
    private String descripcion;

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
