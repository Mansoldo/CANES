<%-- 
    Document   : cadastro-funcionario
    Created on : 11/10/2019, 22:04:20
    Author     : beatriz.silva19
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Dados do Funcionário</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>    
        <script>
            if(${FuncionarioSalvoAtt} === true){
                alert('Funcionário salvo com sucesso!');
            } else {
                alert('Falha ao salvar funcionário!');
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
                <div class="coluna">
                    <h2>Dados do Funcionário</h2>
                </div>
            </div>

            <hr>

            <form id="cadastro__funcionario" name="cadastro__funcionario" class="cadastro__funcionario" method="post" action="${pageContext.request.contextPath}/formularioFuncionario" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <label for="funcionario__nome__completo">Nome completo <span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="funcionario__nome__completo" id="funcionario__nome__completo" />
                    </div>
                    <div class="coluna">
                        <label for="funcionario__cpf">CPF <span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="funcionario__cpf" id="funcionario__cpf" />
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="filial">Filial</label><span class="obrigatorio">* </span>
                        <select class="campo" name="filial" id="filial">
                            <option selected value="selecione_filial">Selecione a filial</option>
                            <option value="Matriz">(SP) Matriz</option>
                            <option value="Brasilia">(DF) Brasilia</option>
                            <option value="Campina Grande">(PB) Campina Grande</option>
                            <option value="Joinville">(SC) Joinville</option>
                        </select>
                    </div>

                    <div class="coluna">
                        <label for="departamento">Departamento</label><span class="obrigatorio">* </span>
                        <select class="campo" name="departamento" id="departamento">
                            <option selected value="selecione_departamento">Selecione o departamento</option>
                            <option value="Diretoria">Diretoria</option>
                            <option value="Produtos/Marketing">Produtos / Marketing</option>
                            <option value="TI">TI</option>
                            <option value="Vendas">Vendas</option>
                        </select>
                    </div>

                    <div class="coluna">
                        <label for="cargo">Cargo</label><span class="obrigatorio">* </span>
                        <select class="campo" name="cargo" id="cargo">
                            <option selected value="selecione_cargo">Selecione o cargo</option>
                            <option value="Analista">Analista</option>
                            <option value="Backoffice">Backoffice</option>
                            <option value="Diretor">Diretor</option>
                            <option value="Gerente">Gerente</option>
                            <option value="Vendedor">Vendedor</option>
                        </select>
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="funcionario__username">Username<span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="funcionario__username" id="funcionario__username">
                    </div>
                    <div class="coluna">
                        <label for="funcionario__senha">Senha<span class="obrigatorio">*</span>
                            <input type="password" class="campo" name="funcionario__senha" id="funcionario__senha">
                    </div>
                </div>
                
                <input type="submit" value="Salvar" class="btn btn-salvar" />
            </form>
            
            <form method="post" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-cancelar" />
            </form>
        </div>
    </body>
</html>