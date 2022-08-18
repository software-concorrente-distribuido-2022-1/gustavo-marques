package persistencia;

import javax.persistence.EntityManager;

import negocio.Usuario;
import negocio.UsuarioKeys;

public class UsuarioDAO {
	private EntityManager em;
	
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}
	
	public Usuario getUsuario(String login, String senha) {
		return em.find(Usuario.class, new UsuarioKeys(login, senha));
	}
}
