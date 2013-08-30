/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Endereco;
import model.ManipularArquivos;
import model.Usuario;

/**
 *
 * @author bernard
 */
@ManagedBean (name="controller")
@SessionScoped
public class CtrlUsuario implements Serializable{
    
    private Endereco endereco;
    private Usuario usuario;
    private File file = new File("UsuarioArq.dat");
    // list de contatos
    private List<Usuario> listaDeUsuarios;
    // arquivo
    private ManipularArquivos arq;
    
    public CtrlUsuario() throws IOException {
        endereco = new Endereco();
        usuario = new Usuario();
        listaDeUsuarios = new ArrayList<Usuario>();
        arq = new ManipularArquivos();
        
        if(!file.exists()){
            file = new File("UsuarioArq.dat");
            arq.escreveObjetoNoArquivo(file.getName(), listaDeUsuarios);
        }
        else{
            listaDeUsuarios = (List<Usuario>) arq.leObjetoNoArquivo(file.getName());
        }
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
  
    public void cadastrarNovoUsuario(){
        // lembrar de criar o 1 usuario do sistema  pra na hora de ver ja ter um para evitar o 
        // erro futuro para castro de guardar o usuario seguinte assim so pegar o objeto de lista e ir slavando 
        // e verificando
       
        //listaDeUsuarios.add(usuario);
        //usuario = new Usuario();
        
       if(listaDeUsuarios.size()==0){
           listaDeUsuarios.add(usuario);
               usuario = new Usuario();
                try {
                    arq.escreveObjetoNoArquivo("UsuarioArq.dat", listaDeUsuarios);
                } catch (IOException ex) {
                    Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
       else{
           for(Usuario usuarioCad:listaDeUsuarios){
               if(usuarioCad.getEmail().equals(usuario.getEmail())){
                   FacesContext.getCurrentInstance().addMessage("email", new //<editor-fold defaultstate="collapsed" desc="comment">
                       FacesMessage
                       //</editor-fold>
                           (FacesMessage.SEVERITY_INFO,"usuario ja existe", null));
                   //return "error";
               }         
           }
           listaDeUsuarios.add(usuario);
           usuario = new Usuario();
                try {
                    arq.escreveObjetoNoArquivo("UsuarioArq.dat", listaDeUsuarios);
                } catch (IOException ex) {
                    Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
       
    }
      

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }
    
    
    public String moveToPage1(){
        return "index";
    }
    
}
