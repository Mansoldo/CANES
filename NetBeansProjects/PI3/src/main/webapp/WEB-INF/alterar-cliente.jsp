<%-- 
    Document   : alterar-cliente
    Created on : 12/10/2019, 15:57:32
    Author     : Gabriel Vital
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
        <form method="post" action="${pageContext.request.contextPath}/ClienteAlterar" novalidate>
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
                        <h2>Dados do Cliente</h2>
                    </div>
                </div>

                <hr>

                <form id="cadastro__cliente" name="cadastro__cliente" class="cadastro__cliente" method="post" action="${pageContext.request.contextPath}/ClienteAlterar" novalidate>
                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__nome__completo">Nome completo <span class="obrigatorio">*</span></label>
                            <input type="text" value="${nomeAtt}" class="campo" name = "nome" id="cliente__nome__completo"/>
                        </div>
                    </div>

                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__cpf">CPF <span class="obrigatorio">*</span></label>
                            <input type="text" value="${cpfAtt}" class="campo" name = "cpf" id="cliente__cpf" />
                        </div>
                        <div class="coluna">
                            <label for="cliente__data__nascimento">Data de Nascimento <span class="obrigatorio">* </span></label>
                            <input type="date" value="${dataAtt}" class="campo" name  = "nascimento" id="cliente__data__nascimento">
                        </div>
                        <div class="coluna">
                            <label for="sexo">Sexo</label><span class="obrigatorio">*</span>
                            <input type="radio" value="Feminino" class="campo" name="sexo" id="radioFeminino" />Feminino
                            <input type="radio" value="Masculino" class="campo" name="sexo" id="radioMasculino" /> Masculino
                            <script>
                                function setSexo(valor) {
                                    try {
                                        if (valor == 0) {
                                            document.getElementById('radioFeminino').checked = true;
                                            document.getElementById('radioMasculino').checked = false;
                                        } else {
                                            document.getElementById('radioFeminino').checked = false;
                                            document.getElementById('radioMasculino').checked = true;
                                        }


                                    } catch (err) {
                                        alert(err);
                                    }
                                }
                                setSexo(${sexo});
                            </script>
                        </div>
                    </div>

                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__email">E-mail <span class="obrigatorio">*</span></label>
                            <input type="email" value="${emailAtt}" class="campo" name = "email" id="cliente__email">
                        </div>
                        <div class="coluna">
                            <label for="cliente__telefone">Telefone <span class="obrigatorio">*</span>
                            <input type="text" value="${telefoneAtt}" class="campo" name ="telefone" id="cliente__telefone">
                        </div>
                    </div>

                    <div class="linha">
                        <input type="submit" value="Salvar" class="btn btn-salvar" />
                </form>

                        <form method="get" action="${pageContext.request.contextPath}/ConsultaCliente" novalidate>
                            <input type="submit" value="Cancelar" class="btn btn-cancelar" />
                        </form>
                    </div>    
            </div>
    </body>
</html>

