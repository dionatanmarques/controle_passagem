package br.edu.fa7.controle_passagem.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class IndexController {

	@Get("/")
	public void index() {
		// Tela Inicial do Sistema
	}
}