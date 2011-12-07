/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.SQLException;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logging.Debugger;
import perfum.exceptions.ClienteNotFoundException;
import perfum.util.Constantes;

/**
 *
 * @author Hp
 */
public class CheckLogin extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if(request.getMethod().equals("POST")){
                try {
                    getEstadoLogin(request, response);
                
//                }catch(SQLException ex){
//                    out.println("<h1>SQLException: "+ex.getMessage()+"<h1>");
                }catch(ClienteNotFoundException ex){
//                    throw new ServletException(ex);
                    out.println("<html>");
                    out.println("<h1>Verifique usuario y password</h1>");
                    //includes the header :)
//                    request.setAttribute("title", "Envio de e-Mail de Confirmacion Pedido");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/new_header.jsp");
                    dispatcher.include(request, response);

                    out.println("<body>");
                    out.println("<div class=\"frame\" align=\"center\">");
                    out.println("<h1>"+ex.getMessage()+"</h1>");
                    out.println("<a href=\"/Perfum/login.jsp\">Volver a Loguearme</h1>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");

                }catch (Exception ex) {
                 request.setAttribute("javax.servlet.jsp.jspException", ex);

                  RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
                  dispatcher.include(request, response);
                }
            }

        } finally {
            out.close();
        }
    }
    private void getEstadoLogin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException, ServletException, ClienteNotFoundException{
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
        Debugger.debug("buscando bicho con: "+username+":"+passwd);
        //TODO: CHEQUEAR ESTA VALIDACION EN EL CLIENTE!
//        if(username==null && passwd==null)
//            out.println("<B>Usted no tiene permisos suficientes para ver esta pagina</B>");
//        if(username.trim().equals("") || passwd.trim().equals(""))
//            out.println("<B>Usted no tiene permisos suficientes para ver esta pagina</B>");
        //String path  = this.getServletContext().getRealPath("/");
        perfum.Cliente cli = new perfum.negocio.Clientes().getCliente(username, passwd);
        if(cli!=null){
            HttpSession session = request.getSession();
            Debugger.debug("setting session's attribute");
            session.setAttribute(Constantes.SESSON_CLIENTE_ATTRIBUTE, cli);
            String requestedUrl = (String) session.getAttribute(Constantes.REQUESTED_URL);
            Debugger.debug("requested URL[CheckLogin]: "+requestedUrl);
            if(requestedUrl!=null){
                response.sendRedirect(requestedUrl);
            }else{
                response.sendRedirect(this.getServletContext().getInitParameter(Constantes.PARAMETER_HOME));
            }
        }else{
            Debugger.debug("bad login!");
            out.println("<B>badLogin</B>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
