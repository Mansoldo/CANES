/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.time.LocalDate;

/**
 *
 * @author nik_r
 */
public class Vendas {
    private int id;
    private LocalDate data;
    private float valorTotal;
    private int idCliente;

    public Vendas() {
    }

    public Vendas(LocalDate data, float valorTotal) {
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Vendas(int id, LocalDate data, float valorTotal, int idCliente) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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
    
}
