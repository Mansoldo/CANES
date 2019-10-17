package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeStr = request.getParameter("nome");
        String cpfStr = request.getParameter("cpf");
        String sexoStr = request.getParameter("sexo");
        String emailStr = request.getParameter("email");
        String telefoneStr = request.getParameter("telefone");
        
        String dataString = request.getParameter("nascimento"); 
       
        boolean clienteSalvo = Controller.ClienteController.cadastrarCliente(nomeStr, cpfStr, dataString, sexoStr, emailStr, telefoneStr);

        request.setAttribute("clienteSalvoAtt", clienteSalvo);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/ConsultaCliente.jsp");
        dispatcher.forward(request, response);
    }
}
