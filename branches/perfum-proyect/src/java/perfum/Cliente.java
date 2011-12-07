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
public class Cliente {
    public Cliente(){
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.email = "";
        this.usuario = "";
        this.password = "";
        this.pedido = new Pedido();
    }
    public Cliente(String nombre, String apellido,String direccion,String tel,String email,String usuario, Pedido pedido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = tel;
        this.email = email;
        this.usuario = usuario;
        this.pedido = pedido;
    }
    public String toString(){
        return nombre + " " + apellido;
    }
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String usuario;
    private String password;
    private Pedido pedido;
    private int id_cliente;
    private Date fecha_hora_ultima_session;

    public Date getFecha_hora_ultima_session() {
        return fecha_hora_ultima_session;
    }

    public void setFecha_hora_ultima_session(Date fecha_hora_ultima_session) {
        this.fecha_hora_ultima_session = fecha_hora_ultima_session;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

   

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


}
