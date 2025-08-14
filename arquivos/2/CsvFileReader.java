import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {

	public static void main(String[] args) {

		File arquivo = new File("funcionarios.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] linhas = linha.split(",");
				System.out.println("Funcionário: " + linhas[0]);
				System.out.println("Idade: " + linhas[1]);
				System.out.println("Departamento: " + linhas[2]);
				System.out.println("Salarial: " + linhas[3]);
				System.out.println("------------------------");

			}
			System.out.println("Leitura do arquivo concluída.");
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}

}
