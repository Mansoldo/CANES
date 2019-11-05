/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;
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
 * @author diego
 */
@WebServlet(name = "FuncionarioAlterar", urlPatterns = {"/FuncionarioAlterar"})
public class FuncionarioAlterar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selecao = request.getParameter("idFunc");
        int ID = Integer.parseInt(selecao);
        String departamentoAtt;
        String filialAtt;

        String selecao2 = request.getParameter("cargo");

        ArrayList<Funcionario> lista = new Controller.FuncionarioController().getFuncionario(ID);

        for (Funcionario funcionarios : lista) {
            request.setAttribute("idAtt", funcionarios.getId_func());
            request.setAttribute("nomeAtt", funcionarios.getNome_func());
            request.setAttribute("cpfAtt", funcionarios.getCpf());
            request.setAttribute("cargoAtt", funcionarios.getCargo());

            int departamento = funcionarios.getDepartamento();
            if (departamento == 1) {
                departamentoAtt = "Diretoria";
            } else if (departamento == 2) {
                departamentoAtt = "Produtos/Marketing";
            } else if (departamento == 3) {
                departamentoAtt = "TI";
            } else {
                departamentoAtt = "Vendas";
            }
            request.setAttribute("departamentoAtt", departamentoAtt);

            int filial = funcionarios.getFilial();
            if (filial == 1) {
                filialAtt = "Matriz";
            } else if (filial == 2) {
                filialAtt = "Brasilia";
            } else if (filial == 3) {
                filialAtt = "Campina Grande";
            } else {
                filialAtt = "Joinville";
            }
            request.setAttribute("filialAtt", filialAtt);

            request.setAttribute("loginAtt", funcionarios.getLogin());
            request.setAttribute("senhaAtt", funcionarios.getSenha());
            request.setAttribute("idAtt", selecao);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/alterar-funcionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selecao = request.getParameter("idFunc");
        int ID = Integer.parseInt(selecao);

        int filial = 0, departamento = 0;

        String nomeStr = request.getParameter("funcionario__nome__completo");
        String cpfStr = request.getParameter("funcionario__cpf");
        String filialStr = request.getParameter("filial");
        String departamStr = request.getParameter("departamento");
        String cargoStr = request.getParameter("cargo");
        String usernameStr = request.getParameter("funcionario__username");
        String senha = request.getParameter("funcionario__senha");

        if (filialStr.equals("Matriz")) {
            filial = 1;
        } else if (filialStr.equals("Brasilia")) {
            filial = 2;
        } else if (filialStr.equals("Campina Grande")) {
            filial = 3;
        } else {
            filial = 4;
        }

        if (departamStr.equals("Diretoria")) {
            departamento = 1;
        } else if (departamStr.equals("Produtos/Marketing")) {
            departamento = 2;
        } else if (departamStr.equals("TI")) {
            departamento = 3;
        } else {
            departamento = 4;
        }

        boolean funcionarioSalvo = false;
        Funcionario funcionario = new Funcionario(ID, usernameStr, senha, cpfStr, nomeStr, cargoStr, departamento, filial);
        funcionarioSalvo = new Controller.FuncionarioController().alterar(funcionario);

        request.setAttribute("funcionarioAlteradoAtt", funcionarioSalvo);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consultar-funcionario.jsp");
        dispatcher.forward(request, response);

    }
}
