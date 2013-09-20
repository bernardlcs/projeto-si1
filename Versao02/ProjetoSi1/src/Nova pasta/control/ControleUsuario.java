package control;

import java.util.ArrayList;
import java.util.List;

import model.FachadaJDomUsuario;
import model.Usuario;

public class ControleUsuario {
	
	private List<Usuario> listaDeUsuarios;
	private boolean validate = false;
	
	
	public ControleUsuario(){
		 listaDeUsuarios = new ArrayList<Usuario>();
		
	}
	
	public void validarUsuario(String nickNome,String nickEmail)throws Exception{
        listaDeUsuarios = FachadaJDomUsuario.lerUsuarios();

    	this.validate = false;
    	for(Usuario usuarioJaCadastrado: listaDeUsuarios){
    		
    		if(usuarioJaCadastrado.getEmail().equals(nickEmail)){
    			throw new Exception("Login invalido");
    		}
    		if(usuarioJaCadastrado.getNomeDeLogin().equals(nickNome)){
    			throw new Exception("Nome invalido");
    		}
    	}
    	
    	this.validate = true;  	
    	
    }
	
	public boolean validateIsOk(){
		return this.validate;
	}
	

}
