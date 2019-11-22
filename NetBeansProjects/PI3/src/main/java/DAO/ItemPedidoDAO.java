
package DAO;

import Classes.ItemPedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ItemPedidoDAO {

    private final static ArrayList<ItemPedido> lista = new ArrayList<>();

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://canes.cp2usnfank7u.us-east-1.rds.amazonaws.com:3306?useLegacyDatetimeCode=false&serverTimezone=America/Fortaleza&useTimezone=true", "admin", "Canes123");
        return conexao;
    }

    public boolean daoSalvarItem(ItemPedido item) {

        lista.add(item);
        return true;
    }

    public ArrayList<ItemPedido> getItens() {
        return ItemPedidoDAO.lista;
    }

    public static boolean daoSalvarItemBD(ItemPedido item, int ID) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO LIVRARIA.ITEMPEDIDO "
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

    public boolean daoExcluirItem() {

        lista.clear();

        return true;
    }

    public ArrayList<ItemPedido> getItensBD() {

        ArrayList<ItemPedido> itens = new ArrayList<>();

        try (Connection conexao = obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_ITEM, QUANTIDADE, VALOR_ITEM, ID_PRODUTO, "
                    + "ID_COMANDA, NOME_PRODUTO\n"
                    + "FROM LIVRARIA.ITEM_COMANDA");

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
