package Controller;

import Classes.Funcionario;
import Classes.Produto;
import Classes.ProdutoCdDvd;
import Classes.ProdutoLivro;
import Classes.ProdutoManga;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel Vital
 */
public class ProdutoController {

    
    public boolean cadastrarProduto(String nome, float valorUnitario, String Idioma, String categoria, int quantidade, int filial) {
        Produto produto = new Produto(nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarProduto(produto);
    }

    public boolean cadastrarProdutoLivro(String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoLivro produto = new ProdutoLivro(editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarProdutoLivro(produto);
    }

    public boolean cadastrarProdutoCdDvd(String tempo, String nome, float valorUnitario, String Idioma, String categoria, int quantidade, int filial) {
        ProdutoCdDvd produto = new ProdutoCdDvd(tempo, nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarCdDvd(produto);
    }
    
        public boolean cadastrarProdutoManga(String editora, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoManga produto = new ProdutoManga(editora, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarProdutoManga(produto);
    }
     
    public ArrayList<Produto> getProdutoGenerico(int id) {
        ArrayList<Produto> produto = new DAO.ProdutoDAO().getProdutos(id);
        return produto;
    }

    public ArrayList<ProdutoLivro> getProdutoLivro(int id) {
        ArrayList<ProdutoLivro> produto = new DAO.ProdutoDAO().getProdutosLivros(id);
        return produto;
    }
    
    public ArrayList<ProdutoManga> getProdutoManga(int id) {
        ArrayList<ProdutoManga> produto = new DAO.ProdutoDAO().getProdutosManga(id);
        return produto;
    }

    public ArrayList<ProdutoCdDvd> getProdutoCdDvd(int id) {
        ArrayList<ProdutoCdDvd> produto = new DAO.ProdutoDAO().getProdutosCdDvd(id);
        return produto;
    }

    public ArrayList<Produto> getProdutoFilter(String filter, int filial_func) {
        ArrayList<Produto> produto = new DAO.ProdutoDAO().getProdutoFilter(filter, filial_func);
        return produto;
    }

    
    public boolean AlterarProdutoLivro(int ID, String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoLivro produto = new ProdutoLivro(ID, editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProdutoLivro(produto);
    }

    public boolean AlterarProdutoCdDvd(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial, String tempo) {
        ProdutoCdDvd produto = new ProdutoCdDvd(ID, tempo, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProdutoCdDvd(produto);
    }

    public boolean AlterarProduto(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        Produto produto = new Produto(ID, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProduto(produto);
    }
    
    public boolean AlterarProdutoManga(int ID, String editora, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoManga produto = new ProdutoManga(ID, editora, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProdutoManga(produto);
    }
     
    public boolean excluirProduto(int ID) {
        return new DAO.ProdutoDAO().excluirDAOProduto(ID);
    }
    
    public boolean atualizarEstoque(int id, int qtd){
        return new DAO.ProdutoDAO().daoAtualizarEstoque(id, qtd);
    }
}
