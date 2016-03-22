package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passagem")
@SequenceGenerator(name = "passagem_id_generator", sequenceName = "passagem_id_seq")
public class Passagem implements Serializable {

	private static final long serialVersionUID = -4648957372549599418L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passagem_id_generator")
	private Integer id;

	@Column(name = "porcentagem_desconto")
	private Integer porcentagemDesconto;

	@ManyToMany
	@JoinTable(
		name = "checkin",
		joinColumns = {
			@JoinColumn(name = "id_passagem")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "id_assento")
		}
	)
	private List<Assento> assentos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_voo", nullable = false)
	private Voo voo;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPorcentagemDesconto() {
		return this.porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Integer porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public List<Assento> getAssentos() {
		return this.assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Voo getVoo() {
		return this.voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
}