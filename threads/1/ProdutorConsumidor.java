public class ProdutorConsumidor {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();

		Consumidor consumidor = new Consumidor(buffer);

		Produtor produtor = new Produtor(buffer);

		// Criar e iniciar as threads do produtor e consumidor
		Thread t1 = new Thread(produtor);
		Thread t2 = new Thread(consumidor);

		t1.start();
		t2.start();

	}
}
