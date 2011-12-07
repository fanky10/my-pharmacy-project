/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.datos;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import perfum.config.Configuracion;

/**
 *
 * @author Fanky <fanky10@gmail.com>
 */
public class MySQLDB extends DBConnector{
    private static final String MYSQL_STR_CNN = "jdbc:mysql://";
    private static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DEFAULT_USER = "dbop";
    private String host;
    private String nombre_db;
    private int port;
    private String usuario;

    public MySQLDB() throws  ClassNotFoundException, InstantiationException, IllegalAccessException{
        Properties props = Configuracion.getDBProperties();
        host = (props.getProperty("host", "localhost"));
        nombre_db = (props.getProperty("database","crucibase"));
        port = (Integer.parseInt(props.getProperty("port", "3306")));
        usuario = (props.getProperty("user",DEFAULT_USER));
        Class.forName(MYSQL_DRIVER_CLASS).newInstance();

    }
    public void conectar() throws SQLException{
        //System.out.println("conectandome a: "+getURLConn());
        conn = DriverManager.getConnection(getURLConn(), usuario, ("none".equals(usuario)?"":"dbop-510"));
        //System.out.println("success");
    }

    public ResultSet ejecuta_query(String query) throws SQLException {
        return conn.createStatement().executeQuery(query);
    }

    public Statement getStatement() throws SQLException {
        return (Statement) conn.createStatement();
    }
    private String getURLConn(){
        return MYSQL_STR_CNN+ host + ":" + port + "/" + nombre_db;
    }

    @Override
    public PreparedStatement getPreparedStatement(String stmt) throws SQLException{
        return conn.prepareStatement(stmt);
    }
}
