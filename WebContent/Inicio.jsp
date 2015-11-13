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
<header class="cabecalho">
	<img src="imagens/oie_transparent(3).png">
</header>
 <nav>	
	<ul id="visualizacao" class="listaInicio">
		<li><a>GERENCIA DE TIPOS DE PROBLEMA</a>
			<ul>
				<li>
					<form id="pagAdicionarProblemas" method="post" action="ServletProblemas">
						<input type="hidden" name="pagSelecionada" value="pagInserir" />
					</form>
					<a href="#" onClick="redirectAdicionarProblemas()">ADICIONAR</a>
				</li>
				<li>
					<form id="pagRemoverProblemas" method="post" action="ServletProblemas">
						<input type="hidden" name="pagSelecionada" value="pagRemover" />
					</form>
					<a href="#" onClick="redirectRemoverProblemas()">REMOVER</a>
				</li>
				<li>
					<form id="pagAtualizarProblemas" method="post" action="ServletProblemas">
						<input type="hidden" name="pagSelecionada" value="pagAtualizar" />
					</form>
					<a href="#" onClick="redirectAtualizarProblemas()">ATUALIZAR</a>
				</li>
				<li>
					<form id="pagConsultarProblemas" method="post" action="ServletProblemas">
						<input type="hidden" name="pagSelecionada" value="pagConsultar" />
					</form>
					<a href="#" onClick="redirectConsultarProblemas()">CONSULTAR</a>
				</li>
			</ul>
		</li>	
		<li><a>GERENCIA DE FISCAIS</a>
			<ul>
				<li>
					<form id="pagAdicionarFiscal" method="post" action="ServletFiscal">
						<input type="hidden" name="pagSelecionada" value="pagInserir" />
					</form>
					<a href="#" onClick="redirectAdicionarFiscal()">ADICIONAR</a>
				</li>
				<li>
					<form id="pagRemoverFiscal" method="post" action="ServletFiscal">
						<input type="hidden" name="pagSelecionada" value="pagRemover" />
					</form>
					<a href="#" onClick="redirectRemoverFiscal()">REMOVER</a>
				</li>
				<li>
					<form id="pagAtualizarFiscal" method="post" action="ServletFiscal">
						<input type="hidden" name="pagSelecionada" value="pagAtualizar" />
					</form>
					<a href="#" onClick="redirectAtualizarFiscal()">ATUALIZAR</a>
				</li>
				<li>
					<form id="pagConsultarFiscal" method="post" action="ServletFiscal">
						<input type="hidden" name="pagSelecionada" value="pagConsultar" />
					</form>
					<a href="#" onClick="redirectConsultarFiscal()">CONSULTAR</a>
				</li>
			</ul>
		</li>	
		<li><a>GERENCIA DE BAIRROS</a>
			<ul>
				<li>
					<form id="pagAdicionarBairros" method="post" action="ServletBairros">
						<input type="hidden" name="pagSelecionada" value="pagInserir" />
					</form>
					<a href="#" onClick="redirectAdicionarBairros()">ADICIONAR</a>
				</li>
				<li>
					<form id="pagRemoverBairros" method="post" action="ServletBairros">
						<input type="hidden" name="pagSelecionada" value="pagRemover" />
					</form>
					<a href="#" onClick="redirectRemoverBairros()">REMOVER</a>
				</li>
				<li>
					<form id="pagAtualizarBairros" method="post" action="ServletBairros">
						<input type="hidden" name="pagSelecionada" value="pagAtualizar" />
					</form>
					<a href="#" onClick="redirectAtualizarBairros()">ATUALIZAR</a>
				</li>
				<li>
					<form id="pagConsultarBairros" method="post" action="ServletBairros">
						<input type="hidden" name="pagSelecionada" value="pagConsultar" />
					</form>
					<a href="#" onClick="redirectConsultarBairros()">CONSULTAR</a>
				</li>
			</ul>
		</li>
		<li>
			<form id="pagConsultas" method="post" action="ServletGestor">
				<input type="hidden" name="pagSelecionada" value="pagConsultar" />
			</form>
			<a href="#" onClick="redirectConsultas()">CONSULTAS</a>
		</li>
		<li>
			<form id="logout" method="post" action="ServletLogin">
				<input type="hidden" name="action" value="logout" />
			</form>
			<a href="#" onClick="logout()">SAIR</a>
		</li>
	</ul>
 </nav>	

</body>
</html>