/**
 * 
 */
$(document).ready(
		function() {
		//Validation/refus selon le remplissage du formulaire
			$('#idFormCreationNclub').submit(
				function(e) {
					var $nom = $('#idNom');
					var $cp = $('#idCodePostal');
					var $ville = $('#idVille');
					var valNom = $nom.val();
					var valCp = $cp.val();
					var valVille = $ville.val();
					//Par défaut le formulaire est OK
					var formOK = true;
					//Si champ obligatoire non rempli
					if (valNom == '') {
						formOK &= false;
						$nom.parent().parent().parent().addClass('has-error');
						$nom.parent().next('span').html('Vous devez fournir le nom du night club');
					} else {
						$nom.parent().parent().parent().removeClass('has-error');
						$nom.parent().next('span').html('');
					}
					var rx = new RegExp('[0-9]{5}');
					if (valCp == '' || !rx.test(valCp)) {
						formOK &= false;
						$cp.parent().parent().parent().addClass('has-error');
						$cp.parent().next('span').html('Vous devez fournir un code postal valide');
					} else {
						$cp.parent().parent().parent().removeClass('has-error');
						$cp.parent().next('span').html('');
					}
					if (valVille == '') {
						formOK &= false;
						$ville.parent().parent().parent().addClass('has-error');
						$ville.parent().next('span').html('Vous devez fournir un nom de ville');
					} else {
						$ville.parent().parent().parent().removeClass('has-error');
						$ville.parent().next('span').html('');
					}
					if (!formOK) {
						$('#idFormAlertError').removeClass('hidden');
						$('#idFormAlertError').fadeTo(10000, 500).slideUp(500);
						e.preventDefault();
					} else {
						$('#idFormAlertError').addClass('hidden');
					}
				});
			

			$('#idFormCreationAmbiance').submit(
					function(e) {
						e.preventDefault();
						var $libAmbiance = $('#idLibAmbiance');
						var valLibAmbiance = $libAmbiance.val();
						
						//Par défaut le formulaire est OK
						var formOK = true;
						//Si champ obligatoire non rempli
						if (valLibAmbiance == '') {
							formOK &= false;
							$libAmbiance.parent().parent().parent().addClass('has-error');
							$libAmbiance.parent().next('span').html('Vous devez renseigner un nouveau type !');
						} else {
							$libAmbiance.parent().parent().parent().removeClass('has-error');
							$libAmbiance.parent().next('span').html('');
						}
						if (formOK) {
							$.ajax({
								type: "POST", url: "creationAmbiance", data: $('#idFormCreationAmbiance').serialize(),
								success: function(msg){
									$("#idAmbiance").append('<option value="' + msg.idAmbiance + '" selected="selected">' + msg.libambiance + '</option>');
									$("#idModal").modal('hide'); //hide popup
									$('#idFormCreationAmbiance')[0].reset();
								},
								error: function(){
									alert("failure");
								}
							});
						}
				});
			});