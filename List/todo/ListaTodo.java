import java.util.ArrayList;

public class ListaTodo {

	private ArrayList<Tarefa> tarefas;

	public ListaTodo() {
		tarefas = new ArrayList<>();
	}

	public void adicionarTarefa(Tarefa tarefa) {
		for (Tarefa trf : tarefas) {
			if (trf.getIdentificador() == tarefa.getIdentificador()) {
				throw new IllegalArgumentException(
						String.format("Tarefa com identificador %s ja existente na lista", trf.getIdentificador()));
			}
		}
		tarefas.add(tarefa);
	}

	public boolean marcarTarefaFeita(int identificador) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getIdentificador() == identificador) {
				tarefa.setEstahFeita(true);
				return true;
			}
		}
		return false;
	}

	public boolean desfazerTarefa(int identificador) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getIdentificador() == identificador) {
				tarefa.setEstahFeita(false);
				return true;
			}
		}
		return false;
	}

	public void desfazerTodas() {
		for (Tarefa tarefa : tarefas) {
			tarefa.setEstahFeita(false);
		}
	}

	public void fazerTodas() {
		for (Tarefa tarefa : tarefas) {
			tarefa.setEstahFeita(true);
		}
	}

	public void listarTarefas() {
		for (Tarefa tarefa : tarefas) {
			System.out.println(String.format("[%s]  Id: %s - Descricao: %s", tarefa.isEstahFeita() ? "X" : " ",
					tarefa.getIdentificador(), tarefa.getDescricao()));
		}
	}

	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
