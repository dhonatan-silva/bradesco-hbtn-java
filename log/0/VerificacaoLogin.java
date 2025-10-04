import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerificacaoLogin {

	// Inicialização do logger
	private static final Logger logger = LoggerFactory.getLogger(VerificacaoLogin.class);

	public static void main(String[] args) {
		// Simulação de entradas do usuário
		String usuarioCorreto = "admin";
		String senhaCorreta = "12345";

		// Tentativas de login
		realizarLogin("admin", "12345", usuarioCorreto, senhaCorreta); // Login correto
		realizarLogin("admin", "senhaErrada", usuarioCorreto, senhaCorreta); // Senha incorreta
		realizarLogin("usuarioDesconhecido", "12345", usuarioCorreto, senhaCorreta); // Usuário desconhecido
	}

	public static void realizarLogin(String usuario, String senha, String usuarioCorreto, String senhaCorreta) {
		// implemente aqui o log
		if (usuario.equals("usuarioDesconhecido")) {
			logger.error("Tentativa de longin: usuario {} não localizado!", usuario);
		} else if (senha.equals("senhaErrada")) {
			logger.warn("Tentativa de longin: senha errada!");
		} else {
			logger.info("Tentativa de longin: usuario {} logado com sucesso!", usuario);
		}
	}
}
