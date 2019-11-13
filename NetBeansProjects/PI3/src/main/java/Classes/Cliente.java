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
public class Cliente {

    private int ID;

    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String sexo;
    private String email;
    private String telefone;

    public Cliente(String nome, String cpf, LocalDate data, String sexo, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = data;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente() {

    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", data=" + nascimento + ", sexo=" + sexo + ", email=" + email + ", telefone=" + telefone + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
