
function carregaFrota() {
	$.post("/controle_passagem/aviao/buscaJson", {
		"companhiaId" : $("#companhiaId").val()
	}, function(data) {
		$("#aviaoId").empty();
		for(i = 0; i < data.list.length;i++){
			$("#aviaoId").append("<option value=\""+data.list[i].id+"\">"+data.list[i].nome+"</option>");
		}
	});
}

function carregaDestino() {
	$.post("/controle_passagem/local/buscaExclusivaJson", {
		"origemId" : $("#origemId").val()
	}, function(data) {
		$("#destinoId").empty();
		for(i = 0; i < data.list.length;i++){
			$("#destinoId").append("<option value=\""+data.list[i].id+"\">"+data.list[i].nome+"</option>");
		}
	});
}
