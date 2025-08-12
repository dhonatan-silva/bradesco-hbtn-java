import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {

	public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
		super(numeracao, taxaJurosAnual);
	}

	private int quantidadeTransacoes;

	@Override
	public void sacar(double valor) throws OperacaoInvalidaException {
		super.sacar(valor);
		setSaldo(getSaldo() - 0.10);
	}

	@Override
	public void depositar(double valor) throws OperacaoInvalidaException {
		super.depositar(valor);
		setSaldo(getSaldo() - 0.10);
	}

	public int getQuantidadeTransacoes() {
		return quantidadeTransacoes;
	}

}
