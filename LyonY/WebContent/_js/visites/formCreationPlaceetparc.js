/**
 * 
 */
$(document).ready(
	function() {
	//Validation/refus selon le remplissage du formulaire
		$('#idFormCreationPlaceetparc').submit(
			function(e) {
				var $nom = $('#idNom');
				var $typev = $('#idTypevisite');
				var $quart = $('#idQuartier');
				var $cp = $('#idCodepostal');
				var $ville = $('#idVille');
				var valNom = $nom.val();
				var valTypev = $typev.val();
				var valQuart = $quart.val();
				var valCp = $cp.val();
				var valVille = $ville.val();
				//Par défaut le formulaire est OK
				var formOK = true;
				//Si champ obligatoire non rempli
				if (valNom == '') {
					formOK &= false;
					$nom.parent().parent().parent().addClass('has-error');
					$nom.parent().next('span').html('Vous devez fournir le nom du monument');
				} else {
					$nom.parent().parent().parent().removeClass('has-error');
					$nom.parent().next('span').html('');
				}
				if (valTypev == '') {
					formOK &= false;
					$typev.parent().parent().parent().addClass('has-error');
					$typev.parent().next('span').html('Vous devez renseigner le type');
				} else {
					$typev.parent().parent().parent().removeClass('has-error');
					$typev.parent().next('span').html('');
				}
				if (valQuart == '') {
					formOK &= false;
					$quart.parent().parent().parent().addClass('has-error');
					$quart.parent().next('span').html('Vous devez selectionner un quartier');
				} else {
					$quart.parent().parent().parent().removeClass('has-error');
					$quart.parent().next('span').html('');
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
		
		
//		$("#idAppelModal#submit").click(function(){
//			$.ajax({
//				type: "POST",
//				url: "process.php", //process to mail
//				data: $('form.contact').serialize(),
//				success: function(msg){
//					$("#idAppelModal").html(msg) //hide button and show thank you
//					$("#form-content").modal('hide'); //hide popup	
//				},
//				error: function(){
//					alert("failure");
//				}
//			});
//		});
		
		});