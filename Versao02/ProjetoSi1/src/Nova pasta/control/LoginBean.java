/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.FachadaJDomUsuario;
import model.ManipularArquivos;
import model.Usuario;

/**
 *
 * @author bernard
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
   
    private String login;
    private String senha;
    private String nextView;
    private Usuario usuario;
    private List<Usuario> usuarioList;

     
    public LoginBean() {
        usuarioList = new ArrayList<Usuario>();
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

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNextView() {
        return nextView;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    

    public void setNextView(String nextView) {
        this.nextView = nextView;
    }
    
    public String validateLogin() {
        
    	boolean validoLogin = false;
    	
    	if(usuarioList.size()==0){
    		FacesContext.getCurrentInstance().addMessage("email/login", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login/senha Invalido", null));
    	}
        for(Usuario usuarioCad:usuarioList){
            if(login.equals(usuarioCad.getNomeDeLogin()) && senha.equals(usuarioCad.getSenha())){
            	this.usuario = usuarioCad;
            	 validoLogin= true;
            }
          
        }
        
        if(!(validoLogin==true)){
			FacesContext.getCurrentInstance().addMessage("email", new FacesMessage(FacesMessage.SEVERITY_INFO,"Login/senha Invalido", null));
           
        }
        else{
            return "perfilUsuario.xhmtl";
        }
		return "erro";
       
        
    }
    
    
    
}
