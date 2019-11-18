<%-- 
    Document   : ConsultaCliente
    Created on : 14/10/2019, 11:38:27
    Author     : Micael Santos
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
                alert('Cliente Excluido Com sucesso!');
            } else {
                alert('Falha ao Excluir o cliente!');
            }
        </script>
        <script>
            if (${clienteAlteradoAtt} === true) {
                alert('Cliente alterado com sucesso!');
            } else {
                alert('Falha ao alterar o Cliente!');
            }
        </script>
        <script>
            if (${clienteSalvoAtt} === true) {
                alert('Cliente Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o cliente!');
            }
        </script>

        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades" />
                <h1>Tades</h1>
            </div>
            <div class="user-menu">
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
                <h2>Consultar Cliente</h2>
            </div>

            <hr>

            <form id="consultaCliente" name="consultaCliente" class="form" method="post" action="${pageContext.request.contextPath}/ConsultaCliente" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <select name="consultar" id="consultar" class="campo mt-0">
                            <option selected value="selecione">Pesquisar por</option>
                            <option value="CPF">CPF</option>
                            <option value="Nome">Nome</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <input type="text" value="" name="pesquisa__cliente" class="campo mt-0" />
                    </div>
                    <div class="coluna">
                        <input type="submit" value="Pesquisar" class="btn mt-0" />
                    </div>
                </div>

                <table id="tabelaCliente" class="tabela" style="width: 100%">
                    <thead>
                        <tr>
                            <th style="width: 30%">Nome</th>
                            <th style="width: 15%">CPF</th>
                            <th>Data de Nascimento</th>
                            <th style="width: 5%">Sexo</th>
                            <th style="width: 30%">Email</th>
                            <th>Telefone</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${clienteAtt}" var="cliente">
                            <tr>
                                <td id="nomeTable"><c:out value="${cliente.getNome()}" /></td>
                                <td id="cpfTable"><c:out value="${cliente.getCpf()}" /></td>
                                <td id="dataTable"><c:out value="${cliente.getNascimento()}" /></td>
                                <td id="sexoTable"><c:out value="${cliente.getSexo()}" /></td>
                                <td id="emailTable"><c:out value="${cliente.getEmail()}" /></td>
                                <td id="telefoneTable"><c:out value="${cliente.getTelefone()}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <script>
                    highlight_row();
                    function highlight_row() {
                        var table = document.getElementById('tabelaCliente');
                        var cells = table.getElementsByTagName('td');

                        for (var i = 0; i < cells.length; i++) {
                            // Take each cell
                            var cell = cells[i];
                            // do something on onclick event for cell
                            cell.onclick = function () {
                                // Get the row id where the cell exists
                                var rowId = this.parentNode.rowIndex;

                                var rowsNotSelected = table.getElementsByTagName('tr');
                                for (var row = 0; row < rowsNotSelected.length; row++) {
                                    rowsNotSelected[row].style.backgroundColor = "";
                                    rowsNotSelected[row].classList.remove('selected');
                                }
                                var rowSelected = table.getElementsByTagName('tr')[rowId];
                                rowSelected.style.backgroundColor = "#d9d9d9";
                                rowSelected.className += " selected";
                            }
                        }

                    }
                </script>
            </form>

            <div class="botoes">
                <form method="get" action="${pageContext.request.contextPath}/ClienteAlterar" novalidate>
                    <input type="submit" value="Alterar" class="btn btn-salvar">
                    <input type="hidden" value="?" id="cpf" name="cpf">

                    <script>
                        var table = document.getElementById('tabelaCliente');

                        for (var i = 1; i < table.rows.length; i++) {
                            table.rows[i].onclick = function () {
                                //rIndex = this.rowIndex;
                                document.getElementById("cpf").value = this.cells[1].innerHTML;
                                document.getElementById("cpf2").value = this.cells[1].innerHTML;
                            };
                        }
                    </script>
                </form>

                <form method="post" action="${pageContext.request.contextPath}/ClienteExcluir" novalidate>
                    <input type="submit" value="Excluir" class="btn btn-cancelar">
                    <input type="hidden" value="?" id="cpf2" name="cpf2">
                </form>
            </div>
        </div>
    </body>
</html>
