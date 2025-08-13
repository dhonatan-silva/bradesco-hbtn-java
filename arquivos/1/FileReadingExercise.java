import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExercise {

	public static void main(String[] args) {
		String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura

		// efetue a leitura do arquivo

		File arquivo = new File(fileName);

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}

	}

}
