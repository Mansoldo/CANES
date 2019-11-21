/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Vital
 */
@WebServlet(name = "ClienteAlterar", urlPatterns = {"/ClienteAlterar"})
public class ClienteAlterar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selecao = request.getParameter("cpf");
        if (!selecao.equals("?")) {
            ArrayList<Cliente> listaClientes = new Controller.ClienteController().getClientes();
            for (Cliente clientes : listaClientes) {
                if (clientes.getCpf().equals(selecao)) {
                    request.setAttribute("nomeAtt", clientes.getNome());
                    request.setAttribute("cpfAtt", clientes.getCpf());
                    request.setAttribute("dataAtt", clientes.getNascimento());
                    if (clientes.getSexo().equals("Feminino")) {
                        request.setAttribute("sexo", 0);
                    } else {
                        request.setAttribute("sexo", 1);
                    }
                    request.setAttribute("emailAtt", clientes.getEmail());
                    request.setAttribute("telefoneAtt", clientes.getTelefone());
                }
            }
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/alterar-cliente.jsp");
            dispatcher.forward(request, response);
        } else {
            boolean validar =false;
            request.setAttribute("ClienteAlter", validar);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/consultar-cliente.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String nomeStr = request.getParameter("nome");
        String cpfStr = request.getParameter("cpf");
        String nascimentoStr = request.getParameter("nascimento");
        String sexoStr = request.getParameter("sexo");
        String emailStr = request.getParameter("email");
        String telefoneStr = request.getParameter("telefone");
        LocalDate nasc = LocalDate.parse(nascimentoStr);

        Cliente cliente = new Cliente(nomeStr, cpfStr, nasc, sexoStr, emailStr, telefoneStr);
        boolean clienteSalvo = new Controller.ClienteController().alterar(cliente);

        request.setAttribute("clienteAlteradoAtt", clienteSalvo);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-cliente.jsp");
        dispatcher.forward(request, response);

    }
}
