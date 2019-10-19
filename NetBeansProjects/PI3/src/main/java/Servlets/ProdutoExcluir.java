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

@WebServlet(name = "ProdutoExcluir", urlPatterns = {"/ProdutoExcluir"})
public class ProdutoExcluir extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selecao = request.getParameter("idProd2");
        int id = Integer.parseInt(selecao);

        boolean produto = Controller.ProdutoController.excluirProduto(id);
        
         request.setAttribute("produtoExcluidoAtt", produto);
         
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-produto.jsp");
        dispatcher.forward(request, response);
    }

}
