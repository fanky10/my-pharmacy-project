<%--
    Document   : MyPrivate
    Created on : 13/06/2010, 20:52:41
    Author     : Hp
--%>
<%@page import="perfum.util.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
</script>
<html>
    <html>
    <jsp:include page="/new_header.jsp?linkAct=liCta&title=Tu Cuenta en Le Pefum"/>

   <div id="bg">
	<div id="page">

		<div id="content">
                            <h1 id="title">Productos adquiridos</h1>
                    <table class="tbl-compras" align="left" cellspacing="25px">
                        <tr>
                            <th>
                                Producto
                            </th>

                            <th>
                                Nro Pedido
                                &nbsp;
                                &nbsp;
                                 &nbsp;
                                 &nbsp;

                            </th>
                            <th>


                                Presentación

                            </th>
                            <th>
                                 <th>
                                Cantidad
                            </th>
                        </tr>


        <%

        try{

            perfum.Cliente cliente = (perfum.Cliente) session.getAttribute(Constantes.SESSON_CLIENTE_ATTRIBUTE);
            perfum.negocio.Pedidos pe = new perfum.negocio.Pedidos();

            for(perfum.Pedido i: pe.getPedidos(cliente)){


            for(perfum.LineaDePedido l:i.getLineas())
                {out.println("<br>");

            out.println("<tr class='alt'>");

                out.println("<th with=\"200000\">");
                //la imagen del producto

                out.println("<img src=\"/Perfum/display_img.jsp?imgID="+l.getProducto().getId_producto()+"\" width=\"115\" id=\"im\" border=\"0\"/>");
                out.println("<th with=\"200000\">");
                //presentacion + cantidad


                 out.println(i.getId_pedido());
                 out.println("<td>");

                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");


                out.println(l.getPresentacion().getDescripcion());

                out.println("<th with=\"500000\">");

                out.println("<th with=\"500000\">"+l.getCantidad());

                out.println("</th>");


                out.println("</th>");
                out.println("</td>");

            out.println("</tr>");


                }
            }
            }






        catch(Exception e){
        %>
        <h1><%
            out.println("Exception: "+e.getMessage());
        %></h1>
        <%}%>
           </table>
        </div>

        <div align="center">
            <br>
        <a href="/Perfum/Logout">Cerrar Sesión</a>
        </div>


		</div>
		<img name="defaultimage" src="'+randomimages[Math.floor(Math.random()*(randomimages.length))]+'">
   </div>
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

	randomimages[0]="/Perfum/images/deseo.jpg"
	randomimages[1]="/Perfum/images/cdior.jpg"
	randomimages[2]="/Perfum/images/kenzo.jpg"
        randomimages[3]="/Perfum/images/perfumes.jpg"
        randomimages[4]="/Perfum/images/polo.jpg"
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
