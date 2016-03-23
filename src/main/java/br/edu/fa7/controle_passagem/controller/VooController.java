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
import br.edu.fa7.controle_passagem.model.Local;
import br.edu.fa7.controle_passagem.model.Voo;
import br.edu.fa7.controle_passagem.util.DateUtil;
import br.edu.fa7.controle_passagem.util.PesquisaVoo;

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
	public void pesquisar(PesquisaVoo pesquisaVoo) {
		// TODO: Pesquisar Voos
		Local origem = localDao.carregar(pesquisaVoo.getOrigem());
		Local destino = localDao.carregar(pesquisaVoo.getDestino());
		Voo voo = new Voo();
		voo.setLocalOrigem(origem);
		voo.setLocalDestino(destino);
		List<Voo> voosIda = dao.buscarPorData(pesquisaVoo.getDataIda(),origem,destino);
		List<Voo> voosVolta = new ArrayList<Voo>();
		if(pesquisaVoo.isTipoIdaVolta()){
			voosVolta = dao.buscarPorData(pesquisaVoo.getDataVolta(),destino,origem);
		}
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