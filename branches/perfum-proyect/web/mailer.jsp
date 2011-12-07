<%-- 
    Document   : mailer
    Created on : 13/09/2010, 21:40:54
    Author     : Noelia S Franco
--%>

<%@ page errorPage="errorPage.jsp" contentType="text/html" pageEncoding="UTF-8"%>

<html>
     <jsp:include page="new_header.jsp?linkAct=liWho&title=Le Pefum Contacto"/>
<head>
	
</head>
<body>
	<div class="frame">
	<jsp:useBean id="mailer" class="perfum.util.Mailer">
		<jsp:setProperty name="mailer" property="*"/>
		<% mailer.sendMail(); %>
	</jsp:useBean>
         
	<div align="center">
<table width="407" border="0" cellpadding="0" cellspacing="0" class="marco">
									  <tr>
										<td width="401" class="marcoform"><table width="391" border="0" cellspacing="0" cellpadding="0">
											<tr>
											  <td width="391"><span class="tituloform">FORMULARIO DE CONTACTO </span> <br /> <br />
												<span class="tablaCopia_1">Su email ha sido enviado</span><br /><br /></td>
											</tr>
											<tr>
                                                                                            <td align="left" valign="middle">
											 	        <span id="texto">Muchas Gracias por entrar en contacto con Le Perfum, su formulario fue recibido con éxito y a la brevedad nos comunicaremos con Usted.<br /><br />
													Atentamente,<br />Le Perfum</span>
													<br /><br />



												</td>
											</tr>
										  </table></td>
									  </tr>
									</table>
        </div>
	</div>
</body>
</html>