package Servlets;

import Classes.Cliente;
import Classes.ItemPedido;
import Classes.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Vender", urlPatterns = {"/Vender"})
public class Vender extends HttpServlet {

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

        String filter = request.getParameter("pesquisar__produto");
        String filter2 = request.getParameter("pesquisar__cliente");

        ArrayList<Produto> produto = new Controller.ProdutoController().getProdutoFilter(filter);
        request.setAttribute("produtoAtt", produto);

        ArrayList<ItemPedido> lista = Controller.ItemPedidoController.getItens();
        request.setAttribute("produtoList", lista);
        ArrayList<Cliente> cliente = new Controller.ClienteController().getClientesFilter(filter2);
        request.setAttribute("clienteAtt", cliente);
        
        float calculoTotal = 0;
        for (ItemPedido itens : lista) {
            calculoTotal += itens.Valor_total();
        }
        request.setAttribute("valorTotal", calculoTotal);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/venda.jsp");
        dispatcher.forward(request, response);
    }

}
