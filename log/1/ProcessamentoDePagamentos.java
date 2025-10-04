import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessamentoDePagamentos {

	// Logger SLF4j
	private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

	public static void main(String[] args) {

		// implemente o codigo necessario para resolucao do problema

		List<String> pagamentos = new ArrayList<>();
		pagamentos.add("falha");
		pagamentos.add("sucesso");
		pagamentos.add("sucesso");
		pagamentos.add("falha");
		pagamentos.add("pendente");

		for (int i = 0; i < pagamentos.size(); i++) {
			String pagamento = pagamentos.get(i);
			int indice = i + 1;
			logger.info("Iniciando o processamento do pagamento {}", indice);

			realizarProcessamento(pagamento, indice);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("Processamento de pagamentos concluído.");

	}

	public static void realizarProcessamento(String pagamento, int indice) {
		if (pagamento.equals("falha")) {
			logger.error("Erro ao processar o pagamento {}: Falha na transação.", indice);
		} else if (pagamento.equals("pendente")) {
			logger.error("Pagamento {} está pendente. Aguardando confirmação.", indice);
		} else {
			logger.error("Pagamento {} processado com sucesso.", indice);
		}
	}
}
