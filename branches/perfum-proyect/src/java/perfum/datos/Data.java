/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;

import java.sql.SQLException;
import perfum.config.Configuracion;

/**
 *
 * @author fanky
 */
public class Data {
    protected DBConnector db;
    public Data(){
        db = Configuracion.getDBConn();
    }
    public void openConn() throws SQLException{
        if(db.connectionIsClosed())
            db.conectar();
    }
    public void closeConn() throws SQLException{
        if(db instanceof MyDataSource){
            //System.out.println("DEBUG es DataSource, no cerramos conexion");
            return;
        }
        if(!db.connectionIsClosed())//evitemos sqlExceptions xD
            db.closeConnection();
    }
}
