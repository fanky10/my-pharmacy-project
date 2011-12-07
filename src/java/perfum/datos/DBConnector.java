/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fanky <fanky10@gmail.com>
 * v0.01 creacion de la clase los atributos y metodos
 * v0.02 se cierra mas la clase y maneja el cerrado de conexiones,apertura,etc
 */
public abstract class DBConnector {
    protected Connection conn;
    public void closeConnection() throws SQLException{
        if(!connectionIsClosed())
            conn.close();
    }
    public boolean connectionIsClosed() throws SQLException{
        if(conn!=null){
            return conn.isClosed();
        }
        //si es nulo entonces ni la abrio
        return true;
    }
    public abstract void conectar() throws SQLException;
    public abstract ResultSet ejecuta_query(String query) throws SQLException ;
    public abstract Statement getStatement() throws SQLException;
    public abstract PreparedStatement getPreparedStatement(String stmt) throws SQLException;
    
    public static String adapta_string(String txt){
        return "'"+txt+"'";
    }
    public static String adapta_float(Float aFloat){
        return "'"+aFloat+"'";
    }
}
