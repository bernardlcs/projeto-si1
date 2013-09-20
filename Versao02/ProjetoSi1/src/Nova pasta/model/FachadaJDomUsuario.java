package model;
//package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jdom2.*;
import org.jdom2.output.XMLOutputter;
import java.util.List;
import model.Endereco;
import model.Usuario;
import org.jdom2.input.SAXBuilder;

/**
 * 
 * @author Administrador
 */
public class FachadaJDomUsuario {

	private static Usuario usuarioReconstruido = null;

	public static void salvarUsuarios(List<Usuario> listaDeUsuarios) {
		Element root = new Element("listaDeUsuarios");
		for (Usuario i : listaDeUsuarios) {
			adcionarAtributosUsuario(i, root);
		}
		Document doc = new Document();
		doc.setRootElement(root);
		try {
			XMLOutputter xout = new XMLOutputter();
			FileWriter arquivo = new FileWriter(new File("C:/usuarios.xml"));
			xout.output(doc, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void adcionarAtributosUsuario(Usuario usuarioAtual,
			Element root) {
		Element usuario = new Element("usuario");
		root.addContent(usuario);
		//nome
		Attribute nomeDoUsuario = new Attribute("nomeDoUsuario",
				usuarioAtual.getNomeDoUsuario());
		usuario.setAttribute(nomeDoUsuario);
		//nome de loguin
		Attribute nomeDeLogin = new Attribute("nomeLogin",
				usuarioAtual.getNomeDeLogin());
		usuario.setAttribute(nomeDeLogin);
		//email
		Attribute email = new Attribute("email", usuarioAtual.getEmail());
		usuario.setAttribute(email);
		//senha
		Attribute senha = new Attribute("senha", usuarioAtual.getSenha());
		usuario.setAttribute(senha);
		//numero de caronas
		String caronasPegas_String = String.valueOf(usuarioAtual.getCaronasPegas());
		Attribute caronasPegas = new Attribute("caronasPegas",
				caronasPegas_String);
		usuario.setAttribute(caronasPegas);
		//cidade
		Attribute cidade = new Attribute("cidade",
				usuarioAtual.getCidade());
		usuario.setAttribute(cidade);
		//estado
		Attribute estado = new Attribute("estado",
				usuarioAtual.getEstado());
		usuario.setAttribute(estado);
	}

	public static List<Usuario> lerUsuarios() {
		List<Usuario> listaReconstruida = new ArrayList<Usuario>();
		File f = new File("C:/usuarios.xml");
		
			
		SAXBuilder saxBuilder = new SAXBuilder();

		try {
			Document doc = saxBuilder.build(f);
			Element listaDeUsuarios = doc.getRootElement();

			//iteramos com os elementos filhos
			Iterator<Element> it1 = listaDeUsuarios.getChildren().iterator();
			while (it1.hasNext()) {
				Element element = (Element) it1.next();
				try {
					
					//int caronasPegas_Int = Integer.parseInt(element.getAttributeValue("caronasPegas"));
	
					usuarioReconstruido = new Usuario(
							element.getAttributeValue("nomeDoUsuario"),
							element.getAttributeValue("nomeLogin"),
							element.getAttributeValue("email"),
							element.getAttributeValue("senha"), 
							element.getAttributeValue("cidade"),
							element.getAttributeValue("estado"));
					//usuarioReconstruido.setCaronasPegas(caronasPegas_Int);
					usuarioReconstruido.setCaronasPegas();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				listaReconstruida.add(usuarioReconstruido);
			}
		} catch (IOException io) {
			io.printStackTrace();
			// System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			jdomex.printStackTrace();
			// System.out.println(jdomex.getMessage());
		}
		return listaReconstruida;
	}

	public static void resetUsuarios() {
		FachadaJDomUsuario.salvarUsuarios(new ArrayList<Usuario>());
	}
}