package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "formularioFuncionario", urlPatterns = {"/formularioFuncionario"})
public class formularioFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/cadastrar-funcionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean funcionarioSalvo = false;
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
        
        if(cargoStr.equals("Analista")){
            funcionarioSalvo = Controller.FuncionarioController.cadastrarFuncionarioAnalista(usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else if(cargoStr.equals("Backoffice")){
            funcionarioSalvo = Controller.FuncionarioController.cadastrarFuncionarioBackOffice(usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else if(cargoStr.equals("Diretor")){
            funcionarioSalvo = Controller.FuncionarioController.cadastrarFuncionarioDiretor(usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else if(cargoStr.equals("Gerente")){
            funcionarioSalvo = Controller.FuncionarioController.cadastrarFuncionarioGerente(usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        } else {
            funcionarioSalvo = Controller.FuncionarioController.cadastrarFuncionarioVendedor(usernameStr, senha, cpfStr, 
                    nomeStr, cargoStr, departamento, filial);
        }
        
        request.setAttribute("FuncionarioSalvoAtt", funcionarioSalvo);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/cadastrar-funcionario.jsp");
        dispatcher.forward(request, response);
    }

}
