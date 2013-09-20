package model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class jdomtest {

	Usuario usuario01;
	Usuario usuario02;
	Usuario usuario03;
	Usuario usuario04;
	Usuario usuario05;
	Usuario usuario06;
	Usuario usuario07;
	Usuario usuario08;
	Usuario usuario09;
	Usuario usuario10;

	@Before
	public void inicializando() throws Exception {
		usuario01 = new Usuario("joao01", "joao2013", "j01@gmail", "1234567", "cidade", "estado");
		usuario02 = new Usuario("joao02", "joao2014", "j02@gmail", "1234567", "cidade", "estado");
		usuario03 = new Usuario("joao03", "joao2015", "j03@gmail", "1234567", "cidade", "estado");
		usuario04 = new Usuario("joao04", "joao2016", "j04@gmail", "1234567", "cidade", "estado");
		usuario05 = new Usuario("joao05", "joao2017", "j05@gmail", "1234567", "cidade", "estado");
		usuario06 = new Usuario("joao06", "joao2018", "j06@gmail", "1234567", "cidade", "estado");
		usuario07 = new Usuario("joao07", "joao2019", "j07@gmail", "1234567", "cidade", "estado");
		usuario08 = new Usuario("joao08", "joao2020", "j08@gmail", "1234567", "cidade", "estado");
		usuario09 = new Usuario("joao09", "joao2021", "j09@gmail", "1234567", "cidade", "estado");
		usuario10 = new Usuario("joao10", "joao2022", "j10@gmail", "1234567", "cidade", "estado");
	}
	
	@Ignore
	public void testFail(){//testando ler arquivo inexistente
		List<Usuario> usList2 = new ArrayList<Usuario>();
		
		usList2 = FachadaJDomUsuario.lerUsuarios();//envia mensagem de erro

		System.out.println(usList2.size() + " usuarios(Deve ser zero):");
		for (Usuario i2 : usList2) {
			System.out.println(i2.getNomeDoUsuario());
		}

		System.out.println("fim do teste de leitura impossivel\n");

	}

	@Test
	public void test() {
		List<Usuario> usList = new ArrayList<Usuario>();
		usList.add(usuario01);
		usList.add(usuario02);
		usList.add(usuario03);
		usList.add(usuario04);
		usList.add(usuario05);
		usList.add(usuario06);
		usList.add(usuario07);
		usList.add(usuario08);
		usList.add(usuario09);
		usList.add(usuario10);

		System.out.println("teste 01:\nantes...");
		for (Usuario i : usList) {
			System.out.println(i.getNomeDoUsuario());
		}
		System.out.println("salvei os usuarios!\n");
		FachadaJDomUsuario.salvarUsuarios(usList);

		List<Usuario> usList2 = new ArrayList<Usuario>();
		usList2 = FachadaJDomUsuario.lerUsuarios();

		System.out.println("...depois");
		System.out.println(usList2.size() + " usuarios:");
		for (Usuario i2 : usList2) {
			System.out.println(i2.getNomeDoUsuario());
		}
		System.out.println("fim do teste de recuperacao\n");
		//***********************************

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
		System.out.println("fim do teste de reset\n");*/

	}
}
