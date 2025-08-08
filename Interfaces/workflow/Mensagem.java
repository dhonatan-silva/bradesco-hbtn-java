public class Mensagem {

	private TipoMensagem tipoMensagem;
	private String texto;

	public Mensagem(TipoMensagem tipoMensagem, String texto) {
		this.tipoMensagem = tipoMensagem;
		this.texto = texto;
	}

	public TipoMensagem getTipoMensagem() {
		return tipoMensagem;
	}

	public void setTipoMensagem(TipoMensagem tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
