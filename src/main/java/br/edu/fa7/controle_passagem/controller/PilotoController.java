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
import br.edu.fa7.controle_passagem.dao.PilotoDao;
import br.edu.fa7.controle_passagem.dao.PessoaDao;
import br.edu.fa7.controle_passagem.model.Funcionario;
import br.edu.fa7.controle_passagem.model.Local;
import br.edu.fa7.controle_passagem.model.Piloto;

@Restrito
@Controller
@Path("/piloto")
public class PilotoController {

	private final Result result;
	private final PilotoDao dao;
	private final Validator validator;

	@Inject
	public PilotoController(Result result, PilotoDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}

	public PilotoController() {
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
		result.include("listaDePilotos", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}

	@Get("/edita")
	public void edita(int cod){
		result.include("piloto", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
	
	@Post
	public void cadastrar(@Valid Piloto piloto){
		
		validator.onErrorRedirectTo(this).cadastro();
		
		dao.salvar(piloto);
		result.include("msg", 
				new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}