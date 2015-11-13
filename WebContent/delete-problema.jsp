<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
	  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	  	<title>Deletar Problema</title>

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

				<fieldset>
					<legend>Lista de Problemas:</legend>
					<form id="removerProblema" method="post" action="ServletProblemas">
						<input type="hidden" name="action" value="remover" />
			    		<select name="problema">
			    			<option value="">- Selecione um Problema -</option>
			    			<c:forEach var="problema" items="${listaProblemas}">
			    				<option value="${problema.problema}">${problema.problema}</option>
			    			</c:forEach>
			    		</select>
			    	</form>
					<button class="button" type="submit" form="removerProblema" value="Submit">Remover</button>
					<button class="button" type="button" value="redirect" onClick="redirectMenu()">Voltar ao Menu</button>  
		    	</fieldset>    		

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
