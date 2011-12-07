/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import perfum.Presentaciones;
import perfum.exceptions.ProductoNoEncontradoException;

/**
 *
 * @author Lacha
 */
public class Producto extends Data {
    public Producto(){
        super();
    }
    public perfum.Productos getProductos() throws SQLException{
        perfum.Productos prodV = new perfum.Productos();
        //que pasa si ningun producto esta en stock? si todos tienen stock 0? como informo al usuario "No hay productos en stock"? crear excepcion
        ResultSet rs = db.ejecuta_query("select * from producto as p inner join stock_productos as sp on sp.id_producto = p.id_producto");
        while(rs!=null && rs.next()){            
            perfum.Producto prod = new perfum.Producto();
            prod.setNombre(rs.getString("nombre"));
            prod.setId_producto(rs.getInt("id_producto"));
            prod.setDescripcion(rs.getString("descripcion"));
            prod.setPresentaciones(getPresentaciones(rs.getInt("id_producto")));
            prod.setDescripcion(rs.getString("descripcion"));
            prodV.add(prod);
        }
        return prodV;
        
    }
    /**
     *  
     * @param id_producto el id que figura en la db :)
     * @return toodas las presentaciones pertenecientes a un producto
     */
    private perfum.Presentaciones getPresentaciones(int id_producto) throws SQLException{
        Presentaciones presentacionV = new Presentaciones();
        String query = "select pres.id_presentacion,pres.descripcion as presentacion,prec.fecha_modificacion,prec.precio,st.stock from presentacion pres"
                + " JOIN (select * from precio order by fecha_modificacion desc) prec ON pres.id_presentacion = prec.id_presentacion"
                + " JOIN stock_productos st ON st.id_presentacion = prec.id_presentacion and st.id_producto = prec.id_producto"
                + " WHERE prec.id_producto = "+id_producto
                + " GROUP BY prec.id_producto, prec.id_presentacion";
        //System.out.println("debug: query = "+query);
        ResultSet rs = db.ejecuta_query(query);
        while(rs!=null && rs.next()){
            perfum.Presentacion presentacion = new perfum.Presentacion();
            presentacion.setDescripcion(rs.getString("presentacion"));
            presentacion.setId(rs.getInt("id_presentacion"));
            presentacion.setPrecio(rs.getFloat("precio"));
            presentacion.setStock(rs.getInt("Stock"));
            presentacionV.add(presentacion);
        }
        return presentacionV;
    }
    /**
     *
     * @param id_producto el id que figura en la db :)
     * @return toodas las presentaciones pertenecientes a un producto
     */
    public perfum.Presentacion getPresentacionProducto(int id_presentacion,int id_producto) throws SQLException{
        String query = "select pres.id_presentacion,pres.descripcion as presentacion,prec.fecha_modificacion,prec.precio,st.stock from presentacion pres"
                + " JOIN (select * from precio order by fecha_modificacion desc) prec ON pres.id_presentacion = prec.id_presentacion"
                + " JOIN stock_productos st ON st.id_presentacion = prec.id_presentacion and st.id_producto = prec.id_producto"
                + " WHERE prec.id_presentacion = "+id_presentacion+ " AND prec.id_producto="+id_producto
                + " GROUP BY prec.id_producto, prec.id_presentacion";
        //System.out.println("debug: query = "+query);
        ResultSet rs = db.ejecuta_query(query);
        while(rs!=null && rs.next()){
            perfum.Presentacion presentacion = new perfum.Presentacion();
            presentacion.setDescripcion(rs.getString("presentacion"));
            presentacion.setId(rs.getInt("id_presentacion"));
            presentacion.setPrecio(rs.getFloat("precio"));
            presentacion.setStock(rs.getInt("Stock"));
            return presentacion;
        }
        throw new UnsupportedOperationException("presentacion no encontrada con id: "+id_presentacion+" e idProducto: "+id_producto);
    }

    public perfum.Productos getRanking() throws SQLException{
        perfum.Productos prodV = new perfum.Productos();
        ResultSet rs = db.ejecuta_query("select * from producto where otros='Mujer' limit 5");
        while(rs!=null && rs.next()){
            perfum.Producto prod = new perfum.Producto();
            prod.setNombre(rs.getString("nombre"));
            prod.setId_producto(rs.getInt("id_producto"));
           
            prodV.add(prod);
        }
        return prodV;
    }

    public perfum.Productos getRankingHombres() throws SQLException{
        perfum.Productos prodV = new perfum.Productos();
        ResultSet rs = db.ejecuta_query("select * from producto where otros='Hombre' limit 5");
        while(rs!=null && rs.next()){
            perfum.Producto prod = new perfum.Producto();
            prod.setNombre(rs.getString("nombre"));
            prod.setId_producto(rs.getInt("id_producto"));
            prodV.add(prod);
        }
        return prodV;
    }
     public perfum.Producto getProducto(int id_producto) throws SQLException, ProductoNoEncontradoException{
        ResultSet rs = db.ejecuta_query("select * from producto where id_producto="+id_producto);
        while(rs!=null && rs.next()){
            perfum.Producto prod = new perfum.Producto();
            prod.setNombre(rs.getString("nombre"));
            prod.setId_producto(rs.getInt("id_producto"));
            prod.setDescripcion(rs.getString("descripcion"));
            return prod;
        }
        throw new ProductoNoEncontradoException(id_producto);
    }


    public perfum.Producto getImagenProducto(int id) throws SQLException{
        ResultSet rs = db.ejecuta_query("select imagen from producto where id_producto="+id);
        perfum.Producto prod = new perfum.Producto();
        Blob img;
        while(rs!=null && rs.next()){
            img = rs.getBlob("imagen");
            prod.setImagen(img!=null?img.getBytes(1,(int)img.length()):null);
        }
        return prod;
    }

}
