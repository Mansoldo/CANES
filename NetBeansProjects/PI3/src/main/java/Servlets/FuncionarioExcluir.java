package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncionarioExcluir", urlPatterns = {"/FuncionarioExcluir"})
public class FuncionarioExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String selecao = request.getParameter("idFunc2");
        
        int ID = Integer.parseInt(selecao);

        boolean funcionario = new Controller.FuncionarioController().excluirFuncionario(ID);
        
         request.setAttribute("funcionarioExcluidoAtt", funcionario);
         
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-funcionario.jsp");
        dispatcher.forward(request, response);
       
    }

}
