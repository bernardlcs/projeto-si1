package model;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class jdomtest2 {

	String carona1ID="01"; //idSessao=${sessaoMark} 
	Carona c1 ;
	String carona2ID="02"; //idSessao=${sessaoMark} 
	Carona c2 ;	
	String carona3ID="03"; //idSessao=${sessaoMark} 
	Carona c3 ;		
	String carona4ID="04"; //idSessao=${sessaoMark} 
	Carona c4 ;		
	String carona5ID="05"; //idSessao=${sessaoMark} 
	Carona c5 ;		
	String carona6ID="06"; //idSessao=${sessaoMark} 
	Carona c6 ;

	@Before
	public void inicializando() throws Exception {
		 c1 = new Carona("Cajazeiras" ,"Patos" ,20,07,2013,14,00,4);
		 c2 = new Carona("São Francisco" ,"Palo Alto" ,12,9,2013,21,00,2);
		 c3 = new Carona("Campina Grande" ,"João Pessoa" ,01,06,2013,12,00,1);
		 c4 = new Carona("Campina Grande" ,"João Pessoa" ,02,06,2013,12,00,3);
		 c5 = new Carona("Campina Grande" ,"João Pessoa" ,04,06,2013,16,00,2);
		 c6 = new Carona("Leeds" ,"Londres" ,10,02,2013,10,00,3);
	}

	@Test
	public void test() {
		Map<String , Carona> mapDeCaronas = new HashMap<String, Carona>();
		mapDeCaronas.put(carona1ID, c1);
		mapDeCaronas.put(carona2ID, c2);
		mapDeCaronas.put(carona3ID, c3);
		mapDeCaronas.put(carona4ID, c4);
		mapDeCaronas.put(carona5ID, c5);
		mapDeCaronas.put(carona6ID, c6);

		System.out.println("teste 01:\nantes...");
		for (Iterator<String> it1 = mapDeCaronas.keySet().iterator(); it1.hasNext();) {
			String idChave = it1.next();
			Carona caronaDaChave = mapDeCaronas.get(idChave);
			System.out.println(idChave + ": " + caronaDaChave.getLocalOrigem());
		}
		System.out.println("salvei as caronas!\n");
		FachadaJDomCarona.salvarCaronas(mapDeCaronas);

		Map<String , Carona> mapDeCaronas2 = new HashMap<String, Carona>();
		mapDeCaronas2 = FachadaJDomCarona.lerCaronas();

		System.out.println("...depois");
		System.out.println(mapDeCaronas2.size() + " caronas:");
		for (Iterator<String> it2 = mapDeCaronas2.keySet().iterator(); it2.hasNext();) {
			
			String idChave = it2.next();
			Carona caronaDaChave = mapDeCaronas.get(idChave);
			System.out.println(idChave + ": " + caronaDaChave.getLocalOrigem());
		}
		System.out.println("fim do teste de recuperacao\n");
		//***********************************
/**
		usList.remove(usuario09);
		System.out.println("teste 02:\nantes...");
		for (Usuario i : usList) {
			System.out.println(i.getNomeDoUsuario());
		}
		System.out.println("salvei os usuarios!\n");
		FachadaJDomUsuario.salvarUsuarios(usList);

		usList2 = new ArrayList<Usuario>();
		usList2 = FachadaJDomUsuario.lerUsuarios();

		System.out.println("...depois");
		System.out.println(usList2.size() + " usuarios:");
		for (Usuario i2 : usList2) {
			System.out.println(i2.getNomeDoUsuario());

		}
		System.out.println("fim do teste de remocao re-recuperacao\n");
		//***********************************
		
		usuario01.setNomeDoUsuario("novo nome estranho");
		System.out.println("teste 03:\nantes...");
		for (Usuario i : usList) {
			System.out.println(i.getNomeDoUsuario());
		}
		System.out.println("salvei os usuarios!\n");
		FachadaJDomUsuario.salvarUsuarios(usList);

		usList2 = new ArrayList<Usuario>();
		usList2 = FachadaJDomUsuario.lerUsuarios();

		System.out.println("...depois");
		System.out.println(usList2.size() + " usuarios:");
		for (Usuario i2 : usList2) {
			System.out.println(i2.getNomeDoUsuario());

		}
		System.out.println("fim do teste de alteracao\n");
		//***********************************

/*		System.out.println("teste 04:\nantes...");
		FachadaJDomUsuario.resetUsuarios();

		usList2 = new ArrayList<Usuario>();
		usList2 = FachadaJDomUsuario.lerUsuarios();

		System.out.println("...depois");
		System.out.println(usList2.size() + " usuarios(Deve ser zero):");
		for (Usuario i2 : usList2) {
			System.out.println(i2.getNomeDoUsuario());

		}
		System.out.println("fim do teste de reset\n");
**/
	}
}
