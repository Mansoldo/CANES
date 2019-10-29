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
public class ProdutoLivro extends Produto {
    private String editora;
    private String autor;
    private String ISBN;
    private int paginas;
    private int ID;

    public ProdutoLivro() {
        super();
    }

    public ProdutoLivro(String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        super(nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        this.editora = editora;
        this.ISBN = ISBN;
        this.paginas = paginas;
        this.autor = autor;
    }

    public ProdutoLivro(int ID, String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        super(nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        this.editora = editora;
        this.ISBN = ISBN;
        this.paginas = paginas;
        this.autor = autor;
        this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

}
