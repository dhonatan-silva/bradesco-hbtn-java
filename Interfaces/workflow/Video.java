public class Video {
	private String arquivo;
	private FormatoVideo formato;

	public Video(String arquivo, FormatoVideo formato) {
		this.arquivo = arquivo;
		this.formato = formato;
	}

	public final String getArquivo() {
		return arquivo;
	}

	public final void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public final FormatoVideo getFormato() {
		return formato;
	}

	public final void setFormato(FormatoVideo formato) {
		this.formato = formato;
	}

}
