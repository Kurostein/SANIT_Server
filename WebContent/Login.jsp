<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="css/style.css">
   <link rel="stylesheet" href="css/buttons.css">

  <title>Login Gestor</title>

  <script type="text/javascript" src="js/scripts.js"></script>
</head>

<body>
  <div>
      <figure class="imagem1">
      	<img src="imagens/oie_transparent(1).png" class="terra">
      </figure>
  </div>

  <div>
    	<figure class="imagem2">
    		<img src="imagens/oie_transparent.png" class="icone">
    	</figure>
 </div>

  <div class="cabecalho">
       <img src="imagens/oie_transparent(3).png">
  </div>

     <div class="UserKey">
        <c:if test="${responseMessage != null}">
          <form class="input_style center">
            <input type="text" name="responseMessage" value="${responseMessage}" size="30" disabled/>
            <br><br>
            </form>
          </c:if>

        <form id="login"  action="ServletLogin" method="post">
           <input type="hidden" name="action" value="login"/>
            Matrícula:<br/>
            <input id="usuario" type="number" class="nome" name="matricula" placeholder=" Matrícula" autofocos><br/>
            Senha:<br/>
            <input id="senha" type="password" class="senha" name="senha" placeholder=" Senha"><br/>

            <button class="button" type="button" onClick="validarLogin()">Login</button> 
        </form>
   </div>
</body>
</html>