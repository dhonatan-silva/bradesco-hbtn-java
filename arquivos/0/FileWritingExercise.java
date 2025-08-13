import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Solicita o nome do arquivo
		System.out.print("Digite o nome do arquivo (com extensão .txt): ");
		String fileName = scanner.nextLine();

		// implemente o codigo aqui

		// Cria um objeto File
		File arquivo = new File("C:\\Users\\dhona\\OneDrive\\Documentos\\teste\\" + fileName);

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();

			if (linha.equals("sair")) {
				break;
			}

			try {
				// Cria um objeto FileWriter para escrever no arquivo
				FileWriter fileWriter = new FileWriter(arquivo, true); // true para append

				// Cria um objeto BufferedWriter para otimizar a escrita
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				// Escreve o conteúdo no arquivo
				bufferedWriter.write(linha);
				bufferedWriter.newLine();

				// Fecha o BufferedWriter e FileWriter
				bufferedWriter.close();
				fileWriter.close();

			} catch (IOException e) {
				System.err.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
				e.printStackTrace();
			}

		}

		System.out.println("Arquivo criado e seu conteúdo foi salvo com sucesso");

		scanner.close();
	}

}
