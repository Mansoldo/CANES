package Servlets;

import Classes.Produto;
import Classes.ProdutoCdDvd;
import Classes.ProdutoLivro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoAlterar", urlPatterns = {"/ProdutoAlterar"})
public class ProdutoAlterar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selecao = request.getParameter("idProd");
        int id = Integer.parseInt(selecao);
        
        String selecao2 = request.getParameter("categoria");
        if (selecao2.equals("Livro")) {
            ArrayList<ProdutoLivro> lista = new Controller.ProdutoController().getProdutoLivro(id);
            for (ProdutoLivro produtos : lista) {
                request.setAttribute("idAtt", produtos.getID());
                request.setAttribute("nomeAtt", produtos.getNomeProduto());
                request.setAttribute("valorAtt", produtos.getValorUnitario());
                request.setAttribute("categoriaAtt", produtos.getCategoria());
                request.setAttribute("idiomaAtt", produtos.getIdioma());
                request.setAttribute("quantidadeAtt", produtos.getQuantidade());
                request.setAttribute("filialAtt", produtos.getFilial());
                request.setAttribute("ISBNAtt", produtos.getISBN());
                request.setAttribute("editoraAtt", produtos.getEditora());
                request.setAttribute("autorAtt", produtos.getAutor());
                request.setAttribute("paginasAtt", produtos.getPaginas());
                request.setAttribute("idAtt", selecao);
            }
        } else if (selecao2.equals("Cd_Dvd")) {
            ArrayList<ProdutoCdDvd> lista = new Controller.ProdutoController().getProdutoCdDvd(id);
            for (ProdutoCdDvd produtos : lista) {
                request.setAttribute("idAtt", produtos.getID());
                request.setAttribute("nomeAtt", produtos.getNomeProduto());
                request.setAttribute("valorAtt", produtos.getValorUnitario());
                request.setAttribute("categoriaAtt", produtos.getCategoria());
                request.setAttribute("idiomaAtt", produtos.getIdioma());
                request.setAttribute("quantidadeAtt", produtos.getQuantidade());
                request.setAttribute("filialAtt", produtos.getFilial());
                request.setAttribute("tempoAtt", produtos.getTempo());
                request.setAttribute("idAtt", selecao);
            }
        } else {
            ArrayList<Produto> lista = new Controller.ProdutoController().getProdutoGenerico(id);
            for (Produto produtos : lista) {
                request.setAttribute("idAtt", produtos.getID());
                request.setAttribute("nomeAtt", produtos.getNomeProduto());
                request.setAttribute("valorAtt", produtos.getValorUnitario());
                request.setAttribute("categoriaAtt", produtos.getCategoria());
                request.setAttribute("idiomaAtt", produtos.getIdioma());
                request.setAttribute("quantidadeAtt", produtos.getQuantidade());
                request.setAttribute("filialAtt", produtos.getFilial());
                request.setAttribute("idAtt", selecao);
            }
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/alterar-produto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selecao = request.getParameter("idProd");
        int id = Integer.parseInt(selecao);
        
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
        if (filialStr.equals("Matriz") || filialStr.equals("1")) {
            filial = 1;
        } else if (filialStr.equals("Brasilia") || filialStr.equals("2")) {
            filial = 2;
        } else if (filialStr.equals("Campina Grande") || filialStr.equals("3")) {
            filial = 3;
        } else {
            filial = 4;
        }

        boolean produtoSalvo = false;
        if (categoriaStr.equals("Livro")) {
            
            int paginas = Integer.parseInt(paginasStr);
            produtoSalvo = new Controller.ProdutoController().AlterarProdutoLivro(id, editorStr, ISBN, paginas, AutorStr, nomeStr, valorUnitario, idiomaStr, categoriaStr, quantidade, filial);
            
        } else if (categoriaStr.equalsIgnoreCase("Cd_Dvd")) {
            produtoSalvo = new Controller.ProdutoController().AlterarProdutoCdDvd(id, nomeStr, valorUnitario, idiomaStr, categoriaStr, quantidade, filial, tempoStr);
        } else {
            produtoSalvo = new Controller.ProdutoController().AlterarProduto(id, nomeStr, valorUnitario, idiomaStr, categoriaStr, quantidade, filial);
        }

        request.setAttribute("ProdutoAlteradoAtt", produtoSalvo);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-produto.jsp");
        dispatcher.forward(request, response);
    }

}
