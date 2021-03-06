/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Mansoldo
 */
public class Funcionario {

    private int id_func;
    private String login;
    private String senha;
    private String cpf;
    private String nome_func;
    private String cargo;
    private int id_departamento;
    private int id_filial; //variável temporária
    //private Filial filial;
    

    public Funcionario() {

    }

    public Funcionario(String login, String senha, String cpf, 
            String nome_func, String cargo, int departamento, int filial) {
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nome_func = nome_func;
        this.cargo = cargo;
        this.id_departamento = departamento;
        this.id_filial = filial;
    }
    
    public Funcionario(int ID, String login, String senha, String cpf, 
            String nome_func, String cargo, int departamento, int filial) {
        this.id_func = ID;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.nome_func = nome_func;
        this.cargo = cargo;
        this.id_departamento = departamento;
        this.id_filial = filial;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    
    public final void setSenhaHash(String senha){
     this.senha = BCrypt.hashpw(senha, BCrypt.gensalt())   ;
    }    
    
    public boolean validarSenha(String senhaUsuario){
        return BCrypt.checkpw(senhaUsuario, senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public int getDepartamento(){
        return id_departamento;
    }

    public void setDepartamento(int departamento){
        this.id_departamento = departamento;
    }
    
    public int getFilial(){
        return id_filial;
    }
    
    public void setFilial(int filial){
        this.id_filial = filial;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }    
    
}
