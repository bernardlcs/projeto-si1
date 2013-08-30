/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ManipularArquivos;
import model.Usuario;

/**
 *
 * @author bernard
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    private ManipularArquivos arq;
    private String login;
    private String senha;
    private List<Usuario> usuarioList;
    private File file = new File("UsuarioArq.dat");
   
    
    public LoginBean() throws IOException{
        arq = new ManipularArquivos();
        
        if(!file.exists()){
            file = new File("UsuarioArq.dat");
            arq.escreveObjetoNoArquivo(file.getName(),usuarioList);
        }
        else{
            usuarioList= (List<Usuario>) arq.leObjetoNoArquivo(file.getName());
        }
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
    
    public boolean validateLogin() throws IOException{
        
        for(Usuario usuarioCad:usuarioList){
            if(login.equals(usuarioCad.getEmail()) && senha.equals(usuarioCad.getSenha())){
                return true;
            }
          
        }
       return false; 
        
    }
    
    public void loginIsOk() throws IOException{
        if(validateLogin()==true){
            try {
                FacesContext.getCurrentInstance().getExternalContext()  
                        .redirect("perfilUsuario.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             FacesContext.getCurrentInstance().addMessage("email", new //<editor-fold defaultstate="collapsed" desc="comment">
                       FacesMessage
                       //</editor-fold>
                           (FacesMessage.SEVERITY_INFO,"usuario/senha incorretos", null));
        }
    }
    
    
    
}
