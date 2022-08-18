package negocio;

import java.io.Serializable;

import javax.persistence.Column;

public class UsuarioKeys implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(length = 100)
	private String login;
	@Column(length = 100)
	private String senha;

	public UsuarioKeys() {
	}

	public UsuarioKeys(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
}
