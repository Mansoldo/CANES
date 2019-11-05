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

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> cliente = new DAO.ClienteDAO().getCliente();
        return cliente;
    }

    public ArrayList<Cliente> getClientesFilter(String filter) {
        ArrayList<Cliente> cliente = new DAO.ClienteDAO().getClienteFilter(filter);
        return cliente;
    }

    public boolean excluirCliente(String cpf) {
        return new DAO.ClienteDAO().excluirDAOCliente(cpf);
    }

    @Override
    public boolean cadastrar(Cliente e) {
        return new DAO.ClienteDAO().daoSalvarCliente(e);
    }

    @Override
    public boolean alterar(Cliente e) {
        return new DAO.ClienteDAO().daoAlterarCliente(e);
    }
}
