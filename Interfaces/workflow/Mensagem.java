public class Mensagem {

	private TipoMensagem tipo;
	private String texto;

	public Mensagem(TipoMensagem tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}

	public TipoMensagem getTipo() {
		return tipo;
	}

	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
