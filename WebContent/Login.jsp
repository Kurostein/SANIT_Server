<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="css/style.css">
<title>LOGIN FISCAL</title>
<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
<div>
  <figure class="imagem1">
  	<img src="imagens/oie_transparent(1).png" class="terra">
  </figure>
</div>
<div>
	<figure class="imagem2">
		<img src="imagens/oie_transparent.png" class="icone">
	</figure>
</div>
<div class="cabecalho">
 <img src="imagens/oie_transparent(3).png">
</div>
 <div class="UserKey">
  <form id="login"  action="ServletLogin" method="post">
   <input type="hidden" name="action" value="login"/>
    Usuario:<br/>
    <input id="usuario" type="text" class="nome" name="usuario" placeholder="Usuário" autofocos><br/>
    Senha:<br/>
    <input id="senha" type="password" class="senha" name="senha" placeholder="Senha"><br/>
    <input id="botao" type="button" name="login" value="Login" onClick="validarLogin()"/>
  </form>
 </div>
</body>
</html>