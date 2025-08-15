import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private File arquivo;
	private List<Produto> listaProdutos;

	public Estoque(String uri) {
		arquivo = new File(uri);
	}

	public void adicionarProduto(String nome, int quantidade, double preco) {
		try {
			// Ler arquivo
			lerArquivo();

			// Adicionar novo produto
			Produto last = listaProdutos.get(listaProdutos.size() - 1);
			int id = last.getId() + 1;
			listaProdutos.add(new Produto(id, nome, quantidade, preco));

			// Limpar arquivo
			limparArquivo();

			// Escrever no arquivo
			reescreverArquivo();

		} catch (IOException e) {
			System.err.println("Erro ao adicionar produto: " + e.getMessage());
		}

	}

	public void excluirProduto(int idExcluir) {
		try {
			// ler arquivo
			lerArquivo();

			// remover produto
			Produto produto = identificarProduto(idExcluir);
			listaProdutos.remove(produto);

			// limpar arquivo
			limparArquivo();

			// reescrever no arquivo
			reescreverArquivo();

		} catch (IOException e) {
			System.err.println("Erro ao excluir produto: " + e.getMessage());
		}
	}

	public void exibirEstoque() {
		try {
			// ler arquivo
			lerArquivo();

			// exibir
			for (Produto produto : listaProdutos) {
				System.out.println(produto.toString());
			}

		} catch (Exception e) {
			System.err.println("Erro ao exibir estoque: " + e.getMessage());
		}
	}

	public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
		try {
			// ler arquivo
			lerArquivo();

			// identificar produto
			Produto produto = identificarProduto(idAtualizar);

			// atualizar quantidade
			produto.setQuantidade(novaQuantidade);

			// limpar arquivo
			limparArquivo();

			// reescrever no arquivo
			reescreverArquivo();

		} catch (Exception e) {
			System.err.println("Erro ao atualizar quantidade: " + e.getMessage());
		}

	}

	private List<Produto> lerArquivo() throws FileNotFoundException, IOException {
		listaProdutos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] line = linha.split(",");
				int id = Integer.parseInt(line[0]);
				String name = line[1];
				int qtd = Integer.parseInt(line[2]);
				double price = Double.parseDouble(line[3]);
				listaProdutos.add(new Produto(id, name, qtd, price));
			}
		}
		return listaProdutos;
	}

	private void limparArquivo() throws IOException {
		FileWriter fileWriter = new FileWriter(arquivo, false);
		fileWriter.close();
	}

	private void reescreverArquivo() throws IOException {
		FileWriter fileWriter = new FileWriter(arquivo, true);

		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		Produto last = listaProdutos.get(listaProdutos.size() - 1);

		for (int i = 0; i < listaProdutos.size(); i++) {
			Produto produto = listaProdutos.get(i);
			bufferedWriter.write(produto.toCsv());

			if (!produto.equals(last)) {
				bufferedWriter.newLine();
			}
		}

		bufferedWriter.close();
		fileWriter.close();
	}

	private Produto identificarProduto(int id) {
		for (Produto produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
}
