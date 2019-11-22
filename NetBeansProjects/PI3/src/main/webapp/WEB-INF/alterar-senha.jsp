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
        if (${ senhaAlteradaAtt } === true) {
            alert('Senha alterada com sucesso!');
        } else {
            alert('Senha atual incorreta!');
        }
    </script>

    <body>
        <header class="header">
                <div class="logo">
                    <h1>Livraria</h1>
                    <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades" />
                    <h1>Tades</h1>
                </div>
                <div class="user-menu">${sessionScope.usuarioLogado.nome_func}
                    <div class="user-menu-content">
                        <form method="get" action="${pageContext.request.contextPath}/Logout" novalidate>
                            <button type="submit" name="BtnCancel" class="botoes">Sair</button>
                        </form>
                    </div>
                </div>
            </header>

        <div class="container__alterar__senha">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
                <h1>Tades</h1>
            </div>

            <form method="post" action="${pageContext.request.contextPath}/AlterarSenha" novalidate>
                <div class="coluna">
                    <input type="hidden" value="${sessionScope.usuarioLogado.id_func}" name="id_Func" id="id_Func" />
                    <label for="senha__atual" class="label__login">Senha Atual</label>
                    <div class="container__alterar">
                        <input type="password" name="senha_atual" id="senha_atual" placeholder="Senha Atual" class="campo">
                    </div>
                    
                    <label for="senha__nova" class="label__login">Nova Senha</label>
                    <div class="container__alterar">    
                        <input type="password" name="senha_nova" id="senha_nova" placeholder="Nova Senha" class="campo">
                    </div>
                    <div class="botoes__alterar">
                        <input type="submit" name="alterarBt" value="Alterar" class="btn">
            </form>
                        <form method="get" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                            <input type="submit" value="Menu Principal" class="btn">
                        </form>
                    </div>
                </div>
        </div>
    </body>
</html>