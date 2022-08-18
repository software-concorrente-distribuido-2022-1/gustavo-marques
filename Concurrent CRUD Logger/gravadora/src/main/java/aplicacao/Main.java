package aplicacao;

import negocio.Usuario;
import negocio.UsuarioKeys;

public class Main {

	public static void main(String[] args) {
		Log log = new Log();
		Monitor monitor = new Monitor(log);

		for (int i = 1; i <= 10; i++) {
			Usuario usuario = new Usuario(new UsuarioKeys("user" + i, "password" + i), monitor);
			usuario.start();
		}

	}

}
