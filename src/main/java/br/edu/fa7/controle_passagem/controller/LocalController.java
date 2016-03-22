package br.edu.fa7.controle_passagem.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.LocalDao;
import br.edu.fa7.controle_passagem.model.Local;

@Controller
@Path("/local")
@Restrito
public class LocalController {
	
	@Inject
	private Result result;

	@Inject
	private LocalDao dao;

	@Inject
	private Validator validator;

	@Get({"","/"})
	public void index(){
	}
	
	@Post
	public void buscar(String nome){
		nome = (nome == null) ? "": nome;
		result.include("listaLocais", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}
	
	@Get
	public void edita(int cod){
		result.include("local", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Get
	public void remove(int cod){
		Local local = dao.carregar(cod);
		dao.deletar(local);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).index();
	}
	
	@Get
	public void cadastro() {
		
	}
	
	@Post
	public void cadastrar(@Valid Local local){
		
		validator.onErrorRedirectTo(this).cadastro();;
		
		dao.salvar(local);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}

}
