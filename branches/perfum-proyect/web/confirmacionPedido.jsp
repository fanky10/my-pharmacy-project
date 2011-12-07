<%-- 
    Document   : confirmacionPedido
    Created on : 20/09/2010, 16:24:16
    Author     : Noelia S Franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
</script>
<html>
    <jsp:include page="/new_header.jsp"/>
<div id="bg">
	<div id="page">
          
		<div id="content">
                     <h1 id="pedido">Usted ha confirmado el siguiente pedido: </h1>
                   
                    <%

        

        if ( request.getParameter("pedidoID") != null ){

            int id_pedido = Integer.parseInt(request.getParameter("pedidoID"));
            try{
                
                perfum.Pedido pedido = new perfum.negocio.Pedidos().getPedido(id_pedido);
                if(pedido.getLineas().isEmpty()){
                    out.println("<h1 align=\"center\">El pedido se encuentra actualmente vacío</h1>");
                }else{
                    %>
                    <table>
                         <tr>
                            <th>
                                Producto
                                &nbsp;
                                &nbsp;
                                &nbsp;
                            </th>
                            &nbsp;
                            <th>
                            <th>
                            
                                  Presentación
                                  &nbsp;
                            
                            </th>
                            <th>
                                Cantidad
                                &nbsp;
                                &nbsp;
                            </th>
                            <th>
                                Total
                            </th>
                        </tr>
                        </table>
                    <%
                    for (perfum.LineaDePedido li : pedido.getLineas()){
             out.println("&nbsp");
            out.println(li.getProducto().getNombre());
            out.println("&nbsp");
            out.println("&nbsp");
            out.println("&nbsp");
            out.println("&nbsp");
               
                out.println(li.getPresentacion().getDescripcion());
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");

                out.println(li.getCantidad());
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println("&nbsp");
                out.println(li.getMonto());
                out.println("<br>");
                out.println("<br>");
                out.println("<br>");
                out.println("<br>");
                out.println("<img alt="+li.getProducto().getNombre()+"\" src=\"display_img.jsp?imgID="+li.getProducto().getId_producto()+"\" width=\"300\" border=\"0\" />"
     );
                        
                        }
                        
                }
            }catch(java.sql.SQLException e){
        %>
        <h1><%
            out.println("Exception: "+e.getMessage());
        %></h1>
        <%
            }

        
        %>
        


        

        <%
        }else{
            out.println("<h1 align=\"center\">Falta de parametros</h1>");
        }
        %>
        

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
