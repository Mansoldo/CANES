/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
import Classes.Gerente;
import Classes.Vendedor;

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
    
}
