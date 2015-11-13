<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
	  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	  	<title>Tipos de Problemas Cadastrados</title>

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

			<div>
		    	<div class="div_size">
				<form>
					<fieldset class="field_size" readonly>
						<legend>Tipos de Problemas Cadastrados</legend>
						<table summary="Tabela de problemas cadastrados.">
							<tr>
								<th id="colProblema">Problema</th>
								<th id="colPrioridade">Prioridade</th>
							</tr>

							<c:forEach var="problema" items="${listaProblemas}">
			    				<tr>
									<td headers="colProblema">
										<p class="table_border">${problema.problema}</p>
									</td>
									<td headers="colPrioridade">
										<p class="table_border">${problema.prioridade}</p>
									</td>
								</tr>
			    			</c:forEach>
							
						</table>
					</fieldset>
				</form>
			</div>	

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
