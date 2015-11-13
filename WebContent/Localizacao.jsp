<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css">
	<title>Localização</title>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script type="text/javascript" src="js/Chart.js"></script>
	<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
</head>
<body>
<div class="cabecalho">
	<img src="imagens/oie_transparent(3).png">
</div>
<div  class="menu">
	<ul id="visualizacao" class="listaInicio">
		<li><a href="http://localhost:8080/SANIT/Inicio.jsp">INICIO</a></li>
		<li><a href="http://localhost:8080/SANIT/Login.jsp">SAIR</a></li>
	</ul>
</div>
<div class="opcoesPesquisa">
	<form action="#">
		<label for="opcoes">Selecione dentre as opções disponiveis:</label><br/>
		  <input type="radio" name="opc" value="tipo de problema">Tipo de problema<br/>
		  <input type="radio" name="opc" value="bairro">Bairro<br/>
		<label for="escolha1">Opções de refinamento da pesquisa</label><br/>  
		<select>
			<option value="">#</option>
		</select><br/>  		  
		<select id="escolhaTipoGrafico" onchange="escolherGrafico()">
			<option value="Barra">Barra</option>
			<option value="Linha">Linha</option>
		</select>
	</form>
</div>
<div class="grafico">
	<canvas id="grafico1" class="grafico2d" width="600px" height="400px"></canvas>
</div>
<div id="map" class="mapa">
</div>
</body>
</html>