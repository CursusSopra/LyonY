/**
 * 
 */

 // création des sliders
var i = $('#num').html();
	
$(function() {
	var nbSliders = $("#Horaires tr").length;
	var startTime;
	var endTime;
	for(var i = 1; i <= nbSliders; i++) {
		$("#slider-range"+i).slider({
			range : true,
			min : 0,
			max : 1425,
			values : [ 540, 1020 ],
			step : 15,
			slide : slideTime
		});
	}
});

 // Fonction pour modifier les données des sliders
function slideTime(event, ui) {
	var $spanTime = $(ui.handle).parent().parent().next().children('span').first();
	var rang = $spanTime.data('rang');
	var val0 = $("#slider-range" + rang).slider("values", 0), val1 = $("#slider-range" + rang)
			.slider("values", 1), minutes0 = parseInt(val0 % 60, 10), hours0 = parseInt(
			val0 / 60 % 24, 10), minutes1 = parseInt(val1 % 60, 10), hours1 = parseInt(
			val1 / 60 % 24, 10);

	startTime = getTime(hours0, minutes0);
	endTime = getTime(hours1, minutes1);
	$spanTime.text(startTime + ' - ' + endTime);
}


// Affiche des données en mode horaire
function getTime(hours, minutes) {
	if(minutes == "0"){
		minutes = minutes + "0";
	} else {
		minutes = minutes;
	} 
	if(hours < "10"){
		hours = "0"+ hours;
	} else{
		hours = hours;
	}
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

