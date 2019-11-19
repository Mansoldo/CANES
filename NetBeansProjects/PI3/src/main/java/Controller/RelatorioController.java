package Controller;

import Classes.Produto;
import Classes.Relatorio;
import java.util.ArrayList;

public class RelatorioController {

    public ArrayList<Relatorio> getRelatorioTop10(int filial) {
        
        ArrayList<Relatorio> relatorio = new DAO.RelatorioDAO().getRelatorioTop10(filial);
        return relatorio;
    }

}
