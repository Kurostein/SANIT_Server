<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	  	<title>Consultas</title>

	  	<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/border.css">
	  	<link rel="stylesheet" href="css/page-layout.css">
	  	<link rel="stylesheet" href="css/buttons.css">
	  	<script type="text/javascript" src="js/consulta.js"></script>
    	<script type="text/javascript" src="js/redirectFunction.js"></script>
    </head>

    <body>
		<div id="body">
		
			<div>
				<header class="cabecalho">
					<img src="imagens/oie_transparent(3).png" alt="SANIT Logo">
				</header>
			</div>
			<div class="menuConsultas">
				<ul class="ulConsultas">
					<li><a href="#" onclick="todasOcorrencias()">TODAS AS OCORRENCIAS</a></li>
					<li><a href="#" onclick="ocorrenciaBairro()">OCORRENCIAS POR BAIRRO</a></li>
					<li><a href="#" onclick="ocorrenciaProblema()">OCORRENCIAS POR TIPO PROBLEMA</a></li>
					<li><a href="#" onclick="numeroProblema()">NUMERO OCORRENCIA POR PROBLEMA</a></li>
					<li><a href="#" onclick="numeroBairro()">NUMERO OCORRENCIA POR BAIRRO</a></li>
				</ul>
			</div>
			<div id="tabela">
			</div>
			<div>
		  		<div class="button-box">
					<button class="button" type="button" value="redirect" onClick="redirectMenu()">Voltar ao Menu</button>  
				</div>
			</div>

			<div class="footer">
				<footer>
					<h3>Projeto SANIT</h3>
					<p>Lorencity</p>
				</footer>
			</div>	
	  </div>

    </body>
</html>