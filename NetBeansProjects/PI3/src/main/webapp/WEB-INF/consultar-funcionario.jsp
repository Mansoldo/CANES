<%-- 
    Document   : consulta-funcionario
    Created on : 14/10/2019, 11:39:33
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
        <title>Consultar Funcionário</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head> 
    <script>
        if (${funcionarioAlterar} === false) {
            alert('Não foi selecionado um funcionário para alterar');
        }
    </script>
    <script>
        if (${funcionarioExcluir} === false) {
            alert('Não foi selecionado um funcionário para excluir');
        }
    </script>
    <script>
        if (${funcionarioAlteradoAtt} === true) {
            alert('Funcionário alterado com sucesso!');
        } else {
            alert('Falha ao alterar o funcionário!');
        }
    </script>
    <script>
        if (${funcionarioExcluidoAtt} === true) {
            alert('Funcionario excluído com sucesso!');
        } else {
            alert('Falha ao excluir o funcionário!');
        }
    </script>


    <body>
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
                <h2>Consultar Funcionário</h2>
            </div>

            <hr>

            <form id="consultaFuncionario" name="consultaFuncionario" class="form" method="post" action="${pageContext.request.contextPath}/FuncionarioConsultar" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <select name="consultar" id="consultar" class="campo mt-0">
                            <option selected value="selecione">Pesquisar por</option>
                            <option value="CPF">CPF</option>
                            <option value="Nome">Nome</option>
                            <option value="Cargo">Cargo</option>
                            <option value="Filial">Filial</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <input type="text" value="" name="pesquisar__funcionario" class="campo mt-0" />
                    </div>
                    <div class="coluna">
                        <input type="submit" value="Pesquisar" class="btn mt-0" />
                    </div>                    
                </div>
                <table id="tabelaFuncionario" class="tabela"  style="width: 100%">
                    <thead>
                        <tr>
                            <th style="width: 10%">Id</th>
                            <th style="width: 50%">Nome</th>
                            <th>CPF</th>
                            <Th>Cargo</Th>
                            <Th>Filial</Th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${funcionarioAtt}" var="funcionario">
                            <tr>
                                <td id="IDtable"><c:out value="${funcionario.getId_func()}"/></td>                                
                                <td id="nomeTable"><c:out value="${funcionario.getNome_func()}"/></td>                                
                                <td id="cpfTable"><c:out value="${funcionario.getCpf()}"/></td>                                
                                <td id="cargoTable"><c:out value="${funcionario.getCargo()}"/></td>                                
                                <td id="filialTable"><c:out value="${funcionario.getFilial()}"/></td>                                
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
                <script>
                    highlight_row();
                    function highlight_row() {
                        var table = document.getElementById('tabelaFuncionario');
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
                <form method="get" action="${pageContext.request.contextPath}/FuncionarioAlterar" novalidate>
                    <input type="submit" value="Alterar" class="btn btn-salvar">
                    <input type="hidden" value="?" id="idFunc" name="idFunc">                    
                    <input type="hidden" value="?" id="cargo" name="cargo">

                    <script>
                        var table = document.getElementById('tabelaFuncionario');

                        for (var i = 1; i < table.rows.length; i++) {
                            table.rows[i].onclick = function () {
                                //rIndex = this.rowIndex;
                                document.getElementById("idFunc").value = this.cells[0].innerHTML;
                                document.getElementById("idFunc2").value = this.cells[0].innerHTML;
                                document.getElementById("cargo").value = this.cells[3].innerHTML;
                            };
                        }
                    </script>
                </form>      

                <form method="post" action="${pageContext.request.contextPath}/FuncionarioExcluir" novalidate>
                    <input type="submit" value="Excluir" class="btn btn-cancelar">
                    <input type="hidden" value="?" id="idFunc2" name="idFunc2">
                </form>
            </div>
        </div>
    </body>
</html>
