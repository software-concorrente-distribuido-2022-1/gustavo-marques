package aplicacao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import negocio.Album;
import negocio.Artista;
import negocio.Musica;
import negocio.Usuario;
import persistencia.AlbumDAO;
import persistencia.ArtistaDAO;
import persistencia.JPAUtil;
import persistencia.LogDAO;
import persistencia.MusicaDAO;
import persistencia.UsuarioDAO;

public class Log {
	private String login, texto;
	private Date data;
	private Time horario;
	private EntityManager em = JPAUtil.getEntityManager();

	public boolean login(String login, String senha) {
		setDataHorario();
		this.login = login;

		UsuarioDAO dao = new UsuarioDAO(em);
		Usuario user;
		em.getTransaction().begin();
		user = dao.getUsuario(login, senha);
		em.getTransaction().commit();
		if (user != null) {
			texto = "Usuario \"" + login + "\" fez acesso no dia " + data + " as " + horario;
			LogDAO.gravarAcesso(texto);
			return true;
		} else {
			texto = "Usuario \"" + login + "\" tentou e nao consegiu fazer acesso no dia " + data + " as " + horario;
			LogDAO.gravarAcesso(texto);
			return false;
		}
	}

	public void inserirArtista(Artista artista) {
		setDataHorario();

		try {
			ArtistaDAO dao = new ArtistaDAO(em);
			em.getTransaction().begin();
			dao.incluir(artista);
			texto = "Usuario \"" + login + "\" INSERIU um novo Artista(cpf: " + artista.getCpf() + ", nome: "
					+ artista.getNome() + ") no dia " + data + " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu INSERIR um novo Artista(cpf: " + artista.getCpf()
					+ ", nome: " + artista.getNome() + ") no dia " + data + " as " + horario;
		}
		LogDAO.gravarOperacao(texto);
	}

	public void inserirMusica(Musica musica) {
		setDataHorario();

		try {
			MusicaDAO dao = new MusicaDAO(em);
			em.getTransaction().begin();
			dao.incluir(musica);
			texto = "Usuario \"" + login + "\" INSERIU uma nova Musica(titulo: " + musica.getTitulo() + ", duracao: "
					+ musica.getDuracao() + ",  album: " + musica.getAlbum().getTitulo() + ") no dia " + data + " as "
					+ horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu INSERIR uma nova Musica(titulo: "
					+ musica.getTitulo() + ", duracao: " + musica.getDuracao() + ",  album: "
					+ musica.getAlbum().getTitulo() + ") no dia " + data + " as " + horario;
		}
		LogDAO.gravarOperacao(texto);
	}

	public void inserirAlbum(Album album) {
		setDataHorario();

		try {
			AlbumDAO dao = new AlbumDAO(em);
			em.getTransaction().begin();
			dao.incluir(album);
			texto = "Usuario \"" + login + "\" INSERIU um novo Album(titulo: " + album.getTitulo()
					+ ", data de lancamento: " + album.getDataLancamento() + ",  produtor: "
					+ album.getProdutor().getNome() + ") no dia " + data + " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu INSERIR um novo Album(titulo: "
					+ album.getTitulo() + ", data de lancamento: " + album.getDataLancamento() + ",  produtor: "
					+ album.getProdutor().getNome() + ") no dia " + data + " as " + horario;
		}
		LogDAO.gravarOperacao(texto);
	}

	public void lerArtista(Artista artista) {
		setDataHorario();

		ArtistaDAO dao = new ArtistaDAO(em);
		em.getTransaction().begin();
		artista = dao.ler(artista.getId());
		em.getTransaction().commit();
		if (artista != null) {
			texto = "Usuario \"" + login + "\" LEU o Artista(cpf: " + artista.getCpf() + ", nome: " + artista.getNome()
					+ ") no dia " + data + " as " + horario;
		} else {
			texto = "Usuario \"" + login + "\" tentou LER o Artista que nao existe";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void lerMusica(Musica musica) {
		setDataHorario();

		MusicaDAO dao = new MusicaDAO(em);
		em.getTransaction().begin();
		musica = dao.ler(musica.getId());
		em.getTransaction().commit();
		if (musica != null) {
			texto = "Usuario \"" + login + "\" LEU a Musica(titulo: " + musica.getTitulo() + ", duracao: "
					+ musica.getDuracao() + ",  album: " + musica.getAlbum().getTitulo() + ") no dia " + data + " as "
					+ horario;
		} else {
			texto = "Usuario \"" + login + "\" tentou LER uma Musica que nao existe";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void lerAlbum(Album album) {
		setDataHorario();

		AlbumDAO dao = new AlbumDAO(em);
		em.getTransaction().begin();
		album = dao.ler(album.getId());
		em.getTransaction().commit();
		if (album != null) {
			texto = "Usuario \"" + login + "\" LEU o Album(titulo: " + album.getTitulo() + ", data de lancamento: "
					+ album.getDataLancamento() + ",  produtor: " + album.getProdutor().getNome() + ") no dia " + data
					+ " as " + horario;
		} else {
			texto = "Usuario \"" + login + "\" tentou LER um Album que nao existe";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void atualizarArtista(Artista artista) {
		setDataHorario();

		try {
			ArtistaDAO dao = new ArtistaDAO(em);
			final Artista aux;
			em.getTransaction().begin();
			aux = dao.ler(artista.getId());
			dao.atualizar(artista);
			texto = "Usuario \"" + login + "\" ATUALIZOU o Artista(cpf: " + aux.getCpf() + " -> " + artista.getCpf()
					+ ", nome: " + aux.getNome() + " -> " + artista.getNome() + ") no dia " + data + " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu ATUALIZAR o Artista(id: " + artista.getId() + ")";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void atualizarMusica(Musica musica) {
		setDataHorario();

		try {
			MusicaDAO dao = new MusicaDAO(em);
			final Musica aux;
			em.getTransaction().begin();
			aux = dao.ler(musica.getId());
			dao.atualizar(musica);
			texto = "Usuario \"" + login + "\" ATUALIZOU a Musica(titulo: " + aux.getTitulo() + " -> "
					+ musica.getTitulo() + ", duracao: " + aux.getDuracao() + " -> " + musica.getDuracao()
					+ ",  album: " + aux.getAlbum().getTitulo() + " -> " + musica.getAlbum().getTitulo() + ") no dia "
					+ data + " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu ATUALIZAR a Musica(id: " + musica.getId() + ")";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void atualizarAlbum(Album album) {
		setDataHorario();

		try {
			AlbumDAO dao = new AlbumDAO(em);
			final Album aux;
			em.getTransaction().begin();
			aux = dao.ler(album.getId());
			dao.atualizar(album);
			texto = "Usuario \"" + login + "\" ATUALIZOU o Album(titulo: " + aux.getTitulo() + " -> "
					+ album.getTitulo() + ", data de lancamento: " + aux.getDataLancamento() + " -> "
					+ album.getDataLancamento() + ",  produtor: " + aux.getProdutor().getNome() + " -> "
					+ album.getProdutor().getNome() + ") no dia " + data + " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu ATUALIZAR o Album(id: " + album.getId() + ")";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void removerArtista(Artista artista) {
		setDataHorario();

		try {
			ArtistaDAO dao = new ArtistaDAO(em);
			em.getTransaction().begin();
			dao.remover(artista);
			texto = "Usuario \"" + login + "\" REMOVEU o Artista(cpf: " + artista.getCpf() + ", nome: "
					+ artista.getNome() + ") no dia " + data + " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu REMOVER o Artista(id: " + artista.getId() + ")";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void removerMusica(Musica musica) {
		setDataHorario();

		try {
			MusicaDAO dao = new MusicaDAO(em);
			em.getTransaction().begin();
			dao.remover(musica);
			texto = "Usuario \"" + login + "\" REMOVEU a Musica(titulo: " + musica.getTitulo() + ", duracao: "
					+ musica.getDuracao() + ",  album: " + musica.getAlbum().getTitulo() + ") no dia " + data + " as "
					+ horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu REMOVER a Musica(id: " + musica.getId() + ")";
		}
		LogDAO.gravarOperacao(texto);
	}

	public void removerAlbum(Album album) {
		setDataHorario();

		try {
			AlbumDAO dao = new AlbumDAO(em);
			em.getTransaction().begin();
			dao.remover(album);
			texto = "Usuario \"" + login + "\" REMOVEU o Album(titulo: " + album.getTitulo() + ", data de lancamento: "
					+ album.getDataLancamento() + ",  produtor: " + album.getProdutor().getNome() + ") no dia " + data
					+ " as " + horario;
			em.getTransaction().commit();
		} catch (Exception e) {
			texto = "Usuario \"" + login + "\" tentou e nao conseguiu REMOVER o Album(id: " + album.getId() + ")";
		}
		LogDAO.gravarOperacao(texto);
	}

	private void setDataHorario() {
		data = Date.valueOf(LocalDate.now());
		horario = Time.valueOf(LocalTime.now());
	}
}
