<%-- 
    Document   : menu-principal
    Created on : 11/10/2019, 22:06:14
    Author     : beatriz.silva19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Menu Principal</title>
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

        <div class="container__menu__principal">
            
            <div class="dropdown">
                <img src="${pageContext.request.contextPath}/img/venda.svg" alt="botão para tela de venda">
                <button class="dropbtn">Vender</button>
                <div class="dropdown-content">
                    <form method="get" action="${pageContext.request.contextPath}/Vender" novalidate>
                    <input type="submit" value="Vender" class="dropdown-content">
                    </form>
                </div>
            </div>
            
            <div class="dropdown">
                <img src="${pageContext.request.contextPath}/img/produto.svg" alt="botão para produtos">
                <button class="dropbtn">Produtos</button>
                <div class="dropdown-content">
                    <form method="get" action="${pageContext.request.contextPath}/ProdutoConsultar" novalidate>
                        <input type="submit" value="Pesquisar" class="dropdown-content">
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/formularioProduto" novalidate>
                        <input type="submit" value="Cadastrar" class="dropdown-content">
                    </form>
                </div>
            </div>

            <div class="dropdown">
                <img src="${pageContext.request.contextPath}/img/cliente.svg" alt="botão para clientes">
                <button class="dropbtn">Clientes</button>
                <div class="dropdown-content">
                    <form method="get" action="${pageContext.request.contextPath}/ConsultaCliente" novalidate>
                        <input type="submit" value="Pesquisar" class="dropdown-content">
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/cliente" novalidate>
                        <input type="submit" value="Cadastrar" class="dropdown-content">
                    </form>
                </div>
            </div>

            <div class="dropdown">
                <img src="${pageContext.request.contextPath}/img/funcionario.svg" alt="botão para funcionários">
                <button class="dropbtn">Funcionários</button>
                <div class="dropdown-content">
                    <form method="get" action="${pageContext.request.contextPath}/FuncionarioConsultar" novalidate>
                        <input type="submit" value="Pesquisar" class="dropdown-content">
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/formularioFuncionario" novalidate>
                        <input type="submit" value="Cadastrar" class="dropdown-content">
                    </form>
                </div>
            </div>

            <div class="dropdown">
                <img src="${pageContext.request.contextPath}/img/relatorio.svg" alt="botão para o menu de relatórios">
                <button class="dropbtn">Relatórios</button>
                <div class="dropdown-content">
                    <form method="get" action="${pageContext.request.contextPath}/RelatorioTop" novalidate>
                        <input type="submit" value="Produtos mais Vendidos" class="dropdown-content">
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/RelatorioFilial" novalidate>
                        <input type="submit" value="Total por Filial" class="dropdown-content">
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/RelatorioPercentual" novalidate>
                        <input type="submit" value="Percentual por Filial" class="dropdown-content">
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>