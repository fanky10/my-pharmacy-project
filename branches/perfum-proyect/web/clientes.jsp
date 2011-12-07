<%-- 
    Document   : clientes
    Created on : 24/06/2010, 15:29:26
    Author     : Fakeus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="cliBean" scope="request" class="perfum.negocio.Clientes"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
        <tr>
        <td width="20%"><b>Nombre</b></td>
        </tr>
        <%
        try{
        for(perfum.Cliente cli: cliBean.getClientes()){
            out.println("<tr><td with=\"20%\">"+cli.getNombre()+"</td></tr>");
        
        }
        }catch(java.sql.SQLException e){

        %>
        <h1><%
            out.println("lalalall Exception: "+e.getMessage());
        %></h1>
        <%}%>
        </table>
    </body>
</html>
