import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsultaPessoas {

	public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> todasPessoas) {
		return todasPessoas.stream()
				.collect(Collectors.groupingBy(
						Pessoa::getCargo,        //chave do map
						() -> new TreeMap<>(Comparator.reverseOrder()), //tipo de map
						Collectors.toCollection( //valor do map
								TreeSet::new     //tipo do valor
								)));
	}

	public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> todasPessoas) {
		return todasPessoas.stream()
				.collect(Collectors.groupingBy(
						Pessoa::getCargo,
						Collectors.counting()
						));
	}

	public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> todasPessoas) {
		return todasPessoas.stream()
				.collect(Collectors.groupingBy(
						Pessoa::getCargo,
						Collectors.groupingBy(
							Pessoa::getIdade,
								Collectors.counting()
								)));
	}

	public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> todasPessoas) {
		return todasPessoas.stream()
				.collect(Collectors.groupingBy(
						Pessoa::getCargo,
						Collectors.averagingDouble(
								Pessoa::getSalario
								)));
	}
}
