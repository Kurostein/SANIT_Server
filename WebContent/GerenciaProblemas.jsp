<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cadastro.css">
<title>Gerencia de problemas</title>
</head>
<body>
<div class="cabecalho">
	<img src="imagens/oie_transparent(3).png">
</div>
<div  class="menu">
	<ul id="visualizacao" class="listaInicio">
	    <li><a href="http://localhost:8080/AndroidWeb/Inicio.jsp">INICIO</a></li>
		<li><a href="http://localhost:8080/AndroidWeb/Cadastro.jsp">CADASTRAR PROBLEMA</a></li>
		<li><a href="http://localhost:8080/AndroidWeb/Login.jsp">SAIR</a></li>
	</ul>
	
<table class="tabela" border="1">
            <thead>
                <tr>
                    <th>tipo de problema</th>
                    <th>prioridade</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" begin="1" end="5" step="1" varStatus ="row">
                    <tr>
                        <td>
                            <c:out value="tipo de problema"/>
                        </td>
                        <td>
                            <c:out value="0" />
                        </td>
                        <td>
                        	<input class="deletar" type="button" name="deleta" value="Deletar"/>
                        </td>
                        <td>
                        	<input class="alterar" type="button" name="altera" value="Alterar"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
</table>       
</div>
</body>
</html>