<%-- 
    Document   : display_img
    Created on : 09/09/2010, 16:05:55
    Author     : Noelia S Franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="prodBean" scope="request" class="perfum.negocio.Productos"/>
    
        <%
        if ( request.getParameter("imgID") != null ){
            int id_producto = Integer.parseInt(request.getParameter("imgID")) ;
            try{
                // display the image
                byte[] imgData = prodBean.getImagenProducto(id_producto).getImagen();
                if(imgData!=null){
                    response.setContentType("image/gif");
                    java.io.OutputStream o = response.getOutputStream();
                    o.write(imgData);
                    o.flush();
                    o.close();
                }else{
                    out.println("img not found");
                }
            }catch(java.sql.SQLException e){
        %>
        <h1><%out.println("Exception: "+e.getMessage());%></h1>
        <%  }
        }else{
            out.println("img not found");
        }
        %>
