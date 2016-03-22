split = window.location.href.split('/');
var baseUrl = window.location.protocol+'//'+split[2]+'/'+split[3];
delete split;

var options = {
	format: "DD/MM/YYYY",
	icons: {
		previous: "fa fa-angle-left",
		next: "fa fa-angle-right"
	},
	widgetPositioning: {
		horizontal: "right"
	}
};

$(document).ready(function() {
	// Inicializa as máscaras de input
	initMask();
	// Inicializa Datepicker
	initDatepicker();
});

function initDatepicker() {
	// Datepicker
	$(".datepicker input").mask("00/00/0000");
	// Calendário
	$(".datepicker").datetimepicker(options);
}

function initMask() {
	// Somente números
	$(".numero").mask("0#");
	$('.money').mask("#.##0,00", {reverse: true});
};

$(document).ajaxStart(function() {
	$(".loading").show();
});

$(document).ajaxStop(function() {
	$(".loading").hide();
});