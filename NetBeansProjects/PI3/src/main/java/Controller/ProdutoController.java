package Controller;

import Classes.ItemPedido;
import Classes.Produto;
import Classes.ProdutoCdDvd;
import Classes.ProdutoLivro;
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
public class ProdutoController /*implements AcoesCrud*/{

    public static boolean cadastrarProduto(String nome, float valorUnitario, String Idioma, String categoria, int quantidade, int filial) {
        Produto produto = new Produto(nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoSalvarProduto(produto);
    }

    public static boolean cadastrarProdutoLivro(String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoLivro produto = new ProdutoLivro(editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoSalvarProdutoLivro(produto);
    }

    public static boolean cadastrarProdutoCdDvd(String tempo, String nome, float valorUnitario, String Idioma, String categoria, int quantidade, int filial) {
        ProdutoCdDvd produto = new ProdutoCdDvd(tempo, nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoSalvarCdDvd(produto);
    }

    public static ArrayList<Produto> getProdutoGenerico(int id) {
        ArrayList<Produto> produto = DAO.ProdutoDAO.getProdutos(id);
        return produto;
    }
    
    public static ArrayList<ProdutoLivro> getProdutoLivro(int id) {
        ArrayList<ProdutoLivro> produto = DAO.ProdutoDAO.getProdutosLivros(id);
        return produto;
    }
    
    public static ArrayList<ProdutoCdDvd> getProdutoCdDvd(int id) {
        ArrayList<ProdutoCdDvd> produto = DAO.ProdutoDAO.getProdutosCdDvd(id);
        return produto;
    }

    public static ArrayList<Produto> getProdutoFilter(String filter) {
        ArrayList<Produto> produto = DAO.ProdutoDAO.getProdutoFilter(filter);
        return produto;
    }

    public static boolean AlterarProdutoLivro(int ID, String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoLivro produto = new ProdutoLivro(ID, editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoAlterarProdutoLivro(produto);
    }

    public static boolean AlterarProdutoCdDvd(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial, String tempo) {
        ProdutoCdDvd produto = new ProdutoCdDvd(ID, tempo, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoAlterarProdutoCdDvd(produto);
    }
    
    public static boolean AlterarProduto(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        Produto produto = new Produto(ID, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoAlterarProduto(produto);
    }
    
    public static boolean excluirProduto(int ID) {
        return DAO.ProdutoDAO.excluirDAOProduto(ID);
    }
}
