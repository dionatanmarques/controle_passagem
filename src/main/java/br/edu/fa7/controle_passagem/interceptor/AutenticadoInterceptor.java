package br.edu.fa7.controle_passagem.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.edu.fa7.controle_passagem.annotations.Restrito;
import br.edu.fa7.controle_passagem.controller.AreaController;
import br.edu.fa7.controle_passagem.seguranca.UsuarioLogado;

@Intercepts
public class AutenticadoInterceptor implements Interceptor {

	@Inject
	private UsuarioLogado usarioLogado;

	@Inject
	private Result result;

	@Override
	public boolean accepts(ControllerMethod method) {
		return (method.getMethod().isAnnotationPresent(Restrito.class) ||
				method.getController().getType().isAnnotationPresent(Restrito.class));
	}

	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object object) throws InterceptionException {
		if(!usarioLogado.isLogado()){
			result.redirectTo(AreaController.class).login();
		} else {
			stack.next(method, object);
		}
	}
}
