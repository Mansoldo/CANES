/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author Mansoldo
 */
public class FuncionarioController {
    
    public static boolean cadastrarFuncionarioAnalista(String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        
        Analista funcionario = new Analista(login, senha, cpf, nome_func, cargo, 
                departamento, filial);
        
        return DAO.FuncionarioDAO.daoSalvarAnalista(funcionario);
    }
    
    public static boolean cadastrarFuncionarioBackOffice(String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        
        BackOffice funcionario = new BackOffice(login, senha, cpf, nome_func, cargo, 
                departamento, filial);
        
        return DAO.FuncionarioDAO.daoSalvarBackOffice(funcionario);
    }
    
    public static boolean cadastrarFuncionarioDiretor(String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        
        Diretor funcionario = new Diretor(login, senha, cpf, nome_func, cargo, 
                departamento, filial);
        
        return DAO.FuncionarioDAO.daoSalvarDiretor(funcionario);
    }
    
    public static boolean cadastrarFuncionarioVendedor(String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        
        Vendedor funcionario = new Vendedor(login, senha, cpf, nome_func, cargo, 
                departamento, filial);
        
        return DAO.FuncionarioDAO.daoSalvarVendedor(funcionario);
    }
    
    public static boolean cadastrarFuncionarioGerente(String login, String senha,
            String cpf, String nome_func, String cargo, int departamento, int filial){
        
        Gerente funcionario = new Gerente(login, senha, cpf, nome_func, cargo,
        departamento, filial);
        
        return DAO.FuncionarioDAO.daoSalvarGerente(funcionario);
    }
    
    /*
    public static ArrayList<Analista> getFuncionarioAnalista(int ID){
        ArrayList<Analista> funcionario = DAO.FuncionarioDAO.getAnalista(ID);
        
        return funcionario;
    }
    
    public static ArrayList<BackOffice> getFuncionarioBackOffice(int ID){
        ArrayList<BackOffice> funcionario = DAO.FuncionarioDAO.getBackOffice(ID);
        
        return funcionario;
    }
    
    public static ArrayList<Diretor> getFuncionarioDiretor(int ID){
        ArrayList<Diretor> funcionario = DAO.FuncionarioDAO.getDiretor(ID);
        
        return funcionario;
    }
    
    public static ArrayList<Gerente> getFuncionarioGerente(int ID){
        ArrayList<Gerente> funcionario = DAO.FuncionarioDAO.getGerente(ID);
        
        return funcionario;
    }
    
    public static ArrayList<Vendedor> getFuncionarioVendedor(int ID){
        ArrayList<Vendedor> funcionario = DAO.FuncionarioDAO.getVendedor(ID);
        
        return funcionario;
    }
    
    public static ArrayList<Funcionario> getFuncionario(String filter){
        
        ArrayList<Funcionario> funcionario = DAO.FuncionarioDAO.getFuncionarioFilter(filter);
    }
    
    public static boolean alterarAnalista(int ID, String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        Analista funcionario = new Analista(ID, login, senha, cpf, nome_func, cargo, departamento, filial);
        return DAO.FuncionarioDAO.daoAlterarAnalista(funcionario);
    }
    
    public static boolean alterarBackOffice(int ID, String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        BackOffice funcionario = new BackOffice(ID, login, senha, cpf, nome_func, cargo, departamento, filial);
        return DAO.FuncionarioDAO.daoAlterarBackOffice(funcionario);
    }
    
    public static boolean alterarDiretor(int ID, String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        Diretor funcionario = new Diretor(ID, login, senha, cpf, nome_func, cargo, departamento, filial);
        return DAO.FuncionarioDAO.daoAlterarDiretor(funcionario);
    }
    
    public static boolean alterarGerente(int ID, String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        Gerente funcionario = new Gerente(ID, login, senha, cpf, nome_func, cargo, departamento, filial);
        return DAO.FuncionarioDAO.daoAlterarGerente(funcionario);
    }
    
    public static boolean alterarVendedor(int ID, String login, String senha, 
            String cpf, String nome_func, String cargo, int departamento, int filial){
        Vendedor funcionario = new Vendedor(ID, login, senha, cpf, nome_func, cargo, departamento, filial);
        return DAO.FuncionarioDAO.daoAlterarVendedor(funcionario);
    }
    
    public static boolean excluirFuncionario(int ID){
        
        return DAO.FuncionarioDAO.excluirFuncionario(ID);
    }
    */
}
