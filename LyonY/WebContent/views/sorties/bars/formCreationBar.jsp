<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Entrez les informations sur le nouveau Bar :</h1>

<form class="form-horizontal" method="post" id="idFormCreationBar" action="<s:url action='creationBar'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		r�essayer</div>


	<legend>Identification du Bar</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du Bar *</label>
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
						<option value="<s:property value="idQuartier" />"><s:property value="nom" /></option>
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
				<input type="text" class="form-control" id="idCodePostal"
					name="codePostal" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="Lyon"/>
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
					placeholder="D�crivez le bar : sp�cialit�s, activit�s..."></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAccessibilit�" class="col-sm-2 control-label">Comment
			y acc�der ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilit�" name="accessibilite" rows=4 cols=40
					placeholder="Expliquez comment l'on peut s'y rendre"></TEXTAREA>
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
					name="prixmin" />
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
					name="prixmax" />
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

