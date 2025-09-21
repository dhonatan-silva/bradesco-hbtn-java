public class SistemaFilas {

	public static void main(String[] args) throws InterruptedException {

		try {
			Fila fila = new Fila(10);

			Produtor produtor = new Produtor(fila);
			Consumidor consumidor = new Consumidor(fila);

			Thread t1 = new Thread(produtor);
			Thread t2 = new Thread(consumidor);

			Thread t3 = new Thread(produtor);
			Thread t4 = new Thread(consumidor);

			t1.start();
			t2.start();
			t3.start();
			t4.start();

			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);

	}

}
