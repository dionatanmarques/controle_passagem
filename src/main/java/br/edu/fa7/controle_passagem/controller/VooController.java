package br.edu.fa7.controle_passagem.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.model.Voo;

@Controller
@Path("/voo")
public class VooController {

	@Inject
	private Result result;

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
		
	}
}