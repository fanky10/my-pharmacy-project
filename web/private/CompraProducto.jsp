<%-- 
    Document   : CompraProducto
    Created on : 24/08/2010, 17:16:23
    Author     : Noelia S Franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="prodBean" scope="request" class="perfum.negocio.Productos"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% 
        if ( request.getParameter("prodID") != null ){
            try{
            int id_producto = Integer.parseInt(request.getParameter("prodID")) ;
            perfum.Producto p = prodBean.getProducto(id_producto);
            out.println("<title>Usted esta por agregar a su carrito el producto: "+p.getNombre()+"</title>");

    %>
            </head>
            <body>
               Agreguemos el producto!! (por aqui una imagen)

            <%
            }catch(java.sql.SQLException e){
        %>
        <h1><%out.println("Exception: "+e.getMessage());%></h1>
        <%  }catch(perfum.exceptions.ProductoNoEncontradoException ex){
        %>
        <h1><%out.println("Exception: "+ex.getMessage());%></h1>
        <%
            }//fin catch
        }else{
            out.println("parametros insuficientes.. redirigiendo...");
        }
    %>
</body>
</html>