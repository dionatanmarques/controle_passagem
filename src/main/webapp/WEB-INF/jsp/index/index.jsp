<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<layout:page titulo="Compra de Passagem">
	<jsp:body>
		<div class="row">
			<div class="col-md-offset-3 col-md-6 col-md-offset-3 panel panel-default">
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/voo/pesquisar" method="post">
						<div class="form-group text-center">
							<label class="radio-inline">
								<input type="radio" name="tipoViagem" checked /> IDA E VOLTA
							</label>
							<label class="radio-inline">
								<input type="radio" name="tipoViagem" /> SOMENTE IDA
							</label>
						</div>
						<div class="form-group col-md-6">
							<label for="localOrigem">Local Origem</label>
							<input id="localOrigem" class="form-control" name="voo.localOrigem.nome" type="text" placeholder="Local Origem" autofocus />
						</div>
						<div class="form-group col-md-6">
							<label for="localDestino">Local Destino</label>
							<input id="localDestino" class="form-control" name="voo.localDestino.nome" type="text" placeholder="Local Destino" />
						</div>
						<div class="form-group col-md-6">
							<label for="ida">Ida</label>
							<div class="input-group date datepicker">
								<input id="ida" class="form-control" type="text" name="voo.dataEmbarque" placeholder="dd/mm/yyyy" />
								<span class="input-group-addon">
									<span class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label for="volta">Volta</label>
							<div class="input-group date datepicker">
								<input id="volta" class="form-control" type="text" name="voo.dataDesembarque" placeholder="dd/mm/yyyy" />
								<span class="input-group-addon">
									<span class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
						<button class="btn btn-primary pull-right" type="submit">Pesquisar</button>
					</form>
				</div>
			</div>
		</div>
	</jsp:body>
</layout:page>