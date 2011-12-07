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
import javax.servlet.http.HttpSession;
import perfum.Pedido;
import perfum.util.Constantes;
import perfum.util.Mailer;

/**
 *
 * @author facundo
 */
public class EnviarMailPedido extends HttpServlet {
   
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
            //TODO agregar a la base de datos el pedido (del cliente) si envia ok el email commit on catch rollback
            //TODO en el cuerpo del mensaje un link de nuestra webpage accediendo a confirmar pedido con id=id_pedido
            HttpSession session = request.getSession(true);
            perfum.Cliente cliente = (perfum.Cliente) session.getAttribute(Constantes.SESSON_CLIENTE_ATTRIBUTE);
            Pedido pedido = cliente.getPedido();
            pedido.setId_cliente(cliente.getId_cliente());
            int id_pedido = new perfum.negocio.Pedidos().guardarPedido(cliente.getPedido());
            

            //envia el emilio
            Mailer m = new Mailer();
            m.setSubject("Confirmacion de pedido");
            m.setMessage(cliente.getNombre()+"\n"
                    + "Usted ha hecho un pedido, y debe confirmarlo haciendo click en la siguiente direccion: "+this.getServletContext().getInitParameter(Constantes.PARAMETER_CONFIRMA_PEDIDO)+"?pedidoID="+id_pedido+"\""
                    + "\n"
                    + "Si usted no ha hecho ningun pedido elimine este email"
                    + "\n"
                    + "\n"
                    + "Saluda Atte."
                    + "Administracion de Perfum");
            m.sendMail(cliente.getEmail());

            //si sale todo ok, le seteamos un pedido en cero
            cliente.setPedido(new Pedido());//un pedido vacio asi, desp no le aparecen cosas que ya compro
            //finalmente mostramos la pagina ok
            out.println("<html>");
            //includes the header :)
            request.setAttribute("title", "Envio de e-Mail de Confirmacion Pedido");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/new_header.jsp");
            dispatcher.include(request, response);
//            out.println("<head>");
//            out.println("<title>EnviandoMailPedido</title>");
//            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"frame\" align=\"center\">");
            out.println("<h1>"+cliente.getNombre()+" le debería haber llegado un email a la cuenta: "+cliente.getEmail()+"</h1>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception ex){
            request.setAttribute("javax.servlet.jsp.jspException", ex);
            System.out.println("forwarding");
            //forward the control to your jsp error page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
            dispatcher.forward(request, response);
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
