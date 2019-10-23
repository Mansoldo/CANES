<%-- 
    Document   : venda
    Created on : 11/10/2019, 22:06:37
    Author     : beatriz.silva19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Venda</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>

    <body>
        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades" />
                <h1>Tades</h1>
            </div>
            <div class="menu__usuario"></div>
        </header>
        <nav class="menu">
            <div><a href="menu-principal.html">Menu Principal</a></div>
            <div><a href="venda.html">Venda</a></div>
            <div><a href="#">Cliente</a></div>
            <div><a href="#">Funcionario</a></div>
            <div><a href="#">Produto</a></div>
            <div><a href="#">Relatório</a></div>
        </nav>

        <div class="container">
            <h2>Venda</h2>
            <hr />
            <div class="linha">
                <div class="coluna">
                    <div class="pesquisa">
                        <input
                            type="text"
                            class="txt__pesquisa"
                            placeholder="Pesquisar Cliente"
                            />
                        <img
                            src="${pageContext.request.contextPath}/img/search.svg"
                            class="btn__pesquisa"
                            alt="Pesquisar"
                            />
                    </div>
                </div>
                <div class="coluna">
                    <input type="button" value="Pesquisar" class="btn" />
                </div>
            </div>

            <div class="linha">
                <div class="coluna">
                    <div class="pesquisa">
                        <input
                            type="text"
                            class="txt__pesquisa"
                            placeholder="Pesquisar Produto"
                            />
                        <img
                            src="${pageContext.request.contextPath}/img/search.svg"
                            class="btn__pesquisa"
                            alt="Pesquisar"
                            />
                    </div>
                </div>
                <div class="coluna">
                    <input type="button" value="Pesquisar" class="btn" />
                </div>
            </div>
        </div>

        <div class="coluna">
            <div class="linha">
                <label for="subtotal">Subtotal:</label>
                <label for="total">Total:</label>
            </div>
        </div>

    </div>
</body>
</html>
