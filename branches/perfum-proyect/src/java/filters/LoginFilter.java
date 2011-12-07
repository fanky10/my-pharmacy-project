/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filters;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logging.Debugger;
import perfum.Cliente;
import perfum.util.Constantes;

/**
 *
 * @author Hp
 * este filter ha sido creado por el IDE :)
 *
 */
public class LoginFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public LoginFilter() {
    } 
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {
        Debugger.debug("Authentication: Request received ...");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        boolean autorizado = false;
        Cliente client = (Cliente) httpRequest.getSession().getAttribute(Constantes.SESSON_CLIENTE_ATTRIBUTE);
        if(client!=null)
            autorizado=true;
        if (autorizado) {
            Debugger.debug("This dude is authorized!");
            //guardo cuando se logueo el wachin ;)
            try{
                new perfum.negocio.Clientes().clienteInicioSession(client);
            }catch(SQLException ex){
                Debugger.debug("sqlException carefully read: "+ex.getMessage());
            }catch(Exception ex){
                Debugger.debug("another kind of exception: "+ex.getMessage());
            }
            //sigue filtrando..
            chain.doFilter(request, response);
            //FIXME
//            arma_urlReq(httpRequest);
//            ServletContext context = filterConfig.getServletContext();
//            String login_page = context.getInitParameter(Constantes.PARAMETER_LOGIN);
//            Debugger.debug("Authentication: Login page = " + login_page);
//            if (login_page != null && !"".equals(login_page)) {
//                context.getRequestDispatcher(login_page).forward(request, response);
//            }
        } else if (filterConfig != null) {
            arma_urlReq(httpRequest);
            ServletContext context = filterConfig.getServletContext();
            String login_page = context.getInitParameter(Constantes.PARAMETER_LOGIN);
            Debugger.debug("Authentication: Login page = " + login_page);
            if (login_page != null && !"".equals(login_page)) {
                context.getRequestDispatcher(login_page).forward(request, response);
            }
        } else {
            throw new ServletException ("FilterConfiguration failure");
        }
        Debugger.debug("Authentication: Response dispatched ...");
    }
    private void arma_urlReq(HttpServletRequest httpRequest){
        // don't overwrite the original request path if already present
        // oh yeah i am motherfucking to overwrite it :D
        String requestedUrl = httpRequest.getRequestURL().toString();
            if (httpRequest.getQueryString() != null) {
                requestedUrl = requestedUrl + "?" + httpRequest.getQueryString();
            }
            Debugger.debug("setting new URL[LoginFilter]: "+requestedUrl);
            httpRequest.getSession().setAttribute(Constantes.REQUESTED_URL, requestedUrl);
//        String requestedUrl = (String) httpRequest.getSession().getAttribute(Constantes.REQUESTED_URL);
//        Debugger.debug("requested URL[LoginFilter]: "+requestedUrl);
//        if (requestedUrl != null) {
//            httpRequest.getSession().setAttribute(Constantes.REQUESTED_URL, requestedUrl);
//        } else {
//            requestedUrl = httpRequest.getRequestURL().toString();
//            if (httpRequest.getQueryString() != null) {
//                requestedUrl = requestedUrl + "?" + httpRequest.getQueryString();
//            }
//            Debugger.debug("setting new URL[LoginFilter]: "+requestedUrl);
//            httpRequest.getSession().setAttribute(Constantes.REQUESTED_URL, requestedUrl);
//        }
    }

    
    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
	return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter 
     */
    public void destroy() { 
    }

    /**
     * Init method for this filter 
     */
    public void init(FilterConfig filterConfig) { 
        this.filterConfig = filterConfig;
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null)
            return ("LoginFilter()");
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
}
