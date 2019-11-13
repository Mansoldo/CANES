/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author nik_r
 */
public class Vendas {

    private int id;
    private Date data;
    private float valorTotal;
    private int idCliente;
    private int idFilial;

    public Vendas() {
    }

    public Vendas(Date data, float valorTotal, int idFilial) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.idFilial = idFilial;
    }

    public Vendas(Date data, float valorTotal, int idCliente, int idFilial) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
        this.idFilial = idFilial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

}
