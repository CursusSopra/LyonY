<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Modification d'un night club</h1>


<form class="form-horizontal" method="post" id="idFormModifNclub" action="<s:url action='modifNclub'/>">
	
	<input type="hidden" id="idNightclub" name="idNightclub" value="<s:property value = "nclub.idNightclub"/>"/>

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		réessayer</div>


	<legend>Identification du Bar</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du Night Club</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomnightclub" value="<s:property value = "nclub.nomnightclub"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	
	<div class="form-group">
	<label for="idAmbiance" class="col-sm-2 control-label">Ambiance</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idAmbiance" name="idAmbiance" >
					<s:iterator value="listeDesAmbiances">
						<option value="<s:property value="idAmbiance" />" ${nclub.libambiance == libambiance ? 'selected' : ''} ><s:property value="libambiance" /></option>
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
				<select id="idQuartier" name="idQuartier"">
					<s:iterator value="listeDesQuartiers">
						<option value="<s:property	value="idQuartier" />" ${nclub.nomquartier == nom ? 'selected' : ''} >
						
						
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
				<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value = "nclub.numero"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value = "nclub.voie"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code
			postal</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codePostal" value="<s:property value = "nclub.codePostal"/>"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value = "nclub.ville"/>" />
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
					 ><s:property value = "nclub.description"/></TEXTAREA>
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
					 ><s:property value = "nclub.accessibilite"/></TEXTAREA>
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
					name="prixmin" value="<s:property value = "nclub.prixmin"/>" />
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
					name="prixmax" value="<s:property value = "nclub.prixmax"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<legend>Horaires</legend>

	




	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">
				<button type="submit" class="btn btn-default">Envoyer</button>
			</div>
		</div>
	</div>

</form>
