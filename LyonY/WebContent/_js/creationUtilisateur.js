/**
 * 
 */
$(function() {
	var selectedPseudo = $('#idNewPseudo').val();
	var selectedEmail = $('#idNewEmail').val();
	$('#idNewPseudo')
		.blur(function() {
			var $this = $(this);
			var selectedPseudo = $('#idNewPseudo').val();	
			$.getJSON('getJSONpseudo?pseudo=' + selectedPseudo)
			 	.success(function(data) { /* affiche pseudo dispo */
			 		if(data.pseudoDispo) {
				 		console.log(data.pseudoDispo);
				 		$this.closest('.form-group').addClass("has-success").removeClass("has-error");
				 		$this.parent().next('span').html('Le pseudo est libre.');
				 		
			 		} else {
			 			$this.closest('.form-group').addClass("has-error").removeClass("has-success");
			 			$this.parent().next('span').html('Ce pseudo n&apos;est pas disponible, merci d&apos;en choisir un autre.');
			 		}
			 		var szOption = '<option>Pseuso disponible</option>';
		 		})
		 		.fail(function(indispo) { /* affiche pseudo indisponible */
		 		});
		});
	
	$('#idNewEmail')
	.blur(function() {
		var $this = $(this);
		var selectedEmail = $('#idNewEmail').val();	
		$.getJSON('getJSONemail?email=' + selectedEmail)
		 	.success(function(data) { /* affiche pseudo dispo */
		 		if(data.emailDispo) {
			 		console.log(data.emailDispo);
			 		$this.closest('.form-group').addClass("has-success").removeClass("has-error");
			 		$this.parent().next('span').html('Le pseudo est libre.');
			 		
		 		} else {
		 			$this.closest('.form-group').addClass("has-error").removeClass("has-success");
		 			$this.parent().next('span').html('Cette adresse mail n&apos;est pas disponible, merci d&apos;en choisir une autre.');
		 		}
		 		var szOption = '<option>Pseuso disponible</option>';
	 		})
	 		.fail(function(indispo) { /* affiche pseudo indisponible */
	 		});
	});
	
});