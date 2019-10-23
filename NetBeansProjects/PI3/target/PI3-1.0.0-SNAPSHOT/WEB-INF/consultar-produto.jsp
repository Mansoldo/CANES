<%-- 
    Document   : consulta-produto
    Created on : 14/10/2019, 11:40:14
    Author     : MICAEL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Consultar Produto</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <script>
            if (${ProdutoSalvoAtt} === true) {
                alert('Produto Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o Produto!');
            }
        </script>
        <script>
            if (${ProdutoAlteradoAtt} === true) {
                alert('Produto Alterado Com sucesso!');
            } else {
                alert('Falha ao Alterar o Produto!');
            }
        </script>
        <script>
            if (${produtoExcluidoAtt} === true) {
                alert('Produto Excluido Com sucesso!');
            } else {
                alert('Falha ao Excluir o Produto!');
            }
        </script>
        
        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
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
            <div class="linha">
                <h2>Consultar Produto</h2>
            </div>
            
            <hr>

            <form id="consultaProduto" name="consultaProduto" class="form" method="post" action="${pageContext.request.contextPath}/ProdutoConsultar" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <select class="campo" name="consultar" id="consultar">
                            <option selected value="selecione">Pesquisar por</option>
                            <option value="Nome">Nome</option>
                            <option value="Categoria">Categoria</option>
                            <option value="Idioma">Idioma</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <input type="text" value="" class="campo" name="pesquisar__produto"/>
                    </div>
                    <div class="coluna">
                        <input type="Submit" value="Pesquisar" class="btn" />
                    </div>
                </div>
                <table id="tabelaProduto" class="tabela">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Idioma</th>
                            <Th>Categoria</Th>
                            <Th>Quantidade</Th>
                            <Th>Valor</Th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtoAtt}" var="produto">
                            <tr>
                                <td id="IDtable"><c:out value="${produto.getID()}" /></td>
                                <td id="nameTable"><c:out value="${produto.getNomeProduto()}" /></td>
                                <td id="idiomaTable"><c:out value="${produto.getIdioma()}" /></td>
                                <td id="categoriaTable"><c:out value="${produto.getCategoria()}" /></td>
                                <td id="quantidadeTable"><c:out value="${produto.getQuantidade()}" /></td>
                                <td id="valorTable"><c:out value="${produto.getValorUnitario()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
            
            <div class="botoes">
                <form method="get" action="${pageContext.request.contextPath}/ProdutoAlterar" novalidate>
                    <input type="submit" value="Alterar" class="btn btn-salvar">
                    <input type="hidden" value="?" id="idProd" name="idProd">
                    <input type="hidden" value="?" id="categoria" name="categoria">
                    
                    <script>
                        var table = document.getElementById('tabelaProduto');
                        
                        for (var i = 1; i < table.rows.length; i++){
                            table.rows[i].onclick = function (){
                                //rIndex = this.rowIndex;
                                document.getElementById("idProd").value = this.cells[0].innerHTML;
                                document.getElementById("idProd2").value = this.cells[0].innerHTML;
                                document.getElementById("categoria").value = this.cells[3].innerHTML;
                            };
                        }
                    </script>
                </form>
                    
                <form method="post" action="${pageContext.request.contextPath}/ProdutoExcluir" novalidate>
                        <input type="submit" value="Excluir" class="btn btn-cancelar">
                        <input type="hidden" value="?" id="idProd2" name="idProd2">
                </form>
                        
                <form method="post" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                        <input type="submit" value="HOME" class="btn">
                </form>
            </div>
        </div>
    </body>
</html>
