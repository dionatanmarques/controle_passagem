package br.edu.fa7.controle_passagem.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fa7.controle_passagem.dao.FuncionarioDao;
import br.edu.fa7.controle_passagem.model.Funcionario;

@Controller
@Path("/area")
public class AreaController implements Serializable{

	private static final long serialVersionUID = -8235909394199292237L;
	
	private final Result result;
	private  final FuncionarioDao dao;
	
	@Inject
	public AreaController(Result result, FuncionarioDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	public AreaController() {
		this(null, null);
	}
	
	@Get("")
	public void login() {
	}
	
	@Post("/logar")
	public void logar(Funcionario funcionario){
		Funcionario usuario = dao.buscarComoUsuario(funcionario.getCpf(), funcionario.getSenha());
		if(usuario != null){
			result.redirectTo(IndexController.class).index();
		}
	}
}
