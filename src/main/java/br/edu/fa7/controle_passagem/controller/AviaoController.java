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
import br.edu.fa7.controle_passagem.dao.AssentoDao;
import br.edu.fa7.controle_passagem.dao.AviaoDao;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.model.Aviao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
import br.edu.fa7.controle_passagem.util.GeradorDeAssento;

//Resolver como ficara a edição
//Não Esquecer isso 
//
//
@Controller
@Path("/aviao")
@Restrito
public class AviaoController {

	private final Result result;
	private final AviaoDao dao;
	private final Validator validator;
	private final CompanhiaAereaDao companhiaDao;
	private final AssentoDao assentoDao;

	@Inject
	public AviaoController(Result result, AviaoDao dao, Validator validator,
			CompanhiaAereaDao companhiaDao, AssentoDao assentoDao) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.companhiaDao = companhiaDao;
		this.assentoDao = assentoDao;
	}

	public AviaoController() {
		this(null, null, null, null, null);
	}

	@Get({ "", "/" })
	public void index() {
		result.include("listaDeCompanhia", companhiaDao.listarTodos());
	}

	@Post
	public void buscar(int companhiaId) {
		CompanhiaAerea companhia = companhiaDao.carregar(companhiaId);
		result.include("listaAvioes", dao.buscaPorCompanhia(companhia));
		result.redirectTo(this).index();
	}

	@Get
	public void edita(int cod) {
		result.include("aviao", dao.carregarEdiacao(cod));
		result.redirectTo(this).cadastro();
	}

	@Get
	public void remove(int cod) {
		Aviao aviao = dao.carregar(cod);
		dao.deletar(aviao);
		result.include("msg", new SimpleMessage("alert-success",
				"Operação realizada com sucesso"));
		result.redirectTo(this).index();
	}

	@Get
	public void cadastro() {
		result.include("listaDeCompanhia", companhiaDao.listarTodos());
	}

	@Post
	public void cadastrar(int companhiaId, @Valid Aviao aviao) {

		validator.onErrorRedirectTo(this).cadastro();
		aviao.setCompanhia(companhiaDao.carregar(companhiaId));
		dao.salvar(aviao);
		if (aviao.getId() == null) {
			GeradorDeAssento geradorDeAssento = new GeradorDeAssento(aviao,
					assentoDao);
			geradorDeAssento.gerarAssentos();
		}
		result.include("msg", new SimpleMessage("alert-success",
				"Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}
