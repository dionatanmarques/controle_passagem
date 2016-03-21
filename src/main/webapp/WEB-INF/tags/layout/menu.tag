<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Menu Principal"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#menu-principal"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}">
				Controle de Passagens Aéreas </a>
		</div>
		<c:if test="${!usuarioLogado.logado}">
			<div class="collapse navbar-collapse" id="menu-principal">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}"> <i
							class="fa fa-ticket"></i> Comprar Passagem
					</a></li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/area"> <i
							class="fa fa-lock"></i> Área Restrita
					</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${usuarioLogado.logado}">
			<div class="collapse navbar-collapse" id="menu-principal">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown fa fa-building"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/companhia/cadastro">Cadastro</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/companhia/consulta"">Consulta</a></li>
							<li role="separator" class="divider"></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/aviao"> <i
							class="fa fa-ticket"></i> Frota Aérea
					</a></li>
					<li><a href="${pageContext.request.contextPath}/voo/cadastro" />
						<i class="fa fa-ticket"></i> Voo </a></li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/area/logout"> <i
							class="fa fa-power-off"></i> Sair
					</a></li>
				</ul>
			</div>
		</c:if>
	</div>
</nav>