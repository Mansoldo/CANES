package DAO;

import Classes.Produto;
import Classes.Relatorio;
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

    public ArrayList<Relatorio> getRelatorioTop10(int filial) {

        ArrayList<Relatorio> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    d.NOME_FILIAL,\n"
                    + "    c.NOME_PRODUTO,\n"
                    + "    a.VALOR_ITEM,\n"
                    + "    SUM(a.QTD) QTD_ITEM,\n"
                    + "    SUM(a.QTD * a.VALOR_ITEM) VALOR_TOTAL\n"
                    + "FROM\n"
                    + "    LIVRARIA.ITEMPEDIDO a\n"
                    + "        INNER JOIN\n"
                    + "    LIVRARIA.PEDIDOVENDA b ON a.FK_ID_VENDA = b.ID_VENDA\n"
                    + "        INNER JOIN\n"
                    + "    LIVRARIA.PRODUTO c ON a.FK_ID_PROD = c.ID_PRODUTO\n"
                    + "        INNER JOIN\n"
                    + "    LIVRARIA.FILIAL d ON c.FK_ID_FILIAL = d.ID_FILIAL\n"
                    + "WHERE d.ID_FILIAL = ?\n"
                    + "GROUP BY 1 , 2\n"
                    + "ORDER BY 4 DESC\n"
                    + "LIMIT 10;");

            comandoSQL.setInt(1, filial);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Relatorio relatorio = new Relatorio();
                    relatorio.setNomeFilial(rs.getString("NOME_FILIAL"));
                    relatorio.setNomeProduto(rs.getString("NOME_PRODUTO"));
                    relatorio.setValorItem(rs.getDouble("VALOR_ITEM"));
                    relatorio.setQtdItem(rs.getInt("QTD_ITEM"));
                    relatorio.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    lista.add(relatorio);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Relatorio> getRelatorioTotalFilialDao(int filial) {

        ArrayList<Relatorio> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    b.NOME_FILIAL, SUM(a.VALOR_TOTAL) AS VALOR_TOTAL\n"
                    + "FROM\n"
                    + "    LIVRARIA.PEDIDOVENDA a\n"
                    + "        INNER JOIN\n"
                    + "    LIVRARIA.FILIAL b ON a.FK_ID_FILIAL = b.ID_FILIAL\n"
                    + "    WHERE b.ID_FILIAL = ?\n"
                    + "GROUP BY 1\n"
                    + "ORDER BY 2 DESC;");
            
            comandoSQL.setInt(1, filial);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Relatorio relatorio = new Relatorio();
                    relatorio.setNomeFilial(rs.getString("NOME_FILIAL"));
                    relatorio.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    lista.add(relatorio);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Relatorio> getRelatorioTotalFilialDaoTodos() {

        ArrayList<Relatorio> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT \n"
                    + "    b.NOME_FILIAL, SUM(a.VALOR_TOTAL) AS VALOR_TOTAL\n"
                    + "FROM\n"
                    + "    LIVRARIA.PEDIDOVENDA a\n"
                    + "        INNER JOIN\n"
                    + "    LIVRARIA.FILIAL b ON a.FK_ID_FILIAL = b.ID_FILIAL    \n"
                    + "GROUP BY 1\n"
                    + "ORDER BY 2 DESC;");            

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Relatorio relatorio = new Relatorio();
                    relatorio.setNomeFilial(rs.getString("NOME_FILIAL"));                    
                    relatorio.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    lista.add(relatorio);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

}
/*
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
