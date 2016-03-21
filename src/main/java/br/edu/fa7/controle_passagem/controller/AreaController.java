package br.edu.fa7.controle_passagem.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.FuncionarioDao;
import br.edu.fa7.controle_passagem.model.Funcionario;
import br.edu.fa7.controle_passagem.seguranca.UsuarioLogado;

@Controller
@Path("/area")
public class AreaController implements Serializable{

	private static final long serialVersionUID = -8235909394199292237L;
	
	private final Result result;
	private final FuncionarioDao dao;
	private final Validator validador;
	private UsuarioLogado usuarioLogado;
	
	@Inject
	public AreaController(Result result, FuncionarioDao dao, 
			Validator validator, UsuarioLogado usuaLogado) {
		this.result = result;
		this.dao = dao;
		this.validador = validator;
		this.usuarioLogado = usuaLogado;
	}
	
	public AreaController() {
		this(null, null, null, null);
	}
	
	@Get("")
	public void login() {
	}
	
	@Post
	public void logar(Funcionario funcionario){
		Funcionario usuario = dao.buscarComoUsuario(funcionario.getCpf(), funcionario.getSenha());
		if(usuario == null){
			validador.add(new I18nMessage("alert-danger", "usuario.invalido"));
			validador.onErrorRedirectTo(this).login();
		}
		usuarioLogado.setUsuario(usuario);
		result.redirectTo(this).index();
	}
	
	@Get("/")
	@Restrito
	public void index(){
		
	}
	
	@Get
	public void logout(){
		usuarioLogado.setUsuario(null);
		result.redirectTo(IndexController.class).index();
	}
}
