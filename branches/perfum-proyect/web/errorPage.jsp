<%-- 
    Document   : errorPage
    Created on : 13/09/2010, 21:42:48
    Author     : Noelia S Franco
--%>

<%@ page isErrorPage="true" %>

<html>
   <jsp:include page="new_header.jsp?linkAct=liWho&title=Le Pefum Home"/>

<body>
    <div class="frame" align="center">
        <%
        if(exception!=null){
            out.println("Ha ocurrido la siguiente Exception: "+exception.getMessage());
            out.println("<br/>");
            out.println("Los administradores fueron avisados de dicha situacion");
            out.println("<br/>");
            out.println("Disculpe las molestias");
            exception.printStackTrace();
        }
        %>
	</div>
</body>
</html> 