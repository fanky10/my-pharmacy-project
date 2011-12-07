<%-- 
    Document   : carrito_compras
    Created on : 02-sep-2010, 17:08:00
    Author     : fanky
--%>

<%@page import="perfum.Presentacion"%>
<%@page import="perfum.util.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
</script>
<html>
    <html>
    <jsp:include page="/new_header.jsp"/>
<div id="bg">
	<div id="page">
		<div id="content">
                    <table>
                        <tr>
                            <th>
                                Producto
                            </th>
                            
                            <th>
                                Presentación
                                &nbsp;
                                &nbsp;
                            </th>
                            <th>
                            <th>
                            <th>
                                Cantidad
                                &nbsp;
                                &nbsp;
                            </th>
                            <th>
                                Total
                            </th>
                        </tr>
                    <%

        try{

        perfum.Cliente cliente = (perfum.Cliente) session.getAttribute(Constantes.SESSON_CLIENTE_ATTRIBUTE);
        if(cliente.getPedido().getLineas().isEmpty()){
            out.println("<h>Pedido vacío</h>");
            return;
        }

        for (perfum.LineaDePedido li : cliente.getPedido().getLineas()){
            out.println("<br>");

            out.println("<tr class='alt'>");
                out.println("<th with=\"200000\">");
                //la imagen del producto
               
                out.println("<img src=\"/Perfum/display_img.jsp?imgID="+li.getProducto().getId_producto()+"\" width=\"115\" id=\"im\" border=\"0\"/>");
                out.println("<th with=\"200000\">");
                //presentacion + cantidad
                
                
                out.println(li.getPresentacion().getDescripcion());
                
                 //out.println("<th with=\"300000\">");
                //cantidad

                out.println("<td>");
                out.println("<th with=\"500000\">");
              
                out.println("<th with=\"500000\">"+li.getCantidad());

                out.println("</th>");
                out.println("<th with=\"500000\">"+li.getMonto());
             
                out.println("</th>");
                out.println("</td>");
            out.println("</tr>");
            
        }
        
        //out.println("cliente con n: "+cli.getPedido().getLineas().size()+" lineas de pedido");
        //out.println ("Cliente con n:" + cliente.getPedido().getLineas().size() + "Lineas de pedido");




        }catch(Exception e){
        %>
        <h1><%
            out.println("Exception: "+e.getMessage());
        %></h1>
        <%}%>
        </table>
        <br/>
        <br>
        <br>
        <div id="titulo">
        <p id="tit"><a href="/Perfum/EnviarMailPedido">Enviar Pedido</a></p>
        <p id="tit"><a href="/Perfum/product_list.jsp">Productos</a></p>
         
        </div>
                           
		</div>
                       			</div>
			<!-- end #about -->
                        <img name="defaultimage" src="'+randomimages[Math.floor(Math.random()*(randomimages.length))]+'">
		</div>
		<!-- end #content -->
		<div style="clear: both; height: 20px;">&nbsp;</div>

<!-- end #bg -->
<div id="footer">
	<hr />
	<p>	Copyright (c).Todos los derechos reservados. Diseñado por Grupo Java.</p>
</div>

<div style="font-size: 0.8em; text-align: center; margin-top: 1.0em; margin-bottom: 1.0em;">

</div>
</body>
<script language="javascript">

var delay=3000 
var curindex=0

var randomimages=new Array()

	randomimages[0]="/Perfum/images/CH.jpg"
	randomimages[1]="/Perfum/images/Dior.jpg"
	randomimages[2]="/Perfum/images/Givenchy.jpg"
        randomimages[3]="/Perfum/images/Revolution.jpg"
        randomimages[4]="/Perfum/images/absinto.jpg"
        randomimages[5]="/Perfum/images/cancan.jpg"
        randomimages[6]="/Perfum/images/chanel.jpg"
        randomimages[7]="/Perfum/images/paco.jpg"

var preload=new Array()

for (n=0;n<randomimages.length;n++)
{
	preload[n]=new Image()
	preload[n].src=randomimages[n]
}



function rotateimage()
{

if (curindex==(tempindex=Math.floor(Math.random()*(randomimages.length)))){
curindex=curindex==0? 1 : curindex-1
}
else
curindex=tempindex

	document.images.defaultimage.src=randomimages[curindex]
}

setInterval("rotateimage()",delay)

          </script>
</html>
