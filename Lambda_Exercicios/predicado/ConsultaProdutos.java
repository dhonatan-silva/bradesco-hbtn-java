import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultaProdutos {

	public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> criterioFiltro) {
		return (ArrayList<Produto>) produtos.stream()
											 .filter(x -> criterioFiltro.test(x))
											 .collect(Collectors.toList());

	}

}
