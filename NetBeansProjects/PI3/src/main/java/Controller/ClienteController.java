/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Cliente;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class ClienteController {

    public static boolean cadastrarCliente(String nome, String cpf, String nascimento, String sexo, String email, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, nascimento, sexo, email, telefone);
        return DAO.ClienteDAO.daoSalvarCliente(cliente);
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
        Cliente cliente = new Cliente(nome, cpf, email, sexo, email, telefone);
        return DAO.ClienteDAO.daoAlterarCliente(cliente);
    }
    
    public static boolean excluirCliente(String cpf){
        return DAO.ClienteDAO.excluirDAOCliente(cpf);
    }
}
