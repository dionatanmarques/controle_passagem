package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="local")
@SequenceGenerator(name="SEQUENCE", sequenceName="local_id_seq")
public class Local implements Serializable {

	private static final long serialVersionUID = 1367822602865675001L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
	@Column(name="loc_id")
	private Integer id;
	
	@Column(name = "loc_nome",length=100)
    @Basic(optional = false)
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}