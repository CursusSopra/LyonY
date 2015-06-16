<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour � la page d'accueil</a> --%>

<h1>Ajout d'un monument</h1>

<form class="form-horizontal" method="post" id="idFormCreationMonument" action="<s:url action='creationMonument'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">
		Le formulaire contient des erreurs. Veuillezr�essayer
	</div>


	<legend>Identification</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du monument</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomL" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>


	<div class="form-group">
		<label for="idTypevisite" class="col-sm-2 control-label">Type de monument</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idTypevisite">
					<s:iterator value="listeDesTypevisites">
						<option value="<s:property value="idtypevisite" />"><s:property value="libtypevisite" /></option>
					</s:iterator>
				</select>
			</div>
			<div class = "row">
				<a href="<s:url action='creationTypevisite'/>">Ajouter un type de monument</a>
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
		<label for="idCodepostal" class="col-sm-2 control-label">Code
			postal</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codePostal" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<legend>Caract�ristiques</legend>
	
	<div class="form-group">
		<label for="idAnnCons" class="col-sm-2 control-label">Ann�e de d�but de construction</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idAnnCons" name="annCons" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAnnFinCons" class="col-sm-2 control-label">Ann�e de fin de construction</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idAnnFinCons" name="annFinCons" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idDescription" name="description" rows=4 cols=40 placeholder="D�crivez le monument, son architecture, etc"></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idAccessibilit�" class="col-sm-2 control-label">Comment y acc�der ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilit�" name="accessibilite" rows=4 cols=40 placeholder="Expliquez comment l'on peut s'y rendre"></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
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
	$(document)
			.ready(
					function() {


						//Validation/refus selon le remplissage du formulaire
						$('#idFormAjouterBar')
								.submit(
										function(e) {
											var $nom = $('#idNom');
											var $prenom = $('#idPrenom');
											var valNom = $nom.val();
											var valPrenom = $prenom.val();
											//Par d�faut le formulaire est OK
											var formOK = true;
											//console.log(valNom);
											//Si champ obligatoire non rempli
											if (valNom == '') {
												formOK &= false;
												$nom.parent().parent().parent()
														.addClass('has-error');
												$nom
														.parent()
														.next('span')
														.html(
																'Vous devez fournir le nom du candidat');
											} else {
												$nom.parent().parent().parent()
														.removeClass(
																'has-error');
												$nom.parent().next('span')
														.html('');
											}

											if (valPrenom == '') {
												formOK &= false;
												$prenom.parent().parent()
														.parent().addClass(
																'has-error');
												$prenom
														.parent()
														.next('span')
														.html(
																'Vous devez fournir le pr�nom du candidat');

											} else {
												$prenom.parent().parent()
														.parent().removeClass(
																'has-error');
												$prenom.parent().next('span')
														.html('');
											}

											if (!formOK) {
												$('#idFormAlertError')
														.removeClass('hidden');
												$('#idFormAlertError').fadeTo(
														2000, 500).slideUp(500);
												e.preventDefault();
											} else {
												$('#idFormAlertError')
														.addClass('hidden');
											}
										});
					});
</script>