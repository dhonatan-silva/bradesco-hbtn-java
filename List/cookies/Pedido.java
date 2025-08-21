import java.util.ArrayList;

public class Pedido {
	private ArrayList<PedidoCookie> cookies;

	public Pedido() {
		cookies = new ArrayList<>();
	}

	public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
		cookies.add(pedidoCookie);
	}

	public int obterTotalCaixas() {
		int total = 0;
		for (PedidoCookie pedidoCookie : cookies) {
			total += pedidoCookie.getQuantidadeCaixas();
		}
		return total;
	}

	public int removerSabor(String sabor) {
		int total = 0;
		for (int i = 0; i < cookies.size(); i++) {
			PedidoCookie pedidoCookie = cookies.get(i);
			if (pedidoCookie.getSabor().equals(sabor)) {
				cookies.remove(i);
				total += pedidoCookie.getQuantidadeCaixas();
			}
		}
		return total;
	}

}
