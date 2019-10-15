<%-- 
    Document   : consulta-produto
    Created on : 14/10/2019, 11:40:14
    Author     : MICAEL
--%>

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

        <form id="consultaProduto" name="consultaProduto" class="form">
            <div class="linha">
                <div class="coluna">
                    <select class="campo" name="consultar" id="consultar">
                        <option selected value="selecione">Pesquisar por</option>
                        <option value="Titulo">Título</option>
                        <option value="Autor">Autor</option>
                        <option value="ISBN">ISBN</option>
                        <option value="Editora">Editora</option>
                    </select>
                </div>
                <div class="coluna">
                    <input type="text" value="" class="campo" />
                </div>
                <div class="coluna">
                    <input type="button" value="Pesquisar" class="btn btn-PesquisaRelatorio" />
                </div>
                <div class="coluna">
                    <input type="button" value="Alterar" class="btn">
                </div>
            </div>
            <table id="tabelaProduto" class="tabela">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Autor</th>
                        <Th>ISBN</Th>
                        <Th>Editora</Th>
                        <Th>Valor</Th>
                        <Th>Estoque</Th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>TESTE</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <div class="coluna">
            <input type="button" value="Salvar" class="btn">
            <input type="button" value="Cancelar" class="btn btn-cancelar">
        </div>

    </div>
</body>

</html>
