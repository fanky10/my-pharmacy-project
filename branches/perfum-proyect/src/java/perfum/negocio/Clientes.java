/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.negocio;

import java.io.IOException;
import java.sql.SQLException;
import perfum.exceptions.ClienteNotFoundException;

/**
 *
 * @author Hp
 */
public class Clientes {
    private perfum.datos.Clientes dClientes;
    public Clientes(){//throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        dClientes = new perfum.datos.Clientes();
    }
    @Deprecated
    public perfum.Clientes getClientes() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        throw new NoSuchMethodError("getClientes is deprecated");
//        try{
//            dClientes.openConn();
//            perfum.Clientes clienteV = dClientes.getClientes();
//            return clienteV;
//        }finally{
//            dClientes.closeConn();
//        }
    }
    public perfum.Cliente getCliente(String user,String pass) throws SQLException, ClienteNotFoundException{
        try{
            dClientes.openConn();
            perfum.Cliente cli = dClientes.getCliente(user, pass);
            return cli;
        }finally{
            dClientes.closeConn();
        }
    }
    public void clienteInicioSession(perfum.Cliente cliente) throws SQLException{
        try{
            dClientes.openConn();
            dClientes.updateClientSession(cliente);
        }finally{
            dClientes.closeConn();
}
    }

}
