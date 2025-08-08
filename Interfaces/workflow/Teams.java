public class Teams implements CanalNotificacao {

	@Override
	public void notificar(Mensagem mensagem) {
		System.out.printf("[TEAMS] {%s} - %s", mensagem.getTipo(), mensagem.getTexto() + "\n");
	}

}
