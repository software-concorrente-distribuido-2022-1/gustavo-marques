package negocio;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import aplicacao.Gerador;

@Entity
@Table(name = "musica")
public class Musica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 100, nullable = false)
	private String titulo;
	@Column(nullable = false)
	private Time duracao;
	@ManyToOne
	@JoinColumn(name = "album_id")
	private Album album;

	public Musica() {
	}

	public void gerarDados() {
		titulo = Gerador.titulo();
		duracao = Gerador.tempo(0, 0, 1, 5, 0, 60);
		album = new Album();
		album.setId(Gerador.numeroInteiro(1, 50));
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Time getDuracao() {
		return duracao;
	}

	public Album getAlbum() {
		return album;
	}
}
