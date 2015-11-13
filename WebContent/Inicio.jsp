<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/page-layout.css">
	<title>Inicio</title>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script type="text/javascript" src="js/redirectFunction.js"></script>
</head>
<body>
<div id="body">
	<header class="cabecalho">
		<img src="imagens/oie_transparent(3).png">
	</header>

	<div>
		<ul id="visualizacao">
			<li>
				<ul class="sub1">
					<li>
						<form id="pagInserirProblema" method="post" action="ServletFiscal">
							<input type="hidden" name="pagSelecionada" value="pagInserir" />
						</form>	
						<a href="#" onClick="redirectInserirProblema()">Inserir Problema</a>
					</li>
					<li>
						<form id="pagRemoverProblema" method="post" action="ServletProblemas">
							<input type="hidden" name="pagSelecionada" value="pagRemover" />
						</form>	
						<a href="#" onClick="redirectRemoverProblema()">Remover Problema</a>
					</li>
					<li>
						<form id="pagAtualizarProblema" method="post" action="ServletFiscal">
							<input type="hidden" name="pagSelecionada" value="pagAtualizar" />
						</form>	
						<a href="#" onClick="redirectAtualizarProblema()">Atualizar Problema</a>
					</li>
					<li>
						<form id="pagConsultarProblema" method="post" action="ServletProblemas">
							<input type="hidden" name="pagSelecionada" value="pagConsultar" />
						</form>	
						<a href="#" onClick="redirectConsultarProblema()">Consultar Problemas</a>
					</li>
				</ul>
			</li>
			<li><a>LOCALIZAÇÃO E ESTATÍSTICAS</a></li>
			<li><a>GERENCIA DE FISCAIS</a></li>
			<li><a onclick="Logout()">SAIR</a></li>
		</ul>
	</div>
</div>
</body>
</html>