/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Gabriel Vital
 */
public class ItemPedido {

    private int id;
    private int quantidade;
    private float valor;
    private int idProduto;
    private int idVenda;
    private String produto;

    public ItemPedido(int quantidade, float valor, int idproduto, String produto) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.idProduto = idproduto;
        this.produto = produto;
    }

    public ItemPedido(int id, int quantidade, float valor, int idproduto, int idVenda) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.idProduto = idproduto;
        this.idVenda = idVenda;
    }

    public ItemPedido() {
    }

     public float Valor_total() {
        return this.quantidade * this.valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
     
}
