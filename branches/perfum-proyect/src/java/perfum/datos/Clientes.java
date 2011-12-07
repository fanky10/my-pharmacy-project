/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import logging.Debugger;
import perfum.exceptions.ClienteNotFoundException;

/**
 *
 * @author Hp
 */
public class Clientes extends Data{
    public Clientes() {
        super();
    }
    @Deprecated
    public perfum.Clientes getClientes() throws SQLException{
        throw new NoSuchMethodError("Este metodo no se usa mas");
//        perfum.Clientes cliV = new perfum.Clientes();
//        ResultSet rs = db.ejecuta_query("select * from cliente");
//        while(rs!=null && rs.next()){
//            perfum.Cliente cli = new perfum.Cliente();
//            cli.setNombre(rs.getString("nombre"));
//            cliV.add(cli);
//        }
//        return cliV;
        }
    public perfum.Cliente getCliente(String usuario,String password) throws SQLException, ClienteNotFoundException{
        PreparedStatement pstmt = db.getPreparedStatement("call getCliente(?,?)");
        pstmt.setString(1, usuario);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();        
        while(rs!=null && rs.next()){
            perfum.Cliente cliente = new perfum.Cliente();
            cliente.setId_cliente(rs.getInt("id_cliente"));
            cliente.setFecha_hora_ultima_session((rs.getTimestamp("fecha_hora_ultima_session")==null? new Date() : new Date(rs.getTimestamp("fecha_hora_ultima_session").getTime())));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setEmail(rs.getString("email"));
            cliente.setUsuario(rs.getString("usuario"));
            return cliente;
        }
        throw new ClienteNotFoundException();
        //TODO que tire una Exception Conocida
        //throw new UnsupportedOperationException("no encontre al cliente con los params");
    }
    public void updateClientSession(perfum.Cliente cliente) throws SQLException{
        String non_query = "update cliente set fecha_hora_ultima_session=current_timestamp where id_cliente="+cliente.getId_cliente();
        db.getStatement().executeUpdate(non_query);
}
}
