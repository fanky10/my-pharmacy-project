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
public class WebContext {
    private ServletContext context;

    public WebContext(ServletContext context){
        this.context = context;
    }
    public ServletContext getServletContext() {
        return context;
    }
}