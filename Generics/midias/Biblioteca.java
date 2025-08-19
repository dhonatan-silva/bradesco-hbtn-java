import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T> extends Midia{

	private List<T> midias = new ArrayList<>();

	public void adicionarMidia(T midia) {
		midias.add(midia);
	}

	public String obterListaMidias() {
		return midias.toString();
	}

}
