public class Pedido {
	private double percentualDesconto;
	private ItemPedido[] itens;
	private double total;
	private double desconto;

	public Pedido(double percentualDesconto, ItemPedido[] itens) {
		this.percentualDesconto = percentualDesconto;
		this.itens = itens;
	}

	public double calcularTotal() {
		double precoTotalItens = 0;
		for (ItemPedido itemPedido : itens) {
			precoTotalItens = precoTotalItens
					+ itemPedido.getQuantidade() * itemPedido.getProduto().obterPrecoLiquido();
			total = precoTotalItens;
		}

		if (percentualDesconto > 0) {
			desconto = precoTotalItens * (percentualDesconto / 100);
			precoTotalItens = precoTotalItens - desconto;
		}
		return precoTotalItens;
	}

	public void apresentarResumoPedido() {
		calcularTotal();

		StringBuilder builder = new StringBuilder();
		builder.append("------- RESUMO PEDIDO -------\n");
		for (ItemPedido item : itens) {
			builder.append("Tipo: " + item.getProduto().getClass().getSimpleName().toString() + " ");
			builder.append("Titulo: " + item.getProduto().getTitulo() + " ");
			builder.append(String.format("Preco: %.2f", item.getProduto().obterPrecoLiquido()) + " ");
			builder.append("Quant: " + item.getQuantidade() + " ");
			builder.append(String.format("Total: %.2f", item.getProduto().obterPrecoLiquido() * item.getQuantidade()) + "\n");
		}

		builder.append("----------------------------" + "\n");
		builder.append(String.format("DESCONTO: %.2f", desconto) + "\n");
		builder.append(String.format("TOTAL PRODUTOS: %.2f", total) + "\n");
		builder.append("----------------------------" + "\n");
		builder.append(String.format("TOTAL PEDIDO: %.2f", calcularTotal()) + "\n");
		builder.append("----------------------------" + "\n");

		System.out.printf(builder.toString());
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public ItemPedido[] getItens() {
		return itens;
	}

	public void setItens(ItemPedido[] itens) {
		this.itens = itens;
	}

}
