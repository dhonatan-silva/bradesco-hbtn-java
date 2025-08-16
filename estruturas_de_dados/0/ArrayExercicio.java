import java.util.Scanner;

public class ArrayExercicio {
	public static void main(String[] args) {
		// Criando o scanner para entrada de dados
		Scanner scanner = new Scanner(System.in);

		// Definindo o tamanho do array
		int tamanhoArray = 10;
		int[] numeros = new int[tamanhoArray];
		int soma = 0;
		int maiorNumero = Integer.MIN_VALUE;

		// Preenchendo o array com números fornecidos pelo usuário
		// Utilize scanner.nextInt(); para receber o numero digitado
		System.out.println("Digite 10 números inteiros:");
		for (int i = 0; i < numeros.length; i++) {
			int n = Integer.parseInt(scanner.nextLine());
			numeros[i] = n;
		}
		// Exibindo os resultados
		for (int i = 0; i < numeros.length; i++) {
			int e = i + 1;
			System.out.println("Digite o número " + e + ": " + numeros[i]);
		}
		System.out.println("\n");
		System.out.println("Conteúdo do array:");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < numeros.length; i++) {
			builder.append(String.valueOf(numeros[i]));
			builder.append(" ");
		}
		System.out.println(builder.toString());

		for (int i = 0; i < numeros.length; i++) {
			soma = soma + numeros[i];
		}

		System.out.println("Soma de todos os números: " + soma);

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > maiorNumero) {
				maiorNumero = numeros[i];
			}
		}

		System.out.println("Maior número no array: " + maiorNumero);
		// Fechando o scanner
		scanner.close();
	}
}
