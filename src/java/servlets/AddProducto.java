/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import perfum.LineaDePedido;
import perfum.exceptions.ProductoNoEncontradoException;
import perfum.util.Constantes;

/**
 *
 * @author fanky
 */
public class AddProducto extends HttpServlet {
    private static boolean DEBUG=true;
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
            if ( request.getParameter("id_producto") != null || request.getParameter("id_presentacion")!=null){
                int id_producto = Integer.parseInt(request.getParameter("id_producto"));
                int id_presentacion = Integer.parseInt(request.getParameter("id_presentacion"));
                perfum.Producto producto = ((perfum.Productos)getServletContext().getAttribute(Constantes.SERVLET_CONTEXT_PRODUCTOS_ATTRIBUTE)).getProducto(id_producto);
                perfum.Presentacion presentacion = producto.getPresentacion(id_presentacion);
                HttpSession session = request.getSession(true);
                perfum.Cliente cliente = (perfum.Cliente) session.getAttribute(Constantes.SESSON_CLIENTE_ATTRIBUTE);
                if(producto==null){
                    throw new IllegalArgumentException("Error en el producto ( el producto es null )");
                }else if(cliente.getPedido() == null){
                    throw new IllegalArgumentException("Error en el Pedido ( el pedido es null )");
                }else if(presentacion == null){
                    throw new IllegalArgumentException("Error en la presentacion ( la presentacion es null )");
                }
                cliente.getPedido().addLineaPedido(new LineaDePedido(0,producto,presentacion));
                debug("pedido size: "+cliente.getPedido().getLineas().size());
                response.sendRedirect(this.getServletContext().getInitParameter(Constantes.PARAMETER_PEDIDO_PRODUCTOS));
            }else{
                throw new UnsupportedOperationException("parameter is null!");
            }
        }catch(ProductoNoEncontradoException ex){
             request.setAttribute("javax.servlet.jsp.jspException", ex);
              System.out.println("forwarding");
              //forward the control to your jsp error page
              RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
              dispatcher.include(request, response);
        }catch(Exception ex){


                 request.setAttribute("javax.servlet.jsp.jspException", ex);
                  System.out.println("forwarding");
                  //forward the control to your jsp error page
                  RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
                  dispatcher.include(request, response);
        }
        finally {
            out.close();
        }
    }
    private void debug(String message){
        if(DEBUG){
            System.out.println("debug: "+message);
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
