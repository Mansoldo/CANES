/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lgomes
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String> erros = new ArrayList<>();

        if (request.getParameter("loginBt") != null) {
            String login = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            if (login == null || login.isEmpty()) {
                erros.add("Login não informado!");

            }
            if (senha == null || senha.isEmpty()) {
                erros.add("Senha não informada!");

            }
            if (erros.isEmpty()) {

                Funcionario funcionario = new Controller.FuncionarioController().getFuncionarioLogin(login);

                if (funcionario != null) {
                    if (funcionario.validarSenha(senha)) {
                        request.getSession().setAttribute("usuarioLogado", funcionario);
                        response.sendRedirect("/livraria/menu-principal");

                        return;
                    } else {
                        erros.add("Senha inválida!");
                    }
                } else {
                    erros.add("Usuário não encontrado!");
                }
            }

        }

        request.setAttribute("mensagensDeErro", erros);
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
