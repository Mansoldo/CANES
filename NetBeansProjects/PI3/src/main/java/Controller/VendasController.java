/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.ItemPedido;
import Classes.Vendas;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Vital
 */
public class VendasController {

    public static boolean finalizarVenda(Vendas venda) {

        boolean salvo = false;

        salvo =  new DAO.VendaDAO().daoSalvarVenda(venda);

        if (salvo == true) {

            int UltimoIDVenda = new DAO.VendaDAO().ultimoIDVenda();

            ArrayList<ItemPedido> item = Controller.ItemPedidoController.getItens();
            for (ItemPedido lista : item) {

                DAO.ItemPedidoDAO.daoSalvarItemBD(lista, UltimoIDVenda);
                new Controller.ProdutoController().atualizarEstoque(lista.getIdProduto(), lista.getQuantidade());
            }
        }
        return salvo;
    }

    public static boolean finalizarVendaCliente(Vendas venda) {

        boolean salvo = false;

        salvo = new DAO.VendaDAO().daoSalvarVendaCliente(venda);

        if (salvo == true) {

            int UltimoIDVenda = new DAO.VendaDAO().ultimoIDVenda();

            ArrayList<ItemPedido> item = Controller.ItemPedidoController.getItens();
            for (ItemPedido lista : item) {

                DAO.ItemPedidoDAO.daoSalvarItemBD(lista, UltimoIDVenda);
                new Controller.ProdutoController().atualizarEstoque(lista.getIdProduto(), lista.getQuantidade());

            }
        }
        return salvo;
    }

}
