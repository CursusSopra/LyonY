<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Modification d'un restaurant</h1>

<form class="form-horizontal" method="post" id="idFormModifRestaurant"	action="<s:url action='formModifRestaurant'/>">
	
	<input type="hidden" id="idRestaurant" name="idRestaurant" value="<s:property value = "restaurant.idRestaurant"/>"/>

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		réessayer</div>


	<legend>Identification du Restaurant</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du Restaurant</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomrestaurant" value="<s:property value = "restaurant.nomrestaurant"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	
	<div class="form-group">
	<label for="idAmbiance" class="col-sm-2 control-label">Ambiance</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idAmbiance">
					<s:iterator value="listeDesAmbiances">
						<option value="<s:property value="idambiance" />" ${restaurant.libambiance == libambiance ? 'selected="selected"' : ''} ><s:property value="libambiance" /></option>
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
		<label for="idQuartier" class="col-sm-2 control-label">Quartier</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idQuartier">
					<s:iterator value="listeDesQuartiers">
						<option value="<s:property value="idquartier" />" ${restaurant.nomquartier == nom ? 'selected="selected"' : ''} >
						
							<s:property	value="nom" />
						</option>
					</s:iterator>
				</select>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<legend>Adresse</legend>

	<div class="form-group">
		<label for="idNumero" class="col-sm-2 control-label">Numéro</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value = "restaurant.numero"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value = "restaurant.voie"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code
			postal</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codepostal" value="<s:property value = "restaurant.codepostal"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value = "restaurant.ville"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<legend>Caractéristiques</legend>

	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA name="description" rows=4 cols=40
					value="<s:property value = "restaurant.description"/>" ></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAccessibilité" class="col-sm-2 control-label">Comment
			y accéder ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilité" name="accessibilite" rows=4 cols=40
					value="<s:property value = "restaurant.accessiblite"/>" ></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idPrixmin" class="col-sm-2 control-label">Prix
			mini</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idPrixmin"
					name="prixmin" value="<s:property value = "restaurant.prixmin"/>"  />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idPrixmax" class="col-sm-2 control-label">Prix
			maxi</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idPrixmax"
					name="prixmax" value="<s:property value = "restaurant.prixmax"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idReservation" class="col-sm-2 control-label">Réservation</label>
		<div class="col-sm-3">
			<div class="row">
				Oui <input type="radio" class="form-align" id="idReservation"
					name="reservation" value="true"> &nbsp; Non <input
					type="radio" class="form-align" id="idReservation"
					name="reservation" value="false">
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAemporter" class="col-sm-2 control-label">A
			emporter</label>
		<div class="col-sm-3">
			<div class="row">
				Oui <input type="radio" class="form-align" id="idAemporter"
					name="aemporter" value="true"> &nbsp; Non <input
					type="radio" class="form-align" id="idAemporter" name=""
					aemporter"" value="false">
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<legend>Horaires</legend>

	<div class="form-group">
		<label for="idHappyHour" class="col-sm-2 control-label">Happy
			hour</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idHappyHour"
					name="happyhour" value="<s:property value = "restaurant.happyhour"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
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
					var $cp = $('#idCodepostal');
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