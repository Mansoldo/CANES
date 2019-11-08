/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.ControllerEventListener;
import Controller.FuncionarioController;

/**
 *
 * @author lgomes
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ArrayList<String>  erros = new ArrayList<>();
        
        if (request.getParameter("loginBt") != null) {
            System.out.println("PERU");
            String login = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            if (login == null || login.isEmpty()) {
                erros.add("Login não informado!");
                System.out.println("PERU1");
            }
            if (senha == null || senha.isEmpty()) {
                erros.add("Senha não informada!");
                System.out.println("PERU2");
            }
            if (erros.isEmpty()) {
                                
                Funcionario user = new Controller.FuncionarioController().getFuncionarioLogin(login);
                System.out.println("PERU3");
                if (user != null) {
                    if (user.getSenha().equals(senha)) {
                        response.sendRedirect("/livraria/menu-principal");
                        System.out.println("PERU4");
                        return;
                    } else {
                        erros.add("Senha inválida!");
                    }
                } else {
                    erros.add("Usuário não encontrado!");
                }
            }

        }
        System.out.println("PERU5");
        request.setAttribute("mensagens", erros);

        String URL = "/WEB-INF/login.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(URL);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
