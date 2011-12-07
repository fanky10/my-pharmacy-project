/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

/**
 *
 * @author Lacha
 */
public class LineaDePedido {

    public LineaDePedido()
    {
        this(0, new Producto(), new Presentacion(),1);
    }

    public LineaDePedido(int id_linea_pedido, perfum.Producto producto)
    {
        this(id_linea_pedido, producto, new Presentacion(),1);
    }
    public LineaDePedido(int id_linea_pedido, perfum.Producto producto,perfum.Presentacion presentacion)
    {
        this(id_linea_pedido, producto, presentacion,1);
    }
    public LineaDePedido(int id_linea_pedido, perfum.Producto producto,perfum.Presentacion presentacion,int cantidad)
    {
        this.id_linea_pedido=id_linea_pedido;
        this.producto=producto;
        this.presentacion=presentacion;
        this.cantidad=cantidad;
        this.monto = presentacion.getPrecio()*cantidad;
    }
    
    private int id_linea_pedido;
    private int cantidad;
    private perfum.Producto producto;
    //es la presentacion perteneciente al producto en cuestion, no cualquiera ehhh!
    private perfum.Presentacion presentacion;
    private float monto;

    public void setMonto(float monto) {
        this.monto = monto;
    }
    public float getMonto(){
        return monto;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getId_linea_pedido()
    {
        return id_linea_pedido;
    }
    public void setId_linea_pedido(int id_linea_pedido)
    {
        this.id_linea_pedido = id_linea_pedido;
    }
    public int getCantidad ()
    {
        return cantidad;
    }
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }
}
