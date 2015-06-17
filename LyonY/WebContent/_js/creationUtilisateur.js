/**
 * 
 */
$(function() {
	var selectedPseudo = $('#idNewPseudo').val();
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
			 	})
		 		.fail(function(indispo) { /* affiche pseudo indisponible */
		 		});
		});
});

$(function() {
	var selectedEmail = $('#idNewEmail').val();
	$('#idNewEmail')
		.blur(function() {
			var $this = $(this);
			var selectedEmail = $('#idNewEmail').val();	
			$.getJSON('getJSONemail?email=' + selectedEmail)
			 	.success(function(data) { /* affiche mail dispo */
			 		if(data.emailDispo) {
				 		console.log(data.emailDispo);
				 		$this.closest('.form-group').addClass("has-success").removeClass("has-error"); /* .closest('.form-group') évite de cumuler pleins de .parent() à la suite*/
				 		$this.parent().next('span').html('L&apos;adresse mail est libre.');
				 		
			 		} else {
			 			$this.closest('.form-group').addClass("has-error").removeClass("has-success");
			 			$this.parent().next('span').html('Cette adresse mail n&apos;est pas disponible, merci d&apos;en choisir une autre.');
			 		}
			 	})
		 		.fail(function(indispo) { /* affiche mail indisponible */
		 		});
		});
});