import java.util.List;

public class ManipularArrayNumeros {

	public static int buscarPosicaoNumero(List<Integer> numeros, int valor) {
		for (int i = 0; i < numeros.size(); i++) {
			Integer numero = numeros.get(i);
			if (numero.equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	public static void adicionarNumero(List<Integer> numeros, int valor) {
		int index = buscarPosicaoNumero(numeros, valor);
		if (index != -1) {
			throw new IllegalArgumentException("Numero jah contido na lista");
		} else {
			numeros.add(valor);
		}
	}

	public static void removerNumero(List<Integer> numeros, int valor) {
		int index = buscarPosicaoNumero(numeros, valor);
		if (index == -1) {
			throw new IllegalArgumentException("Numero nao encontrado na lista");
		} else {
			numeros.remove(index);
		}
	}

	public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
		int index = buscarPosicaoNumero(numeros, numeroSubstituir);
		if (index == -1) {
			adicionarNumero(numeros, numeroSubstituto);
		} else {
			numeros.set(index, numeroSubstituto);
		}
	}

}
