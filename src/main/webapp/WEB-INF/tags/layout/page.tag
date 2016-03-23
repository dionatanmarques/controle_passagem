<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag description="Layout da Página" %>

<%@ attribute name="titulo" required="true" description="Título da página" %>
<%@ attribute name="javascript" fragment="true" description="Scripts específicos para cada página" %>
<%@ attribute name="style" fragment="true" description="Estilos específicos para cada página" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

		<title>${titulo} | CPA - Controle de Passagens Aéreas</title>

		<!-- Bootstrap v3.3.6 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" type="text/css" />

		<!-- Font Awesome v4.5.0 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/font-awesome.min.css" type="text/css" />

		<!-- Datetimepicker v4.14.30 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" type="text/css" />

		<!-- CPA -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cpa.css" type="text/css" />

		<jsp:invoke fragment="style" />
	</head>

	<body>
		<div class="loading"></div>

		<!-- Menu Principal -->
		<layout:menu />

		<!-- Mensagens -->
		<layout:msg />

		<div class="container">
			<jsp:doBody />
		</div>

		<!-- jQuery v1.12.1 -->
		<script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js" type="text/javascript"></script>

		<!-- Bootstrap v3.3.6 -->
		<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

		<!-- Mask v1.13.3 -->
		<script src="${pageContext.request.contextPath}/lib/mask/jquery.mask.js" type="text/javascript"></script>

		<!-- Moment v2.10.3 -->
		<script src="${pageContext.request.contextPath}/lib/moment/moment.js" type="text/javascript"></script>

		<!-- Moment Locale PT-BR -->
		<script src="${pageContext.request.contextPath}/lib/moment/pt-br.js" type="text/javascript"></script>

		<!-- Bootstrap Date Time Picker v4.14.30 -->
		<script src="${pageContext.request.contextPath}/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>

		<!-- CPA -->
		<script src="${pageContext.request.contextPath}/js/cpa.js" type="text/javascript"></script>

		<!-- funcoes_de_conversao.js -->
		<script src="${pageContext.request.contextPath}/js/funcoes_de_conversao.js" type="text/javascript"></script>

		<!-- VOO -->
		<script src="${pageContext.request.contextPath}/js/voo.js" type="text/javascript"></script>

		<jsp:invoke fragment="javascript" />
	</body>
</html>