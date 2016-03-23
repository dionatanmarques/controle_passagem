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
import javax.persistence.Transient;

@Entity
@Table(name = "voo")
@SequenceGenerator(name = "voo_id_generator", sequenceName = "voo_id_seq")
public class Voo implements Serializable {

	private static final long serialVersionUID = -6621689650827007726L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voo_id_generator")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "data_desembarque")
	private Date dataDesembarque;

	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "data_embarque")
	private Date dataEmbarque;

	@Basic(optional = false)
	private BigDecimal preco;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aviao", nullable = false)
	private Aviao aviao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_local_destino", nullable = false)
	private Local localDestino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_local_origem", nullable = false)
	private Local localOrigem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_piloto", nullable = false)
	private Piloto piloto;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "voo_lanche",
		joinColumns = {
			@JoinColumn(name = "id_voo")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "id_lanche")
		}
	)
	private List<Lanche> lanches;

	@Transient
	private boolean tipoIdaVolta;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDesembarque() {
		return this.dataDesembarque;
	}

	public void setDataDesembarque(Date dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public Date getDataEmbarque() {
		return this.dataEmbarque;
	}

	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Aviao getAviao() {
		return this.aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Local getLocalDestino() {
		return this.localDestino;
	}

	public void setLocalDestino(Local localDestino) {
		this.localDestino = localDestino;
	}

	public Local getLocalOrigem() {
		return this.localOrigem;
	}

	public void setLocalOrigem(Local localOrigem) {
		this.localOrigem = localOrigem;
	}

	public Piloto getPiloto() {
		return this.piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public List<Lanche> getLanches() {
		return this.lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}

	public boolean isTipoIdaVolta() {
		return tipoIdaVolta;
	}

	public void setTipoIdaVolta(boolean tipoIdaVolta) {
		this.tipoIdaVolta = tipoIdaVolta;
	}

	@Override
	public String toString() {
		String s = this.getClass().getSimpleName() + " - id: " + getId() + "\n";
		return s;
	}
}