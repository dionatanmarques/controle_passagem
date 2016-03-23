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
					<li><a href="${pageContext.request.contextPath}/companhia/">
							<i class="fa fa-building"></i> Companhia Aérea
					</a></li>
					<li><a href="${pageContext.request.contextPath}/aviao"> <i
							class="fa fa-space-shuttle"></i> Frota Aérea
					</a></li>
					<li><a href="${pageContext.request.contextPath}/local" /> <i
						class="fa fa-picture-o"></i> Destinos </a></li>
					<li><a href="${pageContext.request.contextPath}/lanche" /> <i
						class="fa fa-coffee"></i> Lanches </a></li>
					<li><a href="${pageContext.request.contextPath}/voo/cadastro" />
						<i class="fa fa-plane"></i> Voo </a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><i class="fa fa-users"></i></i>Funcionários <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/funcionario"> <i
								class="fa fa-user-secret"></i> Usuários Sistema </a></li>
							<li role="separator" class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/piloto/">
									<i class="fa fa-user"></i> Piloto
							</a></li>
							<li role="separator" class="divider"></li>
						</ul></li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/area/logout"> <i
							class="fa fa-power-off"></i> Sair
					</a></li>
				</ul>
			</div>
		</c:if>
	</div>
</nav>