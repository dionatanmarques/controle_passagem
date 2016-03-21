<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Mensagens"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<div class="ol-md-12">
			<c:forEach items="${errors}" var="erro">
				<div class="alert ${erro.category} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>${erro.message}</p>
				</div>
			</c:forEach>
			<c:forEach items="${errors}" var="erro">
				<div class="alert ${erro.category} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>${erro.message}</p>
				</div>
			</c:forEach>
		</div>
	</div>
</div>