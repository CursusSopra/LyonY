<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Entrez les informations sur le nouveau Restaurant :</h1>

<form class="form-horizontal" method="post"	id="idFormCreationRestaurant"	action="<s:url action='creationRestaurant'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		r�essayer</div>


	<legend>Identification du Restaurant</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du Restaurant *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomL" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
	<label for="idAmbiance" class="col-sm-2 control-label">Ambiance *</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idAmbiance" name="idAmbiance">
					<s:iterator value="listeDesAmbiances">
						<option value="<s:property value="idAmbiance" />"><s:property value="libambiance" /></option>
					</s:iterator>
				</select>
			</div>
			<div class = "row">
				<a href="<s:url action='creationAmbiance'/>">Ajouter une ambiance</a>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idQuartier" class="col-sm-2 control-label">Quartier *</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idQuartier" name="idQuartier">
					<s:iterator value="listeDesQuartiers">
						<option value="<s:property value="idquartier" />"><s:property value="nom" /></option>
					</s:iterator>
				</select>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<legend>Adresse</legend>

	<div class="form-group">
		<label for="idNumero" class="col-sm-2 control-label">Num�ro</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNumero" name="numero" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodePostal" class="col-sm-2 control-label">Code
			postal *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodePostal" name="codePostal" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<legend>Caract�ristiques</legend>

	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA name="description" rows=4 cols=40
					placeholder="D�crivez le restaurant : sp�cialit�s, activit�s..."></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAccessibilit�" class="col-sm-2 control-label">Comment	y acc�der ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilit�" name="accessibilite" rows=4 cols=40
					placeholder="Expliquez comment l'on peut s'y rendre"></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idPrixmin" class="col-sm-2 control-label">Prix mini</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idPrixmin" name="prixmin" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idPrixmax" class="col-sm-2 control-label">Prix maxi</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idPrixmax"
					name="prixmax" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idReservation" class="col-sm-2 control-label">R�servation</label>
		<div class="col-sm-3">
			<div class="row">
				Oui <input type="radio" class="form-align" id="idReservation" name="reservation" value="true"> &nbsp; &nbsp; &nbsp; 
				Non <input type="radio" class="form-align" id="idReservation" name="reservation" value="false">
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAemporter" class="col-sm-2 control-label">A emporter</label>
		<div class="col-sm-3">
			<div class="row">
				Oui <input type="radio" class="form-align" id="idAemporter"	name="aemporter" value="true"> &nbsp; 
				Non <input type="radio" class="form-align" id="idAemporter" name="aemporter" value="false">
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

		
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">(* : champ obligatoire)</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">
				<button type="submit" class="btn btn-default">Envoyer</button>
			</div>
		</div>
	</div>

</form>



<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
$(document).ready(
		function() {
		//Validation/refus selon le remplissage du formulaire
			$('#idFormCreationRestaurant').submit(
				function(e) {
					var $nom = $('#idNom');
					var $cp = $('#idCodePostal');
					var $ville = $('#idVille');
					var valNom = $nom.val();
					var valCp = $cp.val();
					var valVille = $ville.val();
					//Par d�faut le formulaire est OK
					var formOK = true;
					//Si champ obligatoire non rempli
					if (valNom == '') {
						formOK &= false;
						$nom.parent().parent().parent().addClass('has-error');
						$nom.parent().next('span').html('Vous devez fournir le nom du restaurant');
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
			});
</script>
