package Servlets;

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

@WebServlet(name = "ProdutoConsultar", urlPatterns = {"/ProdutoConsultar"})
public class ProdutoConsultar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consulta-produto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String filter = request.getParameter("pesquisar__produto");
        
        ArrayList<Produto> produto = Controller.ProdutoController.getProdutoFilter(filter);
        
        request.setAttribute("produtoAtt", produto);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consulta-produto.jsp");
        dispatcher.forward(request, response);
    }

}