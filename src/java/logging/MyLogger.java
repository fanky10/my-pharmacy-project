/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import perfum.config.Configuracion;

/**
 *
 * @author Prog1
 */
public class MyLogger extends Logger {
    private static String FQCN = MyLogger.class.getName() + ".";
    public static String CONFIGURATION_FILE = "perfumlog.properties";
//  It's enough to instantiate a factory once and for all.
  private static MyLoggerFactory myFactory = new MyLoggerFactory();

  /**
     Just calls the parent constuctor.
   */
  public MyLogger(String name) {
    super(name);
  }

  /**
     This method overrides {@link Logger#getLogger} by supplying
     its own factory type as a parameter.
  */
    public  static  Logger getLogger(String className) {
        //configures the logger from a properties file
        //default user.dir
        PropertyConfigurator.configure(Configuracion.getRealPath()+CONFIGURATION_FILE);
        return Logger.getLogger(className, myFactory);
    }
    
    private static String file_path;

    public static void setFile_path(String file_path) {
        MyLogger.file_path = file_path;
    }
}
