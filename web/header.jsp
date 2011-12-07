<%-- 
    Document   : header
    Created on : 29/07/2010, 15:40:40
    Author     : Fakeus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
        if ( request.getParameter("title") != null ){

            String title = request.getParameter("title") ;
            out.println("<title>"+title+"</title>");
            }else{
        %>

        <title>Le Perfum</title>
        <%}%>
    </head>
    <body>
        <form action="/Perfum/CheckLogin" method="POST">
        <table width="100%"  border="0" cellspacing="0" cellpadding="0" bgcolor="black" style="">
            <tr>
                <td rowspan="3" style="background-color: black">
                   <a href="<%=application.getInitParameter(perfum.util.Constantes.PARAMETER_HOME)%>">
                      <img src="/Perfum/images/le_perfum_header.jpg" alt="logo" width="500" height="80" border="0" />
                  </a>
                </td>
    <%if(session.getAttribute(perfum.util.Constantes.SESSON_CLIENTE_ATTRIBUTE)==null){%>
      
                <td>
                    <span style="color: #ffffff">
                    Usuario</span></td>
                <td>
                    <span style="color: #ffffff">
                    Password</span></td>
                <td>

                </td>
            </tr>
            <tr>
                <td style="width: 9px"> <input name="username" size=15 type="text" />
                    .</td>
                <td style="width: 9px"> <input type="password" name="password" size=15 type="text" />
                    .</td>
                    <td style="width: 9px"> <input type="submit" value="login" /> 
                    .</td>

            </tr>
    <%}else{%>
            
                <td style="width: 75px">
                    imagen1
                </td>
                <td style="width: 160px">
                    <span style="color: #ffffff">
                    Bienvenido <%=session.getAttribute(perfum.util.Constantes.SESSON_CLIENTE_ATTRIBUTE)%>
                    </span>
                    </td>
            </tr>
            <tr>
                <td style="width: 35px">
                    imagen1
                </td>
                <td style="width: 160px">
                    
                    <a href="<%=application.getInitParameter(perfum.util.Constantes.PARAMETER_HOME)%>">
                        <span style="color: #ffffff">
                        Ver Cuenta
                        </span>
                    </a>
                </td>
            </tr>
            <tr>
                <td style="width: 35px">
                    imagen1
                </td>
                <td style="width: 160px">
                    <a href="<%=application.getInitParameter(perfum.util.Constantes.PARAMETER_HOME)%>">
                        <span style="color: #ffffff">
                        Ver Carrito
                        </span>
                    </a>
                </td>
            </tr>
            <%}%>
        </table>
        </form>
    </body>
</html>
