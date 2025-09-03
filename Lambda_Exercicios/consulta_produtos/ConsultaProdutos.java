import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaProdutos {

	public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterioFiltro) {
		return (ArrayList<Produto>) produtos.stream()
											 .filter(x -> criterioFiltro.testar(x))
											 .collect(Collectors.toList());

	}

}
