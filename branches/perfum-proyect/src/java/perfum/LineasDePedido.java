/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum;

/**
 *
 * @author Lacha
 */

public class LineasDePedido extends java.util.ArrayList<LineaDePedido> implements java.io.Serializable {
    @Override
    public boolean add(LineaDePedido lip){
        for(LineaDePedido li : this){
            if(li.getProducto().equals(lip.getProducto()) && li.getPresentacion().equals(lip.getPresentacion())){
                int cantidad = li.getCantidad()+1;
                li.setCantidad(cantidad);
                return true;
            }
        }
        return super.add(lip);
    }

    public float getTotalPedido() {
        float reto = 0f;
        for(LineaDePedido li: this){
            reto += li.getCantidad()*li.getPresentacion().getPrecio();
        }
        return reto;
    }
}
