<%-- 
    Document   : producto
    Created on : 06/09/2010, 17:41:43
    Author     : Noelia S Franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="prodBean" scope="request" class="perfum.negocio.Productos"/>

<html>
<jsp:include page="new_header.jsp?linkAct=liProd&title=Productos Destacados"/>
<link href="style/screen.css" rel="stylesheet" type="text/css" media="screen" />
<body>


<div id="bg">
    <!--
    <div id="carritoderecha">
usted ha comprado... recuperar de la base lo q ha comprado
</div>
    !-->
	<div id="page">
	<hr />
         <div id="flash" style="text-align: right;">
    <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab" width="300" height="200" align="rigth" >
<param name="movie" value="http://nsf123.fileave.com/coolbloks.swf" />
<embed src="http://nsf123.fileave.com/coolbloks.swf"  width="350" height="300" name="Juego" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" align="right" float="right"></embed></object>
</div>
        <h1 class="titulo">Perfumes disponibles </h1>
        <div id="content">
           
            <table class="tbl-productos" align="left" cellspacing="25px">
          

               <%
        try{
        for(perfum.Producto prod: prodBean.getProductos()){
            out.println("<tr class='alt'>"
                    + "<th with=\"200000\">");
            //la imagen del producto
            out.println("<a href='info_producto.jsp?prodID="+prod.getId_producto()+"'>"
                    +"<img alt="+prod.getNombre()+"\" src=\"display_img.jsp?imgID="+prod.getId_producto()+"\" width=\"115\" border=\"0\" onmouseover='this.width=300;this.height=250;' onmouseout='this.width=115;this.height=100;' />"
                    + "</a>");
            out.println("</th>");
            //el carrito
           
                  out.println("<td scope='row' width=\'50%\'>"
                    + "<a href='info_producto.jsp?prodID="+prod.getId_producto()+"'>"
                    +prod.getNombre()+
                    "</a>"
                    + "<br/>" 
                    + "<a href='info_producto.jsp?prodID="+prod.getId_producto()+"'>"
                    + "<img alt='carrito' src='/Perfum/images/carrito_compras.PNG' border='0' width='31' heigth='27' >"
                    + "</a>"
                    + "</td>"              
                    +"</tr>");
         
           
        }
        }catch(java.sql.SQLException e){
        %>
        <h1><%
            out.println("Exception: "+e.getMessage());
        %></h1>
        <%}%>
        </table>
                             
			<!-- end #about -->
			
		</div>
		<!-- end #content -->

		<div style="clear: both; height: 20px;">&nbsp;</div>
	</div>
	<!-- end #page -->
</div>
<!-- end #bg -->

<div id="footer">
	<hr />
	<p>
            <a href="http://jigsaw.w3.org/css-validator/check/referer">
            <img style="border:0;width:88px;height:31px"
            src="http://jigsaw.w3.org/css-validator/images/vcss"
            alt="¡CSS Válido!" />
            </a>
        </p>
        <p>	Copyright (c).Todos los derechos reservados. Diseñado por Grupo Java.</p>
</div>

<div style="font-size: 0.8em; text-align: center; margin-top: 1.0em; margin-bottom: 1.0em;">

</div>
</body>
</html>