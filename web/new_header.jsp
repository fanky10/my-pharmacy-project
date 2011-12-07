<%-- 
    Document   : new_header
    Created on : 09-sep-2010, 16:47:57
    Author     : fanky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
    if ( request.getParameter("title") != null ){
        String title = request.getParameter("title") ;
        out.println("<title>"+title+"</title>");
    }else{
%>
<title>Le Perfum</title>
<%}%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="robots" content="all" />
<link href="/Perfum/style/screen.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="/Perfum/javascript/functions.js">
</script>
</head>
<body>
<div id="logo"
	<h1><a href="#">Le Perfum</a></h1>
	<h2>Las mejores fragancias online</h2>
</div>
<div id="menu">
	<ul>
            <li id="liWho"><a href="/Perfum/principal.jsp" accesskey="1" title="" onclick="javascript:activate(document.getElementById('liWho'))">Quiénes somos</a></li>
		<li id="liProd"><a href='/Perfum/product_list.jsp' accesskey="2" title="" onclick="javascript:activate(document.getElementById('liProd'))">Productos</a></li>
		<li id="liCta"><a href="/Perfum/private/mi_cuenta.jsp" accesskey="3" title="" onclick="javascript:activate(document.getElementById('liCta'))">Mi Cuenta</a></li>
		<li id="liCon"><a href="/Perfum/contacto.jsp" accesskey="4" title="" onclick="javascript:activate(document.getElementById('liCon'))">Contacto</a></li>
                
                <%
                //lo hice aca xq aca ya esta creado el nodo como para activarlo :)
                //tendria que pasarselo de alguna forma menos villera PERO ANDA!!
    if(request.getParameter("linkAct")!=null){
        out.println("<script type=\"text/javascript\">");
        //out.println("window.onload = select(document.getElementById('"+request.getParameter("linkAct")+"'));");
        out.println("select(document.getElementById('"+request.getParameter("linkAct")+"'));");
        out.println("function select(element){"
                //+ "alert('activando elemento...');"
                + "element.setAttribute(\"class\",\"active\");"
                + "}");
        out.println("</script>");
   }
%>
	</ul>
	<hr />

</div>
      <div style="text-align:right;">
        <embed SRC="/Perfum/style/sitx.mid" height="60" width="144" autostart="true"> </embed>
    </div>
</html>
