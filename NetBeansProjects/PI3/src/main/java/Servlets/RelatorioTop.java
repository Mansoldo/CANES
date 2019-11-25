package Servlets;

import Classes.Funcionario;
import Classes.Relatorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RelatorioTop", urlPatterns = {"/RelatorioTop"})
public class RelatorioTop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");

        String filialStr = request.getParameter("filial");
        int filial;
        boolean naoAutorizado = false;

        if (filialStr.equals("Matriz")) {
            filial = 1;
        } else if (filialStr.equals("Brasilia")) {
            filial = 2;
        } else if (filialStr.equals("Campina Grande")) {
            filial = 3;
        } else if (filialStr.equals("Joinville")) {
            filial = 4;
        } else {
            filial = 5;
        }

        if ((funcionario.getCargo().equals("Diretor") || funcionario.getCargo().equals("Analista") || funcionario.getCargo().equals("Gerente_Global")) && filial != 5) {

            ArrayList<Relatorio> relatorio = new Controller.RelatorioController().getRelatorioTop10(filial);
            request.setAttribute("relatorioTop", relatorio);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 1 && funcionario.getCargo().equals("Gerente") && (filial == 2 || filial == 3 || filial == 4)) {

            naoAutorizado = true;
            request.setAttribute("naoAutorizado", naoAutorizado);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 1 && filial == 1 && funcionario.getCargo().equals("Gerente")) {

            ArrayList<Relatorio> relatorio = new Controller.RelatorioController().getRelatorioTop10(filial);
            request.setAttribute("relatorioTop", relatorio);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 2 && funcionario.getCargo().equals("Gerente") && (filial == 1 || filial == 3 || filial == 4)) {

            naoAutorizado = true;
            request.setAttribute("naoAutorizado", naoAutorizado);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 2 && filial == 2 && funcionario.getCargo().equals("Gerente")) {

            ArrayList<Relatorio> relatorio = new Controller.RelatorioController().getRelatorioTop10(filial);
            request.setAttribute("relatorioTop", relatorio);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 3 && funcionario.getCargo().equals("Gerente") && (filial == 1 || filial == 2 || filial == 4)) {

            naoAutorizado = true;
            request.setAttribute("naoAutorizado", naoAutorizado);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 3 && filial == 3 && funcionario.getCargo().equals("Gerente")) {

            ArrayList<Relatorio> relatorio = new Controller.RelatorioController().getRelatorioTop10(filial);
            request.setAttribute("relatorioTop", relatorio);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 4 && funcionario.getCargo().equals("Gerente") && (filial == 1 || filial == 2 || filial == 3)) {

            naoAutorizado = true;
            request.setAttribute("naoAutorizado", naoAutorizado);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else if (funcionario.getFilial() == 4 && filial == 4 && funcionario.getCargo().equals("Gerente")) {

            ArrayList<Relatorio> relatorio = new Controller.RelatorioController().getRelatorioTop10(filial);
            request.setAttribute("relatorioTop", relatorio);

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        } else {
            
            boolean naoDefinido = true;
            request.setAttribute("definicaoRelatorio", naoDefinido);
            
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/relatorio-top-vendidos.jsp");
            dispatcher.forward(request, response);

        }
    }
}
