/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.exceptions;

/**
 *
 * @author Fanky <fanky10@gmail.com>
 */
public class ClienteNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "Verifique usuario y password :)";
    }
}
