package br.edu.fa7.controle_passagem.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.fa7.controle_passagem.dao.LocalDao;

@Controller
@Path("")
public class IndexController {
	
	@Inject
	private LocalDao localDao;
	@Inject
	private Result result;

	@Get({"","/"})
	public void index() {
		result.include("listaDeOrigens", localDao.listarTodos());
	}
}