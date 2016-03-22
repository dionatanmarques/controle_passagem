<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Companhias Aéreas">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">Lanches Oferecidos
				<a class="btn btn-success btn-sm pull-right"
						href="${pageContext.request.contextPath}/lanche/">
						<span class="fa fa-search"></span> Consultar
					</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/lanche/cadastrar"
					method="post">
					<div class="form-group col-md-6">
						<label for="nome">Nome</label> <input id="nome"
							class="form-control" name="lanche.nome" type="text"
							placeholder="Nome da Lanche" autofocus value="${lanche.nome}" />
							<input type="hidden" name="lanche.id" value="${lanche.id}"/>
					</div>
					<div class="form-group col-md-6">
						<label for="preco">Preço</label> <input id="preco"
							class="form-control money" name="lanche.preco" type="text"
							placeholder="Preço da Lanche" value="${lanche.preco}" />
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>