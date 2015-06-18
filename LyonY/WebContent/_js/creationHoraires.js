/**
 * 
 */

// Variables globales
var arrStartTime = [];
var arrEndTime = [];
var startTime;
var endTime;
var timeString = "";

// Création des sliders
$(function() {
	var nbSliders = $("#Horaires tr").length;

	for (var i = 1; i <= nbSliders; i++) {
		$("#slider-range" + i).noUiSlider({
			start : [ 20, 38 ],
			range : {
				'min' : [ 0 ],
				'max' : [ 48 ]
			},
			step : 1,
			margin : 1,
			behaviour : 'snap',
		}).on({
			slide : function() {
				setTimeHolder($(this));
			}
		})
	}
});

// Fonction pour modifier les données des sliders
function setTimeHolder(moi) {
	var $spanTime = moi.parent().next().children('span').first();
	var rang = $spanTime.data('rang');

	var val0 = moi.val()[0];
	var int0 = parseInt(val0, 10), minutes0 = int0 % 2, hours0 = Math
			.floor(int0 / 2);

	var val1 = moi.val()[1];
	var int1 = parseInt(val1, 10), minutes1 = int1 % 2, hours1 = Math
			.floor(int1 / 2);

	var startTime = getTime(hours0, 30 * minutes0);
	arrStartTime[rang - 1] = startTime;

	var endTime = getTime(hours1, 30 * minutes1);
	arrEndTime[rang - 1] = endTime;

	$spanTime.text(startTime + ' - ' + endTime);
}

// Transformation tableaux en une string pour transfère au java
function toString(arrStartTime, arrEndTime) {
	for (var a = 0; a < 7; a++) {
		if (a < 6) {
			timeString += arrStartTime[a];
			timeString += "-";
			timeString += arrEndTime[a];
			timeString += "|";
		} else {
			timeString += arrStartTime[a];
			timeString += "-";
			timeString += arrEndTime[a];
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
	$('#idTimeString').val(toString(arrStartTime, arrEndTime));
});
