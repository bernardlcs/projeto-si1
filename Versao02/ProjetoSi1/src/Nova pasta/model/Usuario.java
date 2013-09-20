/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author bernard
 */
public class Usuario implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoUsuario,nomeDeLogin,email,senha;
	private int caronasPegas;
	private List<String> IDminhasSolicitacoes;
	private String cidade,estado;
    
   
	public Usuario(){
        
    }
    public Usuario(String nomeDoUsuario,String nomeLogin,String email,String senha,
           String cidade, String estado)throws Exception{
        if(nomeDoUsuario.equals("")|| nomeLogin.equals("")|| email.equals("")|| senha.equals("")
                ){
            throw new Exception("Entrada invalida,nao permitido entrada vazia.");
        }
        
        if(nomeDoUsuario==null || nomeLogin==null || email==null|| senha== null){
            throw new Exception("Entrada invalida,nao permitido entrada null");
        }
       
        if(senha.length()<4){
            throw new Exception("Entrada invalida,senha no minimo 4 caracteres");
        }
        this.nomeDoUsuario = nomeDoUsuario;
        this.nomeDeLogin = nomeLogin;
        this.email = email;
        this.caronasPegas = 0;
      
        this.senha = senha;
        this.IDminhasSolicitacoes = new ArrayList<String>();
        this.cidade = cidade;
        this.estado = estado;
        // TODO tem excecoes para o preenchimento de cidade e estado? 
        // por exemplo deixar o campo em branco(opcional)?
    }

    public int novaCarona(){
    	 return this.caronasPegas++;
    	
    
    }
    
    public void novaSolicitacao(String novoIDSolicitacao){
    	this.IDminhasSolicitacoes.add(novoIDSolicitacao);
    }
    
    public List<String> getIDminhasSolicitacoes() {
		return this.IDminhasSolicitacoes;
	}
    protected void setIDminhasSolicitacoes(List<String> listaID) {
		this.IDminhasSolicitacoes = listaID;
	}
    
	public int getCaronasPegas() {
		return this.caronasPegas;
	}
	
	protected void setCaronasPegas() {
		this.caronasPegas = novaCarona() ;
	}

	
    
    public String getEmail() {
        return this.email;
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
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
