package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Classes.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ClienteConsultar", urlPatterns = {"/ConsultaCliente"})
public class ClienteConsultar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-cliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String campoPesquisa = request.getParameter("pesquisa__cliente");

        ArrayList<Cliente> cliente = new Controller.ClienteController().getClientesFilter(campoPesquisa);
        
        request.setAttribute("clienteAtt", cliente);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-cliente.jsp");
        dispatcher.forward(request, response);
    }

}
