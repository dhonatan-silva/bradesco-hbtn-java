import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
	public List<CanalNotificacao> canais = new ArrayList<>();

	public void registrarCanal(CanalNotificacao canal) {
		canais.add(canal);
	}

	public void processar(Video video) {
		for (CanalNotificacao canal : canais) {
			Mensagem mensagem = new Mensagem(TipoMensagem.LOG, video.getArquivo() + " - " + video.getFormato());
			canal.notificar(mensagem);
		}
	}
}
