/**
 * 
 */

var arrStartTime = [];
var arrEndTime = [];

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

function setTimeHolder(moi) {
	var $spanTime = moi.parent().next().children('span').first();
	var rang = $spanTime.data('rang');
	
	var val0 = moi.val()[0];
	var int0 = parseInt(val0, 10), minutes0 = int0 % 2, hours0 = Math.floor(int0 / 2);

	var val1 = moi.val()[1];
	var int1 = parseInt(val1, 10), minutes1 = int1 % 2, hours1 = Math.floor(int1 / 2);

	var startTime = getTime(hours0, 30 * minutes0);
	arrStartTime[rang - 1] = startTime;

	var endTime = getTime(hours1, 30 * minutes1);
	arrEndTime[rang - 1] = endTime;

	$spanTime.text(startTime + ' - ' + endTime);
	
}

$(function() {
	var nbSliders = $("#Horaires tr").length;
	for(var i = 1; i <= nbSliders; i++) {		
		$("#slider-range"+i)
		.noUiSlider({
			start: [10*60, 22*60],
			range: {
				'min': [0],
				'max': [48]
			},
			step : 1,
			margin: 1,
			behaviour: 'snap'
		})
		.on({
			slide: function(){
				setTimeHolder($(this));
//				var val0 = $(this).val()[0], int0 = parseInt(
//						val0, 10), minutes0 = int0 % 2, hours0 = Math.floor(int0 / 2);
//
//				var val1 = $("#slider-range" + rang).slider("values", 1), int1 = parseInt(
//						val1, 10), minutes1 = int1 % 2, hours1 = Math.floor(int1 / 2);
			}
//		,
//			set: function(){
//				console.log($(this).val());
//			},
//			change: function(){
//				console.log($(this).val());
//			}
		});
	}
});
