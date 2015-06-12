/**
 * 
 */

 // création des sliders
$(function() {
	var startTime;
	var endTime;
	$("slider-range1").slider({
		range : true,
		min : 0,
		max : 1425,
		values : [ 540, 1020 ],
		step : 15,
		slide : slideTime1
	});
});

 // Fonction pour modifier les données des sliders
function slideTime1(event, ui, a) {
	var val0 = $("#slider-range1").slider("values", 0), val1 = $("#slider-range1")
			.slider("values", 1), minutes0 = parseInt(val0 % 60, 10), hours0 = parseInt(
			val0 / 60 % 24, 10), minutes1 = parseInt(val1 % 60, 10), hours1 = parseInt(
			val1 / 60 % 24, 10);

	startTime = getTime(hours0, minutes0);
	endTime = getTime(hours1, minutes1);
	$("#time1").text(startTime + ' - ' + endTime);
}


// Affiche des données en mode horaire
function getTime(hours, minutes) {
	minutes = minutes + "";
	return hours + ":" + minutes;
}

// Submit des horaires
$("#scheduleSubmit").on(
		'click',
		function() {
			console.log(startTime);
			console.log(endTime);
			$('#Schedule tbody').append(
					'<tr>' + '<td>' + startTime + '</td>' + '<td>'
							+ endTime + '</td>' + '</tr>');
});

