package Controller;


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
 * @author nik_r
 */
public class ProdutoController {
    public static boolean cadastrarProduto(String nome,float valorUnitario, String Idioma,String categoria,int quantidade,int filial) {
        
        Produto produto = new Produto(nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return DAO.ProdutoDAO.daoSalvarProduto(produto);
    }
    
    public static boolean cadastrarProdutoLivro(String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        
        ProdutoLivro produto = new ProdutoLivro(editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        
        return DAO.ProdutoDAO.daoSalvarProdutoLivro(produto);
    }
    public static boolean cadastrarProdutoCdDvd(String tempo, String nome,float valorUnitario, String Idioma,String categoria,int quantidade,int filial) {
        
        ProdutoCdDvd produto = new ProdutoCdDvd(tempo, nome, valorUnitario, Idioma, categoria, quantidade, filial);
        
        return DAO.ProdutoDAO.daoSalvarCdDvd(produto);
    }
    
    public static ArrayList<Produto> getProduto() {

        ArrayList<Produto> produto = DAO.ProdutoDAO.getProdutos();

        return produto;
    }

    public static ArrayList<Produto> getProdutoFilter(String filter) {

        ArrayList<Produto> produto = DAO.ProdutoDAO.getProdutoFilter(filter);

        return produto;
    }

    public static boolean AlterarProduto() {
        Produto produto = new Produto();
        return DAO.ProdutoDAO.daoAlterarProduto(produto);
    }
    
    public static boolean excluirProduto(int ID){
        return DAO.ProdutoDAO.excluirDAOProduto(ID);
    }
}
