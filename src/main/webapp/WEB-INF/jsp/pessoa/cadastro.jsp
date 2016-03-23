<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Pessoa">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Usuários
				<a class="btn btn-success btn-sm pull-right"
						href="${pageContext.request.contextPath}/pessoa">
						<span class="fa fa-search"></span> Consultar
					</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/usuario/pessoa" method="post">
					<input type="hidden" name="usuario.id" value="${pesssoa.id}" />
					<div class="form-group col-md-6">
						<label for="nome">Nome</label>
						<input id="nome"
							class="form-control uppercase" name="pessoa.nome" type="text"
							placeholder="Nome" autofocus value="${pessoa.nome}" />
					</div>
					<div class="form-group col-md-6">
						<label for="cpf">CPF</label>
						<input id="cpf"
							class="form-control" name="pessoa.cpf" type="text"
							placeholder="CPF" autofocus value="${pessoa.cpf}" />
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>