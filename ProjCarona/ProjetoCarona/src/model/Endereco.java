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
public class Endereco implements Serializable{
    
    private String logradouro;
    private String bairro;
    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
    private int numero;
    
    
    public Endereco(String  logradouro,String bairro, String cep,String rua, String cidade,
            String estado,String complemento,int numero){
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.rua = rua;
    }
    public Endereco(){
        
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
