<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/cadastro.css">
	<title>Cadastro problema</title>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
<div class="cabecalho">
	<img src="imagens/oie_transparent(3).png">
</div>

<div class="formulario">
<form action="#" method="post">
   <div class="campo1">
      <label class="problema" for="Problema">Problema:</label>
      <input type="text" id="problema" name="problema"/>
   </div>
   <div class="campo2">
      <label class="codigo" for="Codigo">Prioridade:</label>
        <input type="text" id="codigo" name="codigo"/>
   </div>
   <input class="botao1" type="button" name="submit" value="Enviar"/>
   <input class="botao2" type="button" name="voltar" value="Voltar"/>
</form>
</div>
</body>
</html>