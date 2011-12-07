<%-- 
    Document   : principal
    Created on : 06/09/2010, 15:31:25
    Author     : Noelia S Franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="prodBean" scope="request" class="perfum.negocio.Productos"/>

<html>
    <jsp:include page="new_header.jsp?linkAct=liWho&title=Le Pefum Home"/>
<div id="bg">
  
	<div id="page">
		<div id="content">
			<div id="about" class="post">
				<h1 class="title">La Empresa</h1>
				<div class="entry">
					<p><strong>Le Perfum</strong> nació en el año 1985 con el objetivo de ser la cadena de perfumerías más exclusiva de la ciudad.
                                            Luego de consolidarse en la ciudad de Rosario, Le Perfum abrió nuevas sucursales en las localidades de Córdoba, Mendoza, Salta y la ciudad de Buenos Aires.
                                            La posibilidad de encontrar las líneas de cosmética mas exclusivas y todas las fragancias del mundo son los pilares del constante crecimiento de la empresa.
                                            Sumado a detalles como el diseño exclusivo de sus locales, el servicio, la atención y las amplias facilidades de compra.
                                        </p>
				</div>
			</div>
			<!-- end #about -->
			<div class="post">
				<h2 class="title">La importancia de un buen perfume</h2>
				<div class="entry">
					<p> El impacto que causa un perfume en otros al sentirlo, refuerza la imagen que damos, porque como dijo Emilio Valeros, perfumista de Loewe, “El perfume es un medio de comunicación”.
                                            La tendencia hoy en día es tener un perfume para cada ocasión o momento del día. Aparentemente, dentro de poco la fidelidad a una sola fragancia será cosa del pasado, pues cada vez más se instaura la costumbre de tener dos o tres perfumes.
                                            Pero esa variedad está siempre determinada por un factor común: nuestra personalidad. Nuestra personalidad tiene mucho que ver con el tipo de fragancia que elegimos. Por lo regular las personas que son de una manera específica tienden a elegir cierto tipo de aroma</p>
					<ul>
                                            <li><p>Historia del Perfume: <a href='http://www.fmgroup.com.ar'>http://www.fmgroup.com.ar </a> </p></li>
					    <li><p>Perfumes según personalidades: <a href='http://www.estilohoy.com'>http://www.fmgroup.com.ar </a> </p></li>
				            <li><p>Top ten de perfumes: <a href='http://www.perfumesba.com.ar'>http://www.perfumesba.com.ar</a></p></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<div id="useful-links" class="box">
				<h2 class="title">Destacados de mujer</h2>
				<div class="content">
                                    <% for(perfum.Producto prod: prodBean.getRanking()){
						out.println("<li"+"<a href='info_producto.jsp?prodID="+prod.getId_producto()+"'>"+prod.getNombre());
						
					}%>
				</div>
			</div>
			<!-- end #useful-links -->
			<div id="sponsors" class="box">
				<h2 class="title">Only for men's</h2>
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