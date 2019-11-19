package Servlets;

import Classes.Funcionario;
import Classes.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProdutoConsultar", urlPatterns = {"/ProdutoConsultar"})
public class ProdutoConsultar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-produto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String filter = request.getParameter("pesquisar__produto");
        
        HttpSession session = request.getSession();
        Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");
        
        ArrayList<Produto> produto = new Controller.ProdutoController().getProdutoFilter(filter, funcionario.getFilial());
        
        request.setAttribute("produtoAtt", produto);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-produto.jsp");
        dispatcher.forward(request, response);
    }

}
