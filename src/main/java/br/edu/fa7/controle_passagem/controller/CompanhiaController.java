package br.edu.fa7.controle_passagem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;

@Controller
@Path("/companhia")
public class CompanhiaController {

	
	private final Result result;
	private final CompanhiaAereaDao dao;
	private final Validator validator;
	
	@Inject
	public CompanhiaController(Result result, CompanhiaAereaDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator =validator;
	}
	
	public CompanhiaController() {
		this(null,null, null);
	}
	
	@Get("/")
	@Restrito
	public void index(){
		
	}
	
	@Post
	@Restrito
	public void buscar(String nome){
		nome = (nome == null) ? "": nome;
		result.include("listaCompanhias", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}
	
	@Get
	@Restrito
	public void edita(int cod){
		result.include("companhia", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Get
	@Restrito
	public void cadastro() {
		
	}
	
	@Post
	@Restrito
	public void cadastrar(@Valid CompanhiaAerea companhia){
		
		validator.onErrorRedirectTo(this).cadastro();;
		
		dao.salvar(companhia);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}

}
