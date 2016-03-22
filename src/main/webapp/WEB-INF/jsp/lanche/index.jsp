<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<layout:page titulo="Companhias Aéreas">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lanches Oferecidos <a class="btn btn-success btn-sm pull-right"
					href="${pageContext.request.contextPath}/lanche/cadastro"> <span
					class="fa fa-plus"></span> Novo
				</a>
			</div>
			<div class="panel-body">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="${pageContext.request.contextPath}/lanche/buscar"
							method="post">
							<div class="form-group col-md-6">
								<label for="nome">Nome</label> <input id="nome"
									class="form-control" name="nome" type="text"
									placeholder="Nome do Local" autofocus />
							</div>
							<button class="btn btn-primary pull-right" type="submit">Buscar</button>
						</form>
					</div>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Preço</th>
							<th>Ação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaLanches}" var="lanche">
							<tr>
								<td>${lanche.nome}</td>
								<td>
								<fmt:formatNumber value="${lanche.preco}"
										minFractionDigits="2" type="currency" /></td>
								<td><a class="btn btn-primary btn-sm" title="Editar"
									href="${pageContext.request.contextPath}/lanche/edita?cod=${lanche.id}">
										<span class="fa fa-pencil"></span>
								</a> <a class="btn btn-primary btn-sm" title="Excluir"
									href="${pageContext.request.contextPath}/lanche/remove?cod=${lanche.id}">
										<span class="fa fa-remove"></span>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</layout:page>