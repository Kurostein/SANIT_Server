<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css">
	<title>Inicio</title>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script type="text/javascript" src="js/redirectFunction.js"></script>
</head>
<body>
<div class="cabecalho">
	<img src="imagens/oie_transparent(3).png">
</div>
<div  class="menu">
	<ul id="visualizacao" class="listaInicio">
		<li>
					<form id="pagAtualizarProblema" method="post" action="ServletProblemas">
						<input type="hidden" name="pagSelecionada" value="pagAtualizar" />
					</form>	
					<a href="#" onClick="redirectAtualizarProblema()">Atualizar Problema</a>
		</li>
		<li><a>LOCALIZAÇÃO E ESTATÍSTICAS</a></li>
		<li><a>GERENCIA DE FISCAIS</a></li>
		<li><a onclick="Logout()">SAIR</a></li>
	</ul>
</div>
</body>
</html>