public class Livro extends Midia {
	private int edicao;

	public Livro(String nome, int edicao) {
		this.edicao = edicao;
		setNome(nome);
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

}
