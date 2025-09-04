import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

	public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
		return pedido.getProdutos().stream()
									.filter(x -> x.getCategoria().equals(CategoriaProduto.LIVRO))
									.collect(Collectors.toList());
	}

}
