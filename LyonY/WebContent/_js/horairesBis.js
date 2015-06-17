/**
 * 
 */	
$(function() {
	var nbSliders = $("#Horaires tr").length;
	for(var i = 1; i <= nbSliders; i++) {		
		$("#slider-range"+i).noUiSlider({
			start: [10*60, 22*60],
			range: {
				'min': [0],
				'max': [24*60]
			},
			step : 30,
			margin: 30,
			behaviour: 'snap'
		});

		// Tags after '-inline-' are inserted as HTML.
		// noUiSlider writes to the first element it finds.
//		$("#slider-range"+i).Link('upper').to('-inline-<div class="tooltip"></div>', function ( value ) {
//
//			// The tooltip HTML is 'this', so additional
//			// markup can be inserted here.
//			$(this).html(
//				'<strong>Value: </strong>' +
//				'<span>' + value + '</span>'
//			);
//		});


	}
});
