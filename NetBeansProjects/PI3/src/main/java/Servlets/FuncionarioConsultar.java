package Servlets;

import Classes.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncionarioConsultar", urlPatterns = {"/FuncionarioConsultar"})
public class FuncionarioConsultar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consulta-funcionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String filter = request.getParameter("pesquisar__funcionario");
        
        ArrayList<Funcionario> funcionario = Controller.FuncionarioController.getFuncionario(filter);
        
        request.setAttribute("funcionarioAtt", funcionario);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consulta-funcionario.jsp");
        dispatcher.forward(request, response);
    }

}
