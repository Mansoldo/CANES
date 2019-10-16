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
public class Analista extends Funcionario {

    public Analista() {
        super();
    }

    public Analista(String login, String senha, String cpf,
            String nome_func, String cargo, int departamento, int filial) {
        super(login, senha, cpf, nome_func, cargo, departamento, filial);
    }

}
