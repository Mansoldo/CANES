package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Classes.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
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
@WebServlet(name = "formularioCliente", urlPatterns = {"/cliente"})
public class formularioCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeStr = request.getParameter("nome");
        String cpfStr = request.getParameter("cpf");
        String nascimento = request.getParameter("data");
        String nascimentoStr = request.getParameter("nascimento");
        String sexoStr = request.getParameter("sexo");
        String emailStr = request.getParameter("email");
        String telefoneStr = request.getParameter("telefone");

        boolean clienteSalvo = Controller.ClienteController.cadastrarCliente(nomeStr, cpfStr, nascimento, sexoStr, emailStr, telefoneStr);

        request.setAttribute("clienteSalvoAtt", clienteSalvo);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
    }
}
