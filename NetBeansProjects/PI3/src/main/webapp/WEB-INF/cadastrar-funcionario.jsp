<%-- 
    Document   : cadastro-funcionario
    Created on : 11/10/2019, 22:04:20
    Author     : Beatriz da Silva 
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    </head>

    <body>    
        <script>
            if (${FuncionarioSalvoAtt} === true) {
                alert('Funcionário salvo com sucesso!');
            } else {
                alert('Falha ao salvar funcionário!');
            }
        </script>
        <script>
            function validafunc() {
                var submit = true;

                if ($.trim(document.getElementById('funcionario__nome__completo').value) === '') {
                    nameError = "Nome não pode estar vazio";
                    document.getElementById("name_error").innerHTML = nameError;
                    document.getElementById("name_error").style.color = "red";
                    document.getElementById("funcionario__nome__completo").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("name_error").innerHTML = '';
                    document.getElementById("name_error").style.color = "#ced4da";
                    document.getElementById("funcionario__nome__completo").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('funcionario__cpf').value === '') {
                    cpfError = "Cpf não pode estar vazio";
                    document.getElementById("cpf_error").innerHTML = cpfError;
                    document.getElementById("cpf_error").style.color = "red";
                    document.getElementById("funcionario__cpf").style.borderColor = "red";
                    submit = false;
                }else if (document.getElementById('funcionario__cpf').value.length <= 13) {
                    cpfError = "Cpf deve ter 14 digitos";
                    document.getElementById("cpf_error").innerHTML = cpfError;
                    document.getElementById("cpf_error").style.color = "red";
                    document.getElementById("funcionario__cpf").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("cpf_error").innerHTML = '';
                    document.getElementById("cpf_error").style.color = "#ced4da";
                    document.getElementById("funcionario__cpf").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('filial').value === 'selecione_filial') {
                    filialError = "Filial deve ser selecionada";
                    document.getElementById("filial_error").innerHTML = filialError;
                    document.getElementById("filial_error").style.color = "red";
                    document.getElementById("filial").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("filial_error").innerHTML = '';
                    document.getElementById("filial_error").style.color = "#ced4da";
                    document.getElementById("filial").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('departamento').value === 'selecione_departamento') {
                    filialError = "Departamento deve ser selecionado";
                    document.getElementById("dept_error").innerHTML = filialError;
                    document.getElementById("dept_error").style.color = "red";
                    document.getElementById("departamento").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("dept_error").innerHTML = '';
                    document.getElementById("dept_error").style.color = "#ced4da";
                    document.getElementById("departamento").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('cargo').value === 'selecione_cargo') {
                    filialError = "Cargo deve ser selecionado";
                    document.getElementById("cargo_error").innerHTML = filialError;
                    document.getElementById("cargo_error").style.color = "red";
                    document.getElementById("cargo").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("cargo_error").innerHTML = '';
                    document.getElementById("cargo_error").style.color = "#ced4da";
                    document.getElementById("cargo").style.borderColor = "#ced4da";
                }
                
                if ($.trim(document.getElementById('funcionario__username').value) === '') {
                    filialError = "Usuário não pode estar vazio";
                    document.getElementById("username_error").innerHTML = filialError;
                    document.getElementById("username_error").style.color = "red";
                    document.getElementById("funcionario__username").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("username_error").innerHTML = '';
                    document.getElementById("username_error").style.color = "#ced4da";
                    document.getElementById("funcionario__username").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('funcionario__senha').value === '') {
                    filialError = "Senha deve conter mais de 4 caracteres";
                    document.getElementById("senha_error").innerHTML = filialError;
                    document.getElementById("senha_error").style.color = "red";
                    document.getElementById("funcionario__senha").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("senha_error").innerHTML = '';
                    document.getElementById("senha_error").style.color = "#ced4da";
                    document.getElementById("funcionario__senha").style.borderColor = "#ced4da";
                }  

                return submit;
            }
        </script>

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
                    <h2>Dados do Funcionário</h2>
                </div>
            </div>

            <hr>

            <form onsubmit="return validafunc();" id="cadastro__funcionario" name="cadastro__funcionario" class="cadastro__funcionario" method="post" action="${pageContext.request.contextPath}/formularioFuncionario" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <label for="funcionario__nome__completo">Nome completo <span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="funcionario__nome__completo" id="funcionario__nome__completo" maxlength="50" placeholder="Ex: Maria de Andrade" />
                        <span class="error"><p id="name_error"></p></span>
                    </div>
                    <div class="coluna">
                        <label for="funcionario__cpf">CPF <span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="funcionario__cpf" id="funcionario__cpf" maxlength="14" placeholder="000.000.000-00"/>
                        <span class="error"><p id="cpf_error"></p></span>
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
                        <span class="error"><p id="filial_error"></p></span>
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
                        <span class="error"><p id="dept_error"></p></span>
                    </div>

                    <div class="coluna">
                        <label for="cargo">Cargo</label><span class="obrigatorio">* </span>
                        <select class="campo" name="cargo" id="cargo">
                            <option selected value="selecione_cargo">Selecione o cargo</option>
                            <option value="Analista">Analista</option>
                            <option value="Backoffice">Backoffice</option>
                            <option value="Diretor">Diretor</option>
                            <option value="Gerente">Gerente</option>
                            <option value="Gerente_Global">Gerente Global</option>
                            <option value="Vendedor">Vendedor</option>
                        </select>
                        <span class="error"><p id="cargo_error"></p></span>
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="funcionario__username">Username<span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="funcionario__username" id="funcionario__username" maxlength="20">
                        <span class="error"><p id="username_error"></p></span>
                    </div>
                    <div class="coluna">
                        <label for="funcionario__senha">Senha<span class="obrigatorio">*</span>
                        <input type="password" class="campo" name="funcionario__senha" id="funcionario__senha" maxlength="100">
                        <span class="error"><p id="senha_error"></p></span>
                    </div>
                </div>
                <div class="linha">
                    <input type="submit" id="salvar" value="Salvar" class="btn btn-salvar" />
                    </form>

                    <form method="post" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                        <input type="submit" value="Cancelar" class="btn btn-cancelar" />
                    </form>
                    
                    <script>
                        $(document).ready(function () {
                            var $Cpf = $("#funcionario__cpf");
                            $Cpf.mask('000.000.000-00');
                        });
                        var $Nome = $("#funcionario__nome__completo");
                        $Nome.mask("#", {
                            maxlength: false,
                            translation: {
                                '#': {pattern: /[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]/, recursive: true}
                            }
                        });
                    </script>
                </div>
    </body>
</html>