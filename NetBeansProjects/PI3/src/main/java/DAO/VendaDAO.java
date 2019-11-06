/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Vendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nik_r
 */
public class VendaDAO {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC", "root", "adminadmin");
        return conexao;
    }

    public static boolean daoSalvarVenda(Vendas v) {

        boolean retorno = false;

        try (Connection conexao = obterConexao()) {
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO PEDIDOVENDA (DATA, VALOR_TOTAL, FK_ID_CLIENTE)"
                    + " VALUES (?,?,?);");

            comandoSQL.setDate(1, (v.getData()));
            comandoSQL.setFloat(2, v.getValorTotal());
            comandoSQL.setInt(3, v.getIdCliente());

            int linhaAfetada = comandoSQL.executeUpdate();

            return linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public static int ultimoIDVenda() {

        int ID = 0;

        try (Connection conexao = obterConexao()) {
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT MAX(ID_VENDA) AS ID_VENDA FROM PEDIDOVENDA");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ID = rs.getInt("ID_VENDA");
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            ID = 0;
        }
        return ID;
    }
}
