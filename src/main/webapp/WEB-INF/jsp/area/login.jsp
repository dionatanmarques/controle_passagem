<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<layout:page titulo="Login">
	<jsp:body>
		<div class="row">
			<div class="col-md-offset-3 col-md-6 col-md-offset-3 panel panel-default">
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/area/logar" method="post">
						<div class="form-group col-md-6">
							<label for="localOrigem">CPF</label>
							<input id="localOrigem" class="form-control" name="funcionario.cpf" type="text" placeholder="Local Origem" autofocus />
						</div>
						<div class="form-group col-md-6">
							<label for="localDestino">Senha</label>
							<input id="localDestino" class="form-control" name="funcionario.senha" type="text" placeholder="Local Destino" />
						</div>
						<button class="btn btn-primary pull-right" type="submit">Entrar</button>
					</form>
				</div>
			</div>
		</div>
	</jsp:body>
</layout:page>