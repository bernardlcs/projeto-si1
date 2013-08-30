package projeto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Caronas {
	
        private String seriecarona, origem, destino, hora, data;
	private String vagas;
	private String pontosSugeriodosPeloUsuario;
	private List<Usuario> usuariosQueSolicitamVaga;
	private List<String> solicitacoesDePonto;
	private int contadorSolicitacao = 1;
	private Map<String, Boolean> solicitacoesRecebidasDeUsuarios;
	
	private final String ORIGEM = "origem";
	private final String DESTINO = "destino";
	private final String HORA = "hora";
	private final String DATA = "data";
	private final String VAGAS = "vagas";
	private final String PONTO_DE_ENCONTRO = "Ponto de Encontro";
	private final String DONO_DA_SOLICITACAO = "Dono da solicitacao";
	private final String DONO_DA_CARONA = "Dono da carona";
	private final Usuario donoDaCarona;
	private Map<String, Usuario> sugestoesDoUsuario = new HashMap<String, Usuario>();
	

	public Carona(Usuario dono, int contadorDeCaronasID, String origem,String destino, String data, String hora, String vagas) {
		this.idSessao = geraID(contadorDeCaronasID);
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.hora = hora;
		this.vagas = vagas;
		this.solicitacoesRecebidasDeUsuarios = new HashMap<String, Boolean>();
		this.setUsuariosQueSolicitamVaga(new LinkedList<Usuario>());
		this.donoDaCarona = dono;
	}

	private String geraID(int contadorDeCaronasID) {
		return "carona" + contadorDeCaronasID + "ID";
	}

        public void responderSugestaoPontoEncontro(Usuario usuarioResponde, Carona caronaQueRecebeuSolicitacao, String seriecarona, String[] pontosSugeridos) {
		usuarioResponde.setSugestaoDaCarona(pontosSugeridos);

	}

	public String getSerieCarona() {
		return seriecarona;
	}

	public void setSerieCarona(String seriecarona) {
		this.seriecarona = seriecarona;
	}

	public String getPontodeSaida() {
		return pontodesaida;
	}

	public void setPontodeSaida(String pontodesaida) {
		this.pontodesaida = pontodesaida;
	}

	public String getPontodeChegada() {
		return pontodechegada;
	}

	public void setDestino(String destino) {
		this.pontodechegada = pontodechegada;
	}

        public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getVagas() {
		return vagas;
	}

	public void setVagas(String vagas) {
		this.vagas = vagas;
	}

	public void setPontosSugeridosDeEncontro(Usuario usuario, String pontosSugeridos, String seriecarona) {
		this.pontosSugeriodosPeloUsuario = pontosSugeridos;
		this.sugestoesDoUsuario.put(seriecarona, usuario); 
	}

	public String getPontosSugeridosDeEncontro() {
		return this.pontosSugeriodosPeloUsuario;
	}

	public Map<String, Usuario> getSugestoesDoUsuario() {
		return this.sugestoesDoUsuario;
	}

	
	public String getAtributoCarona(String atributo) throws Exception {
		//atributosdecarona faltou eu fazer
	}

	
	
	public String solicitarVagaPontoEncontro(Usuario usuario, String ponto, Map<String, Boolean> solicitacoesDoUsuarios) throws Exception {
		String solicitacao = "solicitacao" + (this.solicitacoesRecebidasDeUsuarios.size() + 1) + "ID";
		this.getSolicitacoesDePonto().add(ponto);
		if (this.getUsuariosQueSolicitamVaga().contains(usuario)) {
			throw new PontoInvalidoException();
		}
		solicitacoesDoUsuarios.put(solicitacao, false);
		this.solicitacoesRecebidasDeUsuarios.put(solicitacao, false);
		this.getUsuariosQueSolicitamVaga().add(usuario);
		contadorSolicitacao++;
		return solicitacao;
	}

	public String getAtributoSolicitacao(String atributo, Usuario usuarioQueSolicitou) throws Exception {
		//atributodesolicitacao faltou eu fazer
	}

	
	public Usuario getDonoDaCarona() {
		return this.donoDaCarona;
	}

	public List<String> getSolicitacaoDeUsuarios() {
		return this.solicitacaoRecebidaDeUsuario.keySet();
	}

	public void aceitarSolicitacaoPontoEncontro(Usuario usuario, String seriecarona) throws Exception {
		if (this.solicitacoesRecebidasDeUsuarios.get(idSolicitacao) == true) {
			throw new SolicitacaoInexistenteException();
		}
		contadorSolicitacao--;
		int vagasDimin = Integer.parseInt(vagas) - 1;
		setVagas(String.valueOf(vagasDimin));
		this.solicitacoesRecebidasDeUsuarios.remove(idSolicitacao);
		this.solicitacoesRecebidasDeUsuarios.put(idSolicitacao, true);
	}
	
	public List<String> getSolicitacoesConfirmadas() {
		List<String> lista = new LinkedList<String>();
		for (String solicitacao : this.solicitacoesRecebidasDeUsuarios.keySet()) {
			if (this.solicitacoesRecebidasDeUsuarios.get(solicitacao) == true) {
				lista.add(solicitacao);
			}
		}
		return lista;
	}
	
	public List<String> getSolicitacoesPendentes() {
		List<String> lista = new LinkedList<String>();
		for (String solicitacao : this.solicitacoesRecebidasDeUsuarios.keySet()) {
			se a solicitacao for confirmada ou seja true
			if (this.solicitacoesRecebidasDeUsuarios.get(solicitacao) == false) {
				lista.add(solicitacao);
			}
		}
		return lista;
	}

	
	public String solicitarVaga(Usuario usuario, Map<String, Boolean> solicitacoesDoUsuario) throws Exception {
		if (getUsuariosQueSolicitamVaga().contains(usuario)) {
			throw new PontoInvalidoException();
		}
		String solicitacao = "solicitacao" + (solicitacoesDoUsuario.size() + 1) + "ID";
		solicitacoesDoUsuario.put(solicitacao, false);
		this.getUsuariosQueSolicitamVaga().add(usuario);
		this.solicitacoesRecebidasDeUsuarios.put(solicitacao, false);
		contadorSolicitacao++;
		return solicitacao;
	}

	public void aceitarSolicitacao(Usuario user, String idSolicitacao)throws Exception {
		if (!usuariosQueSolicitamVaga.contains(user)) {
			throw new UsuarioInexistente();
		}
		if (this.solicitacoesRecebidasDeUsuarios.get(idSolicitacao) == true) {
			throw new SolicitacaoInexistenteException();
		}
		
                contadorSolicitacao--;
		int vagasDiminui = Integer.parseInt(vagas) - 1;
		setVagas(String.valueOf(vagasDiminui));
		
		this.solicitacoesRecebidasDeUsuarios.remove(idSolicitacao);
		this.solicitacoesRecebidasDeUsuarios.put(idSolicitacao, true);
		
		user.addNoHistoricoDeVagasEmCaronas(this);
	}

	public void rejeitarSolicitacao(Usuario user, String idSolicitacao) throws Exception {
		contadorSolicitacao--;
		this.solicitacoesRecebidasDeUsuarios.remove(idSolicitacao);

	}

	public List<Usuario> getUsuariosQueSolicitamVaga() {
		return usuariosQueSolicitamVaga;
	}

	public void setUsuariosQueSolicitamVaga(List<Usuario> usuariosQueSolicitamVaga) {
		this.usuariosQueSolicitamVaga = usuariosQueSolicitamVaga;
	}

	public List<String> getSolicitacoesDePonto() {
		return solicitacoesDePonto;
	}

	public void setSolicitacoesDePonto(List<String> solicitacoesDePonto) {
		this.solicitacoesDePonto = solicitacoesDePonto;
	}

	public String getPontosEncontro() {
		return getPontosSugeridosDeEncontro();
	}

}
