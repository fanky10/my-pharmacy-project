/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;
import java.util.Date;

/**
 *
 * @author Lacha
 */
public class Pedido {
    public static final int SIN_CONFIRMAR=0;
    public static final int CONFIRMADO =1;
    public static final int ENTREGADO =2;
    public static final int CANCELADO = 3;
    public Pedido()
    {
        this.id_cliente = 0;
        this.id_pedido = 0;
        this.estado = 0;
        this.fecha_hora = new Date();
        this.lineas = new LineasDePedido();

    }
    public Pedido ( int id_pedido, int id_cliente, int estado, Date fecha_hora)
    {
        this.id_cliente = id_cliente;
        this.id_pedido = id_pedido;
        this.estado = estado;
        this.fecha_hora = fecha_hora;
        this.lineas = new LineasDePedido();
    }
    private int id_pedido;
    private int id_cliente;
    private int estado;
    private Date fecha_hora;
    private LineasDePedido lineas = new LineasDePedido();
    public float getTotal(){
        return lineas.getTotalPedido();
    }
    public LineasDePedido getLineas() {
        return lineas;
    }
    public void addLineaPedido(LineaDePedido li){
        lineas.add(li);
    }
    public void setLineas(LineasDePedido lineas) {
        this.lineas = lineas;
    }

    public int getId_pedido()
    {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido)
    {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente ()
    {
        return id_cliente;
    }
    public void setId_cliente (int id_cliente)
    {
        this.id_cliente = id_cliente;
    }
    public int getEstado ()
    {
        return estado;
    }
    public void setEstado (int estado)
    {
        this.estado = estado;
    }

    public Date setFecha_hora()
    {
        return fecha_hora;
    }

    public void setFecha_hora (Date fecha_hora)
    {
        this.fecha_hora = fecha_hora;
    }
}
