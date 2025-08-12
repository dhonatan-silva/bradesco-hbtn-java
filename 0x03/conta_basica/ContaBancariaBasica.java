import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
	private String numeracao;
	private double saldo;
	private double taxaJurosAnual;

	public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
		this.numeracao = numeracao;
		this.taxaJurosAnual = taxaJurosAnual;
		this.saldo = 0;
	}

	public void depositar(double valor) throws OperacaoInvalidaException {
		if (valor <= 0) {
			throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
		}
		saldo = saldo + valor;
	}

	public void sacar(double valor) throws OperacaoInvalidaException {
		if (valor <= 0) {
			throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
		}

		if (valor > saldo) {
			throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
		}

		saldo = saldo - valor;
	}

	public double calcularTarifaMensal() {
		double percent = saldo * 0.1;
		return (percent < 10) ? percent : 10;
	}

	public double calcularJurosMensal() {
		double jurosMensal = 0;
		if (saldo > 0) {
			jurosMensal = (taxaJurosAnual / 12);
		}
		return jurosMensal / 100;
	}

	public void aplicarAtualizacaoMensal() {
		double tarifaMensal = calcularTarifaMensal();
		double jurosMensal = calcularJurosMensal();
		
		saldo = saldo + (saldo * jurosMensal);
		saldo = saldo - tarifaMensal;
	}

	public String getNumeracao() {
		return numeracao;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getTaxaJurosAnual() {
		return taxaJurosAnual;
	}

}
