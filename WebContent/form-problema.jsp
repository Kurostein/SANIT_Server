<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
	  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	  	<title>Formulário de Problemas</title>

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
						<legend>Lista de Problemas:</legend>
						<form id="consultarProblema" method="post" action="ServletProblemas">
							<input type="hidden" name="action" value="consultarProblema" />
			    			<select name="id">
			    				<option value="">- Selecione um Problema -</option>
			    				<c:forEach var="problema" items="${listaProblemas}">
			    					<option value="${problema.id}">${problema.problema}</option>
			    				</c:forEach>
			    			</select>
			    		</form>
					<button class="button" type="submit" form="consultarProblema" value="Submit">Escolher</button>
		    		</fieldset>    		
	   			</c:if>

				<form id="form_problema" action="ServletProblemas" method="post">
					<fieldset class="input_style">
						<input type="hidden" name="action" value="${action}" />

						<legend>Informações do Problema:</legend>
							
						<input type="hidden" name="id" value="${problema.id}">	

						<label >Problema:</label>
						<input type="text" name="problema" size="50" value="${problema.problema}" maxlength="50" placeholder="Tipo de problema" required>
						<br><br>
						<label >Prioridade:</label>
						<input type="number" name="prioridade" min="1" max="10" value="${problema.prioridade}" maxlength="2" placeholder="Mínima 1 e máxima 10" required>
					</fieldset>
				</form>

		  		<div class="button-box">
					<button class="button" type="submit" form="form_problema" value="Submit">Salvar</button>
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
