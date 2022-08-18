package aplicacao;

import negocio.Album;
import negocio.Artista;
import negocio.Musica;

public class Monitor {
	private boolean ocupado = false;
	private Log recurso;

	public Monitor(Log recurso) {
		this.recurso = recurso;
	}

	public synchronized void release() {
		ocupado = false;
		notifyAll();
	}

	public synchronized void request() {
		while (ocupado) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		ocupado = true;
	}

	public boolean login(String login, String senha) {
		return recurso.login(login, senha);
	}

	public void inserirArtista(Artista artista) {
		recurso.inserirArtista(artista);
	}

	public void inserirMusica(Musica musica) {
		recurso.inserirMusica(musica);
	}

	public void inserirAlbum(Album album) {
		recurso.inserirAlbum(album);
	}

	public void lerArtista(Artista artista) {
		recurso.lerArtista(artista);
	}

	public void lerMusica(Musica musica) {
		recurso.lerMusica(musica);
	}

	public void lerAlbum(Album album) {
		recurso.lerAlbum(album);
	}

	public void atualizarArtista(Artista artista) {
		recurso.atualizarArtista(artista);
	}

	public void atualizarMusica(Musica musica) {
		recurso.atualizarMusica(musica);
	}

	public void atualizarAlbum(Album album) {
		recurso.atualizarAlbum(album);
	}

	public void removerArtista(Artista artista) {
		recurso.removerArtista(artista);
	}

	public void removerMusica(Musica musica) {
		recurso.removerMusica(musica);
	}

	public void removerAlbum(Album album) {
		recurso.removerAlbum(album);
	}
}
