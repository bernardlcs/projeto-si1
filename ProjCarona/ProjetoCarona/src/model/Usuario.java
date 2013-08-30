/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author bernard
 */
public class Usuario implements Serializable{
    private String nomeDoUsuario;
    private String nomeDeLogin;
    private String email;
    private String senha;
    private int telefone;
    private Endereco enderecoUsuario;
    
    public Usuario(){
        
    }
    public Usuario(String nomeDoUsuario,String nomeLogin,String email,String senha,
            int telefone)throws Exception{
        if(nomeDoUsuario.equals("")|| nomeLogin.equals("")|| email.equals("")|| senha.equals("")
                ){
            throw new Exception("Entrada invalida,nao permitido entrada vazia.");
        }
        
        if(nomeDoUsuario==null || nomeLogin==null || email==null|| senha== null){
            throw new Exception("Entrada invalida,nao permitido entrada null");
        }
        if(telefone < 8 ){
            throw new Exception("Entrada invalida, telefone com numeros insuficientes.");
        }
        if(senha.length()<6){
            throw new Exception("Entrada invalida,senha no minimo 7 caracteres");
        }
        this.nomeDoUsuario = nomeDoUsuario;
        this.nomeDeLogin = nomeLogin;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeDeLogin() {
        return nomeDeLogin;
    }

    public void setNomeDeLogin(String nomeDeLogin) {
        this.nomeDeLogin = nomeDeLogin;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
}
