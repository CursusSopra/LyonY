<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Modification d'un bar</h1>

<form class="form-horizontal" method="post" id="idFormModifBar" action="<s:url action='formModifBar'/>">
	
	<input type="hidden" id="idBar" name="idBar" value="<s:property value = "bar.idBar"/>"/>

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		réessayer</div>


	<legend>Identification du Bar</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du Bar</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nombar" value="<s:property value = "bar.nombar"/>"/>
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
						<option value="<s:property value="idambiance" />" ${bar.libambiance == libambiance ? 'selected="selected"' : ''} ><s:property value="libambiance" /></option>
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
						<option value="<s:property value="idquartier" />" ${bar.nomquartier == nom ? 'selected="selected"' : ''} >
						
						
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
				<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value = "bar.numero"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value = "bar.voie"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code
			postal</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codepostal" value="<s:property value = "bar.codepostal"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value = "bar.ville"/>" />
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
					value="<s:property value = "bar.description"/>" ></TEXTAREA>
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
					value="<s:property value = "bar.accessiblite"/>" ></TEXTAREA>
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
					name="prixmin" value="<s:property value = "bar.prixmin"/>" />
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
					name="prixmax" value="<s:property value = "bar.prixmax"/>" />
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
					name="happyhour" />
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
			$('#idFormCreationBar').submit(
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
						$nom.parent().next('span').html('Vous devez fournir le nom du bar');
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