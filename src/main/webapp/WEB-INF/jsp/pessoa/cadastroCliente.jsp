<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Cadastro Cliente">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Cadastro Cliente
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/pessoa/cadastroCliente" method="post">
					<c:forEach var="voo" items="${voos}">
						<input type="hidden" name="voos[].id" value="${voo.id}" />
					</c:forEach>
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