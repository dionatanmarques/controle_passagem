package br.edu.fa7.controle_passagem.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.controller.AreaController;
import br.edu.fa7.controle_passagem.seguranca.UsuarioLogado;

@Intercepts
public class AutenticadoInterceptor {

	@Inject
	private UsuarioLogado usarioLogado;
	@Inject
	private Result result;
	@Inject
	private ControllerMethod controllerMethod;
	
	@Accepts
	public boolean accepts(){
		return (controllerMethod.containsAnnotation(Restrito.class));
	}
	
	@AroundCall
	public void intercepta(SimpleInterceptorStack stack){
		
		if(!usarioLogado.isLogado()){
			result.redirectTo(AreaController.class).login();
			return;
		}
		stack.next();
	}
}
