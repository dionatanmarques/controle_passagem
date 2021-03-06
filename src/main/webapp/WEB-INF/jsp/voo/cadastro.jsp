<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="V�os">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Frota A�rea <a class="btn btn-success btn-sm pull-right"
					href="${pageContext.request.contextPath}/voo/"> <span
					class="fa fa-search"></span> Consultar
				</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/voo/cadastrar"
					method="post">
					<div class="form-group col-md-4">
						<label for="companhiaId">Companhia A�rea</label> <select onchange="carregaFrota();"
						 class="form-control" name="companhiaId" id="companhiaId">
							<c:forEach items="${listaDeCompanhia}" var="comp">
								<option value="${comp.id}">${comp.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="aviaoId">Aeronaves </label> <select							
							class="form-control" name="voo.aviao.id" id="aviaoId">
							<option>Selecione primeiro a companhia</option>
							<c:forEach items="${listaDeAvioes}" var="nave">
								<option value="${nave.id}">${nave.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="pilotoId">Piloto </label> <select
							class="form-control" name="voo.piloto.id" id="pilotoId">
							<c:forEach items="${listaDePilotos}" var="piloto">
								<option value="${piloto.id}">${piloto.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="origemId">Local de Origem </label> <select onchange="carregaDestino();"
							class="form-control" name="voo.localOrigem.id" id="origemId">
							<option value="">Selecione</option>
							<c:forEach items="${listaDeOrigens}" var="origem">
								<option value="${origem.id}">${origem.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="destinoId">Local de Destino </label> <select
							class="form-control" name="voo.localDestino.id" id="destinoId">
							<option>Selecione primeiro a origem</option>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="dataEmbarque">Data Hora de Embarque</label>
						<div class="input-group date datepicker-with-hours">
							<input id="dataEmbarque" class="form-control" type="text"
								name="dataEmbarque" placeholder="dd/mm/yyyy hh:mm" value="${voo.dataEmbarque}" />
							<span class="input-group-addon">
								<span class="fa fa-calendar"></span>
							</span>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label for="dataDesembarque">Data Hora de Dembarque</label>
						<div class="input-group date datepicker-with-hours">
							<input id="dataDesembarque" class="form-control" type="text"
								name="dataDesembarque" placeholder="dd/mm/yyyy hh:mm" value="${voo.dataDesembarque}" />
							<span class="input-group-addon">
								<span class="fa fa-calendar"></span>
							</span>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label for="preco">Pre�o</label> <input id="preco"
							class="form-control money" name="voo.preco" type="text"
							placeholder="Pre�o da V�o" value="${voo.preco}" />
					</div>
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">Lanches Oferecidos</div>
							<div class="panel-body">
								<div class="row">
									<c:forEach items="${listaDeLanches}" var="lanche">
										<div class="col-lg-3" style="margin-bottom: 20px">
											<div class="input-group">
												<span class="input-group-addon"> <input
													type="checkbox" name="lanches" value="${lanche.id}"
													aria-label="...">
												</span>
												<div class="form-control" aria-label="...">${lanche.nome}</div>
											</div>
											<!-- /input-group -->
										</div>
										<!-- /.col-lg-6 -->
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>