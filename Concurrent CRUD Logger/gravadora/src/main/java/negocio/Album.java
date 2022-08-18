package negocio;

import java.sql.Date;

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
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 100, nullable = false)
	private String titulo;
	@Column(name = "data_lancamento", nullable = false)
	private Date dataLancamento;
	@ManyToOne
	@JoinColumn(name = "artista_id")
	private Artista produtor;

	public Album() {
	}

	public void gerarDados() {
		titulo = Gerador.titulo();
		dataLancamento = Gerador.data(1970, 2022);
		produtor = new Artista();
		produtor.setId(Gerador.numeroInteiro(1, 50));
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

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public Artista getProdutor() {
		return produtor;
	}
}
