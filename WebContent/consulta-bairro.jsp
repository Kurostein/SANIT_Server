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

			<div>
		    	<div class="div_size">
				<form>
					<fieldset class="field_size" readonly>
						<legend>Bairros Cadastrados</legend>
						<table summary="Tabela de bairros cadastrados.">
							<tr>
								<th id="colBairro">Bairro</th>
							</tr>

							<c:forEach var="bairro" items="${listaBairros}">
			    				<tr>
									<td headers="colBairro">
										<p class="table_border">${bairro.nome}</p>
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
