<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:page titulo="Piloto">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				Piloto
				<a class="btn btn-success btn-sm pull-right"
						href="${pageContext.request.contextPath}/piloto">
						<span class="fa fa-search"></span> Consultar
					</a>
			</div>
			<div class="panel-body">
				<form action="${pageContext.request.contextPath}/piloto/cadastrar" method="post">
					<input type="hidden" name="usuario.id" value="${piloto.id}" />
					<div class="form-group col-md-4">
						<label for="nome">Nome</label>
						<input id="nome"
							class="form-control uppercase" name="piloto.nome" type="text"
							placeholder="Nome" autofocus value="${piloto.nome}" />
					</div>
					<div class="form-group col-md-4">
						<label for="cpf">CPF</label>
						<input id="cpf"
							class="form-control" name="piloto.cpf" type="text"
							placeholder="CPF" value="${piloto.cpf}" />
					</div>
					<div class="form-group col-md-4">
						<label for="senha">CHT</label>
						<input id="cht"
							class="form-control" name="piloto.cht" type="text"
							placeholder="Carteiro de Habilitação Tecnica" value="${piloto.cht}" />
					</div>
					
					<button class="btn btn-primary pull-right" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</layout:page>