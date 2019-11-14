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
        </header>

        <div class="container__centralizado">
            <h2>CANES - 2019</h2>
            <p>Esse projeto foi desenvolvido pelos alunos do 3º semestre de TADS do Centro Universitário SENAC Santo Amaro</p>
            <hr>
            <h3>Desenvolvedores</h3>
            <ul>
                <li><a href="https://github.com/beatrizdasilva" target="_blank">Beatriz da Silva</a></li>
                <li><a href="https://github.com/Mansoldo" target="_blank">Diego Mansoldo</a></li>
                <li><a href="https://github.com/lendary11" target="_blank">Everton Thiago Silva Coutinho</a></li>
                <li><a href="https://github.com/gabrielribeiroo" target="_blank">Gabriel Ribeiro Vital</a></li>
                <li><a href="https://github.com/micaelssantos" target="_blank">Micael Santos</a></li>
                <li><a href="https://github.com/Preichmann" target="_blank">Pedro Almeida</a></li>
            </ul>

            <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>
                <input type="submit" value="Voltar" class="btn">
            </form>
        </div>
    </body>
</html>
