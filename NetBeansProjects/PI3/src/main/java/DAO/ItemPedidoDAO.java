/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.ItemPedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class ItemPedidoDAO {

    private final static ArrayList<ItemPedido> lista = new ArrayList<>();

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC", "root", "");
        return conexao;
    }

    public static boolean daoSalvarItem(ItemPedido item) {

        lista.add(item);
        return true;
    }

    public static ArrayList<ItemPedido> getItens() {
        return ItemPedidoDAO.lista;
    }

    public static boolean daoSalvarItemBD(ItemPedido item, int ID) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO ITEMPEDIDO "
                    + "(QTD, VALOR_ITEM, FK_ID_PROD, FK_ID_VENDA)\n"
                    + " VALUES (?,?,?,?);");

            comandoSQL.setInt(1, item.getQuantidade());
            comandoSQL.setFloat(2, item.getValor());
            comandoSQL.setInt(3, item.getIdProduto());
            comandoSQL.setInt(4, ID);
            

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }

        return retorno;
    }

    public static boolean daoExcluirItem() {

        lista.clear();

        return true;
    }

    public static ArrayList<ItemPedido> getItensBD() {

        ArrayList<ItemPedido> itens = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_ITEM, QUANTIDADE, VALOR_ITEM, ID_PRODUTO, "
                    + "ID_COMANDA, NOME_PRODUTO\n"
                    + "FROM ITEM_COMANDA");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ItemPedido item = new ItemPedido();
                    item.setQuantidade(rs.getInt("QUANTIDADE"));
                    item.setIdProduto(rs.getInt("ID_PRODUTO"));
                    itens.add(item);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            itens = null;
        }

        return itens;

    }
}
