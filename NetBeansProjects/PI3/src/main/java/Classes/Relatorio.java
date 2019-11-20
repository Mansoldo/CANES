package Classes;

public class Relatorio {

    private String nomeFilial;
    private String nomeProduto;
    private double valorItem;
    private int qtdItem;
    private double valorTotal;
    private double percentual;

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
    
    //Construtor Total Filial
    public Relatorio(String nomeFilial, double valorTotal){
        this.nomeFilial = nomeFilial;
        this.valorTotal = valorTotal;
    }
    
    //Construtor Percentual
    public Relatorio(String nomeFilial, double valorTotal, double percentual){
        this.nomeFilial = nomeFilial;
        this.valorTotal = valorTotal;
        this.percentual = percentual;
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

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
    

}
