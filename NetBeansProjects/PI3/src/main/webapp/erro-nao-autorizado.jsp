<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Não autorizado</title>
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
        <div class="container__erro">        
            <h1>ERRO: Acesso não autorizado</h1>
            <form method="post" action="${pageContext.request.contextPath}/Login" novalidate>
                <input type="submit" value="Voltar" class="btn">
            </form>
        </div>
    </body>
</html>
