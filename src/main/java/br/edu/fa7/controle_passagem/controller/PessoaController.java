package br.edu.fa7.controle_passagem.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.PessoaDao;

@Restrito
@Controller
@Path("/pessoa")
public class PessoaController {

	private final Result result;
	private final PessoaDao dao;

	@Inject
	public PessoaController(Result result, PessoaDao dao) {
		this.result = result;
		this.dao = dao;
	}

	public PessoaController() {
		this(null, null);
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
		result.include("listaDePessoas", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}

	@Get("/edita")
	public void edita(int cod){
		result.include("pessoa", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
}