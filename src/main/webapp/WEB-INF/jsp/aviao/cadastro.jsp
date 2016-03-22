<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Companhias Aéreas">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Frota Aérea <a class="btn btn-success btn-sm pull-right"
					href="${pageContext.request.contextPath}/aviao/"> <span
					class="fa fa-search"></span> Consultar
				</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/aviao/cadastrar"
					method="post">
					<div class="form-group col-md-6">
						<label for="nome">Companhia Aérea</label>
						<c:choose>
							<c:when test="${aviao.companhia != null}">
								<input class="form-control" readonly="readonly" value="${aviao.companhia.nome}">
								<input type="hidden" name="companhiaId"
									value="${aviao.companhia.id}" />
							</c:when>
							<c:otherwise>
								<select class="form-control" name="companhiaId">
									<c:forEach items="${listaDeCompanhia}" var="comp">
										<option value="${comp.id}">${comp.nome}</option>
									</c:forEach>
								</select> 
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group col-md-6">
						<label for="localOrigem">Nome</label> <input id="nome"
							class="form-control" name="aviao.nome" type="text"
							placeholder="Nome da Avião" autofocus value="${aviao.nome}" /> <input
							type="hidden" name="aviao.id" value="${aviao.id}" />
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>