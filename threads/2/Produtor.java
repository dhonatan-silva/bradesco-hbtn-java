import java.util.Random;
public class Produtor implements Runnable {
	private Fila fila;

	public Produtor(Fila fila) {
		this.fila = fila;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= fila.getCapacidade(); i++) {
				Random random = new Random();
				int numero = random.nextInt(100) + 1;
				fila.adicionar(numero); // O produtor coloca os itens na lista
				Thread.sleep(500); // Simula o tempo para produzir um item
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
