<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Companhias Aéreas">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Frota Aérea
					<a class="btn btn-success btn-sm pull-right"
						href="${pageContext.request.contextPath}/aviao/cadastro">
						<span class="fa fa-plus"></span> Novo
					</a>
			</div>
			<div class="panel-body">
				<div class="panel panel-default">
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/aviao/buscar"
					method="post">
					<div class="form-group col-md-6">
						<label for="nome">Companhia Aérea</label> 
						<select class="form-control" name="companhiaId">
							<c:forEach items="${listaDeCompanhia}" var="comp">
								<option value="${comp.id}">${comp.nome}</option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-primary pull-right" type="submit">Buscar</button>
				</form>
				</div>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Ação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaAvioes}" var="aviao">
							<tr>
								<td>${aviao.nome}</td>
								<td><a class="btn btn-primary btn-sm" title="Editar"
									href="${pageContext.request.contextPath}/aviao/edita?cod=${aviao.id}">
										<span class="fa fa-pencil"></span>
								</a>
								<a class="btn btn-primary btn-sm" title="Excluir"
									href="${pageContext.request.contextPath}/aviao/edita?cod=${aviao.id}">
										<span class="fa fa-remove"></span>
								</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</layout:page>