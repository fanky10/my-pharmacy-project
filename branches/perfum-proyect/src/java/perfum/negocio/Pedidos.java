/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.negocio;

import java.sql.SQLException;

/**
 *
 * @author fanky
 */
public class Pedidos {
    private perfum.datos.Pedidos dPedidos;
    public Pedidos(){//throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        dPedidos = new perfum.datos.Pedidos();
    }
    public perfum.Pedidos getPedidos(perfum.Cliente cliente) throws SQLException{
        try{
            dPedidos.openConn();
            perfum.Pedidos pedidoV = dPedidos.getPedidos(cliente);
            return pedidoV;
        }finally{
            dPedidos.closeConn();
        }
    }
    public perfum.Pedido getPedido(int id_pedido) throws SQLException{
        try{
            dPedidos.openConn();
            perfum.Pedido pedido = dPedidos.getPedido(id_pedido);
            return pedido;
        }finally{
            dPedidos.closeConn();
        }
    }

     public perfum.LineasDePedido getLineasPedidos(perfum.Pedido p) throws SQLException{
        try{
            dPedidos.openConn();
            perfum.LineasDePedido ldp = dPedidos.getLineasPedidos(p);
            return ldp;
        }finally{
            dPedidos.closeConn();
        }
    }




    public int guardarPedido(perfum.Pedido pedido) throws SQLException{
        try{
            dPedidos.openConn();
            return dPedidos.guardaPedido(pedido);
        }finally{
            dPedidos.closeConn();
        }
    }
    public void confirmaPedido(int id_pedido) throws SQLException{
        try{
            dPedidos.openConn();
            dPedidos.cambiaEstadoPedido(id_pedido,perfum.Pedido.CONFIRMADO);
        }finally{
            dPedidos.closeConn();
        }
    }
    public void actualizaStock(int id_pedido) throws SQLException{
        try{
            dPedidos.openConn();
            dPedidos.actualizaStock(id_pedido);
        }finally{
            dPedidos.closeConn();
        }
    }
}
