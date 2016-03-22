<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Companhias Aéreas">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">Locais Para Viagens
				<a class="btn btn-success btn-sm pull-right"
						href="${pageContext.request.contextPath}/local/">
						<span class="fa fa-search"></span> Consultar
					</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/local/cadastrar"
					method="post">
					<div class="form-group col-md-6">
						<label for="localOrigem">Nome</label> <input id="nome"
							class="form-control" name="local.nome" type="text"
							placeholder="Nome da Local" autofocus value="${local.nome}" />
							<input type="hidden" name="local.id" value="${local.id}"/>
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>