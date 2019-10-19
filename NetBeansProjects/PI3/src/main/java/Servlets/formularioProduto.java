/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriel.rvital
 */
@WebServlet(name = "formularioProduto", urlPatterns = {"/formularioProduto"})
public class formularioProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeStr = request.getParameter("produto__nome");
        String categoriaStr = request.getParameter("produto__categoria");
        String idiomaStr = request.getParameter("produto__idioma");
        String quantidadeStr = request.getParameter("produto__estoque");
        String valorUniStr = request.getParameter("produto__valorunitario");
        String filialStr = request.getParameter("produto__filial");
        String editorStr = request.getParameter("editora__produtora");
        String AutorStr = request.getParameter("produto__autor");
        String ISBN = request.getParameter("produto_isbn");
        String paginasStr = request.getParameter("produto__paginas");
        String tempoStr = request.getParameter("produto__tempo");

        int quantidade = Integer.parseInt(quantidadeStr);
        float valorUnitario = Float.parseFloat(valorUniStr);
        int filial = 0;
        if (filialStr.equals("Matriz")) {
            filial = 1;
        } else if (filialStr.equals("Brasilia")) {
            filial = 2;
        } else if (filialStr.equals("Campina Grande")) {
            filial = 3;
        } else {
            filial = 4;
        }

        boolean produtoSalvo = false;
        if (categoriaStr.equals("Livro")) {

            int paginas = Integer.parseInt(paginasStr);
            produtoSalvo = Controller.ProdutoController.cadastrarProdutoLivro(editorStr, ISBN, paginas, AutorStr, nomeStr, valorUnitario, idiomaStr, categoriaStr, quantidade, filial);
        } else if (categoriaStr.equalsIgnoreCase("Cd_Dvd")) {
            produtoSalvo = Controller.ProdutoController.cadastrarProdutoCdDvd(tempoStr, nomeStr, valorUnitario, idiomaStr, categoriaStr, quantidade, filial);
        } else {
            produtoSalvo = Controller.ProdutoController.cadastrarProduto(nomeStr, valorUnitario, idiomaStr, categoriaStr, quantidade, filial);
        }

        request.setAttribute("ProdutoSalvoAtt", produtoSalvo);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-produto.jsp");
        dispatcher.forward(request, response);
    }

}
