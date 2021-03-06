/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Vital
 */
public class ClienteDAO {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://canes.cp2usnfank7u.us-east-1.rds.amazonaws.com:3306?useLegacyDatetimeCode=false&serverTimezone=America/Fortaleza&useTimezone=true", "admin", "Canes123");
        return conexao;
    }

    public boolean daoSalvarCliente(Cliente cliente) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.CLIENTE(NOME,CPF,DATA_NASC,SEXO,EMAIL,TELEFONE)\n"
                    + "VALUES (?,?,?,?,?,?)");

            comandoSQL.setString(1, cliente.getNome());
            comandoSQL.setString(2, cliente.getCpf());
            comandoSQL.setDate(3, java.sql.Date.valueOf(cliente.getNascimento()));
            comandoSQL.setString(4, cliente.getSexo());
            comandoSQL.setString(5, cliente.getEmail());
            comandoSQL.setString(6, cliente.getTelefone());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public ArrayList<Cliente> getCliente() {

        ArrayList<Cliente> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.CLIENTE");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setNome(rs.getString("NOME"));
                    cliente.setCpf(rs.getString("CPF"));
                    cliente.setNascimento(rs.getDate("DATA_NASC").toLocalDate());
                    cliente.setSexo(rs.getString("SEXO"));
                    cliente.setEmail(rs.getString("EMAIL"));
                    cliente.setTelefone(rs.getString("TELEFONE"));
                    lista.add(cliente);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Cliente> getClienteFilter(String filter) {

        ArrayList<Cliente> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.CLIENTE where CPF like '%" + filter + "%' or NOME like '%" + filter + "%'");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setID(rs.getInt("ID_CLIENTE"));
                    cliente.setNome(rs.getString("NOME"));
                    cliente.setCpf(rs.getString("CPF"));
                    cliente.setNascimento(rs.getDate("DATA_NASC").toLocalDate());
                    cliente.setSexo(rs.getString("SEXO"));
                    cliente.setEmail(rs.getString("EMAIL"));
                    cliente.setTelefone(rs.getString("TELEFONE"));
                    lista.add(cliente);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean daoAlterarCliente(Cliente cliente) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.CLIENTE\n"
                    + "SET NOME = ?,CPF= ?,DATA_NASC= ?,SEXO= ?,EMAIL= ?,TELEFONE= ?\n"
                    + "WHERE CPF = ?;");

            comandoSQL.setString(1, cliente.getNome());
            comandoSQL.setString(2, cliente.getCpf());
            comandoSQL.setDate(3, java.sql.Date.valueOf(cliente.getNascimento()));
            comandoSQL.setString(4, cliente.getSexo());
            comandoSQL.setString(5, cliente.getEmail());
            comandoSQL.setString(6, cliente.getTelefone());
            comandoSQL.setString(7, cliente.getCpf());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean excluirDAOCliente(String cpf) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM LIVRARIA.CLIENTE WHERE CPF =?");

            comandoSQL.setString(1, cpf);

            int linhasAfetadas = comandoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }


}
