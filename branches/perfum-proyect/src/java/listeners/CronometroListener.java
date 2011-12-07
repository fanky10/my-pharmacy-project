/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package listeners;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import logging.MyLogger;
import perfum.util.MyTask;

/**
 * Web application lifecycle listener.
 * @author fanky
 */
public class CronometroListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
//        ServletContext servletContext = servletContextEvent.getServletContext();
//        try{
//            Timer timer = new Timer();
//            MyTask task = new MyTask();
//
//            Calendar calendar = Calendar.getInstance();
//            Date startTime = calendar.getTime();
//
//            timer.scheduleAtFixedRate(task, startTime, MyTask.SPEED);
//
//            servletContext.setAttribute ("timer", timer);
//            System.out.println("Initializing Cronometro Listener Application successfully");
//        } catch (Exception e) {
//            servletContext.log ("Problem initializing the task that was to run secondly (por los segundos viteh): " + e.getMessage ());
//        }
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
//        ServletContext servletContext = servletContextEvent.getServletContext();
//
//        Timer timer = (Timer)servletContext.getAttribute ("timer");
//
//        if (timer != null)
//            timer.cancel();
//
//        servletContext.removeAttribute ("timer");
//        System.out.println("Stopping Application successfully");

    }

    

}
