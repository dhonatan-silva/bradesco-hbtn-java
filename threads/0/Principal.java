public class Principal {

	public static void main(String[] args) throws InterruptedException {
		Contador contador = new Contador();

		ThreadContador tc = new ThreadContador(contador);

		Thread t1 = new Thread(tc);
		Thread t2 = new Thread(tc);

		t1.start();
		t1.join();
		t2.start();
		t2.join();

		System.out.println("Valor final do contador: " + contador.getContagem());
	}

}
