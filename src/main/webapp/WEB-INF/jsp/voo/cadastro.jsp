<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Vôos">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Frota Aérea <a class="btn btn-success btn-sm pull-right"
					href="${pageContext.request.contextPath}/voo/"> <span
					class="fa fa-search"></span> Consultar
				</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/voo/cadastrar"
					method="post">
					<div class="form-group col-md-4">
						<label for="companhiaId">Companhia Aérea</label> <select onchange="carregaFrota();"
						 class="form-control" name="companhiaId" id="companhiaId">
							<c:forEach items="${listaDeCompanhia}" var="comp">
								<option value="${comp.id}">${comp.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="aviaoId">Aeronaves </label> <select							
							class="form-control" name="aviaoId" id="aviaoId">
							<option>Selecione primeiro a companhia</option>
							<c:forEach items="${listaDeAvioes}" var="nave">
								<option value="${nave.id}">${nave.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="pilotoId">Piloto </label> <select
							class="form-control" name="pilotoId" id="pilotoId">
							<c:forEach items="${listaDePilotos}" var="piloto">
								<option value="${piloto.id}">${piloto.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="origemId">Local de Origem </label> <select onchange="carregaDestino();"
							class="form-control" name="origemId" id="origemId">
							<c:forEach items="${listaDeOrigens}" var="origem">
								<option value="${origem.id}">${origem.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="destinoId">Local de Destino </label> <select
							class="form-control" name="destinoId" id="destinoId">
							<option>Selecione primeiro a origem</option>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="dataEmbarque">Data Hora de Embarque</label>
							<input id="dataEmbarque" class="form-control date-time" type="text" 
							name="voo.dataEmbarque" value="${voo.dataEmbarque}"/>
					</div>
					<div class="form-group col-md-4">
						<label for="dataDesembarque">Data Hora de Dembarque</label>
							<input id="dataDesembarque" class="form-control date-time" type="text" 
							name="voo.dataDesembarque" value="${voo.dataDesembarque}"/>
					</div>
					<div class="form-group col-md-4">
						<label for="preco">Preço</label> <input id="preco"
							class="form-control money" name="voo.preco" type="text"
							placeholder="Preço da Vôo" value="${voo.preco}" />
					</div>
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>