/**
 * 
 */

// Variables globales
var arrStartTime = [];
var arrEndTime = [];
var startTime;
var endTime;
var timeStringIn = $("#idtimeStringOut").value;
console.log(timeStringIn);
 //Création des sliders
$(function() {
	var nbSliders = $("#Horaires tr").length;
	toTime(timeStringIn);
	for (var i = 1; i <= nbSliders; i++) {
		var min = getValeurs(arrStartTime)[i-1];
		var max = getValeurs(arrEndTime)[i-1];
		console.log(min);
		console.log(max);
		$("#slider-range" + i).noUiSlider({
			start : [ min, max ],
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
function toTime(timeStringIn) {
	var temp1 = timeStringIn.split("|");
	for (var i = 0; i < temp1.length; i++) {

		// On crée un tableau de "hd" et "hf"
		var temp2 = temp1[i].split("-");

		// On valorise les tableaux heureDebut et heureFin
		arrStartTime[i] = temp2[0];
		arrEndTime[i] = temp2[1];
	}
	return arrStartTime, arrEndTime;
	
}

// Affiche des données en mode horaire
function getValeurs(arrTime) {
	var arrValeurs = [];
	
	for (var i = 0; i < arrTime.length; i++) {
		var temp = arrTime[i].split(":");
		//temp[0] vaut heure et temp[1] vaut minutes (0 ou 30)
		if(temp[1] == '00'){
			arrValeurs[i] = (2 * temp[0]);
		} else {
			arrValeurs[i] = (2 * temp[0] + 1);
		}
	}
	return arrValeurs;
}

//Affiche des données en mode horaire
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

function toString(arrStartTime, arrEndTime) {
	for (var a = 0; a < 7; a++) {
		if (a < 6) {
			timeStringOut += arrStartTime[a];
			timeStringOut += "-";
			timeStringOut += arrEndTime[a];
			timeStringOut += "|";
		} else {
			timeStringOut += arrStartTime[a];
			timeStringOut += "-";
			timeStringOut += arrEndTime[a];
		}
	}
	return timeStringOut;
}

//
//// Submit de la string des horaires
$("#scheduleSubmit").on('click', function() {
	$('#idTimeString').val(toString(arrStartTime, arrEndTime));
});
