<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Création de votre profil Lyon'Y</h1>

<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">Alerte !</div>
<form class="form-horizontal" method="post"
	id="idSendCreationUtilisateur"
	action="<s:url action='SendCreationUtilisateur'/>">
	<fieldset>
		<legend>Login</legend>
		<div class="form-group">
			<label for="idPseudo" class="col-lg-4 control-label">Pseudo</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idPseudo"
							name="pseudo" placeholder="Pseudo" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="idMotDePasse" class="col-lg-4 control-label">Mot
				de passe</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="password" class="form-control" id="idMotDePasse"
							name="motDePasse" placeholder="Mot de Passe" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Informations personnelles</legend>
		<div class="form-group">
			<label for="idEmail" class="col-lg-4 control-label">Adresse
				mail</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idEmail" name="email"
							placeholder="exemple.exemple@gmail.fr" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="idDateNaissance" class="col-lg-4 control-label">Date
				de Naissance</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idDateNaissance"
							name="dateNaissance" placeholder="aaaa-mm-jj" pattern="\d{4}-\d{2}-\d{2}" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="idSexe" class="col-lg-4 control-label">Sexe</label>
			<div class="row">
				<input type="radio" name="sexe" value="M" required>Homme 
				<input type="radio" name="sexe" value="F" required>Femme 
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Optionnel</legend>
		<div class="form-group">
			<label for="idAvatar" class="col-lg-4 control-label">Avatar</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idAvatar"
							name="avatar" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>


	<input type="submit" value="Créer le compte" />
</form>
<script>
// $(document).ready(function() {
// //quand idFormCreateCandidat sera soumit, faire ce qu'il y a dans la parenthese de submit
// 	$('#idSendCreationUtilisateur').submit(function(e) {
// 		var $pseudo = $('#idPseudo');
// 		var $motDePasse = $('#idMotDePasse');
// 		var $email = $('#idEmail');
// 		var $dateNaissance = ('#idDateNaissance');
// 		var $sexe = ('#idSexe');
		
// 		var valPseudo = $pseudo.val();
// 		var valMotDePasse = $motDePasse.val();
// 		var valEmail = $email.val();
// 		var valDateNaissance = $dateNaissance.val();
// 		var valSexe = $sexe.val();
		
// 		//par defaut le formulaire est OK
// 		var formOk = true;

// 		// Champ obligatoire non rempli
// 		//presentation
// 		if (valPseudo == '') {
// 			formOk &= false;
// 			//4 parent pck ca refere aux "div" qui sont 4 imbriqués
// 			$pseudo.parent().parent().parent().parent().addClass('has-error').removeClass('has-success');
// 			$pseudo.parent().next('span').html('Vous devez choisir un pseudo.');
// 			} else {
// 				$pseudo.parent().parent().parent().parent().removeClass('has-error').addClass('has-success');
// 				$pseudo.parent().next('span').html('');
// 				}
// 		if (valMotDePasse == '') {
// 			formOk &= false;
// 			$motDePasse.parent().parent().parent().parent().addClass('has-error').removeClass('has-success');
// 			$motDePasse.parent().next('span').html('Vous devez choisir un mot de passe.');
// 			} else {
// 				$motDePasse.parent().parent().parent().parent().removeClass('has-error').addClass('has-success');
// 				$motDePasse.parent().next('span').html('');
// 				}
// 		if (valEmail == '') {
// 			formOk &= false;
// 			$email.parent().parent().parent().parent().addClass('has-error').removeClass('has-success');
// 			$email.parent().next('span').html('Merci d'indiquer votre email afin de pouvoir valider votre inscription sur Lyon'Y.');
// 			} else {
// 				$email.parent().parent().parent().parent().removeClass('has-error').addClass('has-success');
// 				$email.parent().next('span').html('');
// 				}
// 		if (valDateNaissance == '') {
// 			formOk &= false;
// 			$dateNaissance.parent().parent().parent().parent().addClass('has-error').removeClass('has-success');
// 			$dateNaissance.parent().next('span').html('Merci d'indiquer votre date de naissance.');
// 			} else {
// 				$dateNaissance.parent().parent().parent().parent().removeClass('has-error').addClass('has-success');
// 				$dateNaissance.parent().next('span').html('');
// 				}
// 		if (valSexe == '') {
// 			formOk &= false;
// 			$Sexe.parent().parent().addClass('has-error').removeClass('has-success');
// 			$Sexe.parent().next('span').html('Merci de choisir...');
// 			} else {
// 				$Sexe.parent().parent().parent().parent().removeClass('has-error').addClass('has-success');
// 				$Sexe.parent().next('span').html('');
// 				}
// 		//traitement
// 		if (!formOk) {
// 				$('#idFormAlertError').removeClass('hidden');
// 				$('#idFormAlertError').fadeTo(2000,500).slideUp(500);
// 				e.preventDefault();
// 			} else{
// //					$('#idFormAlertError').addClass('hidden');
// 			}
// 	});
// });
</script>