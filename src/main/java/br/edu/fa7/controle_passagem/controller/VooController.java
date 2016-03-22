package br.edu.fa7.controle_passagem.controller;

import java.util.ArrayList;

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
import br.edu.fa7.controle_passagem.dao.AviaoDao;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.dao.LocalDao;
import br.edu.fa7.controle_passagem.dao.PilotoDao;
import br.edu.fa7.controle_passagem.dao.VooDao;
import br.edu.fa7.controle_passagem.model.Aviao;
import br.edu.fa7.controle_passagem.model.Local;
import br.edu.fa7.controle_passagem.model.Piloto;
import br.edu.fa7.controle_passagem.model.Voo;

@Controller
@Path("/voo")
public class VooController {

	@Inject
	private Result result;
	@Inject
	private Validator validator;
	@Inject
	private VooDao dao;
	@Inject
	private CompanhiaAereaDao companhiaDao;
	@Inject
	private AviaoDao aviaoDao;
	@Inject
	private PilotoDao pilotoDao;
	@Inject
	private LocalDao localDao;

	@Post
	public void pesquisar(Voo voo) {
		// TODO: Pesquisar Voos
		result.include("voosIda", new ArrayList<>());
		result.include("voosVolta", new ArrayList<>());
		result.redirectTo(this).listar(voo);
	}

	@Get
	public void listar(Voo voo) {
		if (voo.getLocalOrigem() == null) {
			result.redirectTo(IndexController.class).index();
		} else {
			result.include("voo", voo);
		}
	}
	
	@Get
	@Restrito
	public void cadastro(){
		result.include("listaDeCompanhia", companhiaDao.listarTodos());
		result.include("listaDePilotos", pilotoDao.listarTodos());
		result.include("listaDeOrigens", localDao.listarTodos());
	}
	
	@Post
	@Restrito
	public void cadastrar(int aviaoId, int origemId, int destinoId, int pilotoId, @Valid Voo voo){

		Aviao aviao = aviaoDao.carregar(aviaoId);
		voo.setAviao(aviao);
		Local origem = localDao.carregar(origemId);
		voo.setLocalOrigem(origem);
		Local destino = localDao.carregar(destinoId);
		voo.setLocalDestino(destino);
		Piloto piloto = pilotoDao.carregar(pilotoId);
		voo.setPiloto(piloto);
		
		validator.onErrorRedirectTo(this).cadastro();
		
		dao.salvar(voo);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}