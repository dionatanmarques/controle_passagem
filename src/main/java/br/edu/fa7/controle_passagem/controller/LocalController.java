package br.edu.fa7.controle_passagem.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.LocalDao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
import br.edu.fa7.controle_passagem.model.Local;

@Controller
@Path("/local")
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
	@Restrito
	public void buscar(String nome){
		nome = (nome == null) ? "": nome;
		result.include("listaLocais", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}
	
	@Get
	@Restrito
	public void edita(int cod){
		result.include("local", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Get
	@Restrito
	public void remove(int cod){
		Local local = dao.carregar(cod);
		dao.deletar(local);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).index();
	}
	
	@Get
	@Restrito
	public void cadastro() {
		
	}
	
	@Post
	@Restrito
	public void cadastrar(@Valid Local local){
		
		validator.onErrorRedirectTo(this).cadastro();
		
		dao.salvar(local);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
	
	@Post
	public void buscaExclusivaJson(int origemId){
		Local localOrigem = dao.carregar(origemId);
		List<Local> locais = dao.listarTodos();
		locais.remove(localOrigem);
		result.use(Results.json()).from(locais).serialize();
	}

}
