/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Mansoldo
 */
public class BackOffice extends Funcionario {

    public BackOffice() {
        super();
    }

    public BackOffice(String login, String senha, String cpf,
            String nome_func, String cargo, int departamento, int filial) {
        super(login, senha, cpf, nome_func, cargo, departamento, filial);
    }

    public BackOffice(int ID, String login, String senha, String cpf,
            String nome_func, String cargo, int departamento, int filial) {
        super(ID, login, senha, cpf, nome_func, cargo, departamento, filial);
    }

}
