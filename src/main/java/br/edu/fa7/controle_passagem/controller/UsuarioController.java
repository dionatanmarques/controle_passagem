package br.edu.fa7.controle_passagem.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.dao.UsuarioDao;

@Restrito
@Controller
@Path("/usuario")
public class UsuarioController {

	private final Result result;
	private final UsuarioDao usuarioDao;

	@Inject
	public UsuarioController(Result result, UsuarioDao usuarioDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
	}

	public UsuarioController() {
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
		result.include("usuarios", usuarioDao.buscarPorNome(nome));
		result.redirectTo(this).index();
	}

	@Get("/edita")
	public void edita(int cod){
		result.include("usuario", usuarioDao.carregar(cod));
		result.redirectTo(this).cadastro();
	}
}