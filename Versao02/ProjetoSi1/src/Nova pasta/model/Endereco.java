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
    
    private String cidade;
    private String estado;
    
    
    public Endereco( String cidade,String estado){      
    	this.cidade = cidade;      
        this.estado = estado;
        
    }
    public Endereco(){
        
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
