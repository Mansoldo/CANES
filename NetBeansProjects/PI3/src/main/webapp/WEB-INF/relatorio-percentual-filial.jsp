<%-- 
    Document   : relatorio-percentual-filial
    Created on : 11/10/2019, 22:14:08
    Author     : Beatriz da Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Percentual por Filial</title>
        <link
            rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
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
                <div class="coluna">
                    <h2>Percentual por Filial</h2>
                </div>
            </div>
            <hr>
            <form id="percentualFilial" name="percentual_filial" class="form">
                <div class="linha">
                    <div class="coluna">
                        <select class="campo" name="filial" id="filial">
                            <option selected value="selecione_filial">Selecione a filial</option>
                            <option value="Matriz">(SP) Matriz</option>
                            <option value="Brasilia">(DF) Brasilia</option>
                            <option value="Campina Grande">(PB) Campina Grande</option>
                            <option value="Joinville">(SC) Joinville</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <input type="text" value="" class="campo" /> 
                    </div>
                    <div class="coluna">
                        <input type="button" value="Pesquisar" class="btn mt-0" />
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
                        <tr>
                            <td>São Paulo</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Rio de Janeiro</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Curitiba</td>
                            <td>100%</td>          
                        </tr>
                        <tr>
                            <td>Natal</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Salvador</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Recife</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Florianopolis</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Santos</td>
                            <td>100%</td>
                        </tr>
                        <tr>
                            <td>Belo Horizonte</td>
                            <td>100%</td>
                        </tr>

                        <tr>
                            <td>Sergipe</td>
                            <td>100%</td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
