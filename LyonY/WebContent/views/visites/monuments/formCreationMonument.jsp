<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour à la page d'accueil</a> --%>

<h1>Ajout d'un monument</h1>

<form class="form-horizontal" method="post" id="idFormCreationMonument" action="<s:url action='creationMonument'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">
		Le formulaire contient des erreurs. Veuillez réessayer.
	</div>


	<legend>Identification</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du monument *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomL" placeholder="Exemple : Le Factory"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>


	<div class="form-group">
		<label for="idTypevisite" class="col-sm-2 control-label">Type de monument *</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idTypevisite" name="idTypevisite">
					<option value="">Choisissez...</option>
					<s:iterator value="listeDesTypevisites">
						<option value="<s:property value="idTypevisite" />"><s:property value="libtypevisite" /></option>
					</s:iterator>
				</select>
			</div>
<!-- 			<div class = "row"> -->
<%-- 				<a href="<s:url action='creationTypevisite'/>">Ajouter un type de monument</a> --%>
<!-- 			</div> -->
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idQuartier" class="col-sm-2 control-label">Quartier *</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idQuartier" name="idQuartier">
					<option value="">Choisissez...</option>
					<s:iterator value="listeDesQuartiers">
						<option value="<s:property value="idQuartier" />"><s:property value="nom" /></option>
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
				<input type="text" class="form-control" id="idNumero" name="numero" placeholder="Exemple : 66" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" placeholder="Exemple : cours Charlemagne"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code postal *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codePostal" placeholder="Exemple : 69002" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="Lyon" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<legend>Caractéristiques</legend>
	
	<div class="form-group">
		<label for="idAnnCons" class="col-sm-2 control-label">Année de début de construction</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idAnnCons" name="annCons" placeholder="Exemple : 1988"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAnnFinCons" class="col-sm-2 control-label">Année de fin de construction</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idAnnFinCons" name="annFinCons" placeholder="Exemple : 1991"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idDescription" name="description" rows=4 cols=40 placeholder="Décrivez le monument, son architecture, etc"></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idAccessibilité" class="col-sm-2 control-label">Comment y accéder ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilité" name="accessibilite" rows=4 cols=40 placeholder="Expliquez comment l'on peut s'y rendre"></TEXTAREA>
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
				<button type="reset" class="btn btn-default">Etat initial</button>
				<button type="submit" class="btn btn-default">Ajouter ce monument</button>
			</div>
		</div>
	</div>

</form>

<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
			//Validation/refus selon le remplissage du formulaire
				$('#idFormCreationMonument').submit(
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
				});
</script>