<%-- 
    Document   : ConsultaCliente
    Created on : 11/10/2019, 19:31:25
    Author     : gabriel.rvital
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Consultar Cliente</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <script>
            if (${clienteExcluidoAtt} === true) {
                alert('Cliente Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o cliente!');
            }
        </script>

        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
                <h1>Tades</h1>
            </div>
        </header>
        <div class="container">
            <div class="linha">

                <h2>Consultar Cliente</h2>

            </div>
            <hr>
            <form id="consultaCliente" name="consultaCliente" class="form" method="post" action="${pageContext.request.contextPath}/ConsultaCliente" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <select class="campo" name="consultar" id="consultar">
                            <option selected value="selecione">Pesquisar por</option>
                            <option value="CPF">CPF</option>
                            <option value="Nome">Nome</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <input type="text" value="" class="campo" name="pesquisa__cliente" />
                    </div>
                    <div class="coluna">
                        <input type="submit" value="Pesquisar" class="btn btn-PesquisaRelatorio" />
                    </div>

                </div>
                <table id="tabelaCliente" class="tabela">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Nascimento</th>
                            <th>Sexo</th>
                            <th>Email</th>
                            <th>Telefone</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${clienteAtt}" var="cliente">
                            <tr>
                                <td id="nomeTable"><c:out value="${cliente.getNome()}" /></td>
                                <td id="cpfTable"><c:out value="${cliente.getCpf()}" /></td>
                                <td id="dataTable"><c:out value="${cliente.getData()}" /></td>
                                <td id="sexoTable"><c:out value="${cliente.getSexo()}" /></td>
                                <td id="emailTable"><c:out value="${cliente.getEmail()}" /></td>
                                <td id="telefoneTable"><c:out value="${cliente.getTelefone()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
            <form method="get" action="${pageContext.request.contextPath}/ClienteAlterar" novalidate>
                <div class="coluna">
                    <input type="submit" value="Alterar" class="btn">
                    <input type="hidden" value="?" id="cpf" name="cpf">
                    <script>

                        var table = document.getElementById('tabelaCliente');

                        for (var i = 1; i < table.rows.length; i++)
                        {
                            table.rows[i].onclick = function ()
                            {
                                //rIndex = this.rowIndex;
                                document.getElementById("cpf").value = this.cells[1].innerHTML;
                                document.getElementById("cpf2").value = this.cells[1].innerHTML;
                            };
                        }

                    </script>
                </div>
            </form>
            <form method="post" action="${pageContext.request.contextPath}/ClienteExcluir" novalidate>
                <input type="submit" value="Excluir" class="btn">
                <input type="hidden" value="?" id="cpf2" name="cpf2">
            </form>
        </div>
    </body>

</html>
