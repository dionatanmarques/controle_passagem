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
import br.edu.fa7.controle_passagem.dao.LancheDao;
import br.edu.fa7.controle_passagem.model.Lanche;

@Controller
@Path("/lanche")
@Restrito
public class LancheController {

	@Inject
	private Result result;

	@Inject
	private LancheDao dao;

	@Inject
	private Validator validator;

	@Get({"","/"})
	public void index(){
	}
	
	@Post
	public void buscar(String nome){
		nome = (nome == null) ? "": nome;
		result.include("listaLanches", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}
	
	@Get
	public void edita(int cod){
		result.include("lanche", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Get
	public void remove(int cod){
		Lanche lanche = dao.carregar(cod);
		dao.deletar(lanche);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).index();
	}
	
	@Get
	public void cadastro() {
		
	}
	
	@Post
	public void cadastrar(@Valid Lanche lanche){
		
		validator.onErrorRedirectTo(this).cadastro();;
		
		dao.salvar(lanche);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}
