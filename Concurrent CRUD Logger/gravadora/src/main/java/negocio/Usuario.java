package negocio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import aplicacao.Gerador;
import aplicacao.Monitor;

@Entity
@Table(name = "usuario")
public class Usuario extends Thread implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private UsuarioKeys keys;
	@Transient
	private Monitor monitor;

	public Usuario() {
	}

	public Usuario(UsuarioKeys keys, Monitor monitor) {
		this.keys = keys;
		this.monitor = monitor;
	}

	public void run() {
		monitor.request();
		if (monitor.login(keys.getLogin(), keys.getSenha())) {
			int operacao = Gerador.numeroInteiro(1, 12);
			int idAleatorio = Gerador.numeroInteiro(1, 100);
			Artista artista = new Artista();
			Musica musica = new Musica();
			Album album = new Album();
			switch (operacao) {
			case 1:
				artista.gerarDados();
				monitor.inserirArtista(artista);
				break;
			case 2:
				musica.gerarDados();
				monitor.inserirMusica(musica);
				break;
			case 3:
				album.gerarDados();
				monitor.inserirAlbum(album);
				break;
			case 4:
				artista.setId(idAleatorio);
				monitor.lerArtista(artista);
				break;
			case 5:
				musica.setId(idAleatorio);
				monitor.lerMusica(musica);
				break;
			case 6:
				album.setId(idAleatorio);
				monitor.lerAlbum(album);
				break;
			case 7:
				artista.setId(idAleatorio);
				artista.gerarDados();
				monitor.atualizarArtista(artista);
				break;
			case 8:
				musica.setId(idAleatorio);
				musica.gerarDados();
				monitor.atualizarMusica(musica);
				break;
			case 9:
				album.setId(idAleatorio);
				album.gerarDados();
				monitor.atualizarAlbum(album);
				break;
			case 10:
				artista.setId(idAleatorio);
				monitor.removerArtista(artista);
				break;
			case 11:
				musica.setId(idAleatorio);
				monitor.removerMusica(musica);
				break;
			case 12:
				album.setId(idAleatorio);
				monitor.removerAlbum(album);
				break;
			}
		}
		monitor.release();
	}
}
