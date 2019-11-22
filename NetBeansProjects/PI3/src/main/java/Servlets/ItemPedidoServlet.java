/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.ItemPedido;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Vital
 */
@WebServlet(name = "ItemPedido", urlPatterns = {"/ItemPedido"})
public class ItemPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idProduto = request.getParameter("idProd");
        String quantidade = request.getParameter("quantidade__produto__selecionado");

        if (!idProduto.equals("?") && quantidade != null) {

            idProduto = request.getParameter("idProd");
            quantidade = request.getParameter("quantidade__produto__selecionado");

            int id = Integer.parseInt(idProduto);
            int qtd = Integer.parseInt(quantidade);
            
            if (qtd > 0) {

                boolean result = Controller.ItemPedidoController.salvarItem(id, qtd);

                ArrayList<ItemPedido> lista = Controller.ItemPedidoController.getItens();
                request.setAttribute("produtoList", lista);

                float calculoTotal = 0;
                for (ItemPedido itens : lista) {
                    calculoTotal += itens.Valor_total();
                }
                request.setAttribute("valorTotal", calculoTotal);
                request.setAttribute("adicionarAtt", result);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/WEB-INF/venda.jsp");
                dispatcher.forward(request, response);

            } else {
                
                boolean qtdNegativo = true;
                request.setAttribute("quantidadeNegativa", qtdNegativo);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/WEB-INF/venda.jsp");
                dispatcher.forward(request, response);
                
            }

        } else {

            boolean semItem = true;

            request.setAttribute("semProduto", semItem);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/venda.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/venda.jsp");
        dispatcher.forward(request, response);
    }

}
