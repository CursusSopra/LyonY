/**
 * 
 */
$(document).ready(
	function() {
	//Validation/refus selon le remplissage du formulaire
		$('#idFormCreationAvis').submit(
			function(e) {
				var $avisNote = $('#idAvisNote');
				var valAvisNote = $avisNote.val();
				//Par défaut le formulaire est OK
				var formOK = true;
				//Si champ obligatoire non rempli
				var rx = new RegExp('[0-5]');
				if (valAvisNote == '' || !rx.test(valAvisNote)) {
					formOK &= false;
					$avisNote.parent().parent().parent().addClass('has-error');
					$avisNote.parent().next('span').html('Vous devez fournir une note entre 0 et 5');
				} else {
					$avisNote.parent().parent().parent().removeClass('has-error');
					$avisNote.parent().next('span').html('');
				}
				
				if (!formOK) {
					$('#idFormAlertError').removeClass('hidden');
					$('#idFormAlertError').fadeTo(10000, 500).slideUp(500);
					e.preventDefault();
				} else {
					$('#idFormAlertError').addClass('hidden');
				}
			});
		
		});