<%-- 
    Document   : login
    Created on : 14/10/2019, 11:41:02
    Author     : Micael Santos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Login</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>

    <body>        
        <div class="container__login">
            <div class="logo">
                <h1>Livraria</h1>   
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
                <h1>Tades</h1>
            </div>
            <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>    
                <div class="coluna">
                    <div class="container">
                        <label for="usuario">Usuário</label>
                        <input type="text" name="usuario" id="usuario" placeholder="Usuário" class="campo">
                    </div>
                    <div class="container">
                        <label for="senha">Senha</label>
                        <input type="password" name="senha" id="senha" placeholder="Senha" class="campo">
                    </div>
                    <div class="container">
                        <div class="coluna">
                            <input type="submit" name="loginBt" value="Entrar" class="btn">
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <footer>
            <a href="${pageContext.request.contextPath}/creditos">CANES</a>
            <p>2019 - Todos os direitos reservados</p>
        </footer>
    </body>
</html>
