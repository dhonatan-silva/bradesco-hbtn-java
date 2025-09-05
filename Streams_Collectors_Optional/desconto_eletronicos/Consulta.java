import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

	public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
		return pedido.getProdutos().stream()
								   .filter(x -> x.getCategoria().equals(CategoriaProduto.LIVRO))
								   .collect(Collectors.toList());
	}
	
	public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
		return produtos.stream()
						.sorted(Comparator.comparing(Produto::getPreco).reversed())
						.collect(Collectors.toList())
						.get(0);
	}
	
	public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double valorMinimo) {
		return produtos.stream()
					   .filter(x -> x.getPreco() >= valorMinimo)
				       .collect(Collectors.toList());
	}
	
	public static List<Pedido> obterPedidosComEletronicos(List<Pedido> listaPedidos) {
		List<Pedido> listaFiltrada = new  ArrayList<>();
		
		for (Pedido pedido : listaPedidos) {
			if (pedido.getProdutos().stream().anyMatch(x -> x.getCategoria().equals(CategoriaProduto.ELETRONICO))) {
				listaFiltrada.add(pedido);
			}
		}
		return listaFiltrada;
	}
	
	public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> listaProdutos) {
		return listaProdutos.stream().map(x -> {
			if (x.getCategoria().equals(CategoriaProduto.ELETRONICO)) {
				return new Produto(x.getCodigo(), x.getNome(), x.getCategoria(), x.getPreco() * 0.85);
			}
			return x;
		}).collect(Collectors.toList());
	}

}
