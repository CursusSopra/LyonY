<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour � la page d'accueil</a> --%>

<h1>Modification d'une place ou d'un parc</h1>


<form class="form-horizontal" method="post" id="idFormModifPlaceetparc" action="<s:url action='modifPlaceetparc'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">
		Le formulaire contient des erreurs. Veuillez r�essayer.
	</div>


	<legend>Identification</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du lieu *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomL" value="<s:property value="placeetparc.nomLieu" />"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>


	<div class="form-group">
		<label for="idTypevisite" class="col-sm-2 control-label">Type de lieu *</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idTypevisite" name="idTypevisite">
					<s:iterator value="listeDesTypevisites">
						<s:if test='%{libtypevisite == placeetparc.typeVisite}'>
							<option value="<s:property value="idTypevisite"/>" selected="selected"><s:property value="libtypevisite" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="idTypevisite" />"><s:property value="libtypevisite" /></option>
						</s:else>
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
					<s:iterator value="listeDesQuartiers">
						<s:if test='%{nom == placeetparc.nomQuartier}'>
							<option value="<s:property value="idquartier"/>" selected="selected"><s:property value="nom" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="idquartier" />"><s:property value="nom" /></option>
						</s:else>
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
				<s:if test="%{placeetparc.numAdres == 0}">
					<input type="text" class="form-control" id="idNumero" name="numero"/>
				</s:if>
				<s:else>
					<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value="placeetparc.numAdres" />" />
				</s:else>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value="placeetparc.voieAdres" />"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code postal *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codePostal" value="<s:property value="placeetparc.cpAdres" />" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value="placeetparc.villeAdres" />"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<legend>Caract�ristiques</legend>
	
	<div class="form-group">
		<label for="idAvecFontaine" class="col-sm-2 control-label">Y a-t-il une fontaine ?</label>
		<div class="col-sm-3">
			<div class="row">
				<s:if test="%{placeetparc.avecFontaine}">
					Oui <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="true" checked="checked"> &nbsp;
					Non <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="false">
				</s:if>
				<s:else>
					Oui <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="true"> &nbsp;
					Non <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="false" checked="checked">
				</s:else>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idDescription" name="description" rows=4 cols=40 ><s:property value="placeetparc.descriptionLieu" /></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idAccessibilit�" class="col-sm-2 control-label">Comment y acc�der ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilit�" name="accessibilite" rows=4 cols=40 ><s:property value="placeetparc.accessibiliteLieu" /></TEXTAREA>
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
				<button type="submit" class="btn btn-default">Modifier ce lieu</button>
			</div>
		</div>
	</div>

</form>

<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
			//Validation/refus selon le remplissage du formulaire
				$('#idFormModifPlaceetparc').submit(
					function(e) {
						var $nom = $('#idNom');
						var $cp = $('#idCodepostal');
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
							$nom.parent().next('span').html('Vous devez fournir le nom du lieu');
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