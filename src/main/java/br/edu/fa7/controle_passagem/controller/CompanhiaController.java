package br.edu.fa7.controle_passagem.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
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
	
	
	@Get
	@Restrito
	public void cadastro() {
		
	}
	
	@Post
	public void cadastrar(CompanhiaAerea companhia){
		
	}

}
