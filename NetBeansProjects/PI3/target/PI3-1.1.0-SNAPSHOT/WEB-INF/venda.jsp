<%-- 
    Document   : venda
    Created on : 11/10/2019, 22:06:37
    Author     : Beatriz da Silva
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="container">
            <h2>Venda</h2>
            <hr />
            <form method="post" action="${pageContext.request.contextPath}/Vender" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <div class="pesquisa">
                            <input type="text" placeholder="Pesquisar Produto" class="txt__pesquisa" name="pesquisar__produto" id="pesquisar__produto" />
                            <img src="${pageContext.request.contextPath}/img/search.svg" alt="Pesquisar Produto" class="btn__pesquisa" />
                        </div>
                    </div>
                    <div class="coluna">
                        <input type="submit" value="Pesquisar" class="btn  mt-0 ml-15" />
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <table id="tabelaPesquisaProduto" class="tabela">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <Th>Estoque</Th>
                                    <Th>Valor unitário</Th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${produtoAtt}" var="produto">
                                    <tr>
                                        <td ><c:out value="${produto.getID()}" /></td>
                                        <td ><c:out value="${produto.getNomeProduto()}" /></td>
                                        <td ><c:out value="${produto.getQuantidade()}" /></td>
                                        <td ><c:out value="${produto.getValorUnitario()}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <script>
                            var table = document.getElementById('tabelaPesquisaProduto');

                            for (var i = 1; i < table.rows.length; i++) {
                                table.rows[i].onclick = function () {
                                    document.getElementById("idProd").value = this.cells[0].innerHTML;
                                    document.getElementById("produto__selecionado").value = this.cells[1].innerHTML;
                                };
                            }
                        </script>
                    </div>
                </div>
            </form>

            <form method="get" action="${pageContext.request.contextPath}/ItemPedido" novalidate>
                <input type="hidden" value="?" id="idProd" name="idProd">
                <input type="text" name="produto__selecionado" id="produto__selecionado"/>
                <input type="number" name="quantidade__produto__selecionado" id="quantidade__produto__selecionado" autofocus value="1" min="1"/>                    
                <input type="submit" value="Adicionar" class="btn" />


                <table id="tabelaVenda" class="tabelaVenda">
                    <thead>
                        <tr>
                            <th>Qtd</th>
                            <th>Produto</th>
                            <th>Valor unitário</th>
                            <th>Valor total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtoList}" var="lista">
                            <tr>
                                <td id="nameTable"><c:out value="${lista.getQuantidade()}" /></td>
                                <td id="quantidadeTable"><c:out value="${lista.getProduto()}" /></td>
                                <td id="valorTable"><c:out value="${lista.getValor()}" /></td>
                                <td id="valorTotalTable"><c:out value="${lista.Valor_total()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type="text" value="${valorTotal}" id="Valor_Total" name="Valor_Total">
            </form>

            <div class="linha">
                <form id="finalizar__venda" name="finalizar__venda" class="finalizar__venda" method="post" action="${pageContext.request.contextPath}/FinalizarVenda" novalidate>                
                    <input type="submit" value="Finalizar" class="btn btn-salvar" />
                </form>
                <form method="get" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                    <input type="submit" value="Cancelar" class="btn btn-cancelar" />
                </form>
            </div>

        </div>
    </body>
</html>
