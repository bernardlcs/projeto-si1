package model;

import java.io.*;

/**
 * Classe ManipularArquivos
 * @author bernard,rodrigo
 *
 */
public class ManipularArquivos {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor da classe ManipularArquivos
	 */
	public ManipularArquivos(){
		
	}
	/**
	 * metodo escreverObjetoNoArquivo
	 * recebe o nome do arquivo e o objeto que sera armazenado	
	 * @param nomeDoArquivo
	 * @param o
	 * @throws IOException
	 */
	public void escreveObjetoNoArquivo(String nomeDoArquivo, Object o) throws IOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomeDoArquivo)));
			out.writeObject(o);
		} catch (IOException e){
			System.err.println(e.getMessage());
		} finally {
			out.close();
		}
	}
	
	/**
	 * metodo lerObjetoNoArquivo
	 * recebe o nome do arquivo
	 * @param nomeDoArquivo
	 * @return obejct
	 * @throws IOException
	 */
	public Object leObjetoNoArquivo(String nomeDoArquivo) throws IOException{
		ObjectInputStream in = null;
		Object objeto = null;
		
		try{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomeDoArquivo)));
			objeto = (Object) in.readObject();
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}catch(IOException e){
			System.err.println(e.getMessage());
		}finally{
			in.close();
		}
		return objeto;
	}
}