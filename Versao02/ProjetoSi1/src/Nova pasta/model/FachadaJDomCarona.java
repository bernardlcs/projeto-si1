package model;
//package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;


/**
 * 
 * @author Administrador
 */
public class FachadaJDomCarona {

	private static Carona caronaReconstruido = null;

	public static void salvarCaronas(Map<String , Carona> mapDeCaronas) {
		Element root = new Element("listaDeCaronas");
	
		for (Iterator<String> it1 = mapDeCaronas.keySet().iterator(); it1.hasNext();) {
			
			String idChave = it1.next();
			Carona caronaDaChave = mapDeCaronas.get(idChave);
			adcionarCaronas(idChave, caronaDaChave, root);
		}
		Document doc = new Document();
		doc.setRootElement(root);
		try {
			XMLOutputter xout = new XMLOutputter();
			FileWriter arquivo = new FileWriter(new File("caronas.xml"));
			xout.output(doc, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void adcionarCaronas(String idDaCarona, Carona caronaAtual, Element root) {
		Element carona = new Element("carona");
		root.addContent(carona);
		//id
		Attribute id = new Attribute("id", idDaCarona);
		carona.setAttribute(id);
		//data
		Attribute data = new Attribute("data",
				caronaAtual.getData());
		carona.setAttribute(data);
		//localOrigem
		Attribute localOrigem = new Attribute("localOrigem", caronaAtual.getLocalOrigem());
		carona.setAttribute(localOrigem);
		//localDestino
		Attribute localDestino = new Attribute("localDestino", caronaAtual.getLocalDestino());
		carona.setAttribute(localDestino);
		//hora(int - string)
		String hora_string = String.valueOf((caronaAtual.getHora()));
		Attribute hora = new Attribute("hora", hora_string);
		carona.setAttribute(hora);
		//minuto(int - string)
		String minuto_string = String.valueOf((caronaAtual.getMinuto()));
		Attribute minuto = new Attribute("minuto", minuto_string);
		carona.setAttribute(minuto);
		//vagasDisponiveis(int - string)
		String vagasDisponiveis_string = String.valueOf((caronaAtual.getVagasDisponiveis()));
		Attribute vagasDisponiveis = new Attribute("vagasDisponiveis", vagasDisponiveis_string);
		carona.setAttribute(vagasDisponiveis);
	}

	public static Map<String, Carona> lerCaronas() {
		Map<String, Carona> mapReconstruida = new HashMap<String, Carona>();
		
		File f = new File("caronas.xml");
		SAXBuilder saxBuilder = new SAXBuilder();
		
		try {
			Document doc = saxBuilder.build(f);
			Element listaDeCaronas = doc.getRootElement();
		
			// iteramos com os elementos filhos
			Iterator<Element> it1 = listaDeCaronas.getChildren().iterator();
			while (it1.hasNext()) {
				Element element = (Element) it1.next();
				try {							
					String[] data = element.getAttributeValue("data").split("/");
					int hora_int = Integer.parseInt(element
						.getAttributeValue("hora"));
					int minuto_int = Integer.parseInt(element.getAttributeValue("minuto"));
					int vagasDisponiveis_int = Integer.parseInt(element.getAttributeValue("vagasDisponiveis"));
					caronaReconstruido = new Carona(
						element.getAttributeValue("localOrigem"),
						element.getAttributeValue("localDestino"),
						Integer.parseInt(data[0]),
						Integer.parseInt(data[1]),
						Integer.parseInt(data[2]), 
						hora_int,
						minuto_int, 
						vagasDisponiveis_int);
				} catch (Exception e) {
						e.printStackTrace();
				}
				mapReconstruida.put(element.getAttributeValue("id"),caronaReconstruido);
				}
			} catch (IOException io) {
				io.printStackTrace();
				// System.out.println(io.getMessage());
			} catch (JDOMException jdomex) {
				jdomex.printStackTrace();
				// System.out.println(jdomex.getMessage());
			}
			return mapReconstruida;
		}

	public static void resetCaronas() {
		FachadaJDomCarona.salvarCaronas(new HashMap<String, Carona>());
	}	
}

