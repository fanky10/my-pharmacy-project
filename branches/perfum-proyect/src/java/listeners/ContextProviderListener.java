/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import perfum.config.Configuracion;
import perfum.util.WebContextProvider;

/**
 * Web application lifecycle listener.
 * @author fanky
 */
public class ContextProviderListener implements ServletContextListener {
public void contextInitialized(ServletContextEvent servletContextEvent)
    {
       ServletContext context = servletContextEvent.getServletContext();
       Configuracion.setRealPath(context.getRealPath("/"));
       //WebContextProvider.set(context);
       System.out.println("DEBUG: Initializing ContextProvider Application successfully");
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        Configuracion.setRealPath(null);
        System.out.println("DEBUG: Destroying ContextProvider Application successfully");
        //WebContextProvider.unset();

    }
}
