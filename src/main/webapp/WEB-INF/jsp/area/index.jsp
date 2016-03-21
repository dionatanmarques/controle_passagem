<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<layout:page titulo="Login">
	<jsp:body>
		<div class="row">
			<div class="col-md-offset-3 col-md-6 col-md-offset-3 panel panel-default">
				<div class="panel-body">
					<h4>Seja bem vindo ${usuarioLogado.usuario.nome}!</h4>
				</div>
			</div>
		</div>
	</jsp:body>
</layout:page>