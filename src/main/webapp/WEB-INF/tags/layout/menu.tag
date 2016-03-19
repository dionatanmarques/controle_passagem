<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag description="Menu Principal" %>

<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-principal" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}">
				Controle de Passagens Aéreas
			</a>
		</div>
		<div class="collapse navbar-collapse" id="menu-principal">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="${pageContext.request.contextPath}">
						<i class="fa fa-ticket"></i> Comprar Passagem
					</a>
				</li>
				<li class="active">
					<a href="${pageContext.request.contextPath}/area">
						<i class="fa fa-lock"></i> Área Restrita
					</a>
				</li>
			</ul>
		</div>
	</div>
</nav>