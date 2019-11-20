package Controller;

import Classes.Produto;
import Classes.Relatorio;
import java.util.ArrayList;

public class RelatorioController {

    public ArrayList<Relatorio> getRelatorioTop10(int filial) {

        ArrayList<Relatorio> relatorio = new DAO.RelatorioDAO().getRelatorioTop10(filial);
        return relatorio;
    }

    public ArrayList<Relatorio> getRelatorioTotalFilial(int filial) {

        if (filial == 5) {
            ArrayList<Relatorio> relatorio = new DAO.RelatorioDAO().getRelatorioTotalFilialDaoTodos();
            return relatorio;

        } else {
            ArrayList<Relatorio> relatorio = new DAO.RelatorioDAO().getRelatorioTotalFilialDao(filial);
            return relatorio;
        }

    }

}
