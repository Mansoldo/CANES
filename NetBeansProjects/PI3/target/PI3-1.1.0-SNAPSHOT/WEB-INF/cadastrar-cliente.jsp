<%-- 
    Document   : cliente
    Created on : 07/10/2019, 17:44:26
    Author     : gabriel.rvital
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Dados do Cliente</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>

    <body>
        <form method="post" action="${pageContext.request.contextPath}/cliente" novalidate>
            <header class="header">
                <div class="logo">
                    <h1>Livraria</h1>
                    <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades">
                    <h1>Tades</h1>
                </div>
                <div class="menu__usuario"></div>
            </header>
                    
            <nav class="menu">
                <div><a href="menu-principal">Menu Principal</a></div>
                <div><a href="venda.html">Venda</a></div>
                <div class="current"><a href="cadastro-cliente.html">Cadastro de cliente</a></div>
                <div><a href="cadastro-funcionario.html">Cadastro de funcionario</a></div>
                <div><a href="cadastro-produto.html">Cadastro de produto</a></div>
            </nav>

            <div class="container">
                <div class="linha">
                    <div class="coluna">
                        <h2>Dados do Cliente</h2>
                    </div>
                </div>

                <hr>

                <form id="cadastro__cliente" name="cadastro__cliente" class="cadastro__cliente">
                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__nome__completo">Nome completo <span class="obrigatorio">*</span></label>
                            <input type="text" class="campo" name = "nome" id="cliente__nome__completo" />
                        </div>
                    </div>

                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__cpf">CPF <span class="obrigatorio">*</span></label>
                            <input type="text" class="campo" name = "cpf" id="cliente__cpf" />
                        </div>
                        <div class="coluna">
                            <label for="cliente__data__nascimento">Data de Nascimento <span class="obrigatorio">* </span></label>
                            <input type="date" class="campo" name  = "nascimento" id="cliente__data__nascimento">
                        </div>
                        <div class="coluna">
                            <label for="sexo">Sexo</label><span class="obrigatorio">*</span>
                            <input type="radio" class="campo" name="sexo" id="feminino" value="feminino" checked="checked" />Feminino
                            <input type="radio" class="campo" name="sexo" id="masculino" value="masculino" /> Masculino
                        </div>
                    </div>

                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__email">E-mail <span class="obrigatorio">*</span></label>
                            <input type="email" class="campo" name = "email" id="cliente__email">
                        </div>
                        <div class="coluna">
                            <label for="cliente__telefone">Telefone <span class="obrigatorio">*</span>
                            <input type="text" class="campo" name ="telefone" id="cliente__telefone">
                        </div>
                    </div>
                    
                    <input type="submit" value="Salvar" class="btn btn-salvar" />
                </form>
            </form>
                    
            <form method="post" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-cancelar" />
            </form>
        </div>
    </body>
</html>
