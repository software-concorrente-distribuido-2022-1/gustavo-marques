package persistencia;

import javax.persistence.EntityManager;

import negocio.Album;

public class AlbumDAO {
	private EntityManager em;

	public AlbumDAO(EntityManager em) {
		this.em = em;
	}
	
	public void incluir(Album album) {
		em.persist(album);
	}
	
	public Album ler(int id) {
		return em.find(Album.class, id);
	}
	
	public void atualizar(Album album) {
		em.merge(album);
	}
	
	public void remover(Album album) {
		album = em.merge(album);
		em.remove(album);
	}
}
