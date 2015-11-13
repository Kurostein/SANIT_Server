<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
	  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	  	<title>Formulário de Fiscais</title>

		<link rel="stylesheet" href="css/border.css">
	  	<link rel="stylesheet" href="css/page-layout.css">
	  	<link rel="stylesheet" href="css/buttons.css">
	  	<link rel="stylesheet" href="css/style.css">
	  	<script type="text/javascript" src="js/searchFunction.js"></script>
    	<script type="text/javascript" src="js/redirectFunction.js"></script>
    </head>

    <body>
		<div id="body">
		
			<div>
				<header class="cabecalho">
					<img src="imagens/oie_transparent(3).png" alt="SANIT Logo">
				</header>
			</div>

			<div class="fieldset">
				<c:if test="${responseMessage != null}">
					<form class="input_style center">
						<input type="text" name="responseMessage" value="${responseMessage}" disabled/>
						<br><br>
			    	</form>
	   			</c:if>

				<c:if test="${action == 'atualizar'}">
					<fieldset>
						<legend>Lista de Fiscais:</legend>
						<form id="consultarFiscal" method="post" action="ServletFiscal">
							<input type="hidden" name="action" value="consultarFiscal" />
			    			<select name="matricula">
			    				<option value="">- Selecione um Fiscal -</option>
			    				<c:forEach var="fiscal" items="${listaFiscais}">
			    					<option value="${fiscal.matricula}">${fiscal.matricula} - ${fiscal.nome}</option>
			    				</c:forEach>
			    			</select>
			    		</form>
					<button class="button" type="submit" form="consultarFiscal" value="Submit">Escolher</button>
		    		</fieldset>    		
	   			</c:if>

				<form id="form_fiscal" action="ServletFiscal" method="post">
					<fieldset class="input_style">
						<input type="hidden" name="action" value="${action}" />

						<legend>Informações do Fiscal:</legend>
							
						<label>Nome:</label>
						<input type="text" name="nome" size="50" value="${fiscal.nome}" maxlength="50" placeholder="Nome do fiscal" required>
						<br><br>
						<label>CPF:</label>
						<input type="text" name="cpf" value="${fiscal.cpf}" maxlength="11" placeholder="Apenas os números do CPF" required>
						<br><br>

						<c:if test="${action == 'atualizar'}">
							<label>Matrícula:</label>
							<input class="inputReadOnly" type="number" name="matricula" value="${fiscal.matricula}" placeholder="Número da matrícula" readonly>
	   					</c:if>

						<c:if test="${action == 'inserir'}">
							<label>Matrícula:</label>
							<input type="number" name="matricula" value="${fiscal.matricula}" placeholder="Número da matrícula" required>
	   					</c:if>

						<br><br>
						<label>Senha:</label>
						<input type="text" name="senha" value="${fiscal.senha}" placeholder="Senha de acesso">
					</fieldset>
				</form>

		  		<div class="button-box">
					<button class="button" type="submit" form="form_fiscal" value="Submit">Salvar</button>
					<button class="button" type="button" value="redirect" onClick="redirectMenu()">Voltar ao Menu</button>  
				</div>
			</div>

			<div class="footer">
				<footer>
					<h3>Programação Orientada a Objetos II.</h3>
					<p>Projeto de vendas para avaliação do curso.</p>
				</footer>
			</div>	
	  </div>

    </body>

</html>
