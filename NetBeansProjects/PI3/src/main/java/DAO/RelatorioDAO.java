package DAO;
/*
import Classes.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelatorioDAO {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC", "root", "adminadmin");
        return conexao;
    }

    public boolean daoConsultaTopFilter() {

        ArrayList<String[]> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }

        boolean retorno = false;

        return retorno;

    }

    public boolean daoConsultaTopGeral() {
        ArrayList<String[]> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("");

            comandoSQL.setInt(1, id);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean daoConsultaPercentualFilter() {
        ArrayList<String[]> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("");

            comandoSQL.setInt(1, id);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean daoConsultaPercentualGeral() {
        ArrayList<String[]> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("");

            comandoSQL.setInt(1, id);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean daoConsultaValorFilter() {
        ArrayList<String[]> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("");

            comandoSQL.setInt(1, id);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean daoConsultaValorGeral() {
        ArrayList<String[]> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("");

            comandoSQL.setInt(1, id);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

}
*/