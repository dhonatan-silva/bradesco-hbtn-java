import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

	private String nome;
	private double preco;
	private double percentualMarkup;
	Supplier<Double> precoComMarkup = () -> preco + (preco * percentualMarkup / 100);
	Consumer<Double> atualizarMarkup = x -> percentualMarkup = x;

	public Produto(double preco, String nome) {
		this.preco = preco;
		this.nome = nome;
		this.percentualMarkup = 10;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPercentualMarkup() {
		return percentualMarkup;
	}

	public void setPercentualMarkup(double percentualMarkup) {
		this.percentualMarkup = percentualMarkup;
	}

}
