/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perfum.util;

/**
 *
 * @author Hp
 */

import javax.servlet.ServletContext;
@Deprecated
public class WebContextProvider {
    private static ThreadLocal user = new ThreadLocal();
    
    public static void set(ServletContext context) {
        user.set(new WebContext(context));
    }

    public static WebContext get() {
        return (WebContext) user.get();
    }

    public static void unset() {
        user.set(null);
    }
}