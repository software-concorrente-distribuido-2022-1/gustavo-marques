package persistencia;

import javax.persistence.EntityManager;

import negocio.Musica;

public class MusicaDAO {
	private EntityManager em;

	public MusicaDAO(EntityManager em) {
		this.em = em;
	}

	public void incluir(Musica musica) {
		em.persist(musica);
	}

	public Musica ler(int id) {
		return em.find(Musica.class, id);
	}

	public void atualizar(Musica musica) {
		em.merge(musica);
	}

	public void remover(Musica musica) {
		musica = em.merge(musica);
		em.remove(musica);
	}
}
