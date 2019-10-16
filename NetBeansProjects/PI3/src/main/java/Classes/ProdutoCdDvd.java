/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author nik_r
 */
public class ProdutoCdDvd extends Produto {

    private String tempo;

    public ProdutoCdDvd(String tempo, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        super(nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        this.tempo = tempo;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

}
