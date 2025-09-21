import java.util.LinkedList;

public class Fila {

	private LinkedList<Integer> itens;
	private int capacidade;

	public Fila(int capacidade) {
		this.capacidade = capacidade;
		itens = new LinkedList<>();
	}

	// Método para o produtor colocar um item na fila
	public synchronized void adicionar(int item) throws InterruptedException {
		// Se a fila não tem capacidade, espera o consumidor consumi-lo
		while (this.itens.size() >= this.capacidade) {
			wait(); // Espera o consumidor consumir o item
		}

		// Coloca o item na lista
		this.itens.add(item);
		System.out.println("Produtor produziu: " + item);

		// Notifica o consumidor que o item foi produzido
		notify();

	}

	// Método para o consumidor retirar um item da lista
	public synchronized void retirar() throws InterruptedException {
		// Se a fila estiver vazia, espera o produtor produzir um item
		while (this.itens.isEmpty()) {
			wait(); // Espera o produtor produzir um item
		}

		// Retira o item da fila
		Integer remove = this.itens.remove(0);
		System.out.println("Consumidor consumiu: " + remove);

		// Notifica o consumidor que o item foi produzido
		notify();

	}

	public int getCapacidade() {
		return capacidade;
	}

}
