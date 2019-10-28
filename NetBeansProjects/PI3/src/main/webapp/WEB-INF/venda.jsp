<%-- 
    Document   : venda
    Created on : 11/10/2019, 22:06:37
    Author     : Beatriz Silva
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
                    <input type="button" value="Pesquisar" class="btn mt-0 ml-15" />
                </div>

                <table id="tabelaVenda" class="tabela">
                    <thead>
                        <tr>
                            <th>Produto</th>
                            <th>Quantidade</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${produtoAtt}" var="produto">
                        <tr>
                            <td id="IDtable"><c:out value="${produto.getID()}" /></td>
                            <td id="nameTable"><c:out value="${produto.getNomeProduto()}" /></td>
                            <td id="quantidadeTable"><c:out value="${produto.getQuantidade()}" /></td>
                            <td id="valorTable"><c:out value="${produto.getValorUnitario()}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

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
                    <input type="button" value="Pesquisar" class="btn  mt-0 ml-15" />
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
