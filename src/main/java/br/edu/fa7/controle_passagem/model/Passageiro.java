package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "passageiro")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Passageiro extends Pessoa implements Serializable {

	private static final long serialVersionUID = 3790345090346046227L;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "passageiro_lanche",
		joinColumns = @JoinColumn(name = "id_passageiro"),
		inverseJoinColumns = @JoinColumn(name = "id_lanche")
	)
	private List<Lanche> lanches;

	public List<Lanche> getLanches() {
		return lanches;
	}

	public void setLanches(List<Lanche> lanches) {
		this.lanches = lanches;
	}
}