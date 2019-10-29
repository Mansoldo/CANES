<%-- 
    Document   : venda
    Created on : 11/10/2019, 22:06:37
    Author     : Beatriz da Silva
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

        <div class="container">
            <h2>Venda</h2>
            <hr />
            <div class="linha">
                <div class="coluna">
                    <div class="pesquisa">
                        <input type="text" placeholder="Pesquisar Produto" class="txt__pesquisa" />
                        <img src="${pageContext.request.contextPath}/img/search.svg" alt="Pesquisar Produto" class="btn__pesquisa" />
                    </div>
                </div>
                <div class="coluna">
                    <input type="button" value="Pesquisar" class="btn  mt-0 ml-15" />
                </div>
                <div class="coluna">
                    <div class="pesquisa">
                        <input type="text" placeholder="Digite o CPF" class="txt__pesquisa" />
                        <img src="${pageContext.request.contextPath}/img/search.svg" alt="Pesquisar Cliente" class="btn__pesquisa" />
                    </div>
                </div>
                <div class="coluna">
                    <input type="button" value="Pesquisar" class="btn mt-0 ml-15" />
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
                                <td id="IDtable"><c:out value="${produto.getID()}" /></td>
                                <td id="nameTable"><c:out value="${produto.getNomeProduto()}" /></td>
                                <td id="estoqueTable"><c:out value="${produto.getQuantidade()}" /></td>
                                <td id="valorUnitarioTable"><c:out value="${produto.getValorUnitario()}" /></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <form method="post" action="${pageContext.request.contextPath}/" novalidate>
                        <input type="text" name="produto__selecionado" class="" />
                        <input type="text" name="quantidade__produto__selecionado" placeholder="Quantidade"class="" />                    
                        <input type="input" value="Adicionar" class="btn" />
                    </form>

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
                        <c:forEach items="${produtoAtt}" var="produto">
                            <!-- Revisar -->
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
            </div>
                            
            <div class="linha">
                <form id="finalizar__venda" name="finalizar__venda" class="finalizar__venda" method="post" action="${pageContext.request.contextPath}/" novalidate>                
                    <input type="submit" value="Finalizar" class="btn btn-salvar" />
                </form>
                <form method="post" action="${pageContext.request.contextPath}/venda" novalidate>
                    <input type="submit" value="Cancelar" class="btn btn-cancelar" />
                </form>
            </div>
                    
        </div>
    </body>
</html>
