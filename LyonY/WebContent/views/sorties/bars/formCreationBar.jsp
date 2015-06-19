<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Entrez les informations sur le nouveau Bar :</h1>

<!-- Modal -->
<div class="modal fade" id="idModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" id="myModalLabel">Ajout d'une ambiance de bar</h3>
      </div>
      <div class="modal-body">
        <form id="idFormCreationAmbiance" class="form-horizontal">
			<div class="form-group">
				<label for="idLibAmbiance" class="col-sm-4 control-label">Nouvelle ambiance *</label>
				<div class="col-sm-4">
					<div class="row">
						<input type="text" class="form-control" id="idLibAmbiance" name="libambiance" placeholder="Exemple : Pub"/>
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
        	<input type="hidden" id="idTypeS"  name="types" value="B"/>
	        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
	        <button type="submit" class="btn btn-primary">Ajouter cette ambiance</button>
        </form>
      </div>
    </div>
  </div>
</div>

<form class="form-horizontal" method="post" id="idFormCreationBar" action="<s:url action='creationBar'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		réessayer</div>


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
				<span class="col-lg-20 control-label">&nbsp;</span>
				<a data-toggle="modal" href="#idModal">Ajouter une ambiance</a>
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
		<label for="idNumero" class="col-sm-2 control-label">Numéro</label>
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

	<legend>Caractéristiques</legend>

	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA name="description" rows=4 cols=40
					placeholder="Décrivez le bar : spécialités, activités..."></TEXTAREA>
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

