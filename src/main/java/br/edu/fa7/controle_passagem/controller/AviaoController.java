package br.edu.fa7.controle_passagem.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Patch;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.AviaoDao;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.model.Aviao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;

@Controller
@Path("/aviao")
@Restrito
public class AviaoController {
	
	private final Result result;
	private final AviaoDao dao;
	private final Validator validator;
	private final CompanhiaAereaDao companhiaDao;
	
	@Inject
	public AviaoController(Result result, AviaoDao dao,
			Validator validator, CompanhiaAereaDao companhiaDao) {
			this.result = result;
			this.dao = dao;
			this.validator = validator;
			this.companhiaDao = companhiaDao;
	}
	
	public AviaoController() {
		this(null, null, null, null);
	}
	
	
	@Get({"","/"})
	public void index(){
		result.include("listaDeCompanhia",companhiaDao.listarTodos());
	}
	
	@Post
	public void buscar(int companhiaId){
		CompanhiaAerea companhia = companhiaDao.carregar(companhiaId);
		result.include("listaAvioes", dao.buscaPorCompanhia(companhia));
		result.redirectTo(this).index();
	}
	
	@Get
	public void edita(int cod){
		result.include("companhia", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Get
	public void remove(int cod){
		Aviao aviao = dao.carregar(cod);
		dao.deletar(aviao);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).index();
	}
	
	@Get
	public void cadastro() {
		
	}
	
	@Post
	public void cadastrar(@Valid Aviao aviao){
		
		validator.onErrorRedirectTo(this).cadastro();;	
		dao.salvar(aviao);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}
