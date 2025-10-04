import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SistemaDeGestaoDePedidos {

	// Logger SLF4j
	private static final Logger logger = LoggerFactory.getLogger(SistemaDeGestaoDePedidos.class);

	// Simulação de um banco de dados simples com mapa de pedidos
	private static final Map<Integer, Pedido> pedidos = new HashMap<>();

	public static void main(String[] args) {

		logger.info("Sistema de Gestão de Pedidos iniciado.");

		// Criando pedidos
		criarPedido(1, "Produto A", 100.00);
		criarPedido(2, "Produto B", 50.00);

		// Pagamento de pedidos
		pagarPedido(1, 100.00);
		pagarPedido(2, 60.00); // Pagamento incorreto

		// Cancelando pedidos
		cancelarPedido(1);
		cancelarPedido(3); // Pedido inexistente

		logger.info("Sistema de Gestão de Pedidos finalizado.");
	}

	// Função para criar um pedido
	private static void criarPedido(int id, String nomeProduto, double valor) {
		// implemente aqui
		boolean contain = pedidos.containsKey(id);
		if (contain) {
			logger.warn("Pedido: ID = {} já existe");
		} else {
			pedidos.put(id, new Pedido(id, nomeProduto, valor));
			logger.info("Criando pedido: ID = {} - Produto = {} - Valor = {}", id, nomeProduto, valor);
			logger.info("Pedido ID {} criado com sucesso!", id);
		}
	}

	// Função para pagar um pedido
	private static void pagarPedido(int id, double valorPago) {
		// implemente aqui
		Pedido pedido = pedidos.get(id);
		logger.info("Processando pagamento do pedido ID {} - Valor pago = {}", id, valorPago);
		if (pedido.getValor() == valorPago) {
			pedido.setPago(true);
			pedidos.put(id, pedido);
			logger.info("Pagamento do pedido ID {} realizado com sucesso!", id);
		} else {
			logger.error("Erro ao pagar: Valor pago {} é diferente do valor do pedido {} para o pedido ID {}.",
					valorPago, pedido.getValor(), id);
		}
	}

	// Função para cancelar um pedido
	private static void cancelarPedido(int id) {
		// implemente aqui
		Pedido pedido = pedidos.get(id);
		logger.info("Processando cancelamento do pedido ID {}", id);
		if (pedido == null) {
			logger.error("Erro ao cancelar: Pedido ID {} não encontrado.", id);
		} else if (pedido.isPago()) {
			logger.warn("Não é possível cancelar o pedido ID 1 pois já foi pago.", id);
		} else {
			pedidos.put(id, new Pedido(id, "", 0));
		}
	}
}