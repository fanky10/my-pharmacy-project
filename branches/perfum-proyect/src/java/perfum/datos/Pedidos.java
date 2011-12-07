/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import perfum.LineaDePedido;
import perfum.Presentacion;
import perfum.exceptions.ProductoNoEncontradoException;

/**
 *
 * @author fanky
 */
public class Pedidos extends Data{
    public Pedidos(){
        super();
    }
    public perfum.Pedidos getPedidos(perfum.Cliente cliente) throws SQLException{
        perfum.Pedidos pedidoV = new perfum.Pedidos();
        String query = "select * from pedido where id_cliente = "+cliente.getId_cliente();
        ResultSet rs = db.ejecuta_query(query);
        while(rs.next()){
//            perfum.Pedido pedido = new perfum.Pedido(rs.getInt("id_pedido"), rs.getInt("id_cliente"), rs.getInt("estado"), new Date(rs.getTimestamp("fecha_hora").getTime()));
//            pedido.setLineas(getLineasPedidos(pedido));
            pedidoV.add(getPedido(rs.getInt("id_pedido")));
        }
        return pedidoV;
    }

    
    public perfum.Pedido getPedido(int id_pedido) throws SQLException{
        String query = "select * from pedido where id_pedido = "+id_pedido;
        ResultSet rs = db.ejecuta_query(query);
        while(rs.next()){
            perfum.Pedido pedido = new perfum.Pedido(rs.getInt("id_pedido"), rs.getInt("id_cliente"), rs.getInt("estado"), new Date(rs.getTimestamp("fecha_hora").getTime()));
            pedido.setLineas(getLineasPedidos(pedido));
            return pedido;
        }
        throw new UnsupportedOperationException("pedido no encontrado con id: "+id_pedido);
    }
    public perfum.LineasDePedido getLineasPedidos(perfum.Pedido pedido) throws SQLException{
        perfum.LineasDePedido lpV = new perfum.LineasDePedido();
        String query = "select lp.*, p.nombre as producto, pres.descripcion as presentacion,p.id_marca, m.descripcion as marca from linea_pedido lp "
                + " join producto p on p.id_producto = lp.id_producto"
                + " join marca m on m.id = p.id_marca"
                + " join precio prec on prec.id_presentacion = lp.id_presentacion and prec.id_producto = lp.id_producto"
                + " join presentacion pres on pres.id_presentacion = prec.id_presentacion"
                + " where id_pedido = "+pedido.getId_pedido();
        //System.out.println("pedidos query: "+query);
        ResultSet rs = db.ejecuta_query(query);
        while(rs.next()){
            perfum.LineaDePedido linea = new perfum.LineaDePedido();
            linea.setId_linea_pedido(rs.getInt("id_linea_pedido"));
            linea.setCantidad(rs.getInt("cantidad"));
            linea.setProducto(new perfum.Producto(rs.getInt("id_producto"), rs.getString("producto"), null));
            linea.setPresentacion(new Presentacion(rs.getInt("id_presentacion"), rs.getString("presentacion")));
            linea.setMonto(rs.getFloat("monto"));
            lpV.add(linea);
        }
        return lpV;
    }
    

    public int guardaPedido(perfum.Pedido pedido) throws SQLException{
        String non_query="insert into pedido values (null,current_timestamp,"+pedido.getId_cliente()+","+perfum.Pedido.SIN_CONFIRMAR+")";
        //System.out.println("insert pedido nonquery: "+non_query);
        db.getStatement().executeUpdate(non_query);
        String query = "select max(id_pedido) id_pedido from pedido";
        ResultSet rs = db.ejecuta_query(query);
        if(rs.next()){
            int id_pedido_gen = rs.getInt("id_pedido");
            int nro_linea_pedido =1;
            for(LineaDePedido li: pedido.getLineas()){
                non_query = "insert into linea_pedido values("+nro_linea_pedido+","+id_pedido_gen+","+li.getProducto().getId_producto()+","+li.getPresentacion().getId()+","+li.getCantidad()+","+DBConnector.adapta_float(li.getMonto())+")";
                db.getStatement().executeUpdate(non_query);
                nro_linea_pedido++;
            }
            return id_pedido_gen;
        }
        return -1;
    }
    public void cambiaEstadoPedido(int id_pedido, int estado) throws SQLException{
        String non_query = "update pedido set estado = "+estado+" WHERE id_pedido="+id_pedido;
        db.getStatement().executeUpdate(non_query);
    }
    public void actualizaStock(int id_pedido) throws SQLException{
        String non_query = "update stock_productos st "
                + " join linea_pedido lp on st.id_presentacion = lp.id_presentacion and st.id_producto = lp.id_producto"
                + " set stock = stock - lp.cantidad"
                + " where lp.id_pedido ="+id_pedido;
        db.getStatement().executeUpdate(non_query);

    }
}
