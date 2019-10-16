
package DAO;

import Classes.Cliente;
import Classes.Produto;
import Classes.ProdutoCdDvd;
import Classes.ProdutoLivro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoDAO {
     private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC", "root", "adminadmin");
        return conexao;
    }

    public static boolean daoSalvarProduto(Produto produto) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.PRODUTO(NOME_PRODUTO,VALOR_UNIT,IDIOMA,CATEGORIA,QTD,FK_ID_FILIAL)\n"
                    + "VALUES (?,?,?,?,?,?)");

            comandoSQL.setString(1, produto.getNomeProduto());
            comandoSQL.setFloat(2, produto.getValorUnitario());
            comandoSQL.setString(3, produto.getIdioma());
            comandoSQL.setString(4, produto.getCategoria());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, produto.getFilial());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public static boolean daoSalvarProdutoLivro(ProdutoLivro produto) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.PRODUTO(NOME_PRODUTO,VALOR_UNIT,IDIOMA,CATEGORIA,QTD,FK_ID_FILIAL,EDITORA,AUTOR,ISBN,PAGINAS)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)");

            comandoSQL.setString(1, produto.getNomeProduto());
            comandoSQL.setFloat(2, produto.getValorUnitario());
            comandoSQL.setString(3, produto.getIdioma());
            comandoSQL.setString(4, produto.getCategoria());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, produto.getFilial());
            comandoSQL.setString(7, produto.getEditora());
            comandoSQL.setString(8, produto.getAutor());
            comandoSQL.setString(9, produto.getISBN());
            comandoSQL.setInt(10, produto.getPaginas());
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    public static boolean daoSalvarCdDvd(ProdutoCdDvd produto) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.PRODUTO(NOME_PRODUTO,VALOR_UNIT,IDIOMA,CATEGORIA,QTD,FK_ID_FILIAL,TEMPO)\n"
                    + "VALUES (?,?,?,?,?,?,?)");

            comandoSQL.setString(1, produto.getNomeProduto());
            comandoSQL.setFloat(2, produto.getValorUnitario());
            comandoSQL.setString(3, produto.getIdioma());
            comandoSQL.setString(4, produto.getCategoria());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, produto.getFilial());
            comandoSQL.setString(7, produto.getTempo());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    
    public static ArrayList<Produto> getProdutos() {

        ArrayList<Produto> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM PRODUTO");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setNomeProduto(rs.getString("NOME_PRODUTO"));
                    produto.setValorUnitario(rs.getFloat("VALOR_UNIT"));
                    produto.setIdioma(rs.getString("IDIOMA"));
                    produto.setCategoria(rs.getString("CATEGORIA"));
                    produto.setQuantidade(rs.getInt("QTD"));
                    produto.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static ArrayList<Produto> getProdutoFilter(String filter) {

        ArrayList<Produto> lista = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Produto where CPF like '%" + filter + "%' or NOME like '%" + filter + "%'");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setID(rs.getInt("ID_PRODUTO"));
                    produto.setNomeProduto(rs.getString("NOME_PRODUTO"));
                    produto.setValorUnitario(rs.getFloat("VALOR_UNIT"));
                    produto.setIdioma(rs.getString("IDIOMA"));
                    produto.setCategoria(rs.getString("CATEGORIA"));
                    produto.setQuantidade(rs.getInt("QTD"));
                    produto.setFilial(rs.getInt("FK_ID_FILIAL"));
                    lista.add(produto);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            lista = null;
            ex.printStackTrace();
        }
        return lista;
    }

    public static boolean daoAlterarProduto(Produto produto) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE LIVRARIA.CLIENTE\n"
                    + "SET NOME_PRODUTO = ? ,VALOR_UNIT = ? ,IDIOMA = ? ,CATEGORIA = ? ,QTD = ? ,FK_ID_FILIAL = ? \n"
                    + "WHERE ID_PRODUTO = ?;");

            comandoSQL.setString(1, produto.getNomeProduto());
            comandoSQL.setFloat(2, produto.getValorUnitario());
            comandoSQL.setString(3, produto.getIdioma());
            comandoSQL.setString(4, produto.getCategoria());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setInt(6, produto.getFilial());
            comandoSQL.setInt(7, produto.getID());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public static boolean excluirDAOProduto(int ID) {
        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM Produto WHERE ID_PRODUTO =?");

            comandoSQL.setInt(1, ID);

            int linhasAfetadas = comandoSQL.executeUpdate();
            
            retorno = linhasAfetadas > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
}
