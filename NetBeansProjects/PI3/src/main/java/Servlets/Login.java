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
import javax.servlet.http.HttpSession;

/**
 *
 * @author lgomes
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuarioLogado") != null) {
            // Usuario já está logado -> redireciona para /menu-principal
            response.sendRedirect(request.getContextPath() + "/menu-principal");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Funcionario funcionario = new Controller.FuncionarioController().getFuncionarioLogin(login);

        if (funcionario != null && funcionario.validarSenha(senha)) {

            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", funcionario);
            response.sendRedirect(request.getContextPath() + "/menu-principal");
            return;

        } else {
            request.setAttribute("msgErro", "Usuário ou senha incorreta");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

}
