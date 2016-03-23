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
import br.edu.fa7.controle_passagem.dao.FuncionarioDao;
import br.edu.fa7.controle_passagem.dao.PessoaDao;
import br.edu.fa7.controle_passagem.model.Funcionario;
import br.edu.fa7.controle_passagem.model.Local;

@Restrito
@Controller
@Path("/funcionario")
public class FuncionarioController {

	private final Result result;
	private final FuncionarioDao dao;
	private final Validator validator;

	@Inject
	public FuncionarioController(Result result, FuncionarioDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}

	public FuncionarioController() {
		this(null, null, null);
	}

	@Get({"", "/"})
	public void index() {
		
	}

	@Get("/cadastro")
	public void cadastro() {
		
	}

	@Post("/buscar")
	public void buscar(String nome) {
		nome = (nome == null) ? "": nome;
		result.include("listaDeFuncionarios", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}

	@Get("/edita")
	public void edita(int cod){
		result.include("funcionario", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Post
	public void cadastrar(@Valid Funcionario funcionario){
		
		validator.onErrorRedirectTo(this).cadastro();
		
		dao.salvar(funcionario);
		result.include("msg", 
				new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}