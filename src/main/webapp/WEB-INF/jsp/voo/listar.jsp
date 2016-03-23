<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<layout:page titulo="Voos">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-body">
				<form id="formPassagemAerea" action="${pageContext.request.contextPath}/voo/confirmar" method="post">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-2">
									<i class="fa fa-plane"></i> IDA
								</div>
								<div class="col-md-4">
									${voo.localOrigem.nome} <i class="fa fa-arrow-right"></i> ${voo.localDestino.nome}
								</div>
								<div class="col-md-2 col-md-offset-4">
									<i class="fa fa-calendar"></i> <fmt:formatDate value="${voo.dataEmbarque}" pattern="dd/MM/yyyy" />
								</div>
							</div>
						</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th></th>
										<th>Partindo</th>
										<th>Chegando</th>
										<th>Valor</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${not empty voosIda}">
											<c:forEach var="voo" items="${voosIda}">
												<tr>
													<td>
														<input type="radio" name="vooIda.id" value="${voo.id}" />
													</td>
													<td><fmt:formatDate value="${voo.dataEmbarque}" pattern="HH:mm" /></td>
													<td><fmt:formatDate value="${voo.dataDesembarque}" pattern="HH:mm" /></td>
													<td><fmt:formatNumber value="${voo.preco}" minFractionDigits="2" type="currency"/></td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="4" class="text-center">Não há vôos nessa categoria!</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${voo.tipoIdaVolta}">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<div class="col-md-2">
										<i class="fa fa-plane fa-flip-horizontal"></i> VOLTA
									</div>
									<div class="col-md-4">
										${voo.localDestino.nome} <i class="fa fa-arrow-right"></i> ${voo.localOrigem.nome}
									</div>
									<div class="col-md-2 col-md-offset-4">
										<i class="fa fa-calendar"></i> <fmt:formatDate value="${voo.dataDesembarque}" pattern="dd/MM/yyyy" />
									</div>
								</div>
							</div>
							<div class="panel-body">
								<table class="table">
									<thead>
										<tr>
											<th></th>
											<th>Partindo</th>
											<th>Chegando</th>
											<th>Preço</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${not empty voosVolta}">
												<c:forEach var="voo" items="${voosVolta}">
													<tr>
														<td>
															<input type="radio" name="vooVolta.id" value="${voo.id}" />
														</td>
														<td><fmt:formatDate value="${voo.dataEmbarque}" pattern="HH:mm" /></td>
														<td><fmt:formatDate value="${voo.dataDesembarque}" pattern="HH:mm" /></td>
														<td><fmt:formatNumber value="${voo.preco}" minFractionDigits="2" type="currency"/></td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="4" class="text-center">Não há vôos nessa categoria!</td>
												</tr>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>
						</div>
					</c:if>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>