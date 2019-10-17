/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
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

        String selecao2 = request.getParameter("cargo");

        if (selecao2.equals("Analista")) {
            ArrayList<Analista> lista = Controller.FuncionarioController.getFuncionarioAnalista(ID);

            for (Analista funcionarios : lista) {
                request.setAttribute("idAtt", funcionarios.getId_func());
                request.setAttribute("nomeAtt", funcionarios.getNome_func());
                request.setAttribute("cpfAtt", funcionarios.getCpf());
                request.setAttribute("cargoAtt", funcionarios.getCargo());
                request.setAttribute("departamentoAtt", funcionarios.getDepartamento());
                request.setAttribute("filialAtt", funcionarios.getFilial());
                request.setAttribute("loginAtt", funcionarios.getLogin());
                request.setAttribute("senhaAtt", funcionarios.getSenha());
                request.setAttribute("idAtt", selecao);
            }
        } else if (selecao2.equals("BackOffice")) {
            ArrayList<BackOffice> lista = Controller.FuncionarioController.getFuncionarioBackOffice(ID);

            for (BackOffice funcionarios : lista) {
                request.setAttribute("idAtt", funcionarios.getId_func());
                request.setAttribute("nomeAtt", funcionarios.getNome_func());
                request.setAttribute("cpfAtt", funcionarios.getCpf());
                request.setAttribute("cargoAtt", funcionarios.getCargo());
                request.setAttribute("departamentoAtt", funcionarios.getDepartamento());
                request.setAttribute("filialAtt", funcionarios.getFilial());
                request.setAttribute("loginAtt", funcionarios.getLogin());
                request.setAttribute("senhaAtt", funcionarios.getSenha());
                request.setAttribute("idAtt", selecao);
            }
        } else if (selecao2.equals("Diretor")) {
            ArrayList<Diretor> lista = Controller.FuncionarioController.getFuncionarioDiretor(ID);

            for (Diretor funcionarios : lista) {
                request.setAttribute("idAtt", funcionarios.getId_func());
                request.setAttribute("nomeAtt", funcionarios.getNome_func());
                request.setAttribute("cpfAtt", funcionarios.getCpf());
                request.setAttribute("cargoAtt", funcionarios.getCargo());
                request.setAttribute("departamentoAtt", funcionarios.getDepartamento());
                request.setAttribute("filialAtt", funcionarios.getFilial());
                request.setAttribute("loginAtt", funcionarios.getLogin());
                request.setAttribute("senhaAtt", funcionarios.getSenha());
                request.setAttribute("idAtt", selecao);
            }
        } else if (selecao2.equals("Gerente")) {
            ArrayList<Gerente> lista = Controller.FuncionarioController.getFuncionarioGerente(ID);

            for (Gerente funcionarios : lista) {
                request.setAttribute("idAtt", funcionarios.getId_func());
                request.setAttribute("nomeAtt", funcionarios.getNome_func());
                request.setAttribute("cpfAtt", funcionarios.getCpf());
                request.setAttribute("cargoAtt", funcionarios.getCargo());
                request.setAttribute("departamentoAtt", funcionarios.getDepartamento());
                request.setAttribute("filialAtt", funcionarios.getFilial());
                request.setAttribute("loginAtt", funcionarios.getLogin());
                request.setAttribute("senhaAtt", funcionarios.getSenha());
                request.setAttribute("idAtt", selecao);
            }
        } else {
            ArrayList<Vendedor> lista = Controller.FuncionarioController.getFuncionarioVendedor(ID);

            for (Vendedor funcionarios : lista) {
                request.setAttribute("idAtt", funcionarios.getId_func());
                request.setAttribute("nomeAtt", funcionarios.getNome_func());
                request.setAttribute("cpfAtt", funcionarios.getCpf());
                request.setAttribute("cargoAtt", funcionarios.getCargo());
                request.setAttribute("departamentoAtt", funcionarios.getDepartamento());
                request.setAttribute("filialAtt", funcionarios.getFilial());
                request.setAttribute("loginAtt", funcionarios.getLogin());
                request.setAttribute("senhaAtt", funcionarios.getSenha());
                request.setAttribute("idAtt", selecao);
            }
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/FuncionarioAlterar.jsp");
        dispatcher.forward(request, response);
    }

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
        
        if(departamStr.equals("Diretoria")){
            departamento = 1;
        } else if (departamStr.equals("Produtos/Marketing")){
            departamento = 2;
        } else if (departamStr.equals("TI")){
            departamento = 3;
        } else {
            departamento = 4;
        }
        
        boolean funcionarioSalvo = false;
        
        if(cargoStr.equals("Analista")){
            funcionarioSalvo = Controller.FuncionarioController.alterarAnalista(ID, usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else if(cargoStr.equals("Backoffice")){
            funcionarioSalvo = Controller.FuncionarioController.alterarBackOffice(ID, usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else if(cargoStr.equals("Diretor")){
            funcionarioSalvo = Controller.FuncionarioController.alterarDiretor(ID, usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else if(cargoStr.equals("Gerente")){
            funcionarioSalvo = Controller.FuncionarioController.alterarGerente(ID, usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else {
            funcionarioSalvo = Controller.FuncionarioController.alterarVendedor(ID, usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        }
        
        request.setAttribute("funcionarioAlteradoAtt", funcionarioSalvo);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/consulta-funcionario.jsp");
        dispatcher.forward(request, response);

    }
}
