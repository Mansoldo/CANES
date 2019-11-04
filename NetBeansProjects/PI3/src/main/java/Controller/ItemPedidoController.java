/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.ItemPedido;
import Classes.Produto;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class ItemPedidoController {

    public static boolean salvarItem(int idProd, int qtd) {
        boolean result = false;
        ArrayList<Produto> p = Controller.ProdutoController.getProdutoGenerico(idProd);
        for (Produto prod : p) {
            ItemPedido item = new ItemPedido(qtd, prod.getValorUnitario(), idProd, prod.getNomeProduto());
            result = DAO.ItemPedidoDAO.daoSalvarItem(item);
        }
        return result;
    }

    public static ArrayList<ItemPedido> getItens() {
        ArrayList<ItemPedido> lista = DAO.ItemPedidoDAO.getItens();
        return lista;
    }

    public static void limparLista() {
        DAO.ItemPedidoDAO.daoExcluirItem();
    }
}
