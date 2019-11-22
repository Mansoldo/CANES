<%-- 
    Document   : cadastro-produto
    Created on : 11/10/2019, 22:05:05
    Author     : Beatriz da Silva
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Dados do Produto</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo.svg" type="image/x-svg" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <script src="${pageContext.request.contextPath}/javaScript/validar.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
    </head>

    <body>
        <script>
            if (${ProdutoSalvoAtt} === true) {
                alert('Produto Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o Produto!');
            }
        </script> 
        <script>
            function validafunc() {
                var submit = true;

                if ($.trim(document.getElementById('produto__nome').value) === '') {
                    produtoError = "Produto não pode estar vazio";
                    document.getElementById("produto_error").innerHTML = produtoError;
                    document.getElementById("produto_error").style.color = "red";
                    document.getElementById("produto__nome").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("produto_error").innerHTML = '';
                    document.getElementById("produto__nome").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('produto__categoria').value === 'selecione categoria') {
                    categoriaError = "Categoria não pode estar vazia";
                    document.getElementById("categoria_error").innerHTML = categoriaError;
                    document.getElementById("categoria_error").style.color = "red";
                    document.getElementById("produto__categoria").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("categoria_error").innerHTML = '';
                    document.getElementById("produto__categoria").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('produto__filial').value === 'selecione__filial') {
                    filialError = "Filial deve ser selecinada";
                    document.getElementById("filial_error").innerHTML = filialError;
                    document.getElementById("filial_error").style.color = "red";
                    document.getElementById("produto__filial").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("filial_error").innerHTML = '';
                    document.getElementById("produto__filial").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('produto__estoque').value === '') {
                    estoqueError = "Quantidade em estoque deve ser inserida";
                    document.getElementById("estoque_error").innerHTML = estoqueError;
                    document.getElementById("estoque_error").style.color = "red";
                    document.getElementById("produto__estoque").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("estoque_error").innerHTML = '';
                    document.getElementById("produto__estoque").style.borderColor = "#ced4da";
                }
                
                if (document.getElementById('produto__valorunitario').value === '') {
                    valorunitarioError = "Valor unitário deve ser inserido";
                    document.getElementById("valorunitario_error").innerHTML = valorunitarioError;
                    document.getElementById("valorunitario_error").style.color = "red";
                    document.getElementById("produto__valorunitario").style.borderColor = "red";
                    submit = false;
                }else {
                    document.getElementById("valorunitario_error").innerHTML = '';
                    document.getElementById("produto__valorunitario").style.borderColor = "#ced4da";
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
                    <h2>Dados do Produto</h2>
                </div>
            </div>

            <hr>

            <form onsubmit="return validafunc();" id="cadastro__produto" name="cadastro__produto" class="form" method="post" action="${pageContext.request.contextPath}/formularioProduto" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <label for="produto__nome">Produto <span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="produto__nome" id="produto__nome" placeholder="Ex: Capitães da Areia" maxlength="100"/>
                        <span class="error"><p id="produto_error"></p></span>
                    </div>
                    <div class="coluna">
                        <label for="produto__categoria">Categoria</label><span class="obrigatorio">* </span>
                        <select class="campo" name="produto__categoria" id="produto__categoria">
                            <option selected value="selecione categoria">Selecione a categoria</option>
                            <option value="Livro">Livro</option>
                            <option value="HQ / Mangá">HQ / Mangá</option>
                            <option value="CD / DVD">CD / DVD</option>
                        </select>
                        <span class="error"><p id="categoria_error"></p></span>
                    </div>
                    <div class="coluna">
                        <label for="produto__idioma">Idioma</label>
                        <select class="campo" name="produto__idioma" id="produto__idioma">
                            <option selected value="selecione__idioma">Selecione o idioma</option>
                            <option value="Português">Português</option>
                            <option value="Inglês">Inglês</option>
                            <option value="Espanhol">Espanhol</option>
                            <option value="Japonês">Japonês</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <label for="editora__produtora">Editora / Produtora</label>
                        <input type="text" class="campo" name="editora__produtora" id="editora_produtora" placeholder="Ex: Editora Folha" maxlength="100" />
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="produto__autor">Autor</label>
                        <input type="text" class="campo" name="produto__autor" id="produto__autor" placeholder="Ex: J.K. Rolling" maxlength="100"/>
                    </div>
                    <div class="coluna">
                        <label for="produto_isbn">ISBN</label>
                        <input type="text" class="campo" name="produto_isbn" id="produto_isbn" placeholder="000-0-00-000000-0"/>
                    </div>
                    <div class="coluna">
                        <label for="produto__paginas">Quantidade de páginas</label>
                        <input type="text" class="campo" name="produto__paginas" id="produto__paginas" placeholder="00" maxlength="5" />
                    </div>
                    <div class="coluna">
                        <label for="produto__tempo">Tempo de duração</label>
                        <input type="text" class="campo" name="produto__tempo" id="produto__tempo" placeholder="Minutos" maxlength="4" />
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="produto__filial">Filial</label><span class="obrigatorio">* </span>
                        <select class="campo" name="produto__filial" id="produto__filial">
                            <option selected value="selecione__filial">Selecione a filial</option>
                            <option value="Matriz">(SP) Matriz</option>
                            <option value="Brasilia">(DF) Brasilia</option>
                            <option value="Campina Grande">(PB) Campina Grande</option>
                            <option value="Joinville">(SC) Joinville</option>
                        </select>
                        <span class="error"><p id="filial_error"></p></span>
                    </div>
                    <div class="coluna">
                        <label for="produto__estoque">Quantidade em Estoque<span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="produto__estoque" id="produto__estoque" placeholder="00" maxlength="6" />
                        <span class="error"><p id="estoque_error"></p></span>
                    </div>
                    <div class="coluna">
                        <label for="produto__valorunitario">Valor Unitário<span class="obrigatorio">*</span></label>
                        <input type="text" class="campo" name="produto__valorunitario" id="produto__valorunitario" placeholder="R$ 29.99" maxlength="11" />
                        <span class="error"><p id="valorunitario_error"></p></span>
                    </div>
                </div>
                <div class="linha">
                    <input type="submit" value="Salvar" class="btn btn-salvar" />
            </form>

            <form method="post" action="${pageContext.request.contextPath}/menu-principal" novalidate>
                <input type="submit" value="Cancelar" class="btn btn-cancelar" />
            </form>
            <script>
                $(document).ready(function () {
                    var $Isbn = $("#produto_isbn");
                    $Isbn.mask('000-0-00-000000-0');
                    var $Valor = $("#produto__valorunitario");
                    $Valor.mask('########0.00', {reverse: true});
                    var $Valor = $("#produto__tempo");
                    $Valor.mask('0000', {reverse: true});
                    var $Valor = $("#produto__paginas");
                    $Valor.mask('00000', {reverse: true});
                    var $Valor = $("#produto__estoque");
                    $Valor.mask('000000', {reverse: true});
                });
            </script>
        </div>
    </body>
</html>