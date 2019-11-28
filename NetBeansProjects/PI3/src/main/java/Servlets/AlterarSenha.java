/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Funcionario;
import Controller.FuncionarioController;
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
@WebServlet(name = "AlterarSenha", urlPatterns = {"/AlterarSenha"})
public class AlterarSenha extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/alterar-senha.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("Entrou no post");
        String senha_old = request.getParameter("senha_atual");
        String senha_new = request.getParameter("senha_nova");
        boolean resposta = false;

        HttpSession sessao = request.getSession();
        Funcionario funcionario = (Funcionario) sessao.getAttribute("usuarioLogado");
        System.out.println(funcionario.getId_func());
        

        if (funcionario != null && funcionario.validarSenha(senha_old)) {
            System.out.println("entrou no if");
            
            funcionario.setId_func(Integer.parseInt(request.getParameter("id_Func")));
            funcionario.setSenhaHash(senha_new);
            resposta = new Controller.FuncionarioController().alterarSenha(funcionario);
            request.setAttribute("senhaAlteradaAtt", resposta);
            response.sendRedirect(request.getContextPath() + "/menu-principal");
            

        } else {
            System.out.println("entrou no else");
            request.setAttribute("senhaAlteradaAtt", resposta);
            request.getRequestDispatcher("/WEB-INF/alterar-senha.jsp")
                    .forward(request, response);
        }
    }

}
