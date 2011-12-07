<%-- 
    Document   : login
    Created on : 09/09/2010, 15:13:49
    Author     : Noelia S Franco
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="perfum.util.Constantes"%>
<%@page import="logging.Debugger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <script type="text/javascript" src="/Perfum/javascript/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="/Perfum/javascript/js_valida.js" ></script>
    <jsp:include page="new_header.jsp"/>
<div id="bg">

	<div id="page">
		<div id="content">

			<!-- end #about -->
			<div class="post">
			<h1 align="center">Usted necesita estar logueado para acceder a esta página</h1>
        <form action="/Perfum/CheckLogin" method="POST" align="center" onsubmit="return testData();">
            
            <table class="tbl-contacto" align="left">
              
                <tr>
                     <td> Username  : </td><td> <input id="user" name="username" size=15 type="text"/> </td>
                </tr>
                <tr>
                    <td> Password  : </td><td> <input id="pass" type="password" name="password" size=15 type="text" /> </td>
                </tr>

                <tr>
                    
                    <td style="text-align: left">
                        <input type="submit" value="login" id="boton"/>
                    </td>
                    <td><div id="result" align="center"></div></td>
                </tr>
            </table>

                        

            
           
        </form>
			</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<div id="useful-links" class="box">

			</div>
			<!-- end #useful-links -->
			<div id="sponsors" class="box">
				


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