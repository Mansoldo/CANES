package Controller;

import Classes.AcoesCrud;
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
public class ProdutoController implements AcoesCrud<Produto> {

    /*
    public static boolean cadastrarProduto(String nome, float valorUnitario, String Idioma, String categoria, int quantidade, int filial) {
        Produto produto = new Produto(nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarProduto(produto);
    }

    public static boolean cadastrarProdutoLivro(String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoLivro produto = new ProdutoLivro(editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarProdutoLivro(produto);
    }

    public static boolean cadastrarProdutoCdDvd(String tempo, String nome, float valorUnitario, String Idioma, String categoria, int quantidade, int filial) {
        ProdutoCdDvd produto = new ProdutoCdDvd(tempo, nome, valorUnitario, Idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoSalvarCdDvd(produto);
    }
     */
    public ArrayList<Produto> getProdutoGenerico(int id) {
        ArrayList<Produto> produto = new DAO.ProdutoDAO().getProdutos(id);
        return produto;
    }

    public ArrayList<ProdutoLivro> getProdutoLivro(int id) {
        ArrayList<ProdutoLivro> produto = new DAO.ProdutoDAO().getProdutosLivros(id);
        return produto;
    }

    public ArrayList<ProdutoCdDvd> getProdutoCdDvd(int id) {
        ArrayList<ProdutoCdDvd> produto = new DAO.ProdutoDAO().getProdutosCdDvd(id);
        return produto;
    }

    public ArrayList<Produto> getProdutoFilter(String filter) {
        ArrayList<Produto> produto = new DAO.ProdutoDAO().getProdutoFilter(filter);
        return produto;
    }

    /*
    public static boolean AlterarProdutoLivro(int ID, String editora, String ISBN, int paginas, String autor, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        ProdutoLivro produto = new ProdutoLivro(ID, editora, ISBN, paginas, autor, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProdutoLivro(produto);
    }

    public static boolean AlterarProdutoCdDvd(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial, String tempo) {
        ProdutoCdDvd produto = new ProdutoCdDvd(ID, tempo, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProdutoCdDvd(produto);
    }

    public static boolean AlterarProduto(int ID, String nomeProduto, float valorUnitario, String idioma, String categoria, int quantidade, int filial) {
        Produto produto = new Produto(ID, nomeProduto, valorUnitario, idioma, categoria, quantidade, filial);
        return new DAO.ProdutoDAO().daoAlterarProduto(produto);
    }
     */
    public boolean excluirProduto(int ID) {
        return new DAO.ProdutoDAO().excluirDAOProduto(ID);
    }

    @Override
    public boolean cadastrar(Produto e) {
        if (e instanceof Produto) {
            return new DAO.ProdutoDAO().daoSalvarProduto(e);
        } else if (e instanceof ProdutoCdDvd) {
            ProdutoCdDvd produtoCd = (ProdutoCdDvd) e;
            return new DAO.ProdutoDAO().daoSalvarCdDvd(produtoCd);
        } else {
            ProdutoLivro produtoLivro = (ProdutoLivro) e;
            return new DAO.ProdutoDAO().daoSalvarProdutoLivro(produtoLivro);
        }
    }

    @Override
    public boolean alterar(Produto e) {

        if (e instanceof ProdutoCdDvd) {
            ProdutoCdDvd produtoCd = (ProdutoCdDvd) e;
            return new DAO.ProdutoDAO().daoAlterarProdutoCdDvd(produtoCd);
        } else if (e instanceof ProdutoLivro) {
            ProdutoLivro produtoLivro = (ProdutoLivro) e;
            return new DAO.ProdutoDAO().daoAlterarProdutoLivro(produtoLivro);
        } else {
            return new DAO.ProdutoDAO().daoAlterarProduto(e);
        }
    }
}
