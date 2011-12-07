/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logging;

/**
 *
 * @author Hp
 */
public class Debugger {
    private static boolean DEBUG = true;
    public static void debug(String text){
        if(DEBUG)
            System.out.println("debug: "+text);
    }
}
