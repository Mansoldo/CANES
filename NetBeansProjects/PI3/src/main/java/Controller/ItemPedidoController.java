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
        int calc = 0;
        ArrayList<Produto> p = new Controller.ProdutoController().getProdutoGenerico(idProd);
        ArrayList<ItemPedido> item2 = Controller.ItemPedidoController.getItens();
        for (Produto prod : p) {
            for (ItemPedido i : item2) {
                if (i.getIdProduto() == prod.getID()) {
                    calc += i.getQuantidade();
                }
            }
            calc += qtd;
            if (calc <= prod.getQuantidade()) {
                ItemPedido item = new ItemPedido(qtd, prod.getValorUnitario(), idProd, prod.getNomeProduto());
                calc = 0;
                result = new DAO.ItemPedidoDAO().daoSalvarItem(item);
            }
        }
        return result;
    }

    public static ArrayList<ItemPedido> getItens() {
        ArrayList<ItemPedido> lista = new DAO.ItemPedidoDAO().getItens();
        return lista;
    }

    public static void limparLista() {
        new DAO.ItemPedidoDAO().daoExcluirItem();
    }
}
