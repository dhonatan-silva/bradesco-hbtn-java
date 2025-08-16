import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
	private List<Aluno> listaAlunos = new ArrayList<>();

	public void adicionarAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}

	public void excluirAluno(String nome) {
		for (Aluno aluno : listaAlunos) {
			if (aluno.getNome().equals(nome)) {
				listaAlunos.remove(aluno);
				break;
			}
		}
	}

	public void buscarAluno(String nome) {
		for (Aluno aluno : listaAlunos) {
			if (aluno.getNome().equals(nome)) {
				System.out.println(aluno.toString());
				break;
			}
		}
	}

	public void listarAlunos() {
		for (Aluno aluno : listaAlunos) {
			System.out.println(aluno.toString());
		}
	}

}
