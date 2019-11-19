package Classes;

public class Relatorio {

    private String nomeFilial;
    private String nomeProduto;
    private double valorItem;
    private int qtdItem;
    private double valorTotal;

    public Relatorio() {

    }

    //Construtor TOP 10
    public Relatorio(String nomeFilial, String nomeProduto, double valorItem, int qtdItem, double valorTotal) {
        this.nomeFilial = nomeFilial;
        this.nomeProduto = nomeProduto;
        this.valorItem = valorItem;
        this.qtdItem = qtdItem;
        this.valorTotal = valorTotal;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
