/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author fanky
 */
public class MyDataSource extends DBConnector{
    private DataSource datasource;
    public MyDataSource() throws NamingException, Exception{
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        if ( envContext == null ) {
           throw new Exception("Uh oh -- no EnviromentContext!");
        }
        datasource = (DataSource)envContext.lookup("jdbc/mysql");
        if ( datasource == null ) {
           throw new Exception("Data source not found!");
        }
            
    }


    public ResultSet ejecuta_query(String query) throws SQLException {
        return conn.createStatement().executeQuery(query);
    }

    public Statement getStatement() throws SQLException {
        return (Statement) conn.createStatement();
    }


    @Override
    public PreparedStatement getPreparedStatement(String stmt) throws SQLException{
        return conn.prepareStatement(stmt);
    }

    @Override
    public void conectar() throws SQLException {
        conn = datasource.getConnection();
    }
}
