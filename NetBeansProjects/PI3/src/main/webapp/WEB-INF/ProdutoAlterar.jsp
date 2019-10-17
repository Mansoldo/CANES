<%-- 
    Document   : ProdutoAlterar
    Created on : 16/10/2019, 16:11:57
    Author     : nik_r
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
    </head>

    <body>
        <script>
            if (${ProdutoSalvoAtt} === true) {
                alert('Produto Salvo Com sucesso!');
            } else {
                alert('Falha ao Salvar o Produto!');
            }
        </script>
        <header class="header">
            <div class="logo">
                <h1>Livraria</h1>
                <img src="${pageContext.request.contextPath}/img/logo.svg" alt="Logo Livraria Tades" />
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
                    <h2>Dados do Produto</h2>
                </div>
            </div>

            <hr>

            <form id="cadastro__produto" name="cadastro__produto" class="form" method="post" action="${pageContext.request.contextPath}/ProdutoAlterar" novalidate>
                <div class="linha">
                    <div class="coluna">
                        <label for="produto__nome">Produto <span class="obrigatorio">*</span></label>
                        <input type="text" value="${nomeAtt}" class="campo" name="produto__nome" id="produto__nome" />
                    </div>
                    <div class="coluna">
                        <label for="produto__categoria">Categoria</label><span class="obrigatorio">* </span>
                        <select class="campo" name="produto__categoria" id="produto__categoria">
                            <option selected value="${categoriaAtt}">${categoriaAtt}</option>
                            <option value="Livro">Livro</option>
                            <option value="Hq__Manga">HQ / Mangá</option>
                            <option value="Cd_Dvd">CD / DVD</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <label for="produto__idioma">Idioma</label>
                        <select class="campo" name="produto__idioma" id="produto__idioma">
                            <option selected value="${idiomaAtt}">${idiomaAtt}</option>
                            <option value="Portugues">Português</option>
                            <option value="Ingles">Inglês</option>
                            <option value="Espanhol">Espanhol</option>
                            <option value="Japones">Japonês</option>
                        </select>
                    </div>
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="editora__produtora">Editora / Produtora</label>
                        <input type="text" value="${editoraAtt}" class="campo" name="editora__produtora" id="editora_produtora" />
                    </div>
                    <div class="coluna">
                        <label for="produto__autor">Autor</label>
                        <input type="text" value="${autorAtt}" class="campo" name="produto__autor" id="produto__autor" />
                    </div>
                    <div class="coluna">
                        <label for="produto_isbn">ISBN</label>
                        <input type="text" value="${ISBNAtt}" class="campo" name="produto_isbn" id="produto_isbn" />
                    </div>
                    <div class="coluna">
                        <label for="produto__paginas">Quantidade de páginas</label>
                        <input type="text" value="${paginasAtt}" class="campo" name="produto__paginas" id="produto__paginas" />
                    </div>
                    <div class="coluna">
                        <label for="produto__tempo">Tempo de duração</label>
                        <input type="text" value="${tempoAtt}" class="campo" name="produto__tempo" id="produto__tempo" />
                    </div>
                    <input type="text" value="${idAtt}" name="idProd" id="id_prod" />
                </div>

                <div class="linha">
                    <div class="coluna">
                        <label for="produto__filial">Filial</label><span class="obrigatorio">* </span>
                        <select class="campo" name="produto__filial" id="produto__filial">
                            <option selected value="${filialAtt}">${filialAtt}</option>
                            <option value="Matriz">(SP) Matriz</option>
                            <option value="Brasilia">(DF) Brasilia</option>
                            <option value="Campina Grande">(PB) Campina Grande</option>
                            <option value="Joinville">(SC) Joinville</option>
                        </select>
                    </div>
                    <div class="coluna">
                        <label for="produto__estoque">Quantidade em Estoque<span class="obrigatorio">*</span></label>
                        <input type="text" value="${quantidadeAtt}" class="campo" name="produto__estoque" id="produto__estoque" />
                    </div>
                    <div class="coluna">
                        <label for="produto__valorunitario">Valor Unitário<span class="obrigatorio">*</span></label>
                        <input type="text" value="${valorAtt}" class="campo" name="produto__valorunitario" id="produto__valorunitario" />
                    </div>
                </div>
                <div class="linha">
                    <div class="coluna">
                        <input type="submit" value="Salvar" class="btn btn-salvar" />
                        <input type="button" value="Cancelar" class="btn btn-cancelar" />
                    </div>
                </div>
            </form>
        </div>
    </body>

</html>