public class Empregado {
	private double salarioFixo;

	public Empregado(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	double calcularBonus(Departamento departamento) {
		if (departamento.getValorAtingidoMeta() >= departamento.getValorMeta()) {
			return salarioFixo * 0.1;
		}
		return 0;
	}

	double calcularSalarioTotal(Departamento departamento) {
		return salarioFixo + calcularBonus(departamento);
	}

}
