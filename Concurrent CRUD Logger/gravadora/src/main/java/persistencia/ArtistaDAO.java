package persistencia;

import javax.persistence.EntityManager;

import negocio.Artista;

public class ArtistaDAO {
	private EntityManager em;

	public ArtistaDAO(EntityManager em) {
		this.em = em;
	}

	public void incluir(Artista artista) {
		em.persist(artista);
	}

	public Artista ler(int id) {
		return em.find(Artista.class, id);
	}

	public void atualizar(Artista artista) {
		em.merge(artista);
	}

	public void remover(Artista artista) {
		artista = em.merge(artista);
		em.remove(artista);
	}
}
