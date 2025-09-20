public class Principal {

	public static void main(String[] args) {
		Contador contador = new Contador();

		ThreadContador tc = new ThreadContador(contador);

		Thread t1 = new Thread(tc);
		Thread t2 = new Thread(tc);

		t1.run();
		t2.run();

		System.out.println("Valor final do contador: " + contador.getContagem());
	}

}
