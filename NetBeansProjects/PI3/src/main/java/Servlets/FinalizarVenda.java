/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.ItemPedido;
import Classes.Vendas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nik_r
 */
@WebServlet(name = "FinalizarVenda", urlPatterns = {"/FinalizarVenda"})
public class FinalizarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/venda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idCliente = request.getParameter("idCli");
        ArrayList<ItemPedido> item = Controller.ItemPedidoController.getItens();

        float calcTot = 0;

        for (ItemPedido itens : item) {
            calcTot += itens.Valor_total();
        }

        Calendar c = Calendar.getInstance();
        Date hoje = c.getTime();
        java.sql.Date dataSql = new java.sql.Date(hoje.getTime());

        
        if (!idCliente.equals("?")) {
            int idClie = Integer.parseInt(idCliente);
            Vendas venda = new Vendas(dataSql, calcTot, idClie);
            boolean resulta = Controller.VendasController.finalizarVendaCliente(venda);
            request.setAttribute("resultaAtt", resulta);
        } else {
            Vendas venda = new Vendas(dataSql, calcTot);
            boolean resulta = Controller.VendasController.finalizarVenda(venda);
            request.setAttribute("resultaAtt", resulta);
        }
        
        

        Controller.ItemPedidoController.limparLista();

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/venda.jsp");
        dispatcher.forward(request, response);
    }

}
