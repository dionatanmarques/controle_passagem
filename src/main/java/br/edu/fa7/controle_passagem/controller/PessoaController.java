package br.edu.fa7.controle_passagem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.PassagemDao;
import br.edu.fa7.controle_passagem.dao.PessoaDao;
import br.edu.fa7.controle_passagem.dao.VooDao;
import br.edu.fa7.controle_passagem.model.Pessoa;
import br.edu.fa7.controle_passagem.model.Voo;

@Controller
@Path("/pessoa")
public class PessoaController {

	private final Result result;
	private final PessoaDao dao;
	private final PassagemDao passagemDao;
	private final VooDao vooDao;

	@Inject
	public PessoaController(Result result, PessoaDao dao, PassagemDao passagemDao, VooDao vooDao) {
		this.result = result;
		this.dao = dao;
		this.passagemDao = passagemDao;
		this.vooDao = vooDao;
	}

	public PessoaController() {
		this(null, null, null, null);
	}

	@Get({"", "/"})
	@Restrito
	public void index() {
		
	}

	@Get("/cadastro")
	@Restrito
	public void cadastro() {
		
	}

	@Post("/buscar")
	@Restrito
	public void buscar(String nome) {
		nome = (nome == null) ? "": nome;
		result.include("listaDePessoas", dao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}

	@Get("/edita")
	@Restrito
	public void edita(int cod){
		result.include("pessoa", dao.carregar(cod));
		result.redirectTo(this).cadastro();
	}

	@Get("/cadastroCliente")
	public void cadastroCliente(List<Voo> voos) {
		result.include("voos", voos);
	}

	@Post("/cadastroCliente")
	public void cadastroCliente(Pessoa pessoa, List<Voo> voos) {
		Pessoa p = dao.buscarPorCpf(pessoa);
		if (p != null) {
			pessoa = p;
		} else {
			dao.salvar(pessoa);
		}
		List<Voo> voosList = new ArrayList<>();
		for (Voo voo : voos) {
			if (voo.getId() != null) {
				voosList.add(vooDao.carregar(voo.getId()));
			}
		}
		passagemDao.salvar(pessoa, voosList);
		result.include("msg", new SimpleMessage("alert-success", "Passagem Comprada com Sucesso"));
		result.redirectTo(IndexController.class).index();
	}
}