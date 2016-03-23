split = window.location.href.split('/');
var baseUrl = window.location.protocol+'//'+split[2]+'/'+split[3];
delete split;

var timePickerOptions = {
	format: "DD/MM/YYYY",
	icons: {
		previous: "fa fa-angle-left",
		next: "fa fa-angle-right"
	},
	widgetPositioning: {
		horizontal: "right"
	}
};

var timePickerOptionsWithTime = {
		format: "DD/MM/YYYY HH:mm",
		icons: {
			previous: "fa fa-angle-left",
			next: "fa fa-angle-right",
			up: "fa fa-angle-up",
			down: "fa fa-angle-down",
			time: "fa fa-clock-o",
			date: "fa fa-calendar"
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
	$(".datepicker").datetimepicker(timePickerOptions);
	// Datepicker
	$(".datepicker-with-hours input").mask("00/00/0000 00:00");
	// Calendário com Hora
	$(".datepicker-with-hours").datetimepicker(timePickerOptionsWithTime);
}

function initMask() {
	// Somente números
	$(".numero").mask("0#");
	$('.money').mask("#.##0,00", {reverse: true});
	// DateTime
	$(".date-time input").mask("00/00/0000 00:00:00");
};

$(document).ajaxStart(function() {
	$(".loading").show();
});

$(document).ajaxStop(function() {
	$(".loading").hide();
});