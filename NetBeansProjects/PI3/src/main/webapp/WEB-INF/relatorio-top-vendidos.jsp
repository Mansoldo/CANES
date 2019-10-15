<%-- 
    Document   : relatorio-top-vendidos
    Created on : 11/10/2019, 22:13:08
    Author     : beatriz.silva19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Top 10 Mais Vendidos</title>
        <link
            rel="shortcut icon"  href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades" />
                <h1>Tades</h1>
            </div>
        </header>
        <div class="containerRelatorio">
            <div class="linha">
                <div class="coluna">
                    <h2>Top 10 Mais Vendidos</h2>
                </div>
            </div>
            <hr>
            <form id="topMaisVendidos" name="top_MaisVendidos" class="form">
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
                        <input type="button" value="Pesquisar" class="btn btn-PesquisaRelatorio" />
                    </div>
                </div>
                <table id="tabela" class="tabela">
                    <thead>
                        <tr>
                            <th>Posição</th>
                            <th>Título</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>TESTE</td>          
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>TESTE</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>TESTE</td>
                        </tr>

                        <tr>
                            <td>10</td>
                            <td>TESTE</td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
