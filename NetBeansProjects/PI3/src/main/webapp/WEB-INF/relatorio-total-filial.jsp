<%-- 
    Document   : relatorio-total-filial
    Created on : 11/10/2019, 22:11:47
    Author     : Beatriz da Silva
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Top por Filial</title>
        <link
            rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <script>
            if (${naoAutorizado} === true) {
                alert('Não tem acesso para pesquisar esta filial!');
            }
        </script>
        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades" />
                <h1>Tades</h1>
            </div>
            <div class="user-menu">${sessionScope.usuarioLogado.nome_func}
                <div class="user-menu-content">
                    <form method="get" action="${pageContext.request.contextPath}/AlterarSenha" novalidate>
                        <button type="submit" name="BtnCancel" class="botoes">Alterar senha</button>
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/Logout" novalidate>
                        <button type="submit" name="BtnCancel" class="botoes">Sair</button>
                    </form>
                </div>
            </div>
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
            <div class="linha">
                <div class="coluna">
                    <h2>Total Por Filial</h2>
                </div>
            </div>
            <hr>
            <form method="post" id="totalFilial" name="total_Filial" class="form" action="${pageContext.request.contextPath}/RelatorioFilial" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <select class="campo" name="filial" id="filial">
                            <option selected value="selecione_filial">Selecione a filial</option>
                            <option value="Todas">Todas Filiais</option>
                            <option value="Matriz">(SP) Matriz</option>
                            <option value="Brasilia">(DF) Brasilia</option>
                            <option value="Campina Grande">(PB) Campina Grande</option>
                            <option value="Joinville">(SC) Joinville</option>
                        </select>
                    </div>                    
                    <div class="coluna">
                        <input type="submit" value="Pesquisar" class="btn mt-0" />
                    </div>
                </div>
                <table id="tabela" class="tabela">
                    <thead>
                        <tr>
                            <th>Filial</th>
                            <th>Valor Total</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${relatorioValorTotal}" var="relatorio">
                            <tr>
                                <td id="nomeFilial"><c:out value="${relatorio.getNomeFilial()}"/></td>                                
                                <td id="valorTTotal"><c:out value="${relatorio.getValorTotal()}"/></td>                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
