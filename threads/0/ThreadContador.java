public class ThreadContador implements Runnable {
	private Contador contador;

	public ThreadContador(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		// Cada thread incrementa o contador 1000 vezes
		for (int i = 0; i < 1000; i++) {
			contador.incrementar();
		}
	}
}
