<%-- 
    Document   : info_producto
    Created on : 09/09/2010, 11:01:09
    Author     : Noelia S Franco
<jsp:useBean id="producto" scope="request" class="perfum.negocio.Productos"/>
--%>

<%@page import="perfum.util.Constantes"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="prodBean" scope="request" class="perfum.negocio.Productos"/>

<html>
    <jsp:include page="new_header.jsp"/>
<div id="bg">
	<div id="page">
		<div id="content">
			
    <%
        if ( request.getParameter("prodID") != null ){
            
            try{
                perfum.Productos prodV = (perfum.Productos) getServletContext().getAttribute(Constantes.SERVLET_CONTEXT_PRODUCTOS_ATTRIBUTE);
            if(prodV==null){
                prodV = prodBean.getProductos();
                getServletContext().setAttribute(Constantes.SERVLET_CONTEXT_PRODUCTOS_ATTRIBUTE, prodV);
            }
            int id_producto = Integer.parseInt(request.getParameter("prodID")) ;
            perfum.Producto p = prodV.getProducto(id_producto);
    %>

    <h1 class="title">Usted está por agregar a su carrito el siguiente producto:</h1>

           <%
           
              out.println("<p>"+ p.getDescripcion()+"\"<img align='left' alt="+p.getNombre()+"\" src=\"display_img.jsp?imgID="+p.getId_producto()+"\" width=\"300\"/>");
              out.println ("<br/>");

            for(perfum.Presentacion pres : p.getPresentaciones()){
                
                out.println ("<br/>");
                    out.println(pres.getDescripcion()+" $"+pres.getPrecio());
                    if(pres.getStock() > 0)
                    {
                       out.println( "<br/>"
                        + "<a href='private/AddProducto?id_producto="+p.getId_producto()+"&id_presentacion="+pres.getId()+"'>"
                        + "<img alt='carrito' src='/Perfum/images/carrito_compras.PNG' border='0' width='31' heigth='27'>"
                        + "</a>"
                        + "</td>"
                        +"</tr>");
                    }
                    else
                    {
                        out.println( "<br/>"
                        + "<img alt='carrito' src='/Perfum/images/producto_agotado.png' border='0' width='68' heigth='69'>"
                        + "</td>"
                        +"</tr>");
                    }
                        
                }
           %>
            <%
            }catch(java.sql.SQLException e){
        %>
        <h1><%out.println("Exception 1: "+e.getMessage());%></h1>
        <%  }

            catch(perfum.exceptions.ProductoNoEncontradoException ex){
        %>
        <h1><%out.println("Exception Producto no encontrado: "+ex.getMessage());%></h1>
        <%
            }

            finally{

               }// out.close();}//fin catch
        }else{
            out.println("parametros insuficientes.. redirigiendo...");
            out.close();
        }

        
    %>

				</div>
			</div>
			<!-- end #about -->

		</div>
		<!-- end #content -->
		<div id="sidebar">
			<div id="useful-links" class="box">
				<h2 class="title">Destacados de mujer</h2>
				<div class="content">
                                  <% for(perfum.Producto p: prodBean.getRanking()){
						out.println("<li"+"<a href='info_producto.jsp?prodID="+p.getId_producto()+"'>"+p.getNombre());

					}%>
				</div>
			</div>
			<!-- end #useful-links -->
			<div id="sponsors" class="box">
				<h2 class="title">Only for men</h2>
				<div class="content">
					<ul>
						<li><a href="http://www.loultimomagazine.com/moda-masculina/mejores-perfumes-hombre-2010">Mejores del 2010</a></li>
						<li><a href="http://www.eleconomista.es/gestion-empresarial/noticias/334081/12/07/Cinco-aromas-para-hombre-las-mejores-marcas-lanzan-sus-nuevos-perfumes.html">5 Aromas para hombres </a></li>
						<li><a href="http://www.temadictos.net/6474840117-top-10-de-perfumes-masculinos">Elije tu top 10</a></li>
						<li><a href="http://www.articulo.org/articulo/2603/fragancias_para_hombre.html">Los clásicos de siempre</a></li>

					</ul>
				</div>
			</div>
			<!-- end #sponsors -->
		</div>
		<!-- end #sidebar -->
		<div style="clear: both; height: 20px;">&nbsp;</div>

<!-- end #bg -->
<div id="footer">
	<hr />
	<p>	Copyright (c).Todos los derechos reservados. Diseñado por Grupo Java.</p>
</div>

<div style="font-size: 0.8em; text-align: center; margin-top: 1.0em; margin-bottom: 1.0em;">

</div>
</body>
</html>
