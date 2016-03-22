<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<layout:page titulo="Companhias A�reas">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">Comapanhia A�rea</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/companhia/cadastrar"
					method="post">
					<div class="form-group col-md-6">
						<label for="localOrigem">Nome</label> <input id="nome"
							class="form-control" name="companhia.nome" type="text"
							placeholder="Nome da Companhia A�rea" autofocus value="${companhia.nome}" />
							<input type="hidden" name="companhia.id" value="${companhia.id}"/>
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>