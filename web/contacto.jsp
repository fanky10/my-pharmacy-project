<%-- 
    Document   : newjsp
    Created on : 13/09/2010, 23:34:06
    Author     : Noelia S Franco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <jsp:include page="new_header.jsp?linkAct=liCon&title=Le Pefum Contacto"/>
    <head>
	<script type="text/JavaScript">
<!--
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_validateForm() { //v4.0
  var i,p,q,nm,test,num,min,max,errors='',args=MM_validateForm.arguments;
  for (i=0; i<(args.length-2); i+=3) { test=args[i+2]; val=MM_findObj(args[i]);
    if (val) { nm=val.name; if ((val=val.value)!="") {
      if (test.indexOf('isEmail')!=-1) { p=val.indexOf('@');
        if (p<1 || p==(val.length-1)) errors+='- '+nm+' debe contener un formato de mail válido.\n';
      } else if (test!='R') { num = parseFloat(val);
        if (isNaN(val)) errors+='- '+nm+' debe contener un número.\n';
        if (test.indexOf('inRange') != -1) { p=test.indexOf(':');
          min=test.substring(8,p); max=test.substring(p+1);
          if (num<min || max<num) errors+='- '+nm+' debe contener un número entre '+min+' y '+max+'.\n';
    } } } else if (test.charAt(0) == 'R') errors += '- '+nm+' es requerido.\n'; }
  } if (errors) alert('Errores ocurridos:\n'+errors);
  document.MM_returnValue = (errors == '');
}
//-->
</script>
</head>
<link href="style/screen.css" rel="stylesheet" type="text/css" media="screen" />
<body>
    <div id="page">
<div id="content">
    <div id="about" class="post">

        <div class="entry">
                <form action="mailer.jsp" method="post" onsubmit="MM_validateForm('subject','','RisEmail','message','','R');return document.MM_returnValue">
	<!--Para :<br>
	<input type="text" name="to" class="std"></input><br>
	De :<br>
	<input type="text" name="from" class="std"></input><br>
 -->
	Ingrese su email :<br/>
	<input type="text" name="subject" class="std"/><br/>
	Mensaje :<br/>
	<textarea rows="10" cols="80" name="message"></textarea>
	<br>
        <input type="submit" value="Enviar" id="boton"/>
	</form>
                </div>
        </div>
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
</div>
        
    </div>
     
</body>
</html>
