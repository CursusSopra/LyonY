/**
 * 
 */

// Variables globales
var i = $('#num').html();
var arrStartTime = [];
var arrEndTime = [];
var timeString = "";

// Création des sliders
$(function() {
	var nbSliders = $("#Horaires tr").length;
	var startTime;
	var endTime;

	for (var i = 1; i <= nbSliders; i++) {
		$("#slider-range" + i).slider({
			range : true,
			min : 0,
			max : 47,
			values : [ 20, 40 ],
			step : 1,
			slide : slideTime
		});
	}
});

// Fonction pour modifier les données des sliders
function slideTime(event, ui) {
	var $spanTime = $(ui.handle).parent().parent().next().children('span')
			.first();
	var rang = $spanTime.data('rang');

	// Quel plot du slider a été activé, le premier fils span du parent
	var val0 = $("#slider-range" + rang).slider("values", 0), int0 = parseInt(
			val0, 10), minutes0 = int0 % 2, hours0 = Math.floor(int0 / 2);
	var val1 = $("#slider-range" + rang).slider("values", 1), int1 = parseInt(
			val1, 10), minutes1 = int1 % 2, hours1 = Math.floor(int1 / 2);

	startTime = getTime(hours0, 30 * minutes0);
	arrStartTime[rang - 1] = startTime;

	endTime = getTime(hours1, 30 * minutes1);
	arrEndTime[rang - 1] = endTime;

	$spanTime.text(startTime + ' - ' + endTime);
}

// Transformation tableaux en une string pour transfère au java
function toString(arrStartTime, arrEndTime) {
	for (i = 0; i < 7; i++) {
		if (i < 6) {
			timeString += arrStartTime[i];
			timeString += "-";
			timeString += arrEndTime[i];
			timeString += "|";
		} else {
			timeString += arrStartTime[i];
			timeString += "-";
			timeString += arrEndTime[i];
		}
	}
	return timeString;
}

// Affiche des données en mode horaire
function getTime(hours, minutes) {
	if (minutes == "0") {
		minutes = minutes + "0";
	} else {
		minutes = minutes;
	}
	if (hours < "10") {
		hours = "0" + hours;
	} else {
		hours = hours;
	}
	return hours + ":" + minutes;
}

// Submit de la string des horaires
$("#scheduleSubmit").on('click', function() {
	toString(arrStartTime,arrEndTime);
	console.log(timeString);
});
