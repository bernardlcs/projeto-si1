/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Carona;
import model.Endereco;
import model.FachadaJDomCarona;
import model.FachadaJDomUsuario;
import model.ManipularArquivos;
import model.Usuario;

/**
 *
 * @author bernard
 */
@ManagedBean (name="controller")
@ViewScoped
public class CtrlUsuario implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private File file1 = new File("C:/usuarios.xml");
    private File file2 = new File("C:/usuarios.xml");    
    private String loginParaLogar;
    private String senhaParaLogar;
    private boolean validate = false;
    private List<Usuario> listaDeUsuarios;
    private Carona carona;
    private Map<String,Carona> mapaDeCaronas = new HashMap<String, Carona>();
   
    
    
    public Carona getCarona() {
		return carona;
	}

	public void setCarona(Carona carona) {
		this.carona = carona;
	}

	public CtrlUsuario() throws IOException {
        
        usuario = new Usuario();
       if(!(file1.exists())){
    	   FachadaJDomUsuario.resetUsuarios();
       }
       
       if(!(file2.exists())){
    	   FachadaJDomCarona.resetCaronas();
       }
        listaDeUsuarios = FachadaJDomUsuario.lerUsuarios();
        mapaDeCaronas = FachadaJDomCarona.lerCaronas();
        
        
        
        
        
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public String getLoginParaLogar() {
		return loginParaLogar;
	}

	public void setLoginParaLogar(String loginParaLogar) {
		this.loginParaLogar = loginParaLogar;
	}

	public String getSenhaParaLogar() {
		return senhaParaLogar;
	}

	public void setSenhaParaLogar(String senhaParaLogar) {
		this.senhaParaLogar = senhaParaLogar;
	}
	
	public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }
    

    
    
    public void validarUsuario(){
        listaDeUsuarios = FachadaJDomUsuario.lerUsuarios();

    	this.validate = true;
    	if(listaDeUsuarios.size()==0){
    		
    		//setar o cadCarona
    		
    		listaDeUsuarios.add(usuario);
			FacesContext.getCurrentInstance().addMessage("cadastro", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro feito com sucesso", null));
    	}
    	else{
    		for(Usuario usuarioJaCadastrado: listaDeUsuarios){
        		
        		if(usuarioJaCadastrado.getEmail().equals(usuario.getEmail())){
        			System.out.println(usuario.getEmail());
        			FacesContext.getCurrentInstance().addMessage("email", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login Invalido", null));
                     this.validate = false;
        			
        		}
        		if(usuarioJaCadastrado.getNomeDeLogin().equals(usuario.getNomeDeLogin())){
        			FacesContext.getCurrentInstance().addMessage("Nome de Login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Nome para Login Invalido", null));
        			this.validate = false;
        		}
        		
        	}
    		
    		if(this.validate){
    			//setar o cad carona
    			//usuario.cadarona
        		listaDeUsuarios.add(usuario);
    			FacesContext.getCurrentInstance().addMessage("cadastro", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro feito com sucesso", null));
        	}
    		
    	
    		
    	}
    	
    	FachadaJDomUsuario.salvarUsuarios(listaDeUsuarios);
    		usuario = new Usuario();
			
    	
    	
    }
	
	
    
    public String validateLogin() {
        
    	this.validate = true;
    	if(listaDeUsuarios.size()==0){
    		
			//FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro feito com sucesso", null));
    		validate = false;
    	}
    	else{
    		for(Usuario usuarioJaCadastrado: listaDeUsuarios){
        		
        		if(usuarioJaCadastrado.getNomeDeLogin().equals(getLoginParaLogar())){
        			
        			//FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login/senha invalido", null));
                     this.validate = true;
        			
        		}
        		if(usuarioJaCadastrado.getSenha().equals(getSenhaParaLogar())){
        			//FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login/senha invalido", null));
        			this.validate = true;
        		}
        		
        	}
    		
    		if(this.validate){
    			//setar o cad carona
    			//usuario.cadarona
        		return "perfilUsuario.xhtml";
        	}else{
        		FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login/senha invalido", null));
        	}
    	}
    	return "";
    
   
    }
    
    public void cadastrarCarona(){
    	
    	
    	
    }
    
    
  
    
    
    
    
}
