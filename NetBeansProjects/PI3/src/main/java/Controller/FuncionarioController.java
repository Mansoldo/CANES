/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.AcoesCrud;
import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author Diego Mansoldo
 */
public class FuncionarioController implements AcoesCrud<Funcionario> {

    public ArrayList<Funcionario> getFuncionario(int ID) {
        ArrayList<Funcionario> funcionario = new DAO.FuncionarioDAO().getFuncionario(ID);
        return funcionario;
    }

    public Funcionario getFuncionarioLogin(String login) {
        Funcionario funcionario = new DAO.FuncionarioDAO().getFuncionarioLogin(login);
        return funcionario;
    }

    public ArrayList<Funcionario> getFuncionario(String filter) {
        ArrayList<Funcionario> funcionario = new DAO.FuncionarioDAO().getFuncionarioFilter(filter);
        return funcionario;
    }
    
    public boolean alterarSenha(Funcionario e) {
        return new DAO.FuncionarioDAO().daoAlterarSenhaFuncionrio(e);
    }

    public boolean excluirFuncionario(int ID) {
        return new DAO.FuncionarioDAO().excluirFuncionario(ID);
    }

    @Override
    public boolean cadastrar(Funcionario e) {

        return new DAO.FuncionarioDAO().daoSalvarFuncionario(e);
    }

    @Override
    public boolean alterar(Funcionario e) {
        return new DAO.FuncionarioDAO().daoAlterarFuncionrio(e);
    }

}
