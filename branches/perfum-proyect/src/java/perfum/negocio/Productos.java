/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.negocio;

import java.io.IOException;
import java.sql.SQLException;
import perfum.exceptions.ProductoNoEncontradoException;

/**
 *
 * @author Fakeus
 */
public class Productos {
    private perfum.datos.Producto dProductos;
    public Productos(){//throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        dProductos = new perfum.datos.Producto();
    }
    public perfum.Productos getProductos() throws SQLException{
        try{
            dProductos.openConn();
            perfum.Productos productoV = dProductos.getProductos();
            return productoV;
        }finally{
            dProductos.closeConn();
        }
    }

     public perfum.Productos getRanking() throws SQLException{
        try{
            dProductos.openConn();
            perfum.Productos productoV = dProductos.getRanking();
            return productoV;
        }finally{
            dProductos.closeConn();
        }
    }

    public perfum.Productos getRankingHombres() throws SQLException{
        try{
            dProductos.openConn();
            perfum.Productos productoV = dProductos.getRankingHombres();
            return productoV;
        }finally{
            dProductos.closeConn();
        }
        
    }
    public perfum.Producto getImagenProducto(int id_producto) throws SQLException{
        try{
            dProductos.openConn();
            perfum.Producto p = dProductos.getImagenProducto(id_producto);
            return p;
        }finally{
            dProductos.closeConn();
        }

    }

    public perfum.Producto getProducto(int id_producto) throws SQLException, ProductoNoEncontradoException{
        try{
            dProductos.openConn();
            perfum.Producto p = dProductos.getProducto(id_producto);
            return p;
        }finally{
            dProductos.closeConn();
        }
    }
    public perfum.Presentacion getPresentacionProducto(int id_presentacion,int id_producto) throws SQLException{
        try{
            dProductos.openConn();
            perfum.Presentacion p = dProductos.getPresentacionProducto(id_presentacion,id_producto);
            return p;
        }finally{
            dProductos.closeConn();
        }
    }

    
}
