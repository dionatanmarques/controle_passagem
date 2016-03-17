package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "voo")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "voo_id_seq")
public class Voo implements Serializable {

	private static final long serialVersionUID = -2093323231173103850L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_local_origem", nullable = false)
	private Local localOrigem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_local_destino", nullable = false)
	private Local localDestino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aviao", nullable = false)
	private Aviao aviao;

	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "data_embarque_voo")
	private Date dataEmbarque;

	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "data_desembarque_voo")
	private Date dataDesembarque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_piloto", nullable = false)
	private Piloto piloto;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "voo_lanche",
		joinColumns = @JoinColumn(name = "id_voo"),
		inverseJoinColumns = @JoinColumn(name = "id_lanche")
	)
	private List<Lanche> lanches;

	private BigDecimal preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Local getLocalOrigem() {
		return localOrigem;
	}

	public void setLocalOrigem(Local localOrigem) {
		this.localOrigem = localOrigem;
	}

	public Local getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(Local localDestino) {
		this.localDestino = localDestino;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Date getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public Date getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(Date dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}