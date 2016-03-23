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
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.dao.LocalDao;
import br.edu.fa7.controle_passagem.dao.PilotoDao;
import br.edu.fa7.controle_passagem.dao.VooDao;
import br.edu.fa7.controle_passagem.model.Voo;
import br.edu.fa7.controle_passagem.util.DateUtil;

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
	private PilotoDao pilotoDao;
	@Inject
	private LocalDao localDao;

	@Post
	public void pesquisar(Voo voo) {
		List<Voo> voosIda = dao.buscarPorData(voo);
		List<Voo> voosVolta = new ArrayList<Voo>();
		if (voo.isTipoIdaVolta()) {
			// Inverte os parâmetros do vôo para pesquisa de vôos voltando
			Voo vooVolta = new Voo();
			vooVolta.setDataEmbarque(voo.getDataDesembarque());
			vooVolta.setLocalDestino(voo.getLocalOrigem());
			vooVolta.setLocalOrigem(voo.getLocalDestino());
			voosVolta = dao.buscarPorData(vooVolta);
		}
		voo.setLocalOrigem(localDao.carregar(voo.getLocalOrigem().getId()));
		voo.setLocalDestino(localDao.carregar(voo.getLocalDestino().getId()));
		result.include("voosIda", voosIda);
		result.include("voosVolta", voosVolta);
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
	public void cadastrar(String dataEmbarque, String dataDesembarque, @Valid Voo voo){
		voo.setDataEmbarque(DateUtil.stringToDate(dataEmbarque, "dd/MM/yyyy HH:mm"));
		voo.setDataDesembarque(DateUtil.stringToDate(dataDesembarque, "dd/MM/yyyy HH:mm"));

		validator.onErrorRedirectTo(this).cadastro();

		dao.salvar(voo);
		result.include("msg", new SimpleMessage("alert-success", "Operação realizada com sucesso"));
		result.redirectTo(this).cadastro();
	}
}