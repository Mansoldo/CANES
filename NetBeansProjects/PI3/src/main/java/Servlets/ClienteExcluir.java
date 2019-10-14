package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteExcluir", urlPatterns = {"/ClienteExcluir"})
public class ClienteExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selecao = request.getParameter("cpf2");

        boolean cliente = Controller.ClienteController.excluirCliente(selecao);
        
         request.setAttribute("clienteExcluidoAtt", cliente);
         
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/ConsultaCliente.jsp");
        dispatcher.forward(request, response);
       
    }

}
