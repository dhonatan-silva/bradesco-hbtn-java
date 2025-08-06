public class Gerente extends Empregado {

	public Gerente(double salarioFixo) {
		super(salarioFixo);
	}

	@Override
	public double calcularBonus(Departamento departamento) {
		if (departamento.getValorAtingidoMeta() >= departamento.getValorMeta()) {
			double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
			return (getSalarioFixo() * 0.2) + (diferenca * 0.01);
		}
		return 0;
	}

}
