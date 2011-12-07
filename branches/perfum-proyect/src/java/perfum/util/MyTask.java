/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.util;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import perfum.config.Configuracion;

/**
 *
 * @author fanky
 */
public class MyTask extends TimerTask{  //implements Runnable{
    public static final int SPEED = 1000;//cada un segundin
    
    @Override
    public void run() {
        Calendar cHoy = Calendar.getInstance();
        Date dHoy = cHoy.getTime();
        if(dHoy.equals(Configuracion.getHoraVerificacion().getTime())){
            System.out.println("son las "+Constantes.DATETIME_FORMATTER.format(dHoy)+" a verificaaar...");

        }
    }

}

