<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Funcionário">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Funcionário
				<a class="btn btn-success btn-sm pull-right"
						href="${pageContext.request.contextPath}/funcionario">
						<span class="fa fa-search"></span> Consultar
					</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/funcionario/cadastrar" method="post">
					<input type="hidden" name="usuario.id" value="${funcionario.id}" />
					<div class="form-group col-md-4">
						<label for="nome">Nome</label>
						<input id="nome"
							class="form-control uppercase" name="funcionario.nome" type="text"
							placeholder="Nome" autofocus value="${funcionario.nome}" />
					</div>
					<div class="form-group col-md-4">
						<label for="cpf">CPF</label>
						<input id="cpf"
							class="form-control" name="funcionario.cpf" type="text"
							placeholder="CPF" value="${funcionario.cpf}" />
					</div>
					<div class="form-group col-md-4">
						<label for="senha">Senha</label>
						<input id="cpf"
							class="form-control" name="funcionario.senha" type="password"
							placeholder="Senha" value="${funcionario.senha}" />
					</div>
					
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>