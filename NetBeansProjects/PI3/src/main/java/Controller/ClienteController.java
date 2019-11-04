/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.AcoesCrud;
import Classes.Cliente;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Gabriel Vital
 */
public class ClienteController implements AcoesCrud<Cliente> {

    public static boolean cadastrarCliente(String nome, String cpf, String nascimento, String sexo, String email, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, nascimento, sexo, email, telefone);
        return DAO.ClienteDAO.excluirDAOCliente(cpf);
    }

    public static ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> cliente = DAO.ClienteDAO.getCliente();
        return cliente;
    }

    public static ArrayList<Cliente> getClientesFilter(String filter) {
        ArrayList<Cliente> cliente = DAO.ClienteDAO.getClienteFilter(filter);
        return cliente;
    }

    public static boolean AlterarCliente(String nome, String cpf, String nascimento, String sexo, String email, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, nascimento, sexo, email, telefone);
        return DAO.ClienteDAO.daoAlterarCliente(cliente);
    }

    public static boolean excluirCliente(String cpf) {
        return DAO.ClienteDAO.excluirDAOCliente(cpf);
    }

    @Override
    public boolean cadastrar(Cliente e) {
        return DAO.ClienteDAO.daoSalvarCliente(e);
    }

    @Override
    public boolean alterar(Cliente e) {
        return DAO.ClienteDAO.daoAlterarCliente(e);
    }

    @Override
    public boolean excluir(Cliente e) {
        return DAO.ClienteDAO.excluirDAOCliente(e);
    }

}
