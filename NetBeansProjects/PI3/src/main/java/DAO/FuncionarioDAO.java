/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Analista;
import Classes.BackOffice;
import Classes.Diretor;
import Classes.Funcionario;
import Classes.Gerente;
import Classes.Vendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mansoldo
 */
public class FuncionarioDAO {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://canesdb.c6rp7koaks1z.us-east-1.rds.amazonaws.com:3306", "admin", "Canes123"); //
        return conexao;
    }

    public static boolean daoSalvarAnalista(Analista funcionario) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n"
                    + "VALUES(?,?,?,?,?,?,?)");

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

    public static boolean daoSalvarBackOffice(BackOffice funcionario) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n"
                    + "VALUES(?,?,?,?,?,?,?)");

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

    public static boolean daoSalvarDiretor(Diretor funcionario) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n"
                    + "VALUES(?,?,?,?,?,?,?)");

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

    public static boolean daoSalvarVendedor(Vendedor funcionario) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n"
                    + "VALUES(?,?,?,?,?,?,?)");

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

    public static boolean daoSalvarGerente(Gerente funcionario) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN, SENHA, CPF, NOME_FUNC, CARGO, FK_ID_DPT, FK_ID_FILIAL)\n"
                    + "VALUES(?,?,?,?,?,?,?)");

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

    public static ArrayList<Analista> getAnalista(int ID) {

        ArrayList<Analista> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.FUNCIONARIO WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, ID);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Analista funcionario = new Analista();
                    funcionario.setLogin(rs.getString("LOGIN"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome_func(rs.getString("NOME_FUNC"));
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setDepartamento(rs.getInt("FK_ID_DPT"));
                    funcionario.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<BackOffice> getBackOffice(int ID) {

        ArrayList<BackOffice> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.FUNCIONARIO WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, ID);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BackOffice funcionario = new BackOffice();
                    funcionario.setLogin(rs.getString("LOGIN"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome_func(rs.getString("NOME_FUNC"));
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setDepartamento(rs.getInt("FK_ID_DPT"));
                    funcionario.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<Diretor> getDiretor(int ID) {

        ArrayList<Diretor> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.FUNCIONARIO WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, ID);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Diretor funcionario = new Diretor();
                    funcionario.setLogin(rs.getString("LOGIN"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome_func(rs.getString("NOME_FUNC"));
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setDepartamento(rs.getInt("FK_ID_DPT"));
                    funcionario.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<Gerente> getGerente(int ID) {

        ArrayList<Gerente> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.FUNCIONARIO WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, ID);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Gerente funcionario = new Gerente();
                    funcionario.setLogin(rs.getString("LOGIN"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome_func(rs.getString("NOME_FUNC"));
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setDepartamento(rs.getInt("FK_ID_DPT"));
                    funcionario.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<Vendedor> getVendedor(int ID) {

        ArrayList<Vendedor> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.FUNCIONARIO WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, ID);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Vendedor funcionario = new Vendedor();
                    funcionario.setLogin(rs.getString("LOGIN"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome_func(rs.getString("NOME_FUNC"));
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setDepartamento(rs.getInt("FK_ID_DPT"));
                    funcionario.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<Funcionario> getFuncionarioFilter(String filter) {

        ArrayList<Funcionario> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM LIVRARIA.FUNCIONARIO WHERE CPF LIKE '%" + filter + "%' OR NOME_FUNC LIKE '%" + filter + "%' OR CARGO LIKE '%" + filter + "%' OR FK_ID_FILIAL LIKE '%" + filter + "%'");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId_func(rs.getInt("ID_FUNCIONARIO"));
                    funcionario.setLogin(rs.getString("LOGIN"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setNome_func(rs.getString("NOME_FUNC"));
                    funcionario.setCargo(rs.getString("CARGO"));
                    funcionario.setDepartamento(rs.getInt("FK_ID_DPT"));
                    funcionario.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(funcionario);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static boolean excluirFuncionario(int ID) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM LIVRARIA.FUNCIONARIO WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, ID);

            int linhasAfetadas = comandoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public static boolean daoAlterarAnalista(Analista funcionario) {
        
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.FUNCIONARIO\n"
                    + "SET LOGIN = ? , SENHA = ? , CPF = ? , NOME_FUNC = ? , CARGO = ? , FK_ID_DPT = ?, FK_ID_FILIAL = ?\n"
                    + "WHERE ID_FUNCIONARIO = ?;");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());
            comandoSQL.setInt(8, funcionario.getId_func());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    public static boolean daoAlterarBackOffice(BackOffice funcionario) {
        
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.FUNCIONARIO\n"
                    + "SET LOGIN = ? , SENHA = ? , CPF = ? , NOME_FUNC = ? , CARGO = ? , FK_ID_DPT = ?, FK_ID_FILIAL = ?\n"
                    + "WHERE ID_FUNCIONARIO = ?;");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());
            comandoSQL.setInt(8, funcionario.getId_func());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    public static boolean daoAlterarDiretor(Diretor funcionario) {
        
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.FUNCIONARIO\n"
                    + "SET LOGIN = ? , SENHA = ? , CPF = ? , NOME_FUNC = ? , CARGO = ? , FK_ID_DPT = ?, FK_ID_FILIAL = ?\n"
                    + "WHERE ID_FUNCIONARIO = ?;");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());
            comandoSQL.setInt(8, funcionario.getId_func());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    public static boolean daoAlterarGerente(Gerente funcionario) {
        
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.FUNCIONARIO\n"
                    + "SET LOGIN = ? , SENHA = ? , CPF = ? , NOME_FUNC = ? , CARGO = ? , FK_ID_DPT = ?, FK_ID_FILIAL = ?\n"
                    + "WHERE ID_FUNCIONARIO = ?;");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());
            comandoSQL.setInt(8, funcionario.getId_func());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    public static boolean daoAlterarVendedor(Vendedor funcionario) {
        
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.FUNCIONARIO\n"
                    + "SET LOGIN = ? , SENHA = ? , CPF = ? , NOME_FUNC = ? , CARGO = ? , FK_ID_DPT = ?, FK_ID_FILIAL = ?\n"
                    + "WHERE ID_FUNCIONARIO = ?;");

            comandoSQL.setString(1, funcionario.getLogin());
            comandoSQL.setString(2, funcionario.getSenha());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getNome_func());
            comandoSQL.setString(5, funcionario.getCargo());
            comandoSQL.setInt(6, funcionario.getDepartamento());
            comandoSQL.setInt(7, funcionario.getFilial());
            comandoSQL.setInt(8, funcionario.getId_func());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    

}
