<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
	  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	  	<title>Formulário de Bairros</title>

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
						<legend>Lista de Bairros:</legend>
						<form id="consultarBairro" method="post" action="ServletBairros">
							<input type="hidden" name="action" value="consultarBairro" />
			    			<select name="id">
			    				<option value="">- Selecione um Bairro -</option>
			    				<c:forEach var="bairro" items="${listaBairros}">
			    					<option value="${bairro.id}">${bairro.nome}</option>
			    				</c:forEach>
			    			</select>
			    		</form>
					<button class="button" type="submit" form="consultarBairro" value="Submit">Escolher</button>
		    		</fieldset>    		
	   			</c:if>

				<form id="form_bairro" action="ServletBairros" method="post">
					<fieldset class="input_style">
						<input type="hidden" name="action" value="${action}" />

						<legend>Informações do Bairro:</legend>
							
						<input type="hidden" name="id" value="${bairro.id}">	

						<label>Bairro:</label>
						<input type="text" name="bairro" size="50" value="${bairro.nome}" maxlength="50" placeholder="Nome do bairro" required>
					</fieldset>
				</form>

		  		<div class="button-box">
					<button class="button" type="submit" form="form_bairro" value="Submit">Salvar</button>
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
