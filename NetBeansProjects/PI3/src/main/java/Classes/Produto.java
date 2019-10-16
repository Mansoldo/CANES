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
public class Produto {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    private String nomeProduto;
    private float valorUnitario;
    private String idioma;
    private String categoria;
    private int quantidade;
    private int filial;

    public Produto() {
    }

    public Produto(String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.idioma = idioma;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.filial = filial;
    }

    public Produto(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        this.ID = ID;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.idioma = idioma;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.filial = filial;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

}
