/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import javax.servlet.ServletContext;
import logging.Debugger;
import logging.MyLogger;
import perfum.datos.DBConnector;
import perfum.datos.MyDataSource;
import perfum.datos.MySQLDB;
import perfum.util.WebContextProvider;

/**
 *
 * @author 
 */
public class Configuracion {
    public static final String DB_CONFIGURATION_FILE = "database.properties";
    public static final String PROPERTIES_PACKAGE = "/perfum/properties/";
    private static final String PROPERTIES_VERSION = "version";
    private static final String PROPERTIES_DBCONN = "db_conn";
    private static DBConnector db;
    private static String real_path = null;
    private static final int MYSQLDB_CONN=0;
    private static final int MYDATASOURCE_CONN=1;
//    private static int db_type_conn = MYSQLDB_CONN;
    public static Properties getDBProperties() {
        try{
            String file_path = getRealPath()+DB_CONFIGURATION_FILE;
            Debugger.debug("getting system configuration from: "+file_path);
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(file_path);
            props.load(fis);
            fis.close();
            return props;
        }catch(IOException ex){
            MyLogger.getLogger(Configuracion.class).fatal(ex);
            //System.exit(-1);
        }
        return null;
    }

    /**
     * clase de configuracion para obtener mayormente el path donde nos encontramos ubicados
     * Constructor Deprecated, la configuracion solo utiliza atributos estaticos
     */
//    public Configuracion(){
//        try{
//            //context = WebContextProvider.get().getServletContext();
//            //logging.Debugger.debug("i got my context!! "+context.getContextPath());
//            String propFile = PROPERTIES_PACKAGE + Configuracion.class.getSimpleName().toLowerCase() + ".properties";
//            logging.Debugger.debug("looking up configuration file from: "+propFile);
//            properties = new Properties();
//            properties.load(Configuracion.class.getResourceAsStream(propFile));
//            version = properties.getProperty(PROPERTIES_VERSION);
////            db_type_conn = Integer.parseInt(properties.getProperty(PROPERTIES_DBCONN,String.valueOf(MYSQLDB_CONN)));
//        }catch(IOException e){
//            Debugger.debug(e.getMessage());
//            e.printStackTrace();
//        }
//    }
    public static void setRealPath(String real_path){
        Configuracion.real_path=real_path;
    }
    public static String getRealPath(){
        return real_path;
//        return WebContextProvider.get().getServletContext().getRealPath("/");
    }
    private String version;
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static DBConnector getDBConn(){
        if(db==null){
            createDBConnectorInstance();
        }
        return db;
    }
    private static void createDBConnectorInstance(){
        try{
            int db_type_conn = Integer.parseInt(getDBProperties().getProperty(PROPERTIES_DBCONN,String.valueOf(MYSQLDB_CONN)));
            System.out.println("tipo_con: "+db_type_conn);
            if(db_type_conn==MYSQLDB_CONN)
                db = new MySQLDB();
            else if(db_type_conn == MYDATASOURCE_CONN){
                db = new MyDataSource();
            }
        }catch(ClassNotFoundException ex){
            MyLogger.getLogger(Configuracion.class).warn(ex);
        }catch(InstantiationException ex){
            MyLogger.getLogger(Configuracion.class).warn(ex);
        }catch(IllegalAccessException ex){
            MyLogger.getLogger(Configuracion.class).warn(ex);
        }catch(Exception ex){
            MyLogger.getLogger(Configuracion.class).warn(ex);
        }
    }
    public static Calendar getHoraVerificacion(){
        Calendar cSchedule = Calendar.getInstance();
//        cSchedule.set(Calendar.AM, 12);//podria ser estatico para ahorrar mas memoria
        cSchedule.set(Calendar.HOUR_OF_DAY, 22);
        cSchedule.set(Calendar.MINUTE, 26);
        return cSchedule;
    }

}
