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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    </head>

    <body>
        <script>
            if (${clienteSalvoAtt} === true) {
                alert('Cliente salvo com sucesso!');
            } else {
                alert('Falha ao salvar Cliente!');
            }
        </script>
        <script>
            function validafunc() {
                var submit = true;

                if ($.trim(document.getElementById('cliente__nome__completo').value) === '') {
                    nameError = "Nome não pode estar vazio";
                    document.getElementById("name_error").innerHTML = nameError;
                    document.getElementById("name_error").style.color = "red";
                    document.getElementById("cliente__nome__completo").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("name_error").innerHTML = '';
                    document.getElementById("name_error").style.color = "#ced4da";
                    document.getElementById("cliente__nome__completo").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('cliente__cpf').value === '') {
                    cpfError = "Cpf deve ser preenchido";
                    document.getElementById("cpf_error").innerHTML = cpfError;
                    document.getElementById("cpf_error").style.color = "red";
                    document.getElementById("cliente__cpf").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("cpf_error").innerHTML = '';
                    document.getElementById("cpf_error").style.color = "#ced4da";
                    document.getElementById("cliente__cpf").style.borderColor = "#ced4da";
                }
                if ($.trim(document.getElementById('cliente__email').value) === '') {
                    emailError = "E-mail deve ser preenchido";
                    document.getElementById("email_error").innerHTML = emailError;
                    document.getElementById("email_error").style.color = "red";
                    document.getElementById("cliente__email").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("email_error").innerHTML = '';
                    document.getElementById("email_error").style.color = "#ced4da";
                    document.getElementById("cliente__email").style.borderColor = "#ced4da";
                }
                if ($.trim(document.getElementById('cliente__telefone').value) === '') {
                    telefoneError = "Telefone deve ser preenchido";
                    document.getElementById("telefone_error").innerHTML = telefoneError;
                    document.getElementById("telefone_error").style.color = "red";
                    document.getElementById("cliente__telefone").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("telefone_error").innerHTML = '';
                    document.getElementById("telefone_error").style.color = "#ced4da";
                    document.getElementById("cliente__telefone").style.borderColor = "#ced4da";
                }
                if (!document.getElementById('radioFeminino').checked && !document.getElementById('radioMasculino').checked) {
                    sexoError = "Sexo deve ser selecionado";
                    document.getElementById("sexo_error").innerHTML = sexoError;
                    document.getElementById("sexo_error").style.color = "red";
                    submit = false;
                }else {
                    document.getElementById("sexo_error").innerHTML = '';
                    document.getElementById("sexo_error").style.color = "#ced4da";
                }
                if (document.getElementById('cliente__data__nascimento').value === '') {
                    dataError = "Telefone deve ser preenchido";
                    document.getElementById("data_error").innerHTML = dataError;
                    document.getElementById("data_error").style.color = "red";
                    document.getElementById("cliente__data__nascimento").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("data_error").innerHTML = '';
                    document.getElementById("data_error").style.color = "#ced4da";
                    document.getElementById("cliente__data__nascimento").style.borderColor = "#ced4da";
                }
                return submit;
            }
        </script>
        <form onsubmit="return validafunc();" method="post" action="${pageContext.request.contextPath}/cliente" novalidate>
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

                <form onsubmit="return validafunc();" id="cadastro__cliente" name="cadastro__cliente" class="cadastro__cliente" method="post" action="${pageContext.request.contextPath}/cliente" novalidate>
                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__nome__completo">Nome completo <span class="obrigatorio">*</span></label>
                            <input type="text" required class="campo" name = "nome" id="cliente__nome__completo" maxlength="50" placeholder="Ex: João da silva barros" />
                            <span class="error"><p id="name_error"></p></span>
                        </div>
                    </div>

                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__cpf">CPF <span class="obrigatorio">*</span></label>
                            <input type="text" required class="campo" name = "cpf" id="cliente__cpf" maxlength="14" placeholder="000.000.000-00" />
                            <span class="error"><p id="cpf_error"></p></span>
                        </div>
                        <div class="coluna">
                            <label for="cliente__data__nascimento">Data de Nascimento <span class="obrigatorio">* </span></label>
                            <input type="date" required class="campo" name  = "nascimento" id="cliente__data__nascimento">
                            <span class="error"><p id="data_error"></p></span>
                        </div>
                        <div class="coluna">
                            <label for="sexo">Sexo</label><span class="obrigatorio">*</span>
                            <br>
                            <input type="radio" class="radio" name="sexo" id="radioFeminino" value="Feminino" />&nbsp;Feminino
                            <br>
                            <input type="radio" class="radio" name="sexo" id="radioMasculino" value="Masculino" /> Masculino
                            <span class="error"><p id="sexo_error"></p></span>
                        </div>
                    </div>

                    <div class="linha">
                        <div class="coluna">
                            <label for="cliente__email">E-mail <span class="obrigatorio">*</span></label>
                            <input type="email" required class="campo" name = "email" id="cliente__email" maxlength="50" placeholder="seuemail@dominio.com">
                            <span class="error"><p id="email_error"></p></span>
                        </div>
                        <div class="coluna">
                            <label for="cliente__telefone">Telefone <span class="obrigatorio">*</span>
                                <input type="text" required class="campo" name ="telefone" id="cliente__telefone" maxlength="14" placeholder="(00) 00000-0000">
                                <span class="error"><p id="telefone_error"></p></span>
                                </div>
                                </div>
                                <div class="linha">
                                    <input type="submit" value="Salvar" class="btn btn-salvar" />
                                    </form>

                                    <form method="post" action="${pageContext.request.contextPath}/menu-principal" >
                                        <input type="submit" value="Cancelar" class="btn btn-cancelar" />
                                    </form>
                                </div>
                                <script>
                                    $(document).ready(function () {
                                        var $Cpf = $("#cliente__cpf");
                                        $Cpf.mask('000.000.000-00');
                                        var $Telefone = $("#cliente__telefone");
                                        $Telefone.mask('(00)00000-0000');
                                    });
                                    var $Nome = $("#cliente__nome__completo");
                                    $Nome.mask("#", {
                                        maxlength: false,
                                        translation: {
                                            '#': {pattern: /[a-zA-Z ]/, recursive: true}
                                        }
                                    });
                                </script>
                        </div>
                        </body>
                        </html>
