public class PersonagemGame {
	private int saudeAtual;
	private String nome;
	private String status;

	public PersonagemGame(int saudeAtual, String nome) {
		setSaudeAtual(saudeAtual);
		this.nome = nome;
	}

	public int getSaudeAtual() {
		return saudeAtual;
	}

	public void setSaudeAtual(int saudeAtual) {
		this.saudeAtual = saudeAtual;
		if (saudeAtual > 0) {
			status = "vivo";
		}

		if (saudeAtual == 0) {
			status = "morto";
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void tomarDano(int quantidadeDeDano) {
		setSaudeAtual(saudeAtual - quantidadeDeDano);
		if (saudeAtual < 0) {
			setSaudeAtual(0);
		}

	}

	public void receberCura(int quantidadeDeCura) {
		setSaudeAtual(saudeAtual + quantidadeDeCura);
		if (saudeAtual > 100) {
			setSaudeAtual(100);
		}

	}
}
