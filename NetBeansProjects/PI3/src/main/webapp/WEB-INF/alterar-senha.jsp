<%-- 
    Document   : login
    Created on : 13/11/2019, 11:41:02
    Author     : Pedro Reichmann
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Alteração de Senha</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <script>
        if (${senhaAlteradaAtt} === true) {
            alert('Senha alterada com sucesso!');
        } else {
            alert('Senha atual incorreta!');
        }
    </script>
    <body>        
        <div class="container__alterar__senha">
            <div class="logo">
                <h1>Livraria</h1>   
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
                <h1>Tades</h1>
            </div>
            <form method="post" action="${pageContext.request.contextPath}/AlterarSenha" novalidate>    
                <div class="coluna">
                    <p>Olá ${sessionScope.usuarioLogado.nome_func}</p>
                    <p>Olá ${sessionScope.usuarioLogado.id_func}</p>
                     <input type="hidden" value="${sessionScope.usuarioLogado.id_func}" name="id_Func" id="id_Func" />
                    <div class="container">
                        <label for="senha__atual">Senha Atual</label>
                        <input type="password" name="senha_atual" id="senha_atual" placeholder="Senha Atual" class="campo">
                    </div>
                    <div class="container">
                        <label for="senha__nova">Nova Senha</label>
                        <input type="password" name="senha_nova" id="senha_nova" placeholder="Nova Senha" class="campo">
                    </div>
                    <div class="container">
                        <div class="coluna">
                            <input type="submit" name="alterarBt" value="Alterar" class="btn">
                            </form>
                            <form method="get" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                                <input type="submit" value="Menu Principal" class="btn">
                            </form> 
                        </div>
                    </div>
                </div>

        </div>
    </body>
</html>
