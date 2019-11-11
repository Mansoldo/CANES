<%-- 
    Document   : creditos
    Created on : Nov 11, 2019, 12:39:48 AM
    Author     : Beatriz da Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Créditos</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>

    <body>
        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
                <h1>Tades</h1>
            </div>
            <div class="menu__usuario"></div>
        </header>

        <nav class="menu">
            <form method="get" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                <input type="submit" value="Menu Principal" class="dropmenu">
            </form> 
            <form method="get" action="${pageContext.request.contextPath}/Vender" novalidate>
                <input type="submit" value="Vender" class="dropmenu">
            </form>

            <form method="get" action="${pageContext.request.contextPath}/ProdutoConsultar" novalidate>
                <input type="submit" value="Consultar Produto" class="dropmenu">
            </form>

            <form method="get" action="${pageContext.request.contextPath}/ConsultaCliente" novalidate>
                <input type="submit" value="Consultar Cliente" class="dropmenu">
            </form>

            <form method="get" action="${pageContext.request.contextPath}/FuncionarioConsultar" novalidate>
                <input type="submit" value="Consultar Funcionário" class="dropmenu">
            </form>
        </nav>

        <div class="container">
            <h1>CANES - 2019</h1>
            <p>Esse projeto foi desenvolvido pelo alunos do 3º semestre de TADS do Centro Universitário SENAC Santo Amaro</p>
            <hr>
            <h2>Desenvolvedores</h2>
            <ul>
                <li>Beatriz da Silva</li>
                <li>Diego Mansoldo</li>
                <li>Everton Coutinho</li>
                <li>Gabriel Ribeiro Vital</li>
                <li>Micael Santos</li>
                <li>Pedro </li>
            </ul>
        </div>
    </body>
</html>
