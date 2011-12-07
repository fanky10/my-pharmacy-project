/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author facundo
 */
public class ConfirmarPedido extends HttpServlet {
   
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
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Confirmacion Pedido</title>");
//            out.println("</head>");
//            out.println("<body>");
//            if ( request.getParameter("id_pedido") != null){
//                int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
//                new perfum.negocio.Pedidos().confirmaPedido(id_pedido);
//                out.println("<h1>Se ha confirmado correctamente el pedido, paselo a buscar dentro de las 24hrs o sera cancelado :)</h1>");
//            }
//            out.println("</body>");

            
            out.println("</html>");
            out.println("<html>");
            //includes the header :)
            request.setAttribute("title", "Confirmando Pedido");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/new_header.jsp?title=Confirmando Pedido");
            dispatcher.include(request, response);
//            out.println("<head>");
//            out.println("<title>EnviandoMailPedido</title>");
//            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"frame\" align=\"center\">");
            if ( request.getParameter("id_pedido") != null){
                int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
                new perfum.negocio.Pedidos().actualizaStock(id_pedido);
                new perfum.negocio.Pedidos().confirmaPedido(id_pedido);
                out.println("<h1>Se ha confirmado correctamente el pedido</h1><br/> <h1>Paselo a buscar dentro de las 24hrs o sera cancelado :)</h1>");
            }else{
                out.println("<h1>Sin Parametros Suficientes</h1>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
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
