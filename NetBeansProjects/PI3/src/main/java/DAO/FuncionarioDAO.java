/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
import Classes.Gerente;
import Classes.Vendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mansoldo
 */
public class FuncionarioDAO {
    
    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC", "root", "adminadmin"); //
        return conexao;
    }
    
    public static boolean daoSalvarAnalista(Analista funcionario){
        
        boolean retorno = false;
        
        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n" 
                    +"VALUES(?,?,?,?,?,?,?)");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());            
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;        
    }
    
    public static boolean daoSalvarBackOffice(BackOffice funcionario){
        
        boolean retorno = false;
        
        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n" 
                    +"VALUES(?,?,?,?,?,?,?)");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());            
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;        
    }
    
    public static boolean daoSalvarDiretor(Diretor funcionario){
        
        boolean retorno = false;
        
        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n" 
                    +"VALUES(?,?,?,?,?,?,?)");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());            
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;        
    }
    
    public static boolean daoSalvarVendedor(Vendedor funcionario){
        
        boolean retorno = false;
        
        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n" 
                    +"VALUES(?,?,?,?,?,?,?)");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());            
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;        
    }
    
    public static boolean daoSalvarGerente(Gerente funcionario){
        
        boolean retorno = false;
        
        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n" 
                    +"VALUES(?,?,?,?,?,?,?)");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());            
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;        
    }
    
    
    
}
