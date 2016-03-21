<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<layout:page titulo="Voos">
	<div class="row">
		<div class="panel panel-default">
			<div>Cadastro de Voo</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/comapanhia/cadastrar"
					method="post">
					<div class="form-group col-md-6">
						<label for="localOrigem">Nome</label> <input id="nome"
							class="form-control" name="companhia.nome" type="text"
							placeholder="Nome da Companhia Aérea" autofocus />
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>