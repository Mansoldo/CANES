<%-- 
    Document   : consulta-funcionario
    Created on : 14/10/2019, 11:39:33
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
    <title>Consultar Funcionário</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
            <div><a href="menu-principal.html">Menu Principal</a></div>
            <div><a href="venda.html">Venda</a></div>
            <div><a href="#">Cliente</a></div>
            <div><a href="#">Funcionario</a></div>
            <div><a href="#">Produto</a></div>
            <div><a href="#">Relatório</a></div>
        </nav>
    <div class="container">
        <div class="linha">
            <h2>Consultar Funcionário</h2>
        </div>
        <hr>

        <form id="consultaFuncionario" name="consultaFuncionario" class="form" method="post" action="${pageContext.request.contextPath}/FuncionarioConsultar" novalidate>
            <div class="linha">
                <div class="coluna">
                    <select class="campo" name="consultar" id="consultar">
                        <option selected value="selecione">Pesquisar por</option>
                        <option value="CPF">CPF</option>
                        <option value="Nome">Nome</option>
                        <option value="Cargo">Cargo</option>
                        <option value="Filial">Filial</option>
                    </select>
                </div>
                <div class="coluna">
                    <input type="text" value="" class="campo" name="pesquisar__funcionario" />
                </div>
                <div class="coluna">
                    <input type="submit" value="Pesquisar" class="btn btn-PesquisaRelatorio" />
                </div>
                <div class="coluna">
                    <input type="button" value="Alterar" class="btn">
                </div>
            </div>
            <table id="tabelaFuncionario" class="tabela">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <Th>Cargo</Th>
                        <Th>Filial</Th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${funcionarioAtt}" var="funcionario">
                        <tr>
                            <td id="IDtable"><c:out value="${funcionario.getId_func()}" /></td>                                
                            <td id="cpfTable"><c:out value="${funcionario.getCpf()}"/></td>                                
                            <td id="cargoTable"><c:out value="${funcionario.getCargo()}"/></td>                                
                            <td id="filialTable"><c:out value="${funcionario.getFilial()}"/></td>                                
                        </tr>
                    </c:forEach>    
                </tbody>
            </table>
        </form>

        <div class="coluna">
            <input type="input" value="Salvar" class="btn">
            <input type="button" value="Cancelar" class="btn btn-cancelar">
        </div>
    </div>
</body>
</html>
