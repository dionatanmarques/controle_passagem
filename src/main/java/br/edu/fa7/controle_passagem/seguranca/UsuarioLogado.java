package br.edu.fa7.controle_passagem.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.fa7.controle_passagem.model.Funcionario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = -2660423615967850269L;

	private Funcionario usuario;

	public Funcionario getUsuario() {
		return usuario;
	}

	public void setUsuario(Funcionario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado(){
		return usuario != null;
	}
	
}
